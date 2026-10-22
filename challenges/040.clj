(ns validate-customer-id)

(defn validate-customer-id
  "TODO: implement this function"
  [order]
  nil)

(defn validate-product-id
  "TODO: implement this function"
  [order]
  nil)

(defn validate-quantity
  "TODO: implement this function"
  [order]
  nil)

(defn validate-total
  "TODO: implement this function"
  [order]
  nil)

(defn process-order
  "TODO: implement this function"
  [order]
  nil)

(defn- tst []
  (assert (= (process-order {:customer-id 123, :product-id 456, :quantity 5, :total 99.99}) {:status :success, :order-id "ORD-123-456"}) "Should process valid order")
  (assert (= (process-order {:customer-id -1, :product-id 456, :quantity 5, :total 99.99}) {:status :error, :message "Invalid customer ID"}) "Should reject negative customer ID")
  (assert (= (process-order {:customer-id 123, :product-id 0, :quantity 5, :total 99.99}) {:status :error, :message "Invalid product ID"}) "Should reject zero product ID")
  (assert (= (process-order {:customer-id 123, :product-id 456, :quantity 150, :total 99.99}) {:status :error, :message "Invalid quantity"}) "Should reject quantity > 100")
  (assert (= (process-order {:customer-id 123, :product-id 456, :quantity 0, :total 99.99}) {:status :error, :message "Invalid quantity"}) "Should reject zero quantity")
  (assert (= (process-order {:customer-id 123, :product-id 456, :quantity 1, :total 5.0}) {:status :error, :message "Order total too low"}) "Should reject total < 10.0")
  (assert (= (:status (process-order {:customer-id 1, :product-id 1, :quantity 1, :total 10.0})) :success) "Should accept minimum valid values")
  (assert (= (:status (process-order {:customer-id 999, :product-id 999, :quantity 100, :total 9999.99})) :success) "Should accept maximum valid quantity")
  "SUCCESS"
  )

(tst)
