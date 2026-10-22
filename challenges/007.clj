(ns uppercase-names
  (:require [clojure.string :as str]))

(defn uppercase-names
  "TODO: implement this function"
  [names]
  nil)

(defn- tst []
  (assert (= (uppercase-names ["john" "jane" "bob"]) ["JOHN" "JANE" "BOB"]) "Should convert lowercase names to uppercase")
  (assert (= (uppercase-names ["Alice" "Charlie"]) ["ALICE" "CHARLIE"]) "Should convert mixed case names to uppercase")
  (assert (= (uppercase-names []) []) "Should return empty vector for empty input")
  (assert (= (uppercase-names ["" "test" ""]) ["" "TEST" ""]) "Should preserve empty strings")
  (assert (= (uppercase-names ["DAVID" "EMMA"]) ["DAVID" "EMMA"]) "Should handle already uppercase names")
  (assert (= (uppercase-names ["josé" "françois" "björk"]) ["JOSÉ" "FRANÇOIS" "BJÖRK"]) "Should handle international characters")
  (assert (= (uppercase-names ["user1" "user2" "admin3"]) ["USER1" "USER2" "ADMIN3"]) "Should handle names with numbers")
  (assert (= (uppercase-names ["clojure"]) ["CLOJURE"]) "Should work with single name")
  (assert (= (uppercase-names ["mary anne" "john smith"]) ["MARY ANNE" "JOHN SMITH"]) "Should handle names with spaces")
  "SUCCESS"
  )

(tst)
