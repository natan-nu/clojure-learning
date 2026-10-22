(ns flatten-user-profile)

(defn flatten-user-profile
  "TODO: implement this function"
  [nested-profile]
  nil)

(defn- tst []
  (let [result (flatten-user-profile {:user-id "USER-123", :personal {:name "Alice Johnson", :birthdate "1990-05-15"}, :contact {:email {:primary "alice@example.com", :verified true}, :phone {:mobile "555-0100", :country-code "+1"}, :address {:street "123 Main St", :city "New York", :zip "10001", :country "USA"}}})] (assert (= (:id result) "USER-123") "Should extract user-id as id") (assert (= (:name result) "Alice Johnson") "Should extract name from personal") (assert (= (:birthdate result) "1990-05-15") "Should extract birthdate from personal") (assert (= (:email result) "alice@example.com") "Should extract primary email") (assert (true? (:email-verified result)) "Should extract email verified status") (assert (= (:mobile-phone result) "555-0100") "Should extract mobile phone") (assert (= (:phone-country-code result) "+1") "Should extract phone country code") (assert (= (:street result) "123 Main St") "Should extract street from address") (assert (= (:city result) "New York") "Should extract city from address") (assert (= (:zip result) "10001") "Should extract zip from address") (assert (= (:country result) "USA") "Should extract country from address"))
  (let [result (flatten-user-profile {:user-id "USER-456", :personal {:name "Bob Smith", :birthdate "1985-10-20"}, :contact {:email {:primary "bob@example.com", :verified false}, :phone {:mobile "555-0200", :country-code "+44"}, :address {:street "456 Oak Ave", :city "London", :zip "SW1A 1AA", :country "UK"}}})] (assert (= (:id result) "USER-456") "Should handle different user") (assert (false? (:email-verified result)) "Should handle unverified email") (assert (= (:phone-country-code result) "+44") "Should handle different country code") (assert (= (:country result) "UK") "Should handle different country"))
  "SUCCESS"
  )

(tst)
