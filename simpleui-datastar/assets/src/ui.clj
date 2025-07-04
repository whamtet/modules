(ns <<ns-name>>.web.routes.ui
  (:require
   [<<ns-name>>.web.middleware.exception :as exception]
   [<<ns-name>>.web.middleware.formats :as formats]
   [<<ns-name>>.web.views.home :as home]
   [integrant.core :as ig]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [reitit.ring.middleware.parameters :as parameters]
   [reitit.ring.coercion :as coercion]
   [simpleui.middleware :refer [wrap-datastar]]))

(defn route-data [opts]
  (merge
   opts
   {:muuntaja   formats/instance
    :middleware
    [
      parameters/parameters-middleware
      ;; content-negotiation
      muuntaja/format-negotiate-middleware
      ;; encoding response body
      muuntaja/format-response-middleware
      ;; exception handling
      coercion/coerce-exceptions-middleware
      ;; decoding request body
      muuntaja/format-request-middleware
      ;; coercing response bodys
      coercion/coerce-response-middleware
      ;; coercing request parameters
      coercion/coerce-request-middleware
      wrap-datastar
      ;; exception handling
      exception/wrap-exception]}))

(derive :reitit.routes/ui :reitit/routes)

(defmethod ig/init-key :reitit.routes/ui
  [_ {:keys [base-path]
      :or   {base-path ""}
      :as   opts}]
  [base-path (route-data opts) (home/ui-routes base-path)])
