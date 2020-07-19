(ns discljord-modbot.prepl
  (:require
   [clojure.core.server :refer [prepl]]
   [discljord-modbot.state :refer [*connection* *messaging* state]]))

