(ns snake->kebab-key
  (:require [clojure.string :as str]))

(defn snake->kebab-key
  "TODO: implement this function"
  [k]
  nil)

(defn snake->kebab
  "TODO: implement this function"
  [data]
  nil)

(defn- tst []
  (assert (= (snake->kebab {:first_name "John", :last_name "Doe"}) {:first-name "John", :last-name "Doe"}) "Should transform snake_case to kebab-case")
  (assert (= (snake->kebab {:user_id 123, :email_address "test@example.com"}) {:user-id 123, :email-address "test@example.com"}) "Should handle multiple keys with underscores")
  (assert (= (snake->kebab {:name "Alice"}) {:name "Alice"}) "Keys without underscores should remain unchanged")
  (assert (= (snake->kebab {}) {}) "Empty map should remain empty")
  (assert (= (snake->kebab {:created_at_timestamp 1234567890}) {:created-at-timestamp 1234567890}) "Should handle multiple underscores in one key")
  (assert (= (snake->kebab {:user_name "Bob", :age 25, :home_address "123 Main St"}) {:user-name "Bob", :age 25, :home-address "123 Main St"}) "Should handle mix of keys with and without underscores")
  (let [result (snake->kebab {:user_id 999, :active_flag true})] (assert (= (:user-id result) 999) "Integer values should be preserved") (assert (= (:active-flag result) true) "Boolean values should be preserved"))
  (assert (= (snake->kebab-key :first_name) :first-name) "Helper should convert single key")
  (assert (= (snake->kebab-key :no_change) :no-change) "Helper should replace underscores")
  "SUCCESS"
  )

(tst)
