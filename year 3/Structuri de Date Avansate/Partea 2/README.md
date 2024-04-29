# [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/)

<details>
<summary>Explicatie</summary>

- Am decis sa utilizez 2 heap-uri de minim respectiv de maxim deoarece asa puteam in cel mai simplu mod sa aflu care este elementul/elementul din mijloc.
- Am folosit heap-ul de maxim sa tin elementele mai mici decat media, iar cel de minim pe cele mai mari.  
    - Cand inserez un element il inserez in heap-ul de maxim daca acesta este mai mic decat radacina acestuia, sau in heapul de minim altfel.
        - Dupa fiecare inserare, "echilibrez" cele 2 heap-uri, daca unul are mai multe elemente decat celalalt, dau pop din el si push in celalalt pana sunt egale. In cazul in care este un numar impar de elemente, aleg sa pastrez cu unul mai mult in heapul de inceput (cel de maxim).
    - Cand trebuie sa aflu media, am 2 cazuri:
        - Cazul in care este un numar par de numere (cele 2 heap-uri sunt egale d.p.d.v. al dimensiunii), In acest caz fac media dintre top-ul de la amandoua.
        - Cazul in care nu au numar egal de elemente, deci este un numar impar de numere, caz in care iau top-ul de la heap-ul de maxim (cel cu primele elemente, cel care in cazul asta are dimensiunea cu 1 mai mare decat celalalt).
- Complexitate:
    - Inserare: O(log n). Deoarece inserez in heap, care are un numar de elemente = n/2.
    - Gasire medie: O(1), Deoarece doar iau top-ul de la fiecare, respectiv de la unul din ele, si fac media/ il returnez direct.

</details>

# [Bomboane](https://www.pbinfo.ro/probleme/341/bomboane)

<details>
<summary>Explicatie</summary>

- Am decis sa utilizez 2 heap-uri de minim respectiv de maxim deoarece in felul acesta puteam sa aleg cutia cu numar maxim/minim de bomaboane in O(1) in loc de O(n) in cazul in care as fi pastrat cutiile ca vector.
- Am inserat in cele 2 heap-uri (de pair<int,int> deoarece ma interesa si numarul de ordine al cutiei) numerele in felul urmator:
    - Daca era mai mare decat media (insemna ca din acesta va tb sa scad), l-am pus in maxHeap.
    - Altfel, daca era mai mic, in minHeap.
    - Daca era egal, nu il mai inseram in niciunul.
- Cat timp mai aveam elemente in heap-uri, scoteam top-urile, actualizam valorile, si le inseram la loc (in cazul in care nu erau egale cu media, daca erau, nu le mai inseram).
- Complexitate: O(n logn), deoarece am maxim n pasi (mutari dintr-o cutie in alta) si fiecare pas are complexitatea log n deoarece trebuie sa inserez valorile la loc.

</details>