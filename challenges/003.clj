(ns wire->domain)

(defn wire->domain
  "TODO: implement this function"
  [user-wire]
  nil)

(defn- tst []
  (assert (= (wire->domain {:firstName "John", :lastName "Doe", :emailAddress "john@example.com"}) {:first-name "John", :last-name "Doe", :email "john@example.com"}) "Standard user transformation should work")
  (assert (= (wire->domain {:firstName "Jane", :lastName "Smith", :emailAddress "jane@example.com"}) {:first-name "Jane", :last-name "Smith", :email "jane@example.com"}) "Different user should transform correctly")
  (assert (= (wire->domain {:firstName "Bob", :lastName "Johnson", :emailAddress "bob@test.com"}) {:first-name "Bob", :last-name "Johnson", :email "bob@test.com"}) "User with different email domain should work")
  (assert (= (wire->domain {:firstName "A", :lastName "B", :emailAddress "ab@co.uk"}) {:first-name "A", :last-name "B", :email "ab@co.uk"}) "Single letter names should work")
  (assert (= (wire->domain {:firstName "Mary", :lastName "Anne-Smith", :emailAddress "mary@example.org"}) {:first-name "Mary", :last-name "Anne-Smith", :email "mary@example.org"}) "Hyphenated last name should be preserved")
  (assert (= (wire->domain {:firstName "José", :lastName "García", :emailAddress "jose@example.es"}) {:first-name "José", :last-name "García", :email "jose@example.es"}) "International characters should be preserved")
  "SUCCESS"
  )

(tst)
