(ns site.core
  (:require [clojure.tools.namespace.find :as ns-find]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [stasis.core :as stasis]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.refresh :refer [wrap-refresh]]
            [ring.middleware.resource :refer [wrap-resource]]
            [hiccup.page :refer [html5]]
            [garden.core :refer [css]]))

(def out-dir "docs")

(defn post-namespaces []
  (ns-find/find-namespaces-in-dir (io/file "src/site/posts")))

(defn generate-post-index [posts]
  (let [post-items (for [[path _] posts]
                     [:li [:a {:href path}
                           (-> path
                               (str/replace #"^/posts/" "")
                               (str/replace #"\.html$" ""))]])]
    (html5 [:div
            [:h1 "All Posts"]
            [:ul post-items]])))

(defn header-footer [page]
  (html5 {:lang "en"}
         [:head
          [:title "joey drew"]
          [:link {:rel "icon" :type "image/x-icon" :href "/favicon.ico"}]
          [:meta {:charset "utf-8"}]
          [:meta {:name "viewport"
                  :content "width=device-width, initial-scale=1.0"}]
          [:link {:type "text/css" :href "/css/style.css" :rel "stylesheet"}]
          [:header
           [:h1 "joey drew"]]
          [:body
           page]
          [:footer
           [:div
            [:a {:href "/"} "Home"]
            [:a {:href "/posts"} "Posts"]
            [:a {:href "/about.html"} "About"]]
           [:p "the foghorns sure are loud today"]]]))

(defn load-posts
  "loops through post namespaces and pulls in page functions"
  []
  (into {}
        (for [ns-sym (post-namespaces)]
          (do
            (require ns-sym :reload)
            (let [page-fn (ns-resolve ns-sym 'page)
                  path (str "/posts/" (-> ns-sym name (str/replace #"\." "-")) ".html")]
              [path (page-fn)])))))

(defn format-pages
  "applies partials to pages.
   uses zipmap since 'pages' are a map of 'path : content"
  [pages]
  (zipmap (keys pages)
          (map header-footer (vals pages))))

(defn style
  "create stylesheet"
  []
  (css [:html {:font-size "16px"
               :font-family "sans-serif"
               :line-height "1.35"
               :background-color "#fdf6e3"}]
       [:body {:max-width "500px"
               :margin-top "10px"
               :margin-bottom "10px"}]
       [:p {:border-style "groove"}]
       [:img {:max-width "500px"
              :height "auto"}]
       [:footer {:text-align "justify"}]))

(defn about
  "create about page"
  []
  {"/about.html" (html5 [:p "systems"])})

(defn home
  "create homepage"
  []
  {"/index.html" (html5 [:p "hiccup homepage test"])})

(defn merge-website-assets!
  "builds and merges page maps.
   maps are `path : content`.
   the keys in the stasis call are only used for error reporting
   (when a path conflict occurs)"
  []
  (let [posts (load-posts)
        post-index {"/posts/index.html" (generate-post-index posts)}
        all-pages (merge posts post-index (home) (about))
        page-map (format-pages all-pages)
        css-map {"/css/style.css" (style)}]
    (stasis/merge-page-sources {:css css-map
                                :pages page-map})))

;; WARN:
;; needs some work to fix namespace (post) reloading
(def app
  (-> (stasis/serve-pages (merge-website-assets!))
      (wrap-reload {:dirs "src"})
      (wrap-resource "static")
      wrap-refresh))

(defn export!
  "build static site"
  []
  (stasis/empty-directory! out-dir)
  (stasis/export-pages (merge-website-assets!) out-dir))
