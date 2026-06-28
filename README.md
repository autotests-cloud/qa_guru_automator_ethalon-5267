# UI tests (Java)

Автотесты для [one-page-form](https://qa-guru.github.io/one-page-form/) на Selenide и JUnit 5.

Эталон проекта: правки здесь, затем синхронизация в `templates/project-tests/` (см. корневой `README.md` automator-репозитория).

## Prerequisites

- Java 21
- Google Chrome installed locally

## Run tests

From this directory:

```bash
cd tests-java
./gradlew test
```

Run a single test class:

```bash
./gradlew test --tests LoginTests
```

Open the HTML report after a run:

```bash
open build/reports/tests/test/index.html
```

## What is tested

| Test class   | Page         | Scenarios                          |
|--------------|--------------|------------------------------------|
| `LoginTests` | `login.html` | Успешная авторизация, неверный пароль |

Страницы открываются с GitHub Pages: `https://qa-guru.github.io/one-page-form/`.

## Project layout

```
tests-java/
├── build.gradle
├── gradlew
├── gradlew.bat
├── gradle/wrapper/
└── src/test/
    ├── java/
    │   ├── tests/
    │   │   ├── TestBase.java
    │   │   └── LoginTests.java
    │   ├── config/
    │   └── annotations/
    └── resources/
        └── config/
            └── local.properties
```

## Configuration

Browser settings live in `TestBase.java` and `src/test/resources/config/*.properties`:

- **Browser:** Chrome (default)
- **Window size:** 1920×1280
- **Base URL:** `https://qa-guru.github.io/one-page-form/` (override via `baseUrl` in properties)

## Dependencies

- Selenide 7.16.2
- JUnit Jupiter 5.11.4
