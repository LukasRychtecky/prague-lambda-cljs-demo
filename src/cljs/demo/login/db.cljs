(ns demo.login.db
  (:require
    [clojure.string :refer [blank? trim]]))


(defrecord Form [username password progress?])


(defrecord User [name])


(def login-initial
    {:form (Form. "" "" false)
     :user nil})


(defn filled?
  [value]
  (not (blank? value))
  (-> value str trim blank? not))


(defn valid?
  [form]
  (every? filled? [(:username form) (:password form)]))
