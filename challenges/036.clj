(ns parse-full-name
  (:require [clojure.string :as str]))

(defn parse-full-name
  "TODO: implement this function"
  [full-name]
  nil)

(defn- tst []
  (assert (= (parse-full-name "John Michael Doe") {:first-name "John", :middle-name "Michael", :last-name "Doe"}) "Should parse three-part name")
  (assert (= (parse-full-name "Jane Doe") {:first-name "Jane", :last-name "Doe"}) "Should parse two-part name without middle")
  (assert (= (parse-full-name "Madonna") {:first-name "Madonna", :last-name "Madonna"}) "Should handle mononym")
  (assert (= (parse-full-name "John Paul George Ringo Starr") {:first-name "John", :middle-name "Paul George Ringo", :last-name "Starr"}) "Should handle multiple middle names")
  (let [result (parse-full-name "Jane Doe")] (assert (not (contains? result :middle-name)) "Two-part name should not have :middle-name key"))
  "SUCCESS"
  )

(tst)
