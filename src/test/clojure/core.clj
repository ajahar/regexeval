(ns core
  (:use [clojure.test :only [run-tests deftest is]])
  (:use regexeval.core))

(deftest dummy-test []
  (is (= (re-find #"Hello" dummy-text) "Hello")))

(run-tests)


