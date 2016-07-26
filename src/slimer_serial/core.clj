(ns slimer-serial.core
  (:require [slimer-serial.event.receiver :as receiver]
            [slimer-serial.event.sender :as sender]
            [clojure.core.async :refer [thread]])
  (:gen-class))

(defn -main
  [& args]
  ;;(thread (receiver/execute))
  (thread (sender/execute)))
