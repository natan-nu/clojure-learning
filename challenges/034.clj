(ns coerce-user-types)

(defn coerce-user-types
  "TODO: implement this function"
  [raw-user]
  nil)

(defn- tst []
  (assert (= (coerce-user-types {:name "John", :age "25", :active "true", :role "admin"}) {:name "John", :age 25, :active true, :role :admin}) "Should coerce all types for active admin")
  (assert (= (coerce-user-types {:name "Jane", :age "30", :active "false", :role "user"}) {:name "Jane", :age 30, :active false, :role :user}) "Should coerce all types for inactive user")
  (assert (= (coerce-user-types {:name "Bob", :age "45", :active "true", :role "moderator"}) {:name "Bob", :age 45, :active true, :role :moderator}) "Should coerce all types for active moderator")
  (let [result (coerce-user-types {:name "Test", :age "18", :active "false", :role "guest"})] (assert (string? (:name result)) "Name should be string") (assert (integer? (:age result)) "Age should be integer") (assert (boolean? (:active result)) "Active should be boolean") (assert (keyword? (:role result)) "Role should be keyword"))
  "SUCCESS"
  )

(tst)
