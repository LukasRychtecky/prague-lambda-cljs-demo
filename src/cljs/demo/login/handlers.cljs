(ns demo.login.handlers
  (:require
    [re-frame.core :refer [reg-event-db]]
    [demo.login.middlewares :refer [start-progress finish-progress submit-credentials]]))


(reg-event-db
  :login/update-field
  (fn [db [_ field value]]
    (assoc-in db [:login :form field] value)))


(reg-event-db
  :login/submit-credentials
  [submit-credentials start-progress]
  (fn [db _]
    db))


(reg-event-db
  :login/handle-response
  [finish-progress]
  (fn [db [_ user]]
    (assoc-in db [:login :user] user)))
