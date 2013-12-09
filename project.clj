(defproject clj-rackspace "0.1.2-SNAPSHOT"
  :description "Pure Clojure language bindings for the Rackspace Cloud"
  :url "https://github.com/oubiwann/clj-rackspace"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cheshire "5.2.0"]
                 [clj-http "0.7.7"]]
  :repositories [["releases" {:url "https://clojars.org/repo"
                              :creds :gpg}]]
  :repl-options {
    :init-ns rackspace.api}
  :profiles {
    :dev {
      :dependencies [[org.clojure/tools.namespace "0.2.3"]
                     [org.clojure/java.classpath "0.2.0"]]}
    :testing {
      :dependencies [[clj-http-fake "0.4.1"]
                     [leiningen "2.3.3"]]}})
