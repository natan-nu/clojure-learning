(ns calculate-risk)

(defn calculate-risk
  "TODO: implement this function"
  [transaction]
  nil)

(defn- tst []
  (assert (= (calculate-risk {:amount 500, :user-age 25, :account-age-days 100}) {:score 0, :level :low}) "Should calculate low risk for safe transaction")
  (assert (= (calculate-risk {:amount 6000, :user-age 19, :account-age-days 20}) {:score 70, :level :high}) "Should calculate high risk for risky transaction")
  (assert (= (calculate-risk {:amount 2000, :user-age 30, :account-age-days 50}) {:score 20, :level :low}) "Should calculate risk at low boundary")
  (assert (= (calculate-risk {:amount 8000, :user-age 25, :account-age-days 100}) {:score 20, :level :low}) "Should handle medium amount only")
  (assert (= (calculate-risk {:amount 15000, :user-age 18, :account-age-days 10}) {:score 80, :level :high}) "Should calculate maximum risk score")
  (assert (= (:level (calculate-risk {:amount 0, :user-age 25, :account-age-days 100})) :low) "Should be low for 0 points")
  (assert (= (:level (calculate-risk {:amount 2000, :user-age 19, :account-age-days 50})) :medium) "Should be medium for 35 points")
  "SUCCESS"
  )

(tst)
