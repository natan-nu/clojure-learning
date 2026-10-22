(ns kebab->camel
  (:require [clojure.string :as str]))

(defn kebab->camel
  "TODO: implement this function"
  [s]
  nil)

(defn camel->kebab
  "TODO: implement this function"
  [s]
  nil)

(defn domain->wire
  "TODO: implement this function"
  [data]
  nil)

(defn wire->domain
  "TODO: implement this function"
  [data]
  nil)

(defn- tst []
  (assert (= (domain->wire {:user-id 123, :full-name "John", :email-address "j@test.com"}) {"userId" 123, "fullName" "John", "emailAddress" "j@test.com"}))
  (assert (= (wire->domain {"userId" 456, "fullName" "Jane", "emailAddress" "jane@test.com"}) {:user-id 456, :full-name "Jane", :email-address "jane@test.com"}))
  (let [original {:user-id 789, :full-name "Bob", :email-address "bob@test.com"}] (assert (= (wire->domain (domain->wire original)) original)))
  "SUCCESS"
  )

(tst)
