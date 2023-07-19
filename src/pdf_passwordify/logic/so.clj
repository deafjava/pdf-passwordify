(ns pdf-passwordify.logic.so
  (:require
    [clojure.string :as str]
    [schema.core :as s]))

(s/def ^:const pdf-extension ".pdf")

(s/defn pdf-extension? :- s/Bool
  [file :- s/Any]
  (-> file
      .getName
      str/lower-case
      (str/ends-with? pdf-extension)))
