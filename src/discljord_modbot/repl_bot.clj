(ns discljord-modbot.repl-bot
  "A bot for doing Discljord development in production!"
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [discljord-modbot.discljord :refer [run-bot]]))

(defonce token (str/trim (slurp (io/resource "token.txt"))))

(defn -main
  "Runs the bot from [[discljord-modbot.discljord/run-bot]]"
  [& args]
  (run-bot token))
