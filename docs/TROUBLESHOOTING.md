# Troubleshooting guide

## `mvn` is not recognized

Install Apache Maven, add its `bin` directory to PATH, close and reopen the terminal, then run `mvn -version`. Confirm that JDK 17+ is installed and `JAVA_HOME` points to the JDK.

## `ChromeDriver` / browser startup error

- Confirm Google Chrome is installed and can open normally.
- Use a current Selenium 4 dependency; Selenium Manager handles driver resolution in normal setups.
- Ensure the machine has internet access on first run.
- Close stuck Chrome processes and retry.
- If your lab blocks automatic driver downloads, ask the lab administrator for the approved ChromeDriver and configure it according to the lab environment.

## `NoSuchElementException`

- Confirm `login.html` is in `src/test/resources`.
- Confirm the element IDs match the test: `username`, `password`, `loginButton`, `message`.
- Confirm the page loaded before interacting with it.
- For a real asynchronous website, use `WebDriverWait` and an expected condition instead of fixed sleeps.

## Maven tests fail

Run one test at a time:

```bash
mvn -Dtest=LoginTest#validLoginShouldSucceed test
mvn -Dtest=LoginTest#invalidLoginShouldFail test
```

Inspect `target/surefire-reports/`. Verify the expected text and demo credentials. Fix the cause, then rerun `mvn clean test`.

## Git says `remote origin already exists`

Check `git remote -v`. If the URL is wrong, use:

```bash
git remote set-url origin <correct-repository-url>
```

## Git says `src refspec ... does not match any`

Usually no commit exists yet, or the branch name is incorrect. Run `git status`, `git branch --show-current`, stage files and create the first commit before pushing.

## Git authentication failed

For GitHub HTTPS, authenticate through the supported browser flow or use a personal access token when prompted. Never paste tokens into source code or commit them.

## Merge conflict

Run `git status`, open each conflicted file, reconcile the content, remove `<<<<<<<`, `=======`, and `>>>>>>>` markers, run tests, then `git add <resolved-file>` and commit the merge. Push after verifying the result.
