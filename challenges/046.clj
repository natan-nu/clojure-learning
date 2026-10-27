(ns challenges.046
  (:require [clojure.string :as str]))

(defn validate-required-name
   [data]
   (when (str/blank? (:name data))
     {:error "Name is required"}))

(defn validate-age-limit
  [data]
  (when (< (:age data) 18)
      {:error "Must be 18 or older"}))

(defn validate-email
  [data]
  (when-not (str/includes? (:email data) "@")
      {:error "Invalid email format"}))

(defn compose-validators
  [validators data]
    (some #(% data) validators))


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
