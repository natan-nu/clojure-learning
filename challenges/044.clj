(ns build-report)

(defn build-report
  "TODO: implement this function"
  [flat-record]
  nil)

(defn- tst []
  (let [result (build-report {:transaction-id "TXN-123", :amount 100.0, :fee 2.5, :user-name "John Doe", :user-email "john@example.com", :merchant-name "Coffee Shop", :merchant-category "dining"})] (assert (= (:id result) "TXN-123") "Should extract transaction ID") (assert (= (get-in result [:financial :amount]) 100.0) "Should include amount in financial") (assert (= (get-in result [:financial :fee]) 2.5) "Should include fee in financial") (assert (= (get-in result [:financial :net]) 97.5) "Should calculate net correctly") (assert (= (get-in result [:user :name]) "John Doe") "Should group user name") (assert (= (get-in result [:user :email]) "john@example.com") "Should group user email") (assert (= (get-in result [:merchant :name]) "Coffee Shop") "Should group merchant name") (assert (= (get-in result [:merchant :category]) "dining") "Should group merchant category"))
  (let [result (build-report {:transaction-id "TXN-456", :amount 1500.0, :fee 45.0, :user-name "Jane Smith", :user-email "jane@example.com", :merchant-name "Electronics Store", :merchant-category "retail"})] (assert (= (:id result) "TXN-456") "Should handle different transaction") (assert (= (get-in result [:financial :net]) 1455.0) "Should calculate net for larger amounts"))
  (let [result (build-report {:transaction-id "TXN-789", :amount 50.0, :fee 0.0, :user-name "Bob Wilson", :user-email "bob@example.com", :merchant-name "Gas Station", :merchant-category "fuel"})] (assert (= (get-in result [:financial :net]) 50.0) "Should handle zero fee correctly"))
  "SUCCESS"
  )

(tst)
