(ns challenges.023)

(defn keywords->strings
  [data]
  (reduce-kv #(assoc %1 (name %2) %3) {} data))

(defn- tst []
  (assert (= (keywords->strings {:name "John", :age 25}) {"name" "John", "age" 25}))
  (assert (= (keywords->strings {:user-id 123, :email "test@example.com"}) {"user-id" 123, "email" "test@example.com"}))
  (assert (= (keywords->strings {}) {}))
  "SUCCESS")

(tst)
