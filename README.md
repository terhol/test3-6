# Test 3-5
Third test version 5 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description (Czech language only)
Rozhraní ani předdefinované třídy neměňte. Metody NEMUSÍTE dokumentovat pomocí JavaDoc komentářů. Používejte zásadně privátní atributy.

Úloha simuluje prodej cigaret v prodejním automatu. Ke každé značce cigaret (třída CigaretteBrand) si automat pamatuje počet krabiček, které jsou k dispozici.


**Zadání:**

-   Vytvořte třídu CigaretteAutomat implementující rozhraní ICigaretteAutomat. Metoda sell() slouží k prodeji cigaret zákazníkům, pomocí metody restock() ze doplňují cigarety do automatu, metoda save() zapíše textově stav automatu na výstup a metoda load() naopak načte data z výstupu a nastaví podle nich automat.
-    Metody save() a load() budou vyhazovat výjimku IOException při jakékoliv chybě vstupu/výstupu nebo při chybném formátu dat.
-    Ve třídě CigaretteAutomat vytvořte konstruktor CigaretteAutomat(File file), který inicializuje automat podle dat v souboru daném vstupním parametrem. Vyhněte se opakování kódu (využijte metodu save). Konstruktor bude vyhazovat IOException při jakékoliv chybě vstupu nebo při chybném formátu dat v souboru.



Třída Demo by při spuštění neměla spadnout s výjimkou. Měla by vypsat (pořadí řádků se může lišit) následující text:

        1 31 Petra
        15 33 Lucky Strike
        25 45 Marlboro
        8 45 Marlboro Light
        2 25 Petra


## License
MIT