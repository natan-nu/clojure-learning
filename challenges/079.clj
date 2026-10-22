(ns extract-nested-data)

(defn extract-nested-data
  "TODO: implement this function"
  [data {:keys [paths aliases defaults required], :or {aliases {}, defaults {}, required #{}}}]
  nil)

(defn- tst []
  (let [result (extract-nested-data {:user {:profile {:name "John Doe"}}} {:paths [[:user :profile :name]], :aliases {[:user :profile :name] :name}})] (assert (= (:name result) "John Doe") "Should extract and alias simple nested value"))
  (let [result (extract-nested-data {:user {:profile {:name "Jane"}}} {:paths [[:user :profile :name] [:user :profile :email]], :aliases {[:user :profile :name] :name, [:user :profile :email] :email}, :defaults {[:user :profile :email] "no-email@example.com"}})] (assert (= (:email result) "no-email@example.com") "Should use default for missing optional field"))
  (let [result (extract-nested-data {:user {:profile {:name "Bob"}}} {:paths [[:user :profile :id]], :required #{[:user :profile :id]}, :aliases {[:user :profile :id] :user-id}})] (assert (contains? result :extraction-errors) "Should return errors for missing required paths") (assert (some (fn* [%1] (re-find #"Required path not found" %1)) (:extraction-errors result)) "Should include descriptive error message"))
  (let [result (extract-nested-data {:items [{:id 1} {:id 2}]} {:paths [[:items 0 :id] [:items 1 :id]], :aliases {[:items 0 :id] :first, [:items 1 :id] :second}})] (assert (= (:first result) 1) "Should extract from array by index") (assert (= (:second result) 2) "Should extract multiple array elements"))
  (let [result (extract-nested-data {:user {:bio nil}} {:paths [[:user :bio]], :aliases {[:user :bio] :bio}})] (assert (contains? result :bio) "Should include key even if value is nil") (assert (nil? (:bio result)) "Should preserve nil value"))
  (let [result (extract-nested-data {:order {:customer {:address {:city "Springfield"}}}} {:paths [[:order :customer :address :city]], :aliases {[:order :customer :address :city] :city}})] (assert (= (:city result) "Springfield") "Should handle deeply nested paths"))
  (let [result (extract-nested-data {:user {:id "U123", :email "user@example.com"}} {:paths [[:user :id] [:user :email]], :required #{[:user :id] [:user :email]}, :aliases {[:user :id] :id, [:user :email] :email}})] (assert (not (contains? result :extraction-errors)) "Should not return errors when all required present") (assert (= (:id result) "U123") "Should extract all required fields"))
  "SUCCESS"
  )

(tst)
