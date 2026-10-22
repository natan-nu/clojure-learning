(ns parse-date
  (:require [clojure.string :as str]))

(defn parse-date
  "TODO: implement this function"
  [date-string]
  nil)

(defn- tst []
  (assert (= (parse-date "2024-01-15") {:year 2024, :month 1, :day 15}) "Should parse date with single-digit month")
  (assert (= (parse-date "1999-12-31") {:year 1999, :month 12, :day 31}) "Should parse end of year date")
  (assert (= (parse-date "2000-06-01") {:year 2000, :month 6, :day 1}) "Should parse date with single-digit day")
  (assert (= (parse-date "2024-02-29") {:year 2024, :month 2, :day 29}) "Should parse leap year date")
  (assert (= (parse-date "2023-03-05") {:year 2023, :month 3, :day 5}) "Should handle leading zeros in month and day")
  "SUCCESS"
  )

(tst)
