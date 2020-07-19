(ns discljord-modbot.repl-bot
  "A bot for doing Discljord development in production!"
  (:require
   [clojure.java.io :as io]
   [clojure.core.async :as a]
   [discljord.connections :as conn]
   [discljord.events :as e]
   [discljord.events.middleware :as mdw]
   [discljord.messaging :as msg]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
