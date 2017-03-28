(ns demo.handlers
  (:require
    [re-frame.core :refer [reg-event-db]]
    [demo.db :as db]))


(reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
