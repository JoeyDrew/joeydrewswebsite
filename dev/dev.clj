(ns dev
  (:require [site.core :refer [app]]
            [org.httpkit.server :as http]))

(defonce server (atom nil))

(defn start []
  (reset! server (http/run-server #'app {:port 3000}))
  (println "Server started on http://localhost:3000"))

(defn stop []
  (when @server
    (@server)
    (reset! server nil)
    (println "Server stopped")))

(defn -main []
  (start))

(comment
  (start)
  (stop))
