(ns demo.login.middlewares
  (:require
    [re-frame.core :refer [after dispatch enrich]]))


(defn start-progress-handler
  [db _]
  (assoc-in db [:login :form :progress?] true))

(def start-progress (enrich start-progress-handler))


(defn submit-credentials-handler
  [db _]
  (js/setTimeout #(dispatch [:login/handle-response {:name "Franz"}]) 5000))

(def submit-credentials (after submit-credentials-handler))


(defn finish-progress-handler
  [db _]
  (assoc-in db [:login :form :progress?] false))

(def finish-progress (enrich finish-progress-handler))
