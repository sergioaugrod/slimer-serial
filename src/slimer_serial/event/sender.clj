(ns slimer-serial.event.sender
  (:require [clojure.data.json :as json]
            [slimer-serial.transport.mqtt :as mqtt]
            [slimer-serial.transport.serial :as serial]))

(defn- log-message
  [message]
  (println
    (str "[SENDER]:")
    (str "TOPIC: " (message "topic"))
    (str "VALUE: " (message "value"))))

(defn- parse
  [topic value]
  (let [message {:topic topic :value (String. value "UTF-8")}]
    json/write-str message))

(defn- send-to-serial
  [^String topic _ ^bytes value]
  (let [message (parse topic value)]
    (println message)
    (serial/write message)
    (log-message message)))

(defn- subscribe-queues
  []
  (mqtt/subscribe "sender/#" 0 send-to-serial))

(defn execute
  []
  (subscribe-queues))
