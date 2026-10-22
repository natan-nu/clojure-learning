(ns add-signal
  (:require [clojure.string :as str]))

(defn add-signal
  "TODO: implement this function"
  [result points signal-text]
  nil)

(defn calculate-risk-level
  "TODO: implement this function"
  [fraud-score]
  nil)

(defn determine-action
  "TODO: implement this function"
  [risk-level]
  nil)

(defn detect-fraud
  "TODO: implement this function"
  [transaction]
  nil)

(defn- tst []
  (let [result (detect-fraud {:amount 5000, :is-high-risk-country false, :velocity-24h 2, :device-known true, :amount-deviation-percent 50, :time-since-last-tx-minutes 120, :user-age-days 365})] (assert (= (:fraud-score result) 0) "Should have 0 fraud score") (assert (= (:risk-level result) :low) "Should be low risk") (assert (= (:action result) :approve) "Should approve") (assert (empty? (:signals result)) "Should have no signals") (assert (= (:reason result) "No fraud signals detected")))
  (let [result (detect-fraud {:amount 15000, :is-high-risk-country true, :velocity-24h 12, :device-known false, :amount-deviation-percent 300, :time-since-last-tx-minutes 2, :user-age-days 15})] (assert (= (:fraud-score result) 135) "Should have max fraud score") (assert (= (:risk-level result) :critical) "Should be critical risk") (assert (= (:action result) :block) "Should block transaction") (assert (= (count (:signals result)) 7) "Should have all 7 signals"))
  (let [result (detect-fraud {:amount 12000, :is-high-risk-country false, :velocity-24h 5, :device-known false, :amount-deviation-percent 150, :time-since-last-tx-minutes 60, :user-age-days 100})] (assert (= (:fraud-score result) 35) "Should have medium score") (assert (= (:risk-level result) :medium) "Should be medium risk") (assert (= (:action result) :review) "Should require review"))
  (let [result (detect-fraud {:amount 15000, :is-high-risk-country true, :velocity-24h 11, :device-known true, :amount-deviation-percent 100, :time-since-last-tx-minutes 60, :user-age-days 100})] (assert (= (:fraud-score result) 75) "Should have high score") (assert (= (:risk-level result) :high) "Should be high risk") (assert (= (:action result) :review) "Should require review"))
  "SUCCESS"
  )

(tst)
