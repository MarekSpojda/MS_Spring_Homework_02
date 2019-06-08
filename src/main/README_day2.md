<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE - Spring MVC

### Zadania.

1. Stwórz projekt `Homework_02`. Rozwiązania zadań powinny znajdować się w tym projekcie.


#### Zadanie 1

1. Stwórz kontroler o nazwie `HeaderController`.
2. Stwórz akcję dostępną pod adresem `/showUserAgent`
3. Pobierz wartość nagłówka `userAgent`.
4. Utwórz widok dla tej akcji o nazwie `userAgent.jsp`.
5. Przekaż, a następnie wyświetl w widoku parametr.

#### Zadanie 2

1. Stwórz kontroler o nazwie `RedirectController`.
2. Utwórz akcję dostępną pod adresem `/first`. Akcja ma ma wyświetlać widok `first.jsp`.
3. Utwórz akcję dostępną pod adresem `/third`. Akcja ma ma wyświetlać widok `third.jsp`.
4. W widoku `first.jsp` utwórz link do akcji dostępnej pod adresem `/second`, akcja ma przekierowywać do akcji dostępnej pod adresem `/third`.


#### Zadanie 4(3)

1. Utwórz widok o nazwie `workers.jsp`.
2. W kontrolerze `HelloController` utwórz akcję `workersAction`, dostępną pod adresem `/workers`,
 która wyświetli ten widok.
3. Dodaj do projektu plik o nazwie `Workers.txt`.
4. Plik `Workers.txt` wypełnij listą pracowników (wpisz je samodzielnie):
```
01, Jan Kowalski
05, Jan Wiśniewski
10, Jan Marek
29, Jan Janecki
30, Jan Nowak
```

5. W metodzie kontrolera napisz kod który:
    * Wylosuje liczbę od 1 do 30.
    * Otworzy plik `Workers.txt` i znajdzie w nim osobę odpowiadającą wylosowanej liczbie.
    * Przekaże wylosowaną wartość do widoku, np `Jan Kowalski`
6. Wyświetl zawartość w widoku `workers.jsp`.


### Zadanie 5(4)

1. Zmodyfikuj zadanie z zajęć wykorzystujące klasy `CartController`, `Cart`, `CartItem`, `Product`, tak by wszystkie informacje były wyświetlane w widokach `jsp`.
2. Utwórz akcję wyświetlającą formularz dodawania produktu - formularz ma być utworzony w `jsp`.
3. Dodaj funkcjonalność zmniejszania oraz zwiększania ilości produktów w koszyku o 1.
4. Dodaj funkcjonalność usuwania produktu z koszyka.
5. W widoku jsp wyświetlającym zawartość koszyka, dodaj linki pozwalające zwiększyć oraz zmniejszyć ilość danego produktu oraz link do usunięcia pozycji z koszyka.