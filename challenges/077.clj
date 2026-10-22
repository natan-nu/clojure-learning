(ns validate-transaction)

(defn validate-transaction
  "TODO: implement this function"
  [transaction]
  nil)

(defn- tst []
  (let [result (validate-transaction {:to-account-id "ACC002", :amount 5000, :account-status :active, :country-code "US", :is-international false, :currency :USD, :requires-2fa false, :has-2fa-verified false, :transaction-id "TX123", :available-balance 10000, :account-age-days 100, :transaction-count-24h 2, :from-account-id "ACC001"})] (assert (= (:status result) :valid) "Should be valid") (assert (nil? (:errors result)) "Should have no errors"))
  (let [result (validate-transaction {:to-account-id "ACC001", :amount 60000, :account-status :suspended, :country-code "US", :is-international false, :currency :JPY, :requires-2fa false, :has-2fa-verified false, :transaction-id "TX124", :available-balance 50000, :account-age-days 15, :transaction-count-24h 11, :from-account-id "ACC001"})] (assert (= (:status result) :invalid) "Should be invalid") (assert (= (count (:errors result)) 6) "Should have 6 errors"))
  (let [result (validate-transaction {:to-account-id "ACC002", :amount 15000, :account-status :active, :country-code "US", :is-international false, :currency :USD, :requires-2fa false, :has-2fa-verified false, :transaction-id "TX125", :available-balance 10000, :account-age-days 100, :transaction-count-24h 1, :from-account-id "ACC001"})] (assert (= (:status result) :invalid) "Should be invalid") (assert (= (count (:errors result)) 1) "Should have 1 error") (assert (some (fn* [%1] (re-find #"Insufficient funds" %1)) (:errors result)) "Should mention insufficient funds"))
  (let [result (validate-transaction {:to-account-id "ACC002", :amount 12000, :account-status :active, :country-code "DE", :is-international true, :currency :EUR, :requires-2fa true, :has-2fa-verified false, :transaction-id "TX126", :available-balance 20000, :account-age-days 100, :transaction-count-24h 2, :from-account-id "ACC001"})] (assert (= (:status result) :invalid) "Should be invalid") (assert (= (count (:errors result)) 2) "Should have 2FA errors"))
  (let [result (validate-transaction {:to-account-id "ACC002", :amount 7000, :account-status :active, :country-code "US", :is-international false, :currency :USD, :requires-2fa false, :has-2fa-verified false, :transaction-id "TX128", :available-balance 10000, :account-age-days 15, :transaction-count-24h 1, :from-account-id "ACC001"})] (assert (= (:status result) :invalid) "Should be invalid") (assert (some (fn* [%1] (re-find #"New accounts" %1)) (:errors result)) "Should mention new account limit"))
  "SUCCESS"
  )

(tst)
