(ns calculate-risk-score)

(defn calculate-risk-score
  "TODO: implement this function"
  [transaction]
  nil)

(defn- tst []
  (assert (= (calculate-risk-score {:amount 500, :user-verified true, :account-age-days 180, :has-fraud-history false}) :low) "Low risk: verified, reasonable amount, good history")
  (assert (= (calculate-risk-score {:amount 15000, :user-verified false, :account-age-days 20, :has-fraud-history false}) :high) "High risk: large amount, unverified, new account")
  (assert (= (calculate-risk-score {:amount 12000, :user-verified true, :account-age-days 10, :has-fraud-history false}) :high) "High risk: large amount with very new account even if verified")
  (assert (= (calculate-risk-score {:amount 1000, :user-verified true, :account-age-days 5, :has-fraud-history true}) :critical) "Critical: fraud history overrides all other factors")
  (assert (= (calculate-risk-score {:amount 6000, :user-verified false, :account-age-days 100, :has-fraud-history false}) :medium) "Medium risk: unverified with medium-high amount")
  (assert (= (calculate-risk-score {:amount 12000, :user-verified true, :account-age-days 200, :has-fraud-history false}) :medium) "Medium risk: very large amount even if verified and old account")
  (assert (= (calculate-risk-score {:amount 100, :user-verified false, :account-age-days 50, :has-fraud-history false}) :medium) "Medium risk: unverified new account even with small amount")
  "SUCCESS"
  )

(tst)
