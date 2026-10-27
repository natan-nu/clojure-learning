(ns challenges.016
  (:require [clojure.string :as str]))

(defn valid-email?
  [email]
  (and (not (str/blank? email)) (str/includes? email "@")))

(defn count-valid-emails
  [emails]
  (count (filter valid-email? emails)))

(defn- tst []
  (assert (= (count-valid-emails ["john@example.com" "invalid" "jane@test.com"]) 2) "Should count 2 valid emails out of 3")
  (assert (= (count-valid-emails ["test@test.com" "" "   " "user@domain.org"]) 2) "Should ignore blank entries")
  (assert (= (count-valid-emails ["invalid" "no-at-sign" ""]) 0) "Should return 0 for all invalid")
  (assert (= (count-valid-emails []) 0) "Should return 0 for empty collection")
  (assert (= (count-valid-emails ["a@b.com" "test@example.org" "user@domain.net"]) 3) "Should count all 3 valid emails")
  (assert (= (count-valid-emails ["@" "test@test.com"]) 2) "@ alone should count as valid by our simple rule")
  (assert (= (count-valid-emails ["single@test.com"]) 1) "Should count single valid email")
  (assert (= (valid-email? "test@example.com") true) "Helper should validate correct email")
  (assert (= (valid-email? "invalid") false) "Helper should reject email without @")
  (assert (= (valid-email? "") false) "Helper should reject blank email")
  "SUCCESS")

(tst)
