(ns valid-email-format?
  (:require [clojure.string :as str]))

(defn valid-email-format?
  "TODO: implement this function"
  [email]
  nil)

(defn- tst []
  (assert (= (valid-email-format? "user@example.com") true) "Should return true for valid simple email")
  (assert (= (valid-email-format? "invalid.email") false) "Should return false for email without @")
  (assert (= (valid-email-format? "@example.com") false) "Should return false for empty username")
  (assert (= (valid-email-format? "user@domain") false) "Should return false for domain without dot")
  (assert (= (valid-email-format? "user@mail.example.com") true) "Should return true for email with subdomain")
  (assert (= (valid-email-format? "user@@example.com") false) "Should return false for multiple @ symbols")
  (assert (= (valid-email-format? "user@") false) "Should return false for empty domain")
  (assert (= (valid-email-format? "user@example.") false) "Should return false for missing TLD")
  (assert (= (valid-email-format? "john.doe@company.co.uk") true) "Should return true for complex valid email")
  "SUCCESS"
  )

(tst)
