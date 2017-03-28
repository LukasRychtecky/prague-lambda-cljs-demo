(ns demo.login.subs
  (:require
    [re-frame.core :refer [reg-sub]]))


(reg-sub
  :login/form
  (fn [db _]
    (get-in db [:login :form])))


(reg-sub
  :login/user
  (fn [db _]
    (get-in db [:login :user])))
