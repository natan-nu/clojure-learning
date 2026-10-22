(ns check-eligibility)

(defn check-eligibility
  "TODO: implement this function"
  [applicant]
  nil)

(defn- tst []
  (assert (= (check-eligibility {:age 30, :income 50000, :credit-score 700, :employed true, :debt 10000}) {:eligible true, :reason "Applicant meets all criteria"}) "Should approve qualified applicant")
  (assert (= (check-eligibility {:age 17, :income 50000, :credit-score 700, :employed true, :debt 10000}) {:eligible false, :reason "Age outside eligible range"}) "Should reject applicant under 18")
  (assert (= (check-eligibility {:age 75, :income 50000, :credit-score 700, :employed true, :debt 10000}) {:eligible false, :reason "Age outside eligible range"}) "Should reject applicant over 70")
  (assert (= (check-eligibility {:age 30, :income 25000, :credit-score 700, :employed true, :debt 5000}) {:eligible false, :reason "Income below minimum"}) "Should reject low income")
  (assert (= (check-eligibility {:age 30, :income 50000, :credit-score 550, :employed true, :debt 10000}) {:eligible false, :reason "Credit score too low"}) "Should reject low credit score")
  (assert (= (check-eligibility {:age 30, :income 50000, :credit-score 700, :employed false, :debt 10000}) {:eligible false, :reason "Employment required"}) "Should reject unemployed applicant")
  (assert (= (check-eligibility {:age 30, :income 50000, :credit-score 700, :employed true, :debt 25000}) {:eligible false, :reason "Debt-to-income ratio too high"}) "Should reject high debt-to-income")
  (assert (= (:eligible (check-eligibility {:age 18, :income 30000, :credit-score 600, :employed true, :debt 12000})) true) "Should approve at minimum thresholds")
  (assert (= (:eligible (check-eligibility {:age 70, :income 100000, :credit-score 800, :employed true, :debt 40000})) true) "Should approve at maximum age")
  "SUCCESS"
  )

(tst)
