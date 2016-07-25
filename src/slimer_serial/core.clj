(ns slimer-serial.core
  (:require [slimer-serial.event.receiver :as receiver])
  (:gen-class))

(defn -main
  [& args]
  (receiver/execute))
