(ns unflatten-config)

(defn unflatten-config
  "TODO: implement this function"
  [flat-config]
  nil)

(defn- tst []
  (let [result (unflatten-config {:db-host "localhost", :db-port 5432, :db-name "myapp", :api-base-url "https://api.example.com", :api-timeout 30, :api-retry-count 3, :log-level "info", :log-file "/var/log/app.log"})] (assert (= (get-in result [:database :host]) "localhost") "Should nest db-host under :database") (assert (= (get-in result [:database :port]) 5432) "Should nest db-port under :database") (assert (= (get-in result [:database :name]) "myapp") "Should nest db-name under :database") (assert (= (get-in result [:api :base-url]) "https://api.example.com") "Should nest api-base-url under :api") (assert (= (get-in result [:api :timeout]) 30) "Should nest api-timeout under :api") (assert (= (get-in result [:api :retry-count]) 3) "Should nest api-retry-count under :api") (assert (= (get-in result [:logging :level]) "info") "Should nest log-level under :logging") (assert (= (get-in result [:logging :file]) "/var/log/app.log") "Should nest log-file under :logging"))
  (let [result (unflatten-config {:db-host "db.example.com", :db-port 3306, :db-name "production", :api-base-url "https://prod-api.example.com", :api-timeout 60, :api-retry-count 5, :log-level "warn", :log-file "/var/log/prod.log"})] (assert (= (get-in result [:database :host]) "db.example.com") "Should handle production db host") (assert (= (get-in result [:database :port]) 3306) "Should handle different port") (assert (= (get-in result [:api :timeout]) 60) "Should handle different timeout") (assert (= (get-in result [:logging :level]) "warn") "Should handle different log level"))
  "SUCCESS"
  )

(tst)
