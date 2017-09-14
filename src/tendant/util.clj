(ns tendant.util)

(defn truthy?
  "Return true for all truthy value `s`"
  [s]
  (if s
    (#{"true" "True" "TRUE" true} s)))