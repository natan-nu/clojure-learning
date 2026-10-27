(ns challenges.024)

(defn flatten-profile
  [profile]
  (:user profile))

(defn- tst []
  (assert (= (flatten-profile {:user {:name "John", :age 25, :email "john@example.com"}}) {:name "John", :age 25, :email "john@example.com"}))
  (assert (= (flatten-profile {:user {:name "Jane", :age 30, :email "jane@test.com"}}) {:name "Jane", :age 30, :email "jane@test.com"}))
  "SUCCESS")

(tst)
