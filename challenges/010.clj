(ns fetch-and-sanitize
  (:require [clojure.string :as str]))

(defn fetch-and-sanitize
  "TODO: implement this function"
  [user-id]
  nil)

(defn- tst []
  (assert (= (fetch-and-sanitize 1) {:status :success, :user {:id 1, :name "User 1", :email "user1@example.com"}}) "Valid ID 1 should return success with sanitized user")
  (assert (= (fetch-and-sanitize 0) {:status :error, :message "Invalid user ID"}) "Zero should return error")
  (assert (= (fetch-and-sanitize 42) {:status :success, :user {:id 42, :name "User 42", :email "user42@example.com"}}) "Valid ID 42 should return success")
  (assert (= (fetch-and-sanitize -5) {:status :error, :message "Invalid user ID"}) "Negative ID should return error")
  (assert (= (fetch-and-sanitize 100) {:status :success, :user {:id 100, :name "User 100", :email "user100@example.com"}}) "Large valid ID should work")
  (let [result (fetch-and-sanitize 5)] (assert (= (:status result) :success) "Should return success for valid ID") (assert (not (contains? (:user result) :password)) "Password field should be removed from result"))
  (let [result (fetch-and-sanitize -10)] (assert (= (:status result) :error) "Status should be :error for invalid ID") (assert (contains? result :message) "Error result should contain :message key"))
  (let [result (fetch-and-sanitize 7)] (assert (= (:status result) :success) "Status should be :success for valid ID") (assert (contains? result :user) "Success result should contain :user key") (assert (= (get-in result [:user :id]) 7) "User ID should match input"))
  "SUCCESS"
  )

(tst)
