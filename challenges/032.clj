(ns extract-domain
  (:require [clojure.string :as str]))

(defn extract-domain
  "TODO: implement this function"
  [url]
  nil)

(defn- tst []
  (assert (= (extract-domain "https://www.example.com/path/to/page") "www.example.com") "Should extract domain from https URL with path")
  (assert (= (extract-domain "http://api.github.com:443/users?page=1") "api.github.com") "Should extract domain removing port and query params")
  (assert (= (extract-domain "example.com/about") "example.com") "Should extract domain from URL without protocol")
  (assert (= (extract-domain "https://localhost:8080") "localhost") "Should extract localhost and remove port")
  (assert (= (extract-domain "https://api.service.example.com/v1/users/123") "api.service.example.com") "Should handle subdomain with multiple path segments")
  (assert (= (extract-domain "https://search.example.com?q=clojure") "search.example.com") "Should handle query params without path")
  "SUCCESS"
  )

(tst)
