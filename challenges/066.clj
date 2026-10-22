(ns next-state)

(defn next-state
  "TODO: implement this function"
  [current-state event context]
  nil)

(defn- tst []
  (assert (= (next-state :pending :confirm {:payment-confirmed true, :items-in-stock true, :address-valid true}) :confirmed) "Should transition to confirmed when guards satisfied")
  (assert (= (next-state :pending :cancel {:payment-confirmed false, :items-in-stock false, :address-valid false}) :cancelled) "Should allow cancellation from pending")
  (assert (= (next-state :pending :confirm {:payment-confirmed false, :items-in-stock true, :address-valid true}) :invalid-transition) "Should reject confirm without payment")
  (assert (= (next-state :pending :confirm {:payment-confirmed true, :items-in-stock false, :address-valid true}) :invalid-transition) "Should reject confirm without stock")
  (assert (= (next-state :confirmed :ship {:payment-confirmed true, :items-in-stock true, :address-valid true}) :shipped) "Should transition to shipped when address valid")
  (assert (= (next-state :confirmed :cancel {:payment-confirmed true, :items-in-stock true, :address-valid true}) :cancelled) "Should allow cancellation from confirmed")
  (assert (= (next-state :confirmed :ship {:payment-confirmed true, :items-in-stock true, :address-valid false}) :invalid-transition) "Should reject ship without valid address")
  (assert (= (next-state :shipped :deliver {:payment-confirmed true, :items-in-stock true, :address-valid true}) :delivered) "Should transition to delivered")
  (assert (= (next-state :shipped :cancel {:payment-confirmed true, :items-in-stock true, :address-valid true}) :invalid-transition) "Should not allow cancellation after shipping")
  (assert (= (next-state :delivered :ship {:payment-confirmed true, :items-in-stock true, :address-valid true}) :invalid-transition) "Should reject all transitions from delivered")
  (assert (= (next-state :cancelled :confirm {:payment-confirmed true, :items-in-stock true, :address-valid true}) :invalid-transition) "Should reject all transitions from cancelled")
  "SUCCESS"
  )

(tst)
