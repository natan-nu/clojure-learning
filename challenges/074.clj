(ns build-response)

(defn build-response
  "TODO: implement this function"
  [data fields]
  nil)

(defn- tst []
  (assert (= (build-response {:id "U1", :name "John", :email "john@example.com", :age 30} [:id :name]) {:id "U1", :name "John"}) "Should select only requested fields")
  (let [result (build-response {:id "U1", :name "John", :posts [{:id "P1", :title "Post 1", :date "2024-01-15", :body "Long body..."} {:id "P2", :title "Post 2", :date "2024-01-16", :body "Another body..."}]} [:name {:posts [:title :date]}])] (assert (= (:name result) "John") "Should include simple field") (assert (= (count (:posts result)) 2) "Should include nested collection") (assert (= (get-in result [:posts 0 :title]) "Post 1") "Should select nested fields") (assert (nil? (get-in result [:posts 0 :body])) "Should omit unselected nested fields"))
  (assert (= (build-response {:id "U1", :profile {:name "John", :age 30, :email "john@example.com"}} [:id {:profile [:name :age]}]) {:id "U1", :profile {:name "John", :age 30}}) "Should handle nested objects")
  "SUCCESS"
  )

(tst)
