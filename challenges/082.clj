(ns multi-serialize
  (:require [clojure.string :as str] [clojure.edn :as edn]))

(defn multi-serialize
  "TODO: implement this function"
  [data format operation options]
  nil)

(defn- tst []
  (let [data {:id 1, :tags #{:b :a}, :count 42} serialized (multi-serialize data :edn :serialize {}) deserialized (multi-serialize serialized :edn :deserialize {})] (assert (= data deserialized) "EDN round-trip should be lossless"))
  (let [data {:user-id 123} serialized (multi-serialize data :json :serialize {:preserve-keywords true}) deserialized (multi-serialize serialized :json :deserialize {:preserve-keywords true})] (assert (= data deserialized) "JSON with keyword preservation should round-trip"))
  (let [result (multi-serialize {:tags #{:b :a}} :json :serialize {:preserve-keywords false})] (assert (map? result) "Should return map with warnings for lossy serialization") (assert (contains? result :warnings) "Should include warnings field"))
  (let [data {:items #{1 3 2}} serialized (multi-serialize data :json :serialize {}) result (if (string? serialized) serialized (:result serialized))] (assert (string? result) "Should serialize to string"))
  (let [data {:keyword :value, :vector [1 2 3]} serialized (multi-serialize data :transit :serialize {}) deserialized (multi-serialize serialized :transit :deserialize {})] (assert (= data deserialized) "Transit should preserve Clojure types"))
  (let [data {:user {:profile {:name "John", :age 30}}} edn-ser (multi-serialize data :edn :serialize {}) edn-deser (multi-serialize edn-ser :edn :deserialize {})] (assert (= data edn-deser) "Should handle nested structures"))
  "SUCCESS"
  )

(tst)
