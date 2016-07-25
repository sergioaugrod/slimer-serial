(ns slimer-serial.event.receiver
  (:require [slimer-serial.transport.serial :as serial]
            [slimer-serial.transport.mqtt :as mqtt]
            [clojure.data.json :as json]))

(defn- log-message
  [message]
  (println
    (str "Topic: " (message "topic"))
    (str "Value: " (message "value"))))

(defn- publish
  [message]
  (let [topic (message "topic") value (message "value")]
    (mqtt/publish topic value)))

(defn- parse-and-publish
  [message]
  (try
    (let [parsed-message (json/read-str message)]
      (publish parsed-message)
      (log-message parsed-message))
    (catch Exception e
      nil)))

(defn execute
  []
  (serial/gets parse-and-publish))
