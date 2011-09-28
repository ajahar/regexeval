; RegExEval
; Copyright (C) 2011  Antti Harju
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
  (:use seesaw.core))

(def result-label (label :text "Hello world."))

(def regex-input (text :text "Write your expression here"))

(def matched-text (text :text "Text to match"))

(defn make-matcher []
  "Create a Matcher from user inputs"
  (re-matcher (re-pattern (.getText regex-input)) (.getText matched-text)))

(defn match? []
  "Find using users pattern from supplied text"
  (.find (make-matcher)))

(def match-action
  (action :name "match"
          :handler (fn [e]
                     (if (match?)
                       (text! result-label "matches")
                       (text! result-label "does not match")))))

(def pane (vertical-panel
            :items [regex-input matched-text result-label match-action ]))

(defn make-frame []
  (frame :title "RegExEval" :width 640 :height 480
    :content pane
    :on-close :exit))

(defn -main [& args]
  (invoke-later (show! (make-frame))))
