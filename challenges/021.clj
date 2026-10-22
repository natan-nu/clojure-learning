(ns age-category)

(defn age-category
  "TODO: implement this function"
  [age]
  nil)

(defn group-by-age
  "TODO: implement this function"
  [users]
  nil)

(defn- tst []
  (let [result (group-by-age [{:name "Alice", :age 10} {:name "Bob", :age 16} {:name "Charlie", :age 30} {:name "Diana", :age 70}])] (assert (= (count (:child result)) 1) "Should have 1 child") (assert (= (count (:teen result)) 1) "Should have 1 teen") (assert (= (count (:adult result)) 1) "Should have 1 adult") (assert (= (count (:senior result)) 1) "Should have 1 senior"))
  (let [result (group-by-age [{:name "John", :age 25} {:name "Jane", :age 30}])] (assert (empty? (:child result)) "Child should be empty") (assert (empty? (:teen result)) "Teen should be empty") (assert (= (count (:adult result)) 2) "Should have 2 adults") (assert (empty? (:senior result)) "Senior should be empty"))
  (let [result (group-by-age [])] (assert (= result {:child [], :teen [], :adult [], :senior []}) "All categories should exist and be empty"))
  (let [result (group-by-age [{:name "Age12", :age 12} {:name "Age13", :age 13} {:name "Age17", :age 17} {:name "Age18", :age 18} {:name "Age64", :age 64} {:name "Age65", :age 65}])] (assert (= (count (:child result)) 1) "12 should be child") (assert (= (count (:teen result)) 2) "13-17 should be teen") (assert (= (count (:adult result)) 2) "18-64 should be adult") (assert (= (count (:senior result)) 1) "65+ should be senior"))
  (assert (= (age-category 0) :child))
  (assert (= (age-category 12) :child))
  (assert (= (age-category 13) :teen))
  (assert (= (age-category 17) :teen))
  (assert (= (age-category 18) :adult))
  (assert (= (age-category 64) :adult))
  (assert (= (age-category 65) :senior))
  (assert (= (age-category 100) :senior))
  (let [result (group-by-age [{:name "Test", :age 25}])] (assert (contains? result :child)) (assert (contains? result :teen)) (assert (contains? result :adult)) (assert (contains? result :senior)))
  "SUCCESS"
  )

(tst)
