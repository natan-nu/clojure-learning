(ns project-events)

(defn project-events
  "TODO: implement this function"
  nil
  nil)

(defn- tst []
  (let [result (project-events [{:event-type :account-created, :timestamp 1000, :data {:account-id "ACC-123", :owner "John", :initial-balance 0}} {:event-type :deposit-made, :timestamp 1100, :data {:amount 1000}}])] (assert (= (:balance result) 1000) "Should process deposit correctly") (assert (= (:version result) 2) "Should track event version"))
  (let [result (project-events [{:event-type :account-created, :timestamp 1000, :data {:account-id "ACC-456", :owner "Jane", :initial-balance 500}} {:event-type :withdrawal-made, :timestamp 1100, :data {:amount 200}}])] (assert (= (:balance result) 300) "Should process withdrawal correctly"))
  (let [result (project-events [{:event-type :account-created, :timestamp 1000, :data {:account-id "ACC-789", :owner "Bob", :initial-balance 100}} {:event-type :withdrawal-made, :timestamp 1100, :data {:amount 150}}])] (assert (= (:balance result) 100) "Should not process withdrawal with insufficient funds") (assert (seq (:rejected-events result)) "Should record rejected event"))
  (let [result (project-events [{:event-type :account-created, :timestamp 1000, :data {:account-id "ACC-111", :owner "Alice", :initial-balance 500}} {:event-type :account-locked, :timestamp 1100, :data {:reason "suspicious"}} {:event-type :withdrawal-made, :timestamp 1200, :data {:amount 100}}])] (assert (= (:status result) :locked) "Should lock account") (assert (= (:balance result) 500) "Should not process operations on locked account") (assert (some (fn* [%1] (= (:event-type %1) :withdrawal-made)) (:rejected-events result)) "Should record rejected withdrawal"))
  (let [result (project-events [{:event-type :account-created, :timestamp 1000, :data {:account-id "ACC-222", :owner "Charlie", :initial-balance 300}} {:event-type :account-locked, :timestamp 1100, :data {:reason "test"}} {:event-type :account-unlocked, :timestamp 1200, :data {}}])] (assert (= (:status result) :active) "Should unlock account") (assert (nil? (:locked-reason result)) "Should clear lock reason"))
  (let [result (project-events [{:event-type :account-created, :timestamp 1000, :data {:account-id "ACC-333", :owner "Dave", :initial-balance 1000}} {:event-type :interest-accrued, :timestamp 2000, :data {:rate 0.05}}])] (assert (= (:balance result) 1050.0) "Should accrue interest correctly"))
  (let [result (project-events [{:event-type :account-created, :timestamp 1000, :data {:account-id "ACC-444", :owner "Eve", :initial-balance 200}} {:event-type :invalid-event, :timestamp 1100, :data {}}])] (assert (some (fn* [%1] (= (:reason %1) "Unknown event type")) (:rejected-events result)) "Should handle unknown event types"))
  "SUCCESS"
  )

(tst)
