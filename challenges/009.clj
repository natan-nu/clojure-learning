(ns remove-sensitive)

(defn remove-sensitive
  "TODO: implement this function"
  [user]
  nil)

(defn- tst []
  (assert (= (remove-sensitive {:name "John", :email "john@example.com", :password "secret123", :ssn "123-45-6789", :age 30}) {:name "John", :email "john@example.com", :age 30}) "Should remove :password and :ssn fields")
  (assert (= (remove-sensitive {:name "Jane", :email "jane@example.com", :password "pass456", :ssn "987-65-4321", :age 25}) {:name "Jane", :email "jane@example.com", :age 25}) "Should work for different users")
  (assert (= (remove-sensitive {:name "Bob", :email "bob@test.com", :password "mypass", :ssn "111-22-3333", :age 40}) {:name "Bob", :email "bob@test.com", :age 40}) "Should preserve non-sensitive fields")
  (assert (= (remove-sensitive {:name "Alice", :email "alice@example.com", :password "secret", :ssn "999-88-7777", :age 28, :city "New York", :role :admin}) {:name "Alice", :email "alice@example.com", :age 28, :city "New York", :role :admin}) "Should work with extra fields")
  (let [original {:name "Charlie", :email "charlie@example.com", :password "pass123", :ssn "555-44-3333", :age 35} sanitized (remove-sensitive original)] (assert (= original {:name "Charlie", :email "charlie@example.com", :password "pass123", :ssn "555-44-3333", :age 35}) "Should not modify original map") (assert (= sanitized {:name "Charlie", :email "charlie@example.com", :age 35}) "Should return new map without sensitive fields"))
  (assert (= (remove-sensitive {:name "Dave", :email "dave@example.com", :age 50}) {:name "Dave", :email "dave@example.com", :age 50}) "Should work even if sensitive fields don't exist")
  "SUCCESS"
  )

(tst)
