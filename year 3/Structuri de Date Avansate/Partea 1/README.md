# [Nrpits](https://infoarena.ro/problema/nrpits)

<details>
<summary>Explicatie</summary>

- Am decis sa utilizez o stiva deoarece in felul asta pot parcurge numerele din vector si sa tin cont de cate gropi o sa "inchid" cu fiecare numar nou.
- Am scos toate numerele din stiva care erau mai mici decat pozitia pe care ma aflu  
    - Daca aveam in stiva mai mult de un element insemna ca se inchide o groapa. Ex: daca in stiva am 12 1 si ma aflu pe v[i] = 10, se gaseste o groapa.
        -  In schimb daca aveam v[i] = 13 as fi scos si 1 si 12, dar as fi contorizat o singura groapa (scot si 12 ptc avand 13, nu as mai putea inchide gropi vreodata)
- Complexitate: O(n)

</details>

# [Cifre4](https://infoarena.ro/problema/cifre4)

<details>
<summary>Explicatie</summary>

- Am folosit un queue pentru a "parcurge" numerele formate din 2,3,5,7.
    - Am decis sa aleg un queue, deoarece asa am putut sa ma asigur ca se vor genera in ordinea buna, de la mic la mare.
Am inceput prin a introduce in queue in ordine crescatoare cifrele de start, apoi de fiecare data cand treceam la un numar nou care avea un rest de care nu am mai dat pana acum:
    - Ii adaugam la urma un 2,3,5 si 7, si le introduceam in queue (evident in cazul in care acel rest nu era fix n)
- Complexitate: O(p), deoarece am maxim p resturi posibile.

</details>
