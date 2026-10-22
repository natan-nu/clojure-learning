(ns birthday)

(defn birthday
  "TODO: implement this function"
  [user]
  nil)

(defn- tst []
  (assert (= (birthday {:name "John", :age 25}) {:name "John", :age 26}) "Should increment age by 1")
  (assert (= (birthday {:name "Jane", :age 17}) {:name "Jane", :age 18}) "Should work when turning 18")
  (assert (= (birthday {:name "Bob", :age 0}) {:name "Bob", :age 1}) "Should work for first birthday")
  (assert (= (birthday {:name "Alice", :age 99}) {:name "Alice", :age 100}) "Should work for large ages")
  (assert (= (birthday {:name "Charlie", :age 30, :email "charlie@example.com", :city "New York"}) {:name "Charlie", :age 31, :email "charlie@example.com", :city "New York"}) "Should preserve extra fields")
  (assert (= (-> {:name "Dave", :age 20} (birthday) (birthday) (birthday)) {:name "Dave", :age 23}) "Should work with successive updates")
  (let [original {:name "Henry", :age 40} updated (birthday original)] (assert (= original {:name "Henry", :age 40}) "Should not modify original map") (assert (= updated {:name "Henry", :age 41}) "Should return new map with incremented age"))
  (assert (= (map birthday [{:name "Eve", :age 25} {:name "Frank", :age 30}]) (quote ({:name "Eve", :age 26} {:name "Frank", :age 31}))) "Should work when mapping over collection")
  "SUCCESS"
  )

(tst)
