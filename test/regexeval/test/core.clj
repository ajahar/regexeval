(ns regexeval.test.core
  (:use regexeval.core seesaw.core clojure.test))

(deftest should-match-same-values []
  (text! test-regex "abc")
  (text! matched-text "abc")
  (is (matches? test-regex matched-text)))