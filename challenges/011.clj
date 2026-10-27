(ns challenges.011)

(defn sum-ages
  [users]
  (reduce #(+ %1 (:age %2)) 0 users))

(defn- tst []
  (assert (= (sum-ages [{:name "John", :age 25} {:name "Jane", :age 30} {:name "Bob", :age 45}]) 100) "Should sum multiple ages correctly")
  (assert (= (sum-ages [{:name "Alice", :age 18}]) 18) "Should work with single user")
  (assert (= (sum-ages []) 0) "Should return 0 for empty collection")
  (assert (= (sum-ages [{:name "Diana", :age 20} {:name "Eve", :age 22} {:name "Frank", :age 28}]) 70) "Should sum different ages")
  (assert (= (sum-ages [{:name "User1", :age 10} {:name "User2", :age 20} {:name "User3", :age 30} {:name "User4", :age 40}]) 100) "Should work with many users")
  (assert (= (sum-ages [{:name "A", :age 25} {:name "B", :age 25} {:name "C", :age 25}]) 75) "Should work when all ages are the same")
  (assert (= (sum-ages [{:name "Senior1", :age 80} {:name "Senior2", :age 85}]) 165) "Should work with large ages")
  (assert (= (->> [{:name "Child", :age 10} {:name "Adult1", :age 25} {:name "Adult2", :age 30}] (filter (fn* [%1] (>= (:age %1) 18))) (sum-ages)) 55) "Should work when combined with filter")
  "SUCCESS")

(tst)
