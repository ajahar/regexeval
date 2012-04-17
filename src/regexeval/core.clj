; RegExEval
; Copyright (C) 2011-2012  Antti Harju
;
; This program is free software: you can redistribute it and/or modify
; it under the terms of the GNU General Public License as published by
; the Free Software Foundation, either version 3 of the License, or
; (at your option) any later version.
;
; This program is distributed in the hope that it will be useful,
; but WITHOUT ANY WARRANTY; without even the implied warranty of
; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
; GNU General Public License for more details.
;
; You should have received a copy of the GNU General Public License
; along with this program.  If not, see http://www.gnu.org/licenses/gpl.html.

(ns regexeval.core
  "A simple regular expression tester application"
  (:gen-class)
  (:use seesaw.core)
  (:import java.util.regex.PatternSyntaxException))

(def result-label (label :text "Match result"))

(def test-regex (text :text "Write your expression here"))

(def matched-text (text :text "Text to match"))

(defn matches? [pattern-input text-input]
  "Match regex pattern to text"
  (.matches (.getText test-regex) (.getText matched-text)))

(defn handle-match! []
  (try
    (if (matches? test-regex matched-text)
      (text! result-label "matches")
      (text! result-label "does not match"))
    (catch PatternSyntaxException ex
      (text! result-label (str "You have an error in your regular expression:" (.getDescription ex))))))

(def match-action
  (action :name "match"
          :handler (fn [e] (handle-match!))))

(def replace-action
  (action :name "replace"
          :handler (fn [e] (text! result-label "FAIL: not implemented"))))

(def pane (vertical-panel
            :items [test-regex matched-text result-label match-action replace-action]))

(defn make-frame []
  (frame :title "RegExEval" :width 640 :height 480
    :content pane
    :on-close :exit))

(defn -main [& args]
  (invoke-later (show! (make-frame))))
