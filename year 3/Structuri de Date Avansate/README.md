# [Partea 1](https://github.com/AlexePaul/SDA/tree/main/Partea%201)
#### [Nrpits](https://infoarena.ro/problema/nrpits)

<details>
<summary>Explicatie</summary>

- Am decis sa utilizez o stiva deoarece in felul asta pot parcurge numerele din vector si sa tin cont de cate gropi o sa "inchid" cu fiecare numar nou.
- Am scos toate numerele din stiva care erau mai mici decat pozitia pe care ma aflu  
    - Daca aveam in stiva mai mult de un element insemna ca se inchide o groapa. Ex: daca in stiva am 12 1 si ma aflu pe v[i] = 10, se gaseste o groapa.
        -  In schimb daca aveam v[i] = 13 as fi scos si 1 si 12, dar as fi contorizat o singura groapa (scot si 12 ptc avand 13, nu as mai putea inchide gropi vreodata)
- Complexitate: O(n)

</details>

#### [Cifre4](https://infoarena.ro/problema/cifre4)

<details>
<summary>Explicatie</summary>

- Am folosit un queue pentru a "parcurge" numerele formate din 2,3,5,7.
    - Am decis sa aleg un queue, deoarece asa am putut sa ma asigur ca se vor genera in ordinea buna, de la mic la mare.
Am inceput prin a introduce in queue in ordine crescatoare cifrele de start, apoi de fiecare data cand treceam la un numar nou care avea un rest de care nu am mai dat pana acum:
    - Ii adaugam la urma un 2,3,5 si 7, si le introduceam in queue (evident in cazul in care acel rest nu era fix n)
- Complexitate: O(p), deoarece am maxim p resturi posibile.

</details>

# [Partea 2](https://github.com/AlexePaul/SDA/tree/main/Partea%202)
#### [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/)

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

#### [Bomboane](https://www.pbinfo.ro/probleme/341/bomboane)

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
