# PAO
### This project will represent the Java app of a shop selling Phones, PCs/Laptops, Small And Big home appliances etc.
 
- Aplicatia contine mai multe clase model:
    * Product, o clasa din care pot fi derivate alte clase in vederea adaugarii de produse noi (o categorie noua de produse)
    * Clasele (CoffeeMaker, Fridge, Monitor, Peripheral, PersonalComputer, Phone, VacuumCleaner, Washing Machine) sunt clase cu ajutorul carora se tin caracteristici despre fiecare tip de produs. Aceste clase sunt derivate din Product.
    * Store, este o clasa menita stocarii datelor specifice unui magazin
- Aplicatia contine 2 Utilitare:
    * Clasa Pair<T1,T2> utilizata pentru a crea o pereche de 2 variabile de tipul T1 si T2
    * Clasa Resolution care reprezinta o rezolutie pe care o poate avea un telefon/monitor sau pe viitor daca se mai adauga clase, se pot folosi de aceasta
- Aplicatia are de asemenea si o clasa de exceptii folosita in cadrul serviciilor pentru a semanala diferite introduceri gresite de date
- Aplicatia contine o interfata GenericService cu ajutorul careia se vor implementa toate celelalte servicii
- Aplicatia contine o singura clasa serviciu:
    * Clasa StoreService ce foloseste interfata GenericService. In acest serviciu se gasesc functii menite pentru a putea adauga/scadea stoc dintr-un magazin anume dar si pentru a adauga un magazin
- Aplicatia este folosita cu ajutorul unui meniu ce are urmatoarele optiuni:\
 &nbsp; &nbsp;   1.Adaugare magazin\
 &nbsp; &nbsp;   2.Vezi magazine\
 &nbsp; &nbsp;   3.Adauga aparat cafea\
 &nbsp; &nbsp;   4.Adauga frigider\
 &nbsp; &nbsp;   5.Adauga monitor\
 &nbsp; &nbsp;   6.Adauga periferice\
 &nbsp; &nbsp;   7.Adauga calculator personal\
 &nbsp; &nbsp;   8.Adauga un telefon\
 &nbsp; &nbsp;   9.Adauga aspirator\
 &nbsp; &nbsp;   10.Adauga masina de spalat\
 &nbsp; &nbsp;   11.Verifica stocul unui magazin\
