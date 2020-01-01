(ns vector-primitives-cljs.core)


(defn equiv [o other]
  (and (= (count o) (count other))
       (loop [oh (first o)
              ot (rest o)
              otherh (first other)
              othert (rest other)]
         (cond
           (not= oh otherh)
           false

           (and (empty? ot) (empty? othert))
           true

           (or (empty? ot) (empty? othert))
           false

           :else
           (recur (first ot)
                  (rest ot)
                  (first othert)
                  (rest othert))))))


;; Uint32Array
(extend-protocol ISequential
  js/Uint32Array)

(extend-protocol IEquiv
  js/Uint32Array
  (-equiv [o other]
    (equiv o other)))

(extend-protocol ICloneable
  js/Uint32Array
  (-clone [coll]
    js/Uint32Array. coll))

(extend-protocol ICounted
  js/Uint32Array
  (-count [coll]
    (alength coll)))

(extend-protocol ISeqable
  js/Uint32Array
  (-seq [coll]
    (prim-seq coll)))

(extend-protocol ICollection
  js/Uint32Array
  (-conj [coll o]
    (let [idx (alength coll)]
      (doto (js/Uint32Array. (inc idx))
        (.set coll)
        (aset idx o)))))

(extend-protocol IAssociative
  js/Uint32Array
  (-assoc [coll k v]
    (let [narr (js/Uint32Array. coll)]
      (aset narr k v)
      narr)))

(extend-protocol ILookup
  js/Uint32Array
  (-lookup
    ([o k]
     (aget o k))
    ([o k not-found]
     (let [result (aget o k)]
       (if (nil? result)
         not-found
         result)))))

(extend-protocol IIndexed
  js/Uint32Array
  (-nth
    ([coll n]
     (aget coll n))
    ([coll n not-found]
     (let [result (aget coll n)]
       (if (nil? result)
         not-found
         result)))))




(defn vector-of
  ([t] {:pre [(contains? #{:int :long} t)]}
   (condp = t
     :int  (js/Uint32Array. 0)
     :long (js/BigInt64Array. 0)))
  ([t & elements] {:pre [(contains? #{:int :long} t)]}
   (condp = t
     :int  (js/Uint32Array. (clj->js elements))
     :long (js/BigInt64Array. (clj->js elements)))))
