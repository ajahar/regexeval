(ns regexeval.test.core
  (:use [regexeval.core])
  (:use [clojure.test]))

(deftest replace-me ;; FIXME: write
  (is false "No tests have been written."))
  
(deftest dummy-test []
  (is (= (re-find #"Hello" (.getText result-label)) "Hello")))
