(ns challenges.028
  (:require [clojure.string :as str]))

(defn kebab->camel
  [s]
  (let [parts (str/split s #"-")]
    (str (first parts) (str/join "" (map str/capitalize (rest parts))))))

(defn camel->kebab
  [s]
  (-> s
      (str/replace #"([A-Z])" "-$1")
      (str/lower-case)))

(defn domain->wire
  [data]
  (reduce-kv #(assoc %1 (kebab->camel (name %2)) %3) {} data))

(defn wire->domain
  [data]
  (reduce-kv #(assoc %1 (keyword (camel->kebab %2)) %3) {} data))

(defn- tst []
  (assert (= (domain->wire {:user-id 123, :full-name "John", :email-address "j@test.com"}) {"userId" 123, "fullName" "John", "emailAddress" "j@test.com"}))
  (assert (= (wire->domain {"userId" 456, "fullName" "Jane", "emailAddress" "jane@test.com"}) {:user-id 456, :full-name "Jane", :email-address "jane@test.com"}))
  (let [original {:user-id 789, :full-name "Bob", :email-address "bob@test.com"}] (assert (= (wire->domain (domain->wire original)) original)))
  "SUCCESS")

(tst)
