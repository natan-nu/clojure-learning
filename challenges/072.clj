(ns authorize)

(defn authorize
  "TODO: implement this function"
  [user resource action]
  nil)

(defn- tst []
  (assert (= (:authorized (authorize {:user-id "U1", :role :admin, :team-id "T1"} {:owner-id "U2", :team-id "T2", :visibility :private, :status :active} :delete)) true) "Admin should have full access")
  (assert (= (:authorized (authorize {:user-id "U1", :role :member, :team-id "T1"} {:owner-id "U1", :visibility :private, :status :active} :write)) true) "Owner should have write access")
  (assert (= (:authorized (authorize {:user-id "U1", :role :member, :team-id "T1"} {:owner-id "U1", :visibility :private, :status :archived} :write)) false) "Should block archived resources for non-admins")
  (assert (= (:authorized (authorize {:user-id "U1", :role :guest, :team-id nil} {:owner-id "U2", :team-id "T1", :visibility :public, :status :active} :read)) true) "Guest should read public resources")
  (assert (= (:authorized (authorize {:user-id "U1", :role :guest, :team-id nil} {:owner-id "U2", :team-id "T1", :visibility :private, :status :active} :read)) false) "Guest should not read private resources")
  (assert (= (:authorized (authorize {:user-id "U1", :role :manager, :team-id "T1"} {:owner-id "U2", :team-id "T1", :visibility :team, :status :active} :delete)) true) "Manager should manage team resources")
  (assert (= (:authorized (authorize {:user-id "U1", :role :member, :team-id "T1"} {:owner-id "U2", :team-id "T1", :visibility :team, :status :active} :read)) true) "Member should read team resources")
  "SUCCESS"
  )

(tst)
