(ns demo.views
  (:require
    [re-frame.core :refer [subscribe]]
    [demo.login.views :refer [login-form authorized-screen]]))


(defn layout
  []
  (let [form (subscribe [:login/form])
        user (subscribe [:login/user])]
    (fn []
      [:div.container
       (if (nil? @user)
         [login-form @form]
         [authorized-screen @user])])))
