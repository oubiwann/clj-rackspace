(ns rackspace.servers.v2.service-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as http]
            [rackspace.identity :as identity]
            [rackspace.servers.v2.service :as service]
            [rackspace.services :as services]
            [clojure.data.json :as json]))

(deftest get-new-server-payload-test
  (let [payload (service/get-new-server-payload "name-test" "id-test" "flav-test")
        payload-map (json/read-str payload :key-fn keyword)]
    (is (= payload-map
           {:server {:name "name-test", :imageRef "id-test", :flavorRef "flav-test"}}))))

;simply ensures that the response from the POST is returned
(deftest create-server-test
  (let [mock-response {:mock "response"}]
    (with-redefs [services/get-cloud-servers-region-url (fn [identity-response region] "url")
                  http/post (fn [url data] mock-response)
                  identity/get-token (fn [identity-response] "token")]
      (let [response (service/create-server {} :ord "server-name" "image-id" "flavor-id")]
        (is = (response
               mock-response))))))

;simply ensures that the response from the GET is returned
(deftest get-server-details-list-test
  (let [mock-response {:mock "response"}]
    (with-redefs [services/get-cloud-servers-region-url (fn [identity-response region] "url")
                  http/get (fn [url data] mock-response)
                  identity/get-token (fn [identity-response] "token")]
      (let [response (service/get-server-details-list {} :ord)]
        (is = (response
               mock-response))))))
