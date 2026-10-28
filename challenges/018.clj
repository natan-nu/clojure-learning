(ns challenges.018)

(defn parse-int [s]
  (Integer/parseInt s))

(defn parse-numbers [user-data]
  (reduce #(update %1 %2 parse-int)
          user-data
          [:age :score]))

(defn- tst []
  (assert (= (parse-numbers {:name "John", :age "25", :score "100"}) {:name "John", :age 25, :score 100}) "Should parse age and score to integers")
  (assert (= (parse-numbers {:name "Jane", :age "30", :score "95"}) {:name "Jane", :age 30, :score 95}) "Should work with different values")
  (assert (= (parse-numbers {:name "Bob", :age "18", :score "0"}) {:name "Bob", :age 18, :score 0}) "Should handle zero correctly")
  (assert (= (parse-numbers {:name "Alice", :age "99", :score "9999"}) {:name "Alice", :age 99, :score 9999}) "Should handle large numbers")
  (let [result (parse-numbers {:name "Charlie", :age "25", :score "85"})] (assert (string? (:name result)) "Name should remain a string") (assert (= (:name result) "Charlie") "Name should be unchanged"))
  (let [result (parse-numbers {:name "Dave", :age "20", :score "70"})] (assert (integer? (:age result)) "Age should be an integer") (assert (integer? (:score result)) "Score should be an integer"))
  (assert (= (map parse-numbers [{:name "Emma", :age "22", :score "80"} {:name "Frank", :age "24", :score "90"}]) (quote ({:name "Emma", :age 22, :score 80} {:name "Frank", :age 24, :score 90}))) "Should work when mapping over collection")
  "SUCCESS")

(tst)


;; A ideia central
;;
;;  reduce passa um valor (a "caixa") por uma sequência de passos, onde cada passo transforma essa caixa um pouco, e o resultado de um passo
;;   vira a entrada do próximo. No final, você recebe a caixa já toda transformada.
;;
;;   (reduce f init coll)
;;
;;   - f = o que cada passo faz
;;   - init = valor inicial da caixa
;;   - coll = lista de "paradas" pelas quais a caixa vai passar
;;
;;   No nosso código:
;;   - init = user-data, ou seja {:name "John" :age "25" :score "100"}
;;   - coll = [:age :score] — duas paradas
;;   - f = #(update %1 %2 parse-int) — o que acontece em cada parada
;;
;; As peças
;;
;; update pega um map, uma chave, e uma função; devolve um novo map com aquele campo transformado:
;;
;;   (update caixa chave funcao)
;;
;;   #(update %1 %2 parse-int) é uma função anônima de 2 argumentos. %1 é o primeiro argumento recebido, %2 é o segundo. Quem decide quais
;;   são esses dois argumentos é o reduce: a cada parada, ele chama a função com (caixa-atual, elemento-da-lista-atual).
;;
;; Execução passo a passo
;;
;;   Estado inicial da caixa: {:name "John" :age "25" :score "100"}
;;
;;   Parada 1 — elemento da lista é :age:
;;   reduce chama (update caixa-atual :age parse-int).
;;   Isso pega o valor de :age ("25"), aplica parse-int, troca só esse campo.
;;   Nova caixa: {:name "John" :age 25 :score "100"}
;;
;;   Parada 2 — elemento da lista é :score:
;;   reduce chama (update caixa-atual :score parse-int), usando a caixa que saiu da parada 1.
;;   Nova caixa: {:name "John" :age 25 :score 100}
;;
;;   Não tem mais paradas na lista [:age :score], então reduce devolve essa última caixa como resultado final.
;;
;;   Por que não usar Integer/parseInt direto
;;
;;   update precisa receber uma função de verdade (um valor passável). Integer/parseInt é um método Java, só pode ser chamado com parênteses,
;;   não é um valor. Por isso criamos parse-int como um defn próprio — isso sim é uma função Clojure de verdade, que pode ser passada como
;;   argumento.


