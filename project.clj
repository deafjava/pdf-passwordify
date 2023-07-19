(defproject pdf-passwordify "0.1.0-SNAPSHOT"
  :description "PDF passwordify batch"
  :url "https://github.com/deafjava/car-wash"
  :license {:name "PDF passwordify batch License Agreement"
            :url  "https://github.com/deafjava/pdf-passwordify/blob/main/LICENSE"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.cli "1.0.214"]
                 [org.apache.pdfbox/pdfbox "2.0.27"]
                 [org.clojure/test.check "1.1.1"]
                 [nubank/matcher-combinators "3.8.5"]
                 [prismatic/schema "1.4.1"]]
  :plugins [[lein-ancient "1.0.0-RC3"]
            [com.github.clojure-lsp/lein-clojure-lsp "1.3.17"]]
  :clojure-lsp {:settings {:clean {:ns-inner-blocks-indentation :same-line}}} ;; API options
  :aliases {"clean-ns"     ["clojure-lsp" "clean-ns" "--dry"] ;; check if namespaces are clean
            "format"       ["clojure-lsp" "format" "--dry"] ;; check if namespaces are formatted
            "diagnostics"  ["clojure-lsp" "diagnostics"]    ;; check if project has any diagnostics (clj-kondo findings)
            "lint"         ["do" ["clean-ns"] ["format"] ["diagnostics"]] ;; check all above
            "clean-ns-fix" ["clojure-lsp" "clean-ns"]       ;; Fix namespaces not clean
            "format-fix"   ["clojure-lsp" "format"]         ;; Fix namespaces not formatted
            "lint-fix"     ["do" ["clean-ns-fix"] ["format-fix"]]} ;; Fix both
  :main ^:skip-aot pdf-passwordify.core
  :target-path "target/%s"
  :test-paths ["test" "test-integration"]
  :profiles {:uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
