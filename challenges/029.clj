(ns increment-age)

(defn increment-age
  "TODO: implement this function"
  [profile]
  nil)

(defn- tst []
  (assert (= (increment-age {:user {:name "John", :details {:age 25}}}) {:user {:name "John", :details {:age 26}}}))
  (assert (= (increment-age {:user {:name "Jane", :details {:age 30}}}) {:user {:name "Jane", :details {:age 31}}}))
  (let [result (increment-age {:user {:name "Bob", :details {:age 40}}})] (assert (= (get-in result [:user :name]) "Bob")))
  "SUCCESS"
  )

(tst)
