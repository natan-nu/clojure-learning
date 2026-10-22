(ns transform-product)

(defn transform-product
  "TODO: implement this function"
  [external-product]
  nil)

(defn- tst []
  (let [result (transform-product {:product-id "PROD-001", :details {:name "Laptop", :category "Electronics"}, :pricing {:base-price "999.99", :discount-percent "10"}, :inventory {:stock "50", :warehouse "NYC"}})] (assert (= (:id result) "PROD-001") "Should extract product ID") (assert (= (:name result) "Laptop") "Should extract name") (assert (= (:category result) "Electronics") "Should extract category") (assert (= (:price result) 999.99) "Should parse price as double") (assert (< (Math/abs (- (:discounted-price result) 899.991)) 0.01) "Should calculate 10% discount correctly") (assert (= (:stock result) 50) "Should parse stock as integer") (assert (= (:warehouse result) "NYC") "Should extract warehouse"))
  (let [result (transform-product {:product-id "PROD-002", :details {:name "Mouse", :category "Accessories"}, :pricing {:base-price "29.99", :discount-percent "20"}, :inventory {:stock "200", :warehouse "LA"}})] (assert (= (:name result) "Mouse") "Should handle different product") (assert (< (Math/abs (- (:discounted-price result) 23.992)) 0.01) "Should calculate 20% discount correctly"))
  "SUCCESS"
  )

(tst)
