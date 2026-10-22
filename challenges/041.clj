(ns categorize-transaction)

(defn categorize-transaction
  "TODO: implement this function"
  [transaction]
  nil)

(defn- tst []
  (assert (= (categorize-transaction {:type :purchase, :amount 50, :merchant-category "other", :priority true}) :urgent) "Priority flag should override all other rules")
  (assert (= (categorize-transaction {:type :purchase, :amount 10000, :merchant-category "bank", :priority false}) :high-value) "Amount > 5000 should be high-value")
  (assert (= (categorize-transaction {:type :transfer, :amount 1500, :merchant-category "bank", :priority false}) :high-value) "Transfer > 1000 should be high-value")
  (assert (= (categorize-transaction {:type :purchase, :amount 100, :merchant-category "travel", :priority false}) :travel) "Travel category should be recognized")
  (assert (= (categorize-transaction {:type :purchase, :amount 100, :merchant-category "restaurant", :priority false}) :dining) "Restaurant category should be dining")
  (assert (= (categorize-transaction {:type :purchase, :amount 100, :merchant-category "retail", :priority false}) :shopping) "Retail category should be shopping")
  (assert (= (categorize-transaction {:type :bill-payment, :amount 200, :merchant-category "utilities", :priority false}) :bills) "Bill payment type should be bills")
  (assert (= (categorize-transaction {:type :purchase, :amount 25, :merchant-category "gas-station", :priority false}) :other) "Unmatched transaction should be other")
  "SUCCESS"
  )

(tst)
