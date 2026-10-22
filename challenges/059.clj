(ns internal->api
  (:require [clojure.string :as str]))

(defn internal->api
  "TODO: implement this function"
  [internal-product]
  nil)

(defn- tst []
  (let [result (internal->api {:product-id "PROD-123", :name "Laptop", :category :electronics, :price 999.99, :currency :usd, :stock 50, :warehouse-id "WH-001", :warehouse-location "New York"})] (assert (= (:productId result) "PROD-123") "Should transform product-id to productId") (assert (= (get-in result [:productDetails :productName]) "Laptop") "Should nest name as productName in productDetails") (assert (= (get-in result [:productDetails :category]) "electronics") "Should nest category and convert to string") (assert (= (get-in result [:productDetails :pricing :basePrice]) 999.99) "Should nest price as basePrice in pricing") (assert (= (get-in result [:productDetails :pricing :currency]) "USD") "Should nest currency and convert to uppercase string") (assert (= (get-in result [:inventory :stockLevel]) 50) "Should nest stock as stockLevel") (assert (= (get-in result [:inventory :warehouse :id]) "WH-001") "Should nest warehouse-id in warehouse") (assert (= (get-in result [:inventory :warehouse :location]) "New York") "Should nest warehouse-location in warehouse"))
  (let [result (internal->api {:product-id "PROD-456", :name "Office Chair", :category :furniture, :price 299.5, :currency :eur, :stock 120, :warehouse-id "WH-002", :warehouse-location "London"})] (assert (= (get-in result [:productDetails :category]) "furniture") "Should handle different category") (assert (= (get-in result [:productDetails :pricing :currency]) "EUR") "Should handle different currency with uppercase"))
  "SUCCESS"
  )

(tst)
