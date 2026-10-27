(ns challenges.017)

(defn find-oldest
  [users]
  (apply max-key :age users))

(defn- tst []
  (assert (= (find-oldest [{:name "John", :age 25} {:name "Jane", :age 30} {:name "Bob", :age 20}]) {:name "Jane", :age 30}) "Should return Jane with age 30")
  (assert (= (find-oldest [{:name "Alice", :age 45} {:name "Charlie", :age 50}]) {:name "Charlie", :age 50}) "Should return Charlie with age 50")
  (assert (= (find-oldest [{:name "Solo", :age 99}]) {:name "Solo", :age 99}) "Should return the only user")
  (let [result (find-oldest [{:name "Eve", :age 35} {:name "Frank", :age 35} {:name "Grace", :age 30}])] (assert (= (:age result) 35) "Should return user with age 35") (assert (contains? #{"Frank" "Eve"} (:name result)) "Should return either Eve or Frank"))
  (assert (= (find-oldest [{:name "Dave", :age 40, :email "dave@test.com"} {:name "Emma", :age 45, :email "emma@test.com"}]) {:name "Emma", :age 45, :email "emma@test.com"}) "Should preserve extra fields")
  (assert (= (find-oldest [{:name "Young", :age 18} {:name "Old", :age 100} {:name "Middle", :age 50}]) {:name "Old", :age 100}) "Should handle large age values")
  (let [result (find-oldest [{:name "A", :age 25} {:name "B", :age 25} {:name "C", :age 25}])] (assert (= (:age result) 25) "Should return user with age 25 when all same"))
  "SUCCESS"
  )

(tst)
