(ns add-full-name)

(defn add-full-name
  "TODO: implement this function"
  [user]
  nil)

(defn- tst []
  (assert (= (add-full-name {:first-name "John", :last-name "Doe"}) {:first-name "John", :last-name "Doe", :full-name "John Doe"}) "Should add full name from first and last name")
  (assert (= (add-full-name {:first-name "Jane", :last-name "Smith"}) {:first-name "Jane", :last-name "Smith", :full-name "Jane Smith"}) "Should work for different names")
  (assert (= (add-full-name {:first-name "Bob", :last-name "Johnson"}) {:first-name "Bob", :last-name "Johnson", :full-name "Bob Johnson"}) "Should concatenate with space correctly")
  (assert (= (add-full-name {:first-name "Alice", :last-name "Brown", :age 30, :email "alice@example.com"}) {:first-name "Alice", :last-name "Brown", :age 30, :email "alice@example.com", :full-name "Alice Brown"}) "Should preserve extra fields")
  (assert (= (add-full-name {:first-name "Mary", :last-name "Anne-Smith"}) {:first-name "Mary", :last-name "Anne-Smith", :full-name "Mary Anne-Smith"}) "Should work with hyphenated last names")
  (assert (= (add-full-name {:first-name "J", :last-name "K"}) {:first-name "J", :last-name "K", :full-name "J K"}) "Should work with single letter names")
  (assert (= (->> {:first-name "Charlie", :last-name "Wilson"} (add-full-name) (:full-name)) "Charlie Wilson") "Should be able to extract computed full name")
  (assert (= (map add-full-name [{:first-name "Dave", :last-name "Miller"} {:first-name "Eve", :last-name "Davis"}]) (quote ({:first-name "Dave", :last-name "Miller", :full-name "Dave Miller"} {:first-name "Eve", :last-name "Davis", :full-name "Eve Davis"}))) "Should work when mapping over collection")
  "SUCCESS"
  )

(tst)
