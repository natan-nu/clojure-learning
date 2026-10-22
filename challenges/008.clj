(ns add-status)

(defn add-status
  "TODO: implement this function"
  [user]
  nil)

(defn- tst []
  (assert (= (add-status {:name "John", :email "john@example.com"}) {:name "John", :email "john@example.com", :status :active}) "Should add :status :active to user map")
  (assert (= (add-status {:name "Jane", :email "jane@example.com"}) {:name "Jane", :email "jane@example.com", :status :active}) "Should work for different users")
  (assert (= (add-status {:name "Bob", :email "bob@test.com"}) {:name "Bob", :email "bob@test.com", :status :active}) "Should preserve all existing fields")
  (assert (= (add-status {:name "Alice", :email "alice@example.com", :age 30, :city "New York"}) {:name "Alice", :email "alice@example.com", :age 30, :city "New York", :status :active}) "Should work with maps containing extra fields")
  (let [original {:name "Charlie", :email "charlie@example.com"} updated (add-status original)] (assert (= original {:name "Charlie", :email "charlie@example.com"}) "Should not modify original map") (assert (= updated {:name "Charlie", :email "charlie@example.com", :status :active}) "Should return new map with status"))
  (assert (= (add-status {:name "Dave", :email "dave@example.com", :status :inactive}) {:name "Dave", :email "dave@example.com", :status :active}) "Should overwrite existing :status field")
  (assert (= (add-status {:name "", :email ""}) {:name "", :email "", :status :active}) "Should work with empty string values")
  "SUCCESS"
  )

(tst)
