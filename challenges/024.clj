(ns flatten-profile)

(defn flatten-profile
  "TODO: implement this function"
  [profile]
  nil)

(defn- tst []
  (assert (= (flatten-profile {:user {:name "John", :age 25, :email "john@example.com"}}) {:name "John", :age 25, :email "john@example.com"}))
  (assert (= (flatten-profile {:user {:name "Jane", :age 30, :email "jane@test.com"}}) {:name "Jane", :age 30, :email "jane@test.com"}))
  "SUCCESS"
  )

(tst)
