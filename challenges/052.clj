(ns calculate-activity-level)

(defn calculate-activity-level
  "TODO: implement this function"
  [login-count]
  nil)

(defn aggregate-user-data
  "TODO: implement this function"
  [user-profile user-preferences user-activity]
  nil)

(defn- tst []
  (let [result (aggregate-user-data {:user-id "USER-1", :name "Alice", :email "alice@example.com", :join-date "2023-01-15"} {:theme "dark", :language "pt", :notifications true} {:last-login "2024-01-15", :login-count 150, :posts-count 45})] (assert (= (:user-id result) "USER-1") "Should include profile data") (assert (= (:theme result) "dark") "Should include preference data") (assert (= (:login-count result) 150) "Should include activity data") (assert (= (:activity-level result) :very-active) "Should calculate activity level (>=100)"))
  (let [result (aggregate-user-data {:user-id "USER-2", :name "Bob", :email "bob@example.com", :join-date "2024-01-01"} nil {:last-login "2024-01-10", :login-count 5, :posts-count 2})] (assert (= (:theme result) "default") "Should use default theme when preferences nil") (assert (= (:language result) "en") "Should use default language when preferences nil") (assert (false? (:notifications result)) "Should use default notifications when preferences nil") (assert (= (:activity-level result) :low) "Should calculate low activity (<10)"))
  (let [result (aggregate-user-data {:user-id "USER-3", :name "Charlie", :email "charlie@example.com", :join-date "2023-06-01"} {:theme "light"} {:last-login "2024-01-14", :login-count 75, :posts-count 30})] (assert (= (:theme result) "light") "Should use provided theme") (assert (= (:language result) "en") "Should use default for missing language") (assert (= (:activity-level result) :active) "Should calculate active level (>=50, <100)"))
  (assert (= (calculate-activity-level 100) :very-active) "Should be very-active at exactly 100")
  (assert (= (calculate-activity-level 50) :active) "Should be active at exactly 50")
  (assert (= (calculate-activity-level 10) :moderate) "Should be moderate at exactly 10")
  (assert (= (calculate-activity-level 9) :low) "Should be low below 10")
  "SUCCESS"
  )

(tst)
