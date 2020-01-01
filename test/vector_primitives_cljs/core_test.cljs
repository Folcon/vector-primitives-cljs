(ns vector-primitives-cljs.core-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [vector-primitives-cljs.core :refer [vector-of]]))

(deftest init-int-test
  (is (= (vector-of :int) (js/Uint32Array. 0)))

  (is (not= (vector-of :int) (js/Uint32Array. 1)))

  (is (not (identical? (vector-of :int) (vector-of :int))))

  (let [v (vector-of :int)]
    (is (identical? v v)))

  (is (= (vector-of :int 1 2 3)
         (doto (js/Uint32Array. 3)
           (aset 0 1)
           (aset 1 2)
           (aset 2 3)))))


(deftest conj-int-test
  (let [v (vector-of :int)
        v1 (-> v
               (conj 6))]
    (is (not= v v1))  ;; Check maintains like semantics immutability
    (is (= (last v1) 6))))

(deftest assoc-int-test
  (let [v  (vector-of :int 0 0 0 0)
        v2 (assoc v 1 21)]
    (is (not= v v2))  ;; Check maintains like semantics immutability
    (is (= (get v2 1) 21))))


(deftest get-int-test
  (let [v (vector-of :int 1 2 3 4)]
    (is (= (get v 2) 3))
    (is (= (get v 6 :absent) :absent))))

(deftest nth-int-test
  (let [v (vector-of :int 1 2 3 4)]
    (is (= (nth v 2) 3))
    (is (= (nth v 6 :absent) :absent))))



(comment
  (require '[vector-primitives-cljs.core :as v :refer [vector-of]] :reload-all)

  (try
    (let [v (v/vector-of :int 0 0 0 0)
          v2 (assoc v 1 21)
          _ (println v v2)]
      (= v v2))
    (catch :default e
      (println e))))
