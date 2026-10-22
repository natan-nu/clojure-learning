(ns rule-matches-role?)

(defn rule-matches-role?
  "TODO: implement this function"
  [user rule]
  nil)

(defn rule-matches-action?
  "TODO: implement this function"
  [action rule]
  nil)

(defn rule-conditions-pass?
  "TODO: implement this function"
  [user resource context rule]
  nil)

(defn rule-matches?
  "TODO: implement this function"
  [user resource action context rule]
  nil)

(defn authorize
  "TODO: implement this function"
  [policy user resource action context]
  nil)

(defn- tst []
  (let [result (authorize {:rules [{:id "R1", :roles #{:admin}, :actions #{:delete}, :allow true}]} {:user-id "U1", :roles #{:admin}} {:id "DOC1"} :delete {})] (assert (:allow result) "Admin should be allowed to delete") (assert (= (:matched-rules result) ["R1"]) "Should match R1"))
  (let [result (authorize {:rules [{:id "R2", :roles #{:admin}, :actions #{:delete}, :allow true}]} {:user-id "U2", :roles #{:user}} {:id "DOC2"} :delete {})] (assert (not (:allow result)) "User should be denied") (assert (empty? (:matched-rules result)) "Should have no matched rules"))
  (let [result (authorize {:rules [{:id "R3", :conditions [(fn [u r c] (= (:dept u) (:dept r)))], :actions #{:read}, :allow true}]} {:user-id "U3", :dept "eng", :roles #{:dev}} {:id "DOC3", :dept "eng"} :read {})] (assert (:allow result) "Same department should allow access"))
  (let [result (authorize {:rules [{:id "R4", :conditions [(fn [u r c] (< (:hour c) 18))], :actions #{:access}, :allow true}]} {:user-id "U4", :roles #{:user}} {:id "RES4"} :access {:hour 20})] (assert (not (:allow result)) "After hours should deny"))
  (let [result (authorize {:rules [{:id "R5-deny", :roles #{:intern}, :actions #{:write}, :allow false} {:id "R6-allow", :actions #{:write}, :allow true}]} {:user-id "U5", :roles #{:intern}} {:id "DOC5"} :write {})] (assert (not (:allow result)) "First matching rule should deny") (assert (= (:matched-rules result) ["R5-deny"]) "Should match deny rule"))
  "SUCCESS"
  )

(tst)
