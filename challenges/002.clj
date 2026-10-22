(ns challenges.002
  (:require [clojure.string :as str]))

;; Primer: clojure.string

;; (require '[clojure.string :as str])
;;
;; (str/upper-case "abc")            ;=> "ABC"
;; (str/lower-case "ABC")            ;=> "abc"
;; (str/trim "  hi  ")               ;=> "hi"
;; (str/split "a,b,c" #",")          ;=> ["a" "b" "c"]
;; (str/join "-" ["a" "b" "c"])      ;=> "a-b-c"
;; (str/includes? "abcdef" "cd")     ;=> true
;; (str/replace "abc" "b" "Z")       ;=> "aZc"

(defn valid-email?
  [email]
  (and (not (str/blank? email)) (str/includes? email "@")))

(defn- tst []
  (assert (= (valid-email? "user@example.com") true) "Valid email should return true")
  (assert (= (valid-email? "invalid-email") false) "Email without @ should return false")
  (assert (= (valid-email? "") false) "Empty string should return false")
  (assert (= (valid-email? "@") true) "Just @ should return true")
  (assert (= (valid-email? "test@test") true) "Simple email should return true")
  (assert (= (valid-email? nil) false) "Nil should return false")
  "SUCCESS")

(tst)
