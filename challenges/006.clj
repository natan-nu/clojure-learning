(ns challenges.006)

(defn filter-adults
  [users]
  (filterv #(>= (:age %) 18) users))

(defn- tst []
  (assert (= (filter-adults [{:name "John", :age 25} {:name "Jane", :age 17} {:name "Bob", :age 30}]) [{:name "John", :age 25} {:name "Bob", :age 30}]) "Should filter out minors and keep adults")
  (assert (= (filter-adults [{:name "Alice", :age 16} {:name "Charlie", :age 15}]) []) "Should return empty vector when all are minors")
  (assert (= (filter-adults [{:name "Diana", :age 18} {:name "Eve", :age 18}]) [{:name "Diana", :age 18} {:name "Eve", :age 18}]) "Should include users exactly 18 years old")
  (assert (= (filter-adults []) []) "Should return empty vector for empty input")
  (assert (= (filter-adults [{:name "Frank", :age 21}]) [{:name "Frank", :age 21}]) "Should work with single adult")
  (assert (= (filter-adults [{:name "Grace", :age 18} {:name "Henry", :age 17}]) [{:name "Grace", :age 18}]) "Should include 18 but exclude 17")
  (assert (= (filter-adults [{:name "Ivy", :age 80} {:name "Jack", :age 10} {:name "Kate", :age 45}]) [{:name "Ivy", :age 80} {:name "Kate", :age 45}]) "Should work with large age ranges")
  (assert (= (filter-adults [{:name "Z", :age 25} {:name "A", :age 30} {:name "M", :age 17}]) [{:name "Z", :age 25} {:name "A", :age 30}]) "Should preserve original order")
  "SUCCESS")

(tst)
