(ns ^:figwheel-hooks vector-primitives-cljs.dev
  (:require [goog.dom :as gdom]
            [vector-primitives-cljs.core :as v :refer [vector-of]]))


;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {}))

(defn get-app-element []
  (gdom/getElement "app"))



;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  #_(swap! app-state update-in [:__figwheel_counter] inc))

