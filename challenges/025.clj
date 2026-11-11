(ns challenges.025
  (:require [clojure.string :as str]))

(defn validate-user-multi
  [user]
    (let [{:keys [name email age]} user]
     (or
      (when (str/blank? name)
        {:status :error :message "Name is required"})
  
      (when-not (str/includes? email "@")
        {:status :error :message "Invalid email"})
  
      (when (or (< age 18) (> age 120))
        {:status :error :message "Invalid age range"})
  
      {:status :success :user user})))

(defn- tst []
  (assert (= (validate-user-multi {:name "John", :email "john@test.com", :age 25}) {:status :success, :user {:name "John", :email "john@test.com", :age 25}}))
  (assert (= (validate-user-multi {:name "", :email "test@test.com", :age 25}) {:status :error, :message "Name is required"}))
  (assert (= (validate-user-multi {:name "Jane", :email "invalid", :age 25}) {:status :error, :message "Invalid email"}))
  (assert (= (validate-user-multi {:name "Bob", :email "bob@test.com", :age 150}) {:status :error, :message "Invalid age range"}))
  (assert (= (validate-user-multi {:name "Alice", :email "alice@test.com", :age 17}) {:status :error, :message "Invalid age range"}))
  "SUCCESS"
  )

(tst)
