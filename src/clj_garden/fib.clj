(ns clj-garden.fib
  (:use [clojure.contrib.seq-utils :only [fill-queue]]))
  

;; The following implementation is based loosely on the ideas presented here
;; http://infolace.blogspot.com/2009/08/simple-webhooks-with-clojure-and-ring.html
;; which inspired me to use a fill-queue to create an infinate sequence using a
;; more easily understood imperitive style.  Additionally, since fill-queue uses
;; future the computation can occur concurrently with the code that is processing it.  
(defn fib [] (fill-queue (fn [fill] (loop [a 0 b 1] (fill a) (recur b (+ a b))))))

;; can specify how many extra computations to compute with :queue-size (however as the following shows it appears to computer queue-size + 1)
;; (defn fib2 []  (fill-queue #(loop [n 0 a 0 b 1] (println "computing [" n " " a " " b "]") (% a) (recur (inc n) b (+ a b))) :queue-size 5))


;; Traditional lazy implementations

;; (defn fib3 [] (map first (iterate (fn [[a b]] [b (+ a b)])  [0 1])))

;; (defn fib
;;   ([] 
;;     (concat [0 1] (fib 0 1)))
;;   ([a b] 
;;     (let [c (+ a b)] (lazy-seq (cons c (fib b c))))))


