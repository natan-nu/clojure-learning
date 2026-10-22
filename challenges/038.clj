(ns transform-order)

(defn transform-order
  "TODO: implement this function"
  [external-order]
  nil)

(defn- tst []
  (let [result (transform-order {:order-id "ORD-123", :customer {:personal {:name "John Doe", :email "john@example.com"}, :shipping {:address {:street "123 Main St", :city "Springfield", :zip "12345"}}}, :total "99.50"})] (assert (= (:id result) "ORD-123") "Should extract order ID") (assert (= (:customer-name result) "John Doe") "Should extract customer name") (assert (= (:customer-email result) "john@example.com") "Should extract customer email") (assert (= (:shipping-street result) "123 Main St") "Should extract shipping street") (assert (= (:shipping-city result) "Springfield") "Should extract shipping city") (assert (= (:shipping-zip result) "12345") "Should extract shipping zip") (assert (= (:total result) 99.5) "Should convert total to double"))
  (let [result (transform-order {:order-id "ORD-456", :customer {:personal {:name "Jane Smith", :email "jane@example.com"}, :shipping {:address {:street "456 Oak Ave", :city "Portland", :zip "97201"}}}, :total "149.99"})] (assert (= (:customer-name result) "Jane Smith") "Should handle different customer") (assert (= (:total result) 149.99) "Should handle different total"))
  "SUCCESS"
  )

(tst)
