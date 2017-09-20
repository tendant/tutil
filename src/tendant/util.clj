(ns tendant.util)

(defn truthy?
  "Return true for all truthy value `s`"
  [s]
  (if s
    (if (#{"true" "True" "TRUE" true} s)
      true
      false)
    false))