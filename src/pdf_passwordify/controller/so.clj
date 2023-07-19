(ns pdf-passwordify.controller.so
  (:require
   [pdf-passwordify.diplomat.output :as diplomat.output]
   [pdf-passwordify.logic.so :as logic.so]
   [schema.core :as s])
  (:import
   (java.io File)
   (org.apache.pdfbox.pdmodel PDDocument)
   (org.apache.pdfbox.pdmodel.encryption AccessPermission StandardProtectionPolicy)))

(defn ^:private list-files [directory]
  (->> directory
       File.
       .listFiles
       (filter #(logic.so/pdf-extension? %))
       (map #(.getName %))))

(s/defn ^:private protect-pdf!
  [path :- s/Str
   destination :- s/Str
   password :- s/Str]
  (let [document (PDDocument/load ^File (File. ^String path))
        permission (AccessPermission.)
        policy (StandardProtectionPolicy. password password permission)]
    (.setEncryptionKeyLength policy 128)
    (.protect document policy)
    (.save document (str destination "/" (.getName (File. ^String path))))
    (.close document)))

(s/defn protect-pdf-files!
  [origin :- s/Str
   destiny :- s/Str]
  (doseq [file-pdf (list-files origin)]
    (diplomat.output/protecting-message! file-pdf)
    (protect-pdf! (str origin "/" file-pdf) destiny "1234")))
