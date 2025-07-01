(ns <<ns-name>>.web.views.home
    (:require
      [simpleui.core :as simpleui :refer [defcomponent]]
      [<<ns-name>>.web.page :refer [page]]))

(defcomponent ^:endpoint hello [req]
  (prn 'hello (:params req))

(defn ui-routes [base-path]
  (simpleui/make-routes
   base-path
   (fn [req]
     hello
     (page
      [:input {:data-bind-input true}]
      [:button {:data-on-click "@get('hello')"} "hi"]
      [:button {:data-on-click "@post('hello')"} "there"]))))
