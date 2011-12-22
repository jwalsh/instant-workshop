(ns demo.web
  (:use compojure.core, ring.adapter.jetty)
  (:use [hiccup.page-helpers :only (html5)]) 
  (:require [compojure.route :as route]))

(def site-name "Instant Workshop")

(defn index []
  (html5
   [:head
    [:title site-name]]
   [:body
    [:div {:id "content"} site-name]]))

(defroutes main-routes
  (GET "/" [] (index))
  (route/not-found "<h1>Page not found</h1>"))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty main-routes {:port port})))


