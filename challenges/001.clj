(ns challenges.001)

(defn adult?
  "TODO: implement this function"
  [age]
  (>= age 18))

(defn tst []
  (assert (= (adult? 18) true) "Should return true for age 18 (exactly legal)")
  (assert (= (adult? 17) false) "Should return false for age 17 (below legal)")
  (assert (= (adult? 25) true) "Should return true for age 25 (above legal)")
  (assert (= (adult? 0) false) "Edge case - should return false for age 0")
  (assert (= (adult? 100) true) "Edge case - should return true for age 100")
  (assert (= (adult? 16) false) "Should return false for teenager age 16")
  (assert (= (adult? 19) true) "Should return true for age 19 (just above)")
  "SUCCESS"
  )

(tst)

