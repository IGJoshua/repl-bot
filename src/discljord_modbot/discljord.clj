(ns discljord-modbot.discljord
  "Code to start the bot."
  (:require
   [clojure.core.async :as a]
   [discljord.connections :as conn]
   [discljord.events :as e]
   [discljord.events.middleware :as mdw]
   [discljord.events.state :as s]
   [discljord.messaging :as msg]
   [discljord-modbot.state :refer [*connection* *messaging* state]]
   [discljord-modbot.prepl :as prepl]))

(defn prepl-message
  [event-type event-data]
  )

(def handlers {:create-message [(mdw/ignore-bot-messages #'prepl-message)]})

(defn run-bot
  [token]
  (let [events (a/chan 100)]
    (binding [*messaging* (msg/start-connection! token)
              *connection* (conn/connect-bot! token events :intents conn/gateway-intents)]
      ;; Start the prepl on another thread
      (e/message-pump! events ((s/caching-middleware state) (partial e/dispatch-handlers #'handlers))))))
