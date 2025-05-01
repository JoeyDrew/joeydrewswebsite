(ns site.posts.pb
  (:require [hiccup2.core :as h]))

(defn page []
  (h/html [:p "A proof of concept with an MPC with CV outs and a modular system"]
          [:audio {:controls , :autobuffer , :src "/audio/beatgen.mp3"}]
          [:pre
           [:code "patch notes:\n-"
            [:span {:class "ruby"} "- Morphagene manipulating a piano sample"] "-"
            [:span {:class "ruby"} "- MPC One cv sequencing μPlaits "
             [:span {:class "hljs-keyword"} "for"] " bass, pads."] "-"
            [:span {:class "ruby"} "- Percussion from the MPC"]]]
          [:p
           [:img {:src "/img/kevin.jpg", :alt "kevin"}]]
          [:blockquote
           [:p "Minolta X570 | 28mm ƒ/2.8 MD | Portra 400"]]
          [:p
           [:img {:src "/img/leadville.jpg", :alt "leadville"}]
           [:a {:href "http://joeydrew.com/img/leadville.jpg"} "full size image"]]
          [:blockquote
           [:p "Minolta X570 | 28mm ƒ/2.8 MD | Portra 400"]]
          [:p
           [:img {:src "/img/snowdog.jpg", :alt "snowdog"}]
           [:a {:href "http://joeydrew.com/img/snowdog.jpg"} "full size image"]]
          [:blockquote
           [:p "Minolta X570 | 28mm ƒ/2.8 MD | Portra 400"]]))
