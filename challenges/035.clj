(ns try-fetch-primary)

(defn try-fetch-primary
  "TODO: implement this function"
  [user-id]
  nil)

(defn try-fetch-secondary
  "TODO: implement this function"
  [user-id]
  nil)

(defn try-fetch-with-fallback
  "TODO: implement this function"
  [user-id]
  nil)

(defn- tst []
  (assert (= (try-fetch-with-fallback 50) {:status :success, :source :primary, :user {:id 50, :name "User 50"}}) "Should fetch from primary for even <= 100")
  (assert (= (try-fetch-with-fallback 150) {:status :success, :source :secondary, :user {:id 150, :name "User 150"}}) "Should fetch from secondary for even > 100")
  (assert (= (try-fetch-with-fallback 99) {:status :error, :message "User not found in any source"}) "Should return error for odd numbers")
  (assert (= (:source (try-fetch-with-fallback 100)) :primary) "Should use primary for 100 (boundary)")
  (assert (= (:source (try-fetch-with-fallback 102)) :secondary) "Should use secondary for 102 (just above boundary)")
  (assert (= (try-fetch-with-fallback 1) {:status :error, :message "User not found in any source"}) "Should return error for odd 1")
  "SUCCESS"
  )

(tst)
