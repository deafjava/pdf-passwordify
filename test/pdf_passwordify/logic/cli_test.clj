(ns pdf-passwordify.logic.cli-test
  (:require
    [clojure.test :refer :all]
    [pdf-passwordify.logic.cli :refer :all]))


(deftest errors?-test
  (testing "Are there errors?"
    (are [m valid?]
      (= (errors? m) valid?)
      {} false
      nil false
      '() false
      [] false
      {:o "l"} true)))


(deftest pdf-extension?-test
  (testing "Are they same?"
    (are [origin destiny valid?]
      (= (origin<->destiny? origin destiny) valid?)
      "a" "a" true
      "a" "b" false
      "b" "a" false
      nil "a" false
      nil nil false)))
x