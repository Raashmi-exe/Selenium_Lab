# Experiment 4: Selenium, Git Client and Git Server

**Scenario:** Several developers are updating an e-commerce website. This project demonstrates a feature branch, a committed and pushed change, and automated successful/unsuccessful login checks using Selenium WebDriver.

## Contents

- `pom.xml` — Maven configuration with Selenium and JUnit 5.
- `src/test/java/com/experiment4/DriverFactory.java` — Chrome WebDriver setup.
- `src/test/java/com/experiment4/LoginTest.java` — positive and negative login tests.
- `src/test/resources/login.html` — self-contained demo login page.
- `scripts/` — sample Windows Git commands.
- `docs/` — expected results and exam-ready answers.

## Requirements

1. Windows 10/11 (or another OS with equivalent commands).
2. JDK 17 or later. Verify with `java -version`.
3. Apache Maven 3.8+. Verify with `mvn -version`.
4. Google Chrome installed.
5. Git installed. Verify with `git --version`.
6. Internet access on the first Maven/Selenium run so dependencies and the matching driver can be resolved.

No external website, database, account, or real password is needed. The local demo page uses the test-only credentials `admin` / `password123`. Do not use real credentials in test code.

## Run the Selenium tests

Open a terminal in the project root (the folder containing `pom.xml`) and run:

```bash
mvn clean test
```

Selenium 4 includes Selenium Manager. It normally discovers/resolves the compatible ChromeDriver automatically. Chrome will open for each test and close after the test.

To run Chrome headlessly:

```bash
mvn -Dheadless=true clean test
```

To run one test:

```bash
mvn -Dtest=LoginTest#validLoginShouldSucceed test
mvn -Dtest=LoginTest#invalidLoginShouldFail test
```

Test report:

```text
target/surefire-reports/
```

Expected result: **Tests run: 2, Failures: 0, Errors: 0, Skipped: 0**.

## Git client and Git server workflow

A Git *client* is the developer's local working copy. A Git *server/remote* is the shared repository to which developers push and from which they pull. GitHub is a hosted remote Git server. For a lab demonstration without GitHub, create a local bare repository to act as the remote.

### Option A — Use GitHub as the remote

1. Create an empty GitHub repository (do not initialize it with a README if you already have this project locally).
2. Open Git Bash/terminal in this project folder.
3. Run:

```bash
git init
git add .
git commit -m "Initial commit: Selenium login tests"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/selenium-git-login.git
git push -u origin main
git switch -c feature/selenium-login-validation
```

4. Make a small change (for example, update the page heading in `src/test/resources/login.html`).
5. Commit and push the feature branch:

```bash
git status
git add src/test/resources/login.html
git commit -m "Add e-commerce login page heading"
git push -u origin feature/selenium-login-validation
```

Replace the URL with your own repository URL. GitHub may ask you to authenticate using a browser or personal access token; never put a password/token in the project files.

### Option B — Simulate a Git server locally (no GitHub account required)

Run the following commands in **Git Bash**. If using PowerShell, replace the `/c/...` path with a valid Windows path such as `C:/Users/YourName/git-remotes/selenium-git-login.git`.

```bash
mkdir -p ~/git-remotes
git init --bare ~/git-remotes/selenium-git-login.git
git clone ~/git-remotes/selenium-git-login.git selenium-git-client
cd selenium-git-client
```

Copy the project files into the `selenium-git-client` folder (or clone the GitHub repository instead). Then:

```bash
git add .
git commit -m "Initial commit: Selenium login tests"
git branch -M main
git push -u origin main
git switch -c feature/selenium-login-validation
```

Make a small change and then:

```bash
git status
git add src/test/resources/login.html
git commit -m "Add e-commerce login page heading"
git push -u origin feature/selenium-login-validation
git branch -vv
git log --oneline --decorate -5
```

The bare repository is the remote server; the cloned folder is the developer's local client/working copy.

## Complete experiment question mapping

- **Q13:** Clone/open repository, create feature branch, make a small change, commit and push — see Git workflow above and `docs/EXAM_ANSWERS.md`.
- **Q14:** Configure Selenium WebDriver and write valid/invalid login tests — see `DriverFactory.java` and `LoginTest.java`.
- **Q15:** Run Git and Selenium tasks; resolve merge conflicts and failed tests — see `docs/TROUBLESHOOTING.md`.
- **Q16:** Show expected browser behaviour, test results and Git status — see `docs/EXPECTED_RESULTS.md`.

## Important notes

- This is a self-contained **lab simulation** of an e-commerce login page, not a production authentication system.
- The JavaScript demo checks fixed test credentials only. A real e-commerce system must authenticate securely on the server and must never store plain-text passwords.
- If your lab requires a specific remote repository URL or a different browser, change the remote/driver setup as directed by your faculty.
