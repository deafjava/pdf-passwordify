(ns pdf-passwordify.logic.so-test
  (:require
    [clojure.test :refer :all]
    [pdf-passwordify.logic.so :refer :all])
  (:import (java.io File)))


(deftest pdf-extension?-test
  (testing "Are those file PDF?"
    (are [pdf-file valid?]
      (= (pdf-extension? pdf-file) valid?)
      (File. "text.txt") false
      (File. "text.pdf") true
      (File. "text.df") false
      (File. "text.pd") false
      (File. "textpdf") false
      (File. "text.PDF") true
      (File. "pdf.text") false)))
