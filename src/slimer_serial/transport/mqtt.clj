(ns slimer-serial.transport.mqtt
  (:require [slimer-serial.config :as config]
            [clojurewerkz.machine-head.client :as mqtt]))

(def ^:private generated-id (mqtt/generate-id))
(def ^:private conn (mqtt/connect config/host generated-id))

(defn publish
  [topic value]
  (mqtt/publish conn topic (str value)))

(defn subscribe
  [topics qos handler]
  (mqtt/subscribe conn {topics qos} handler))
