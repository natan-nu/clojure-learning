(ns extract-transaction-summary)

(defn extract-transaction-summary
  "TODO: implement this function"
  [{:keys [id], {:keys [name tier]} :customer, {:keys [amount currency]} :payment}]
  nil)

(defn- tst []
  (let [result (extract-transaction-summary {:id "TXN-001", :customer {:name "Alice", :tier :gold}, :payment {:method :credit-card, :amount 1500.0, :currency "USD"}, :metadata {:timestamp "2024-01-15", :ip "192.168.1.1"}})] (assert (= (:transaction-id result) "TXN-001") "Should extract transaction ID") (assert (= (:customer-name result) "Alice") "Should extract customer name") (assert (= (:customer-tier result) :gold) "Should extract customer tier") (assert (= (:payment-amount result) 1500.0) "Should extract payment amount") (assert (= (:payment-currency result) "USD") "Should extract payment currency") (assert (true? (:is-premium-customer result)) "Should mark gold as premium") (assert (true? (:is-high-value result)) "Should mark >1000 as high-value"))
  (let [result (extract-transaction-summary {:id "TXN-002", :customer {:name "Bob", :tier :silver}, :payment {:method :debit-card, :amount 500.0, :currency "USD"}, :metadata {:timestamp "2024-01-16", :ip "192.168.1.2"}})] (assert (false? (:is-premium-customer result)) "Should mark silver as not premium") (assert (false? (:is-high-value result)) "Should mark <=1000 as not high-value"))
  (let [result (extract-transaction-summary {:id "TXN-003", :customer {:name "Charlie", :tier :platinum}, :payment {:method :wire-transfer, :amount 800.0, :currency "EUR"}, :metadata {:timestamp "2024-01-17", :ip "192.168.1.3"}})] (assert (true? (:is-premium-customer result)) "Should mark platinum as premium") (assert (false? (:is-high-value result)) "Should mark 800 as not high-value"))
  (let [result (extract-transaction-summary {:id "TXN-004", :customer {:name "Diana", :tier :bronze}, :payment {:method :credit-card, :amount 5000.0, :currency "GBP"}, :metadata {:timestamp "2024-01-18", :ip "192.168.1.4"}})] (assert (false? (:is-premium-customer result)) "Should mark bronze as not premium") (assert (true? (:is-high-value result)) "Should mark 5000 as high-value"))
  (let [result (extract-transaction-summary {:id "TXN-005", :customer {:name "Eve", :tier :silver}, :payment {:method :credit-card, :amount 1000.0, :currency "USD"}, :metadata {:timestamp "2024-01-19", :ip "192.168.1.5"}})] (assert (false? (:is-high-value result)) "Should mark exactly 1000 as not high-value (> not >=)"))
  "SUCCESS"
  )

(tst)
