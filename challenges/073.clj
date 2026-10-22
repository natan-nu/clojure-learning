(ns kebab->camel
  (:require [clojure.string :as str]))

(defn kebab->camel
  "TODO: implement this function"
  [s]
  nil)

(defn xml->json
  "TODO: implement this function"
  [xml-data]
  nil)

(defn- tst []
  (let [result (xml->json {:tag :user-profile, :attrs {:id "123"}, :content [{:tag :name, :attrs {}, :content ["John"]} {:tag :email, :attrs {}, :content ["john@example.com"]}]})] (assert (contains? result :userProfile) "Should convert tag to camelCase") (assert (= (get-in result [:userProfile :attributes :id]) "123") "Should preserve attributes") (assert (= (count (get-in result [:userProfile :children])) 2) "Should have 2 children"))
  (let [result (xml->json {:tag :simple-element, :attrs {}, :content ["Hello"]})] (assert (= (get-in result [:simpleElement :text]) "Hello") "Should extract text"))
  "SUCCESS"
  )

(tst)
