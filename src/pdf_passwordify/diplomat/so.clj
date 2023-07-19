(ns pdf-passwordify.diplomat.so
  (:require
   [schema.core :as s])
  (:import
   (java.io File)))

(s/defn prepare-destiny-dir!
  [destiny :- s/Str]
  (when-not (.isDirectory (File. ^String destiny))
    (.mkdirs (File. ^String destiny))))
