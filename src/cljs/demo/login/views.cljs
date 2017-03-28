(ns demo.login.views
  (:require
    [clojure.string :refer [join]]
    [goog.string.format]
    [goog.string :refer [format]]
    [re-frame.core :refer [dispatch]]
    [demo.login.db :refer [valid?]]))


(defn field
  [form id label field-type value]
  [:div
   [:label {:class "sr-only"
            :for (name id)}
    label]
   [:input {:class "form-control"
            :on-change #(dispatch [:login/update-field id (-> % .-target .-value)])
            :value (id form)
            :placeholder label
            :id (name id)
            :type field-type}]])


(defn compose-button-class
  [form]
  (->> ["btn" "btn-lg" "btn-primary" "btn-block" (when (or (not (valid? form))
                                                           (:progress? form))
                                                   "disabled")]
       (remove nil?)
       (join " ")))


(defn spinner
  []
  [:img {:src "https://cdnjs.cloudflare.com/ajax/libs/timelinejs/2.25/css/loading.gif"
         :width "20"
         :height "20"}])


(defn submit-button
  [form label]
  [:button {:class (compose-button-class form)
            :on-click #(when (valid? form)
                         (js/console.log form)
                         (dispatch [:login/submit-credentials]))
            :type "submit"}
    [:span label (when (:progress? form)
                   [spinner])]])


(defn login-form
  [form]
  [:div.form-signin
   [:h2.form-signin-heading "Please sign in"]
   [field form :username "E-mail address" "type"]
   [field form :password "Password" "password"]
   [submit-button form "Sign in"]])


(defn authorized-screen
  [user]
  [:h1 (format "Hallo, %s" (:name user))])
