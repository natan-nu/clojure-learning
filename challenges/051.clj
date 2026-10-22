(ns trim-strings
  (:require [clojure.string :as str]))

(defn trim-strings
  "TODO: implement this function"
  [data]
  nil)

(defn normalize-email
  "TODO: implement this function"
  [data]
  nil)

(defn parse-age
  "TODO: implement this function"
  [data]
  nil)

(defn add-timestamp
  "TODO: implement this function"
  [data]
  nil)

(defn process-registration
  "TODO: implement this function"
  [raw-data]
  nil)

(defn- tst []
  (let [result (process-registration {:name "  Alice Johnson  ", :email "  ALICE@EXAMPLE.COM  ", :age "25"})] (assert (= (:name result) "Alice Johnson") "Should trim name") (assert (= (:email result) "alice@example.com") "Should trim and lowercase email") (assert (= (:age result) 25) "Should parse age to integer") (assert (= (:registered-at result) "2024-01-15T10:00:00") "Should add timestamp"))
  (let [result (process-registration {:name "Bob Smith", :email "BOB@EXAMPLE.COM", :age "30"})] (assert (= (:name result) "Bob Smith") "Should handle clean name") (assert (= (:email result) "bob@example.com") "Should still lowercase email"))
  (assert (= (trim-strings {:name "  Test  ", :email "  test@test.com  "}) {:name "Test", :email "test@test.com"}) "trim-strings should trim both fields")
  (assert (= (normalize-email {:email "TEST@EXAMPLE.COM"}) {:email "test@example.com"}) "normalize-email should lowercase")
  (assert (= (parse-age {:age "35"}) {:age 35}) "parse-age should convert to integer")
  (assert (= (add-timestamp {:name "Test"}) {:name "Test", :registered-at "2024-01-15T10:00:00"}) "add-timestamp should add field")
  "SUCCESS"
  )

(tst)
