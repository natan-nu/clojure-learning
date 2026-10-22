(ns playground
  (:require
   [clojure.string :as s]))

(defn hello-world
  "Com um valor em String no parâmetro 'name', imprime
  uma hello mensagem para esse 'name'."
  [name]
  (println "Hello" name))

(defn hello-world
  "Multi-aridade — várias versões da função, cada uma com sua lista de parâmetros:"
  ([name]
   (str "Hello " name))
  ([firstname lastname]
   (str "Hello " firstname " " lastname)))

(defn hello-world
  "Varargs — uma função que aceita qualquer número de argumentos, usando &:"
  [& names]
  (s/join " " (cons "Hello" names)))

(defn hello-world
  "O & names dos varargs, que vincula todos os argumentos restantes numa sequência. Mas dá pra ser mais seletivo. Veja:"
  [first-name & more-names]
  (clojure.string/join " " (conj more-names (clojure.string/upper-case first-name) "Hello")))

(defn hello-world
  "Também existe a palavra-chave :as, que te dá acesso à sequência inteira além das partes desestruturadas,
  Aqui, names é a lista completa, first-name o primeiro item, more-names o resto — tudo ao mesmo tempo:"
  [& [first-name & more-names :as names]]
  (println "Received" (count names) "names for" first-name)
  (clojure.string/join " " (conj more-names (clojure.string/upper-case first-name) "Hello")))

(fn [name]
  (str "Hello " name))

; Desestruturação associativa (a mais usada no dia a dia)
(defn hello-world
  [{:keys [first-name middle-name last-name]
    :or {first-name "something" middle-name "something" last-name "something"}}]
  (let [strings (remove nil? ["Hello" first-name middle-name last-name])]
    (clojure.string/join " " strings)))

(comment
  (map #(str "Hello " %1) ["Inez" "Maria" "Fred" "Joao"])
  (let [greeting "Hello"
        separator " " name "Natan"]
    (str greeting separator name))

;;   (hello-world "Ted")
;;   (hello-world "Ted" "Nugent")
;;   (hello-world [:first-name "Clair" :middle-name "de" :last-name "Lune"]))
  (hello-world []))