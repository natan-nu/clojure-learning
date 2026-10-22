(ns fetch-with-fallback)

(defn fetch-with-fallback
  "TODO: implement this function"
  [user-id]
  nil)

(defn- tst []
  (assert (= (fetch-with-fallback 100) {:status :success, :user {:id 100, :name "User 100"}}))
  (assert (= (fetch-with-fallback 0) {:status :error, :message "Invalid ID"}))
  (assert (= (fetch-with-fallback -5) {:status :error, :message "Invalid ID"}))
  (assert (= (fetch-with-fallback 2000) {:status :error, :message "ID out of range"}))
  (assert (= (fetch-with-fallback 51) {:status :error, :message "User not found"}))
  (assert (= (fetch-with-fallback 1) {:status :error, :message "User not found"}))
  (assert (= (:status (fetch-with-fallback 2)) :success))
  (assert (= (:status (fetch-with-fallback 500)) :success))
  "SUCCESS"
  )

(tst)
