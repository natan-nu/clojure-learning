(ns api->internal
  (:require [clojure.string :as str]))

(defn api->internal
  "TODO: implement this function"
  [api-response]
  nil)

(defn- tst []
  (let [result (api->internal {:productId "PROD-123", :productDetails {:productName "Laptop", :category "electronics", :pricing {:basePrice 999.99, :currency "USD"}}, :inventory {:stockLevel 50, :warehouse {:id "WH-001", :location "New York"}}, :metadata {:timestamp "2024-01-15", :version 2}})] (assert (= (:product-id result) "PROD-123") "Should extract and rename productId") (assert (= (:name result) "Laptop") "Should extract nested productName") (assert (= (:category result) :electronics) "Should extract and convert category to keyword") (assert (= (:price result) 999.99) "Should extract nested basePrice") (assert (= (:currency result) :usd) "Should extract and convert currency to lowercase keyword") (assert (= (:stock result) 50) "Should extract nested stockLevel") (assert (= (:warehouse-id result) "WH-001") "Should extract nested warehouse id") (assert (= (:warehouse-location result) "New York") "Should extract nested warehouse location") (assert (nil? (:metadata result)) "Should discard metadata"))
  (let [result (api->internal {:productId "PROD-456", :productDetails {:productName "Office Chair", :category "furniture", :pricing {:basePrice 299.5, :currency "EUR"}}, :inventory {:stockLevel 120, :warehouse {:id "WH-002", :location "London"}}, :metadata {:timestamp "2024-01-16", :version 1}})] (assert (= (:category result) :furniture) "Should handle different category") (assert (= (:currency result) :eur) "Should handle different currency"))
  "SUCCESS"
  )

(tst)
