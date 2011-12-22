(ns demo.web
  (:use compojure.core, ring.adapter.jetty)
  (:require [compojure.route :as route]))

(defroutes main-routes
  (GET "/" [] "<!DOCTYPE html><link rel='stylesheet' href='http://cdn.wal.sh/default.css'/><h1>Instant Workshop</h1>")
  (route/not-found "<h1>Page not found</h1>"))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty main-routes {:port port})))


