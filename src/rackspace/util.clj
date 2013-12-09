(ns rackspace.util
  (:require [cheshire.core :refer :all]))

(defn parse-json-body [response]
  (decode (response :body) true))
