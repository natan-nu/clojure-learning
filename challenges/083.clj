(ns process-event)

(defn process-event
  "TODO: implement this function"
  [machine-state event event-data]
  nil)

(defn- tst []
  (let [result (process-event {:current-state :draft, :context {:doc-id "DOC-1"}, :history [], :definition {:transitions {:draft {:submit :review}}}} :submit {})] (assert (= (:current-state result) :review) "Should transition to review state") (assert (= (count (:history result)) 1) "Should add entry to history"))
  (let [result (process-event {:current-state :review, :context {:approvals 1, :required 2}, :history [], :definition {:transitions {:review {:approve :approved}}, :guards {:review {:approve (fn [ctx _] (>= (:approvals ctx) (:required ctx)))}}}} :approve {})] (assert (contains? result :error) "Should return error when guard fails") (assert (= (:current-state result) :review) "Should not change state when guard fails"))
  (let [result (process-event {:current-state :review, :context {:approvals 2, :required 2}, :history [], :definition {:transitions {:review {:approve :approved}}, :guards {:review {:approve (fn [ctx _] (>= (:approvals ctx) (:required ctx)))}}}} :approve {})] (assert (= (:current-state result) :approved) "Should transition when guard passes"))
  (let [result (process-event {:current-state :approved, :context {}, :history [], :definition {:transitions {:approved {:publish :published}}, :effects {:approved {:publish [:notify :index]}}}} :publish {})] (assert (= (:effects result) [:notify :index]) "Should collect side effects"))
  (let [result (process-event {:current-state :draft, :context {}, :history [], :definition {:transitions {:draft {:submit :review}}}} :invalid-event {})] (assert (contains? result :error) "Should error on undefined transition"))
  (let [result (process-event {:current-state :review, :context {:version 1}, :history [], :definition {:transitions {:review {:update :review}}}} :update {:version 2, :editor "user-123"})] (assert (= (:version (:context result)) 2) "Should update context with event data"))
  (let [result (process-event {:current-state :draft, :context {}, :history [], :definition {:transitions {:draft {:submit :review}}}} :submit {})] (assert (= (get-in result [:history 0 :from]) :draft) "History should track from-state") (assert (= (get-in result [:history 0 :to]) :review) "History should track to-state") (assert (= (get-in result [:history 0 :event]) :submit) "History should track event"))
  "SUCCESS"
  )

(tst)
