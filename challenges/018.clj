(ns parse-numbers)

(defn parse-numbers
  "TODO: implement this function"
  [user-data]
  nil)

(defn- tst []
  (assert (= (parse-numbers {:name "John", :age "25", :score "100"}) {:name "John", :age 25, :score 100}) "Should parse age and score to integers")
  (assert (= (parse-numbers {:name "Jane", :age "30", :score "95"}) {:name "Jane", :age 30, :score 95}) "Should work with different values")
  (assert (= (parse-numbers {:name "Bob", :age "18", :score "0"}) {:name "Bob", :age 18, :score 0}) "Should handle zero correctly")
  (assert (= (parse-numbers {:name "Alice", :age "99", :score "9999"}) {:name "Alice", :age 99, :score 9999}) "Should handle large numbers")
  (let [result (parse-numbers {:name "Charlie", :age "25", :score "85"})] (assert (string? (:name result)) "Name should remain a string") (assert (= (:name result) "Charlie") "Name should be unchanged"))
  (let [result (parse-numbers {:name "Dave", :age "20", :score "70"})] (assert (integer? (:age result)) "Age should be an integer") (assert (integer? (:score result)) "Score should be an integer"))
  (assert (= (map parse-numbers [{:name "Emma", :age "22", :score "80"} {:name "Frank", :age "24", :score "90"}]) (quote ({:name "Emma", :age 22, :score 80} {:name "Frank", :age 24, :score 90}))) "Should work when mapping over collection")
  "SUCCESS"
  )

(tst)
