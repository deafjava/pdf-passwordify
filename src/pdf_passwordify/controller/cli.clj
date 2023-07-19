(ns pdf-passwordify.controller.cli
  (:require
    [clojure.tools.cli :as cli]
    [pdf-passwordify.controller.so :as controller.so]
    [pdf-passwordify.diplomat.output :as diplomat.output]
    [pdf-passwordify.diplomat.so :as diplomat.so]
    [pdf-passwordify.logic.cli :as logic.cli]
    [schema.core :as s]))

(s/def ^:const cli-options
  [["-o" "--origem ORIGEM" "Pasta de origem"]
   ["-d" "--destino DESTINO" "Pasta de destino"]
   ["-h" "--help" "Ajuda de comom usar o comando"]])

(s/defn ^:private pdf-protection-steps!
  [origin :- s/Str
   destiny :- s/Str]
  (diplomat.so/prepare-destiny-dir! destiny)
  (diplomat.output/header-message!)
  (controller.so/protect-pdf-files! origin destiny)
  (diplomat.output/finished-message! destiny))


(s/defn process!
  [args :- s/Any]
  (let [{{destiny :destino origin :origem} :options :keys [errors summary]} (cli/parse-opts args cli-options)]
    (cond
      (logic.cli/errors? errors)
      (diplomat.output/generic-error-message! errors summary)

      (logic.cli/origin<->destiny? origin destiny)
      (diplomat.output/origin-destiny-error-message! origin)

      :else
      (pdf-protection-steps! origin destiny))))
