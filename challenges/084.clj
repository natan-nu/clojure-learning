(ns process-record-through-stage)

(defn process-record-through-stage
  "TODO: implement this function"
  [record stage]
  nil)

(defn process-record-through-pipeline
  "TODO: implement this function"
  [record stages]
  nil)

(defn calculate-stats
  "TODO: implement this function"
  [total successful failed start-time end-time]
  nil)

(defn execute-pipeline
  "TODO: implement this function"
  [pipeline-config input-data]
  nil)

(defn- tst []
  (let [result (execute-pipeline {:stages [{:name :add-field, :fn (fn [r] (assoc r :processed true))}], :error-handling :continue} [{:id 1} {:id 2}])] (assert (= (count (:successful result)) 2) "Should have 2 successful") (assert (= (count (:failed result)) 0) "Should have 0 failed") (assert (= (get-in result [:stats :total]) 2) "Stats should show 2 total"))
  (let [result (execute-pipeline {:stages [{:name :validate, :fn (fn [r] (if (even? (:id r)) r (throw (Exception. "Odd ID"))))}], :error-handling :continue} [{:id 1} {:id 2} {:id 3}])] (assert (= (count (:successful result)) 1) "Should have 1 successful (id 2)") (assert (= (count (:failed result)) 2) "Should have 2 failed (ids 1,3)") (assert (some (fn* [%1] (= (:stage %1) :validate)) (:failed result)) "Failed records should have stage info"))
  (let [result (execute-pipeline {:stages [{:name :noop, :fn identity}], :error-handling :continue} [])] (assert (empty? (:successful result)) "Should have no successful") (assert (= (get-in result [:stats :total]) 0) "Stats should show 0 total"))
  (let [result (execute-pipeline {:stages [{:name :double, :fn (fn [r] (update r :val (fn* [%1] (* 2 %1))))} {:name :triple, :fn (fn [r] (update r :val (fn* [%1] (* 3 %1))))}], :error-handling :continue} [{:id 1, :val 5}])] (assert (= (get-in result [:successful 0 :val]) 30) "5 * 2 * 3 = 30"))
  (let [result (execute-pipeline {:stages [], :error-handling :continue} [{:id 1} {:id 2} {:id 3}])] (assert (number? (get-in result [:stats :duration-ms])) "Should have duration") (assert (= (get-in result [:stats :success-rate]) 1) "100% success rate"))
  "SUCCESS"
  )

(tst)
