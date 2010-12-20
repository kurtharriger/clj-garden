(ns clj-garden.groovyish )

;; Safe Navigation Operator (?.) http://groovy.codehaus.org/Operators#Operators-ElvisOperator%28%3F%3A%29
;; Basically same usage ad .. but with nil checks
(defmacro ?. ([x form] `(if ~x (. ~x ~form))) ([x form & more] `(?. (?. ~x ~form) ~@more )))

;; TODO: *. - Groovy splat operator