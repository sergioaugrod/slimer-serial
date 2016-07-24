(ns slimer-serial.core
  (:require [clojure.data.json :as json]
            [aero.core :as aero :refer (read-config)]
            [serial.core :as serial])
  (:import [java.io BufferedReader InputStreamReader InputStream]))

(def config (aero/read-config "resources/config.edn"))

(defrecord Connection [port baud-rate])
(def connection (map->Connection (:connection config)))

(def serial-port (serial/open (:port connection) :baud-rate (:baud-rate connection)))

(defn- listen-readline
  [port handler]
  (serial/listen
    port (fn [^InputStream in-stream]
           (let [buff-reader (BufferedReader. (InputStreamReader. in-stream))]
             (handler (.readLine buff-reader))))))

(defn- print-message
  [message]
  (println
    (str "Topic: " (message "topic"))
    (str "Value: " (message "value"))))

(defn- parse-print-message
  [message]
  (try (print-message (json/read-str message))
  (catch Exception e
    nil)))

(defn start
  []
  (listen-readline serial-port parse-print-message))

(defn close
  []
  (serial/close! serial-port))
