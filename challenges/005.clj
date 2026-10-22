(ns challenges.005)

(defn validate-and-fetch
  [user-id]
  (if (pos? user-id)
    {:status :success
     :user {:id user-id
            :name (str "User " user-id)}}
    {:status :error
     :message "Invalid user ID"}))

(defn- tst []
  (assert (= (validate-and-fetch 1) {:status :success, :user {:id 1, :name "User 1"}}) "Valid ID 1 should return success with user data")
  (assert (= (validate-and-fetch 0) {:status :error, :message "Invalid user ID"}) "Zero should return error")
  (assert (= (validate-and-fetch -5) {:status :error, :message "Invalid user ID"}) "Negative ID should return error")
  (assert (= (validate-and-fetch 42) {:status :success, :user {:id 42, :name "User 42"}}) "Valid ID 42 should return success with correct name")
  (assert (= (validate-and-fetch 100) {:status :success, :user {:id 100, :name "User 100"}}) "Large valid ID should work correctly")
  (assert (= (validate-and-fetch -1) {:status :error, :message "Invalid user ID"}) "Negative ID -1 should return error")
  (let [result (validate-and-fetch 5)] (assert (= (:status result) :success) "Status should be :success for valid ID") (assert (contains? result :user) "Success result should contain :user key") (assert (= (get-in result [:user :id]) 5) "User ID should match input"))
  (let [result (validate-and-fetch -10)] (assert (= (:status result) :error) "Status should be :error for invalid ID") (assert (contains? result :message) "Error result should contain :message key"))
  "SUCCESS")

(tst)
