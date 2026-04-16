(ns <<ns-name>>.core
  (:require
    [reagent.core :as r]
    [reagent.dom.client :as rdomc]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "Welcome to Reagent!"]])

;; -------------------------
;; Initialize app

(defonce root (rdomc/create-root (.getElementById js/document "app")))

(defn ^:dev/after-load mount-root []
  (rdomc/render root [home-page]))

(defn ^:export ^:dev/once init! []
  (mount-root))
