(ns tendant.util)

(defn truthy?
  "Return true for all truthy value `s`"
  [s]
  (if s
    (if (#{"true" "True" "TRUE" true} s)
      true
      false)
    false))

(defn postwalk-execute
  "Recursively transforms form by replacing keys with the result of fn,
  in which fn is original value function, fn should take 2
  parameters [k context].  Like clojure/replace but works on any data
  structure.  Does replacement at the leaves of the tree first."
  [form context]
  (walk/postwalk (fn [x]
                   (if (and (vector? x)
                            (= 2 (count x))
                            (fn? (second x)))
                     [(first x) ((second x) (first x) context)]
                     x))
                 form))
