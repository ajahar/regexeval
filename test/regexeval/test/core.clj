(ns regexeval.test.core
  (:use regexeval.core seesaw.core clojure.test))

(deftest should-match-same-values []
  (text! regex-input "abc")
  (text! matched-text "abc")
  (is (match?)))