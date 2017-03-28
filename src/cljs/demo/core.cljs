(ns demo.core
  (:require
    [reagent.core :as reagent]
    [re-frame.core :as re-frame]
    [devtools.core :as devtools]
    [demo.handlers]
    [demo.views :as views]
    [demo.config :as config]
    [demo.login.core]))


(defn dev-setup! []
  (when config/debug?
    (enable-console-print!)
    (devtools/install! [:formatters :hints :async])))


(defn mount-root []
  (reagent/render [views/layout]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup!)
  (mount-root))
