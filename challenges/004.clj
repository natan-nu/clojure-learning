(ns extract-contact-info)

(defn extract-contact-info
  "TODO: implement this function"
  [user]
  nil)

(defn- tst []
  (assert (= (extract-contact-info {:name "John Doe", :email "john@example.com", :age 30, :address "123 Main St", :phone "555-1234"}) {:name "John Doe", :email "john@example.com"}) "Should extract only name and email from full user record")
  (assert (= (extract-contact-info {:name "Jane Smith", :email "jane@example.com", :age 25, :address "456 Oak Ave", :phone "555-5678"}) {:name "Jane Smith", :email "jane@example.com"}) "Should work for different user data")
  (assert (= (extract-contact-info {:name "Bob Johnson", :email "bob@test.com", :age 40, :address "789 Pine Rd", :phone "555-9999"}) {:name "Bob Johnson", :email "bob@test.com"}) "Should filter out all non-contact fields")
  (assert (= (extract-contact-info {:name "Alice", :email "alice@example.com", :age 28, :ssn "123-45-6789", :credit-card "1234-5678-9012-3456"}) {:name "Alice", :email "alice@example.com"}) "Should exclude sensitive fields like SSN and credit card")
  (assert (= (extract-contact-info {:name "Charlie", :age 35}) {:name "Charlie"}) "Should only include keys that exist in input")
  (assert (= (extract-contact-info {:name "", :email "", :age 50}) {:name "", :email ""}) "Should preserve empty string values")
  "SUCCESS"
  )

(tst)
