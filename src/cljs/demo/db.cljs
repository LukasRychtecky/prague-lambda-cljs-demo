(ns demo.db
  (:require
    [demo.login.db :refer [login-initial]]))


(def default-db
  {:login login-initial})
