(ns extract-domain
  (:require [clojure.string :as str]))

(defn extract-domain
  "TODO: implement this function"
  [email]
  nil)

(defn- tst []
  (assert (= (extract-domain "john@example.com") "example.com") "Should extract domain from standard email")
  (assert (= (extract-domain "jane@test.org") "test.org") "Should work with different TLD")
  (assert (= (extract-domain "bob@company.co.uk") "company.co.uk") "Should work with multi-part domains")
  (assert (= (extract-domain "invalid-email") "") "Should return empty string when no @ present")
  (assert (= (extract-domain "user@mail.example.com") "mail.example.com") "Should extract full domain including subdomain")
  (assert (= (extract-domain "@") "") "Should handle just @ symbol")
  (assert (= (extract-domain "@example.com") "example.com") "Should handle @ at start")
  (assert (= (extract-domain "user@") "") "Should return empty string when @ at end")
  (assert (= (extract-domain "user@host@example.com") "example.com") "Should take last part when multiple @ present")
  (assert (= (map extract-domain ["john@example.com" "jane@test.org" "bob@company.co.uk"]) (quote ("example.com" "test.org" "company.co.uk"))) "Should work when mapping over collection")
  "SUCCESS"
  )

(tst)
