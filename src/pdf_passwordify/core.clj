(ns pdf-passwordify.core
  (:require
   [pdf-passwordify.controller.cli :as controller.cli])
  (:gen-class))

(defn -main
  [& args]
  (controller.cli/process! args))
