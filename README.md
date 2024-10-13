# REST Manager Task 02

## Opis Zadania 2 (rest-manager-task02)

## Technologie
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (do testów)

## Endpointy

### Zadania (`/tasks`)

#### 1. Pobierz wszystkie zadania
- **Method:** `GET`
- **Endpoint:** `/tasks`
- **Response:** Lista wszystkich zadań.
- **Status:** 200 OK

#### 2. Filtruj zadania po statusie
- **Method:** `GET`
- **Endpoint:** `/tasks/filter/status?status=AKTYWNE`
- **Query Parameter:**
  - `status`: Status, po którym chcesz filtrować zadania (np. `AKTYWNE`, `ZAKONCZONE`, `ANULOWANE`, `PRIORYTETOWE`, `OPOZNIONE`).
- **Response:** Lista zadań o podanym statusie.
- **Status:** 200 OK

#### 3. Dodaj nowe zadanie
- **Method:** `POST`
- **Endpoint:** `/tasks`
- **Request Body:** Obiekt `Task` (zawierający tytuł, opis, status i innych użytkowników).
- **Response:** Utworzone zadanie.
- **Status:** 201 Created

#### 4. Usuń zadanie
- **Method:** `DELETE`
- **Endpoint:** `/tasks/{id}`
- **Path Variable:**
  - `id`: ID zadania do usunięcia.
- **Response:** Brak treści.
- **Status:** 204 No Content

#### 5. Zmień status zadania
- **Method:** `GET`
- **Endpoint:** `/tasks/{taskId}/change-status?status=status`
- **Przykład:** `/tasks/3/change-status?status=ZAKONCZONE`
- **Path Variable:**
  - `id`: ID zadania do zmiany statusu.
- **Query Parameter:**
  - `status`: Nowy status zadania.
- **Response:** Brak treści.
- **Status:** 200 OK

#### 6. Aktualizuj zadanie
- **Method:** `PUT`
- **Endpoint:** `/tasks/{id}`
- **Path Variable:**
  - `id`: ID zadania do aktualizacji.
- **Request Body:** Obiekt `Task` z nowymi danymi.
- **Response:** Zaktualizowane zadanie.
- **Status:** 200 OK

#### 7. Częściowa aktualizacja zadania
- **Method:** `PATCH`
- **Endpoint:** `/tasks/{id}`
- **Path Variable:**
  - `id`: ID zadania do częściowej aktualizacji.
- **Request Body:** Obiekt `Task` z danymi do aktualizacji.
- **Response:** Zaktualizowane zadanie.
- **Status:** 200 OK

#### 8. Przypisz użytkownika do zadania
- **Method:** `PUT`
- **Endpoint:** `/tasks/{taskId}/assign/{userId}`
- **Path Variable:**
  - `taskId`: ID zadania.
  - `userId`: ID użytkownika do przypisania.
- **Response:** Zaktualizowane zadanie z przypisanym użytkownikiem.
- **Status:** 200 OK

### Użytkownicy (`/users`)

#### 1. Dodaj nowego użytkownika
- **Method:** `POST`
- **Endpoint:** `/users`
- **Request Body:** Obiekt `User`.
- **Response:** Utworzony użytkownik.
- **Status:** 201 Created

#### 2. Pobierz wszystkich użytkowników
- **Method:** `GET`
- **Endpoint:** `/users`
- **Response:** Lista wszystkich użytkowników.
- **Status:** 200 OK

#### 3. Filtruj użytkowników po nazwisku
- **Method:** `GET`
- **Przykład:** `/users/filter/nazwisko?nazwisko=Kowalski`
- **Query Parameter:**
  - `nazwisko`: Nazwisko, po którym chcesz filtrować użytkowników.
- **Response:** Lista użytkowników o podanym nazwisku.
- **Status:** 200 OK

#### 4. Usuń użytkownika
- **Method:** `DELETE`
- **Endpoint:** `/users/{id}`
- **Path Variable:**
  - `id`: ID użytkownika do usunięcia.
- **Response:** Brak treści.
- **Status:** 204 No Content


