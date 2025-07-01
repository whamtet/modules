(ns <<ns-name>>.web.htmx
  (:require
   [simpleui.render :as render]
   [ring.util.http-response :as http-response]
   [hiccup.core :as h]
   [hiccup.page :as p]))

(defn page-response [opts & content]
  (-> (p/html5 opts content)
      http-response/ok
      (http-response/content-type "text/html")))

(defn ui [opts & content]
  (-> (h/html opts content)
      http-response/ok
      (http-response/content-type "text/html")))

(defn page [& body]
  (page-response
   [:head
    [:meta {:charset "UTF-8"}]
    [:title "Datastar + Kit"]
    [:script {:src "https://cdn.jsdelivr.net/gh/starfederation/datastar@v1.0.0-beta.11/bundles/datastar.js" :type "module"}]]
   [:body (render/walk-attrs body)]))
