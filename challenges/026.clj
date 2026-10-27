(ns challenges.026)

(defn average-age
  [users]
  (if (empty? users) 0.0
      (let [total (reduce #(+ %1 (:age %2)) 0 users) cnt (count users)]
        (double (/ total cnt)))))

(defn- tst []
  (assert (= (average-age [{:name "John", :age 20} {:name "Jane", :age 30} {:name "Bob", :age 40}]) 30.0))
  (assert (= (average-age [{:name "Alice", :age 25} {:name "Charlie", :age 35}]) 30.0))
  (assert (= (average-age []) 0.0))
  (assert (= (average-age [{:name "Solo", :age 50}]) 50.0))
  "SUCCESS")

(tst)
