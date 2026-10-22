(ns evaluate-loan-application)

(defn evaluate-loan-application
  "TODO: implement this function"
  [loan-application]
  nil)

(defn- tst []
  (assert (= (evaluate-loan-application {:credit-score 780, :annual-income 60000, :debt-to-income-ratio 25, :employment-status :employed, :loan-amount 150000}) :approved) "Should auto-approve: excellent credit, good income, low debt")
  (assert (= (evaluate-loan-application {:credit-score 820, :annual-income 80000, :debt-to-income-ratio 38, :employment-status :self-employed, :loan-amount 200000}) :approved) "Should auto-approve: very high credit and income")
  (assert (= (evaluate-loan-application {:credit-score 550, :annual-income 40000, :debt-to-income-ratio 35, :employment-status :employed, :loan-amount 100000}) :rejected) "Should auto-reject: poor credit score")
  (assert (= (evaluate-loan-application {:credit-score 750, :annual-income 0, :debt-to-income-ratio 0, :employment-status :unemployed, :loan-amount 50000}) :rejected) "Should auto-reject: unemployed")
  (assert (= (evaluate-loan-application {:credit-score 720, :annual-income 60000, :debt-to-income-ratio 55, :employment-status :employed, :loan-amount 100000}) :rejected) "Should auto-reject: excessive debt ratio")
  (assert (= (evaluate-loan-application {:credit-score 700, :annual-income 40000, :debt-to-income-ratio 30, :employment-status :employed, :loan-amount 250000}) :rejected) "Should auto-reject: loan too large for income")
  (assert (= (evaluate-loan-application {:credit-score 680, :annual-income 55000, :debt-to-income-ratio 32, :employment-status :self-employed, :loan-amount 120000}) :manual-review) "Should require manual review: borderline case")
  "SUCCESS"
  )

(tst)
