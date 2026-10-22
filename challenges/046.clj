(ns validate-required-name
  (:require [clojure.string :as str]))

(defn validate-required-name
  "TODO: implement this function"
  [data]
  nil)

(defn validate-age-limit
  "TODO: implement this function"
  [data]
  nil)

(defn validate-email
  "TODO: implement this function"
  [data]
  nil)

(defn compose-validators
  "TODO: implement this function"
  [validators data]
  nil)

(defn- tst []
  (assert (nil? (compose-validators [validate-required-name validate-age-limit validate-email] {:name "John", :age 25, :email "john@example.com"})) "Should return nil when all validations pass")
  (assert (= (compose-validators [validate-required-name validate-age-limit validate-email] {:name "", :age 25, :email "john@example.com"}) {:error "Name is required"}) "Should return first error (name required)")
  (assert (= (compose-validators [validate-required-name validate-age-limit validate-email] {:name "John", :age 16, :email "john@example.com"}) {:error "Must be 18 or older"}) "Should return second error (age limit)")
  (assert (= (compose-validators [validate-required-name validate-age-limit validate-email] {:name "John", :age 25, :email "invalid"}) {:error "Invalid email format"}) "Should return third error (email format)")
  (assert (nil? (compose-validators [] {:name "John", :age 25, :email "john@example.com"})) "Should return nil for empty validators")
  (assert (= (compose-validators [validate-required-name validate-age-limit validate-email] {:name "", :age 16, :email "invalid"}) {:error "Name is required"}) "Should return first error when multiple fail")
  "SUCCESS"
  )

(tst)
