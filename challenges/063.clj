(ns query-string->map
  (:require [clojure.string :as str]))

(defn query-string->map
  "TODO: implement this function"
  [query-string]
  nil)

(defn- tst []
  (assert (= (query-string->map "name=John&age=25&city=NYC") {:name "John", :age "25", :city "NYC"}) "Should parse multiple parameters")
  (assert (= (query-string->map "status=active&verified=true") {:status "active", :verified "true"}) "Should keep boolean-like values as strings")
  (assert (= (query-string->map "") {}) "Should return empty map for empty string")
  (assert (= (query-string->map "query=clojure") {:query "clojure"}) "Should parse single parameter")
  (assert (= (query-string->map "page=1&limit=10&offset=20") {:page "1", :limit "10", :offset "20"}) "Should keep numeric-like values as strings")
  (assert (= (query-string->map "firstName=Alice&lastName=Smith&email=alice@example.com") {:firstName "Alice", :lastName "Smith", :email "alice@example.com"}) "Should handle camelCase keys")
  "SUCCESS"
  )

(tst)
