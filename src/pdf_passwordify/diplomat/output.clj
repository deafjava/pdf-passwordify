(ns pdf-passwordify.diplomat.output
  (:require
   [clojure.java.io :as io]
   [schema.core :as s]))

(s/def ^:const key-ascii-art
  "key.ascii-art.txt")

(s/defn generic-error-message!
  [errors :- s/Any
   summary :- s/Any]
  (do (println errors)
      (println summary)))

(s/defn origin-destiny-error-message!
  [origin :- s/Str]
  (println (str "Pasta origem \"" origin "\" não pode ser igual a pasta destino")))

(s/defn header-message! []
  (println)
  (println (slurp (io/resource key-ascii-art)))
  (println))

(s/defn protecting-message!
  [file-pdf :- s/Str]
  (println "Protegendo o arquivo" (str "\"" file-pdf "\"") "com senha..."))

(s/defn finished-message!
  [destiny :- s/Str]
  (println "Pronto! Arquivos protegidos estão na pasta" (str "\"" destiny "\"" "!")))
