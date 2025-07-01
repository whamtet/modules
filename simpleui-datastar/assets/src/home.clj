(ns <<ns-name>>.web.views.home
    (:require
      [simpleui.core :as simpleui :refer [defcomponent]]
      [<<ns-name>>.web.page :refer [page]]))

(defcomponent ^:endpoint hello [req my-name]
  [:div#hello "Hello " my-name])

(defn ui-routes [base-path]
  (simpleui/make-routes
   base-path
   (fn [req]
     (page
      [:div "ok"]))))
