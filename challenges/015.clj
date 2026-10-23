(ns challenges.015
  (:require [clojure.string :as str]))

(defn validate-user
  [{:keys [name email age] :as user}]
  (cond
    (str/blank? name) {:status :error
                       :message "Name cannot be empty"}
    (not (str/includes? email "@"))
    {:status :error
     :message "Invalid email format"}
    (< age 18)
    {:status :error
     :message "User must be adult"}
    :else
    {:status :success
     :user user}))

(defn- tst []
  (assert (= (validate-user {:name "John", :email "john@example.com", :age 25}) {:status :success, :user {:name "John", :email "john@example.com", :age 25}}) "Valid user should return success")
  (assert (= (validate-user {:name "", :email "john@example.com", :age 25}) {:status :error, :message "Name cannot be empty"}) "Empty name should return name error")
  (assert (= (validate-user {:name "John", :email "invalid", :age 25}) {:status :error, :message "Invalid email format"}) "Email without @ should return email error")
  (assert (= (validate-user {:name "John", :email "john@example.com", :age 17}) {:status :error, :message "User must be adult"}) "Age < 18 should return age error")
  (assert (= (validate-user {:name "", :email "invalid", :age 17}) {:status :error, :message "Name cannot be empty"}) "Multiple failures should return first error")
  (assert (= (validate-user {:name "Jane", :email "jane@test.com", :age 18}) {:status :success, :user {:name "Jane", :email "jane@test.com", :age 18}}) "Age exactly 18 should pass")
  (assert (= (validate-user {:name "   ", :email "test@example.com", :age 30}) {:status :error, :message "Name cannot be empty"}) "Blank name with spaces should fail")
  (assert (= (validate-user {:name "Bob", :email "b@c", :age 25}) {:status :success, :user {:name "Bob", :email "b@c", :age 25}}) "Minimal email with @ should pass")
  "SUCCESS")

(tst)
