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
  (:import (javax.swing JFrame JPanel JLabel JButton JTextArea)
           (java.awt.event ActionListener)))

(def label (JLabel. "Hello world."))

(def regex-input (JTextArea. "Write your expression here"))

(def matched-text (JTextArea. "Text to match"))

(def match-action (proxy [ActionListener] []
  (actionPerformed [e]
    (.setText label
      (re-matches (re-pattern (.getText regex-input)) (.getText regex-input))))))

(def match-button (doto (JButton. "match")
  (.addActionListener match-action)))

(def pane (doto (JPanel.)
  (.add regex-input)
  (.add matched-text)
  (.add label)
  (.add match-button)))

(defn make-frame []
  (let[frame (JFrame. "RegExEval")]
    (doto frame
      (.add pane)
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.setSize 640 480)
      (.setVisible true))))

(defn -main [& args]
  (make-frame))