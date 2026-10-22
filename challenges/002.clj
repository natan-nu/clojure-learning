(ns valid-email?
  (:require [clojure.string :as str]))

(defn valid-email?
  "TODO: implement this function"
  [email]
  nil)

(defn- tst []
  (assert (= (valid-email? "user@example.com") true) "Valid email should return true")
  (assert (= (valid-email? "invalid-email") false) "Email without @ should return false")
  (assert (= (valid-email? "") false) "Empty string should return false")
  (assert (= (valid-email? "@") true) "Just @ should return true")
  (assert (= (valid-email? "test@test") true) "Simple email should return true")
  (assert (= (valid-email? nil) false) "Nil should return false")
  "SUCCESS"
  )

(tst)
