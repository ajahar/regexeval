(ns core
  (:use [clojure.test :only [deftest is]])
  (:use regexeval.core))

(deftest dummy-test []
  (is (= (re-find #"Hello" (.getText label)) "Hello")))


