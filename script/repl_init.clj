(ns user
  (:require [vimclojure.nails :as vimnails])
  (:use [clojure.contrib.repl-utils :only (show)]))
;(clojure.contrib/repl-utils/add-break-thread!)

(defn runnail []
  (vimnails/start-server-thread))

(defn unmap-all-ns []
  (doseq  [[f _]  (ns-publics *ns*)]  (ns-unmap *ns* f)))

;user=>  (let  [band "zeppelin" city "london"]  (show-env))
;{city #<LocalBinding clojure.lang.Compiler$LocalBinding@78ff9053>, band #<LocalBinding clojure.lang.Compiler$LocalBinding@525c7734>}
;(defmacro show-env [] (println &env))
(defmacro show-env []
  (println  (keys &env)) `(println ~@(keys &env)))

;(println  (+ (* 2 3) (dbg  (* 8 9))))
;(println  (dbg (println "yo")))
(defmacro dbg [x]
  `(let  [x# ~x]  (println "dbg:" '~x "=" x#) x#))

;This doesn't really belong here, but I don't want to lose it.
;This is macro to express imperative style loops
;It's only really helpful for readability for someone not
;familiar with lisps and Clojure
(defmacro iloop [[b t n] & body]
  `(loop [~@b]
     (when ~t
       ~@body
       (recur ~n))))

