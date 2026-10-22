(ns calculate-risk-level)

(defn calculate-risk-level
  "TODO: implement this function"
  [{:keys [health-status occupation-risk coverage-amount smoker age]}]
  nil)

(defn calculate-eligibility
  "TODO: implement this function"
  [applicant]
  nil)

(defn- tst []
  (let [result (calculate-eligibility {:age 30, :health-status :excellent, :occupation-risk :low, :coverage-amount 200000, :has-preexisting false, :smoker false})] (assert (true? (:eligible result)) "Should be eligible") (assert (= (:risk-level result) :low) "Should be low risk") (assert (= (:premium-multiplier result) 1.0) "Should have 1.0x multiplier") (assert (= (:reason result) "Approved") "Should have approval reason"))
  (let [result (calculate-eligibility {:age 80, :health-status :good, :occupation-risk :low, :coverage-amount 100000, :has-preexisting false, :smoker false})] (assert (false? (:eligible result)) "Should be ineligible") (assert (= (:reason result) "Age exceeds maximum") "Should have age reason"))
  (let [result (calculate-eligibility {:age 15, :health-status :excellent, :occupation-risk :low, :coverage-amount 50000, :has-preexisting false, :smoker false})] (assert (false? (:eligible result)) "Should be ineligible") (assert (= (:reason result) "Below minimum age") "Should have age reason"))
  (let [result (calculate-eligibility {:age 45, :health-status :poor, :occupation-risk :low, :coverage-amount 150000, :has-preexisting true, :smoker false})] (assert (false? (:eligible result)) "Should be ineligible") (assert (= (:reason result) "Health risk too high") "Should have health reason"))
  (let [result (calculate-eligibility {:age 35, :health-status :excellent, :occupation-risk :high, :coverage-amount 600000, :has-preexisting false, :smoker false})] (assert (false? (:eligible result)) "Should be ineligible") (assert (= (:reason result) "Occupation risk too high for coverage") "Should have occupation reason"))
  (let [result (calculate-eligibility {:age 50, :health-status :fair, :occupation-risk :medium, :coverage-amount 350000, :has-preexisting false, :smoker true})] (assert (true? (:eligible result)) "Should be eligible") (assert (= (:risk-level result) :high) "Should be high risk") (assert (= (:premium-multiplier result) 2.0) "Should have 2.0x multiplier"))
  (let [result (calculate-eligibility {:age 40, :health-status :good, :occupation-risk :low, :coverage-amount 400000, :has-preexisting false, :smoker false})] (assert (true? (:eligible result)) "Should be eligible") (assert (= (:risk-level result) :medium) "Should be medium risk") (assert (= (:premium-multiplier result) 1.5) "Should have 1.5x multiplier"))
  (let [result (calculate-eligibility {:age 65, :health-status :good, :occupation-risk :low, :coverage-amount 200000, :has-preexisting false, :smoker true})] (assert (true? (:eligible result)) "Should be eligible") (assert (= (:risk-level result) :critical) "Should be critical risk") (assert (= (:premium-multiplier result) 3.0) "Should have 3.0x multiplier"))
  "SUCCESS"
  )

(tst)
