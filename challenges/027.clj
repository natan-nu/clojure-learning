(ns all-adults?)

(defn all-adults?
  "TODO: implement this function"
  [users]
  nil)

(defn- tst []
  (assert (= (all-adults? [{:name "John", :age 25} {:name "Jane", :age 30}]) true))
  (assert (= (all-adults? [{:name "John", :age 25} {:name "Bob", :age 17}]) false))
  (assert (= (all-adults? []) true))
  (assert (= (all-adults? [{:name "Alice", :age 18}]) true))
  (assert (= (all-adults? [{:name "Child", :age 10}]) false))
  "SUCCESS"
  )

(tst)
