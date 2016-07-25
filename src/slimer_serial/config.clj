(ns slimer-serial.config
  (:require [aero.core :as aero :refer (read-config)]))

(def ^:private config (aero/read-config "resources/config.edn"))

; SERIAL
(def port (-> config :serial :port))
(def baud-rate (-> config :serial :baud-rate))

; MQTT
(def host (-> config :mqtt :host))
