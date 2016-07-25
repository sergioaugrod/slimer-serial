(defproject slimer-serial "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/core.async "0.2.385"]
                 [aero "1.0.0"]
                 [clj-serial "2.0.4-SNAPSHOT"]
                 [clojurewerkz/machine_head "1.0.0-beta9"]]
  :main ^:skip-aot slimer-serial.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
