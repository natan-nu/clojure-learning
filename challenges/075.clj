(ns reserve-inventory
  (:require [clojure.string :as str]))

(defn reserve-inventory
  "TODO: implement this function"
  [state]
  nil)

(defn charge-payment
  "TODO: implement this function"
  [state]
  nil)

(defn create-shipment
  "TODO: implement this function"
  [state]
  nil)

(defn send-confirmation
  "TODO: implement this function"
  [state]
  nil)

(defn release-inventory
  "TODO: implement this function"
  [state]
  nil)

(defn refund-payment
  "TODO: implement this function"
  [state]
  nil)

(defn cancel-shipment
  "TODO: implement this function"
  [state]
  nil)

(defn execute-saga-step
  "TODO: implement this function"
  [state step-fn step-name]
  nil)

(defn run-compensations
  "TODO: implement this function"
  [state completed-steps]
  nil)

(defn process-order
  "TODO: implement this function"
  [order-request]
  nil)

(defn- tst []
  (let [result (process-order {:order-id "ORD-123", :user-id "U1", :items [], :payment {}})] (assert (= (:status result) :completed) "Should complete successfully") (assert (= (count (:steps result)) 4) "Should have 4 steps"))
  (let [result (process-order {:order-id "ORD-fail-inventory", :user-id "U1", :items [], :payment {}})] (assert (= (:status result) :failed) "Should fail") (assert (= (:failed-step result) "reserve-inventory") "Should fail at inventory") (assert (empty? (:compensations-run result)) "Should have no compensations (first step)"))
  (let [result (process-order {:order-id "ORD-fail-payment", :user-id "U1", :items [], :payment {}})] (assert (= (:status result) :failed) "Should fail") (assert (= (:failed-step result) "charge-payment") "Should fail at payment") (assert (= (count (:compensations-run result)) 1) "Should run inventory compensation"))
  (let [result (process-order {:order-id "ORD-fail-shipment", :user-id "U1", :items [], :payment {}})] (assert (= (:status result) :failed) "Should fail") (assert (= (:failed-step result) "create-shipment") "Should fail at shipment") (assert (= (count (:compensations-run result)) 2) "Should run 2 compensations"))
  "SUCCESS"
  )

(tst)
