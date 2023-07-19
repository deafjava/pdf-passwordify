(ns pdf-passwordify.logic.cli
  (:require
   [schema.core :as s]))

(s/defn errors? :- s/Bool
  [errors :- s/Any]
  (not (empty? errors)))

(s/defn origin<->destiny? :- s/Bool
  [origin :- s/Str
   destiny :- s/Str]
  (and (some? origin)
       (some? destiny)
       (= origin destiny)))
