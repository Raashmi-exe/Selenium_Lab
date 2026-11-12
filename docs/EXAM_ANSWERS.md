# Experiment 4 — Exam-ready answers (Questions 13–16)

## Q13. Clone/open the Git repository, create a feature branch, make a small change, commit and push it. (10 marks)

**Procedure**

1. Install Git and open Git Bash/terminal.
2. Clone the shared repository: `git clone <repository-url>`.
3. Move into the project directory: `cd selenium-git-login`.
4. Check the current branch and working tree: `git status`.
5. Create and switch to a feature branch: `git switch -c feature/selenium-login-validation`.
6. Make a small change, such as changing the login page heading.
7. Stage the changed file: `git add src/test/resources/login.html`.
8. Commit the change: `git commit -m "Add e-commerce login page heading"`.
9. Push the branch to the remote: `git push -u origin feature/selenium-login-validation`.
10. Verify using `git status`, `git branch -vv` and `git log --oneline -5`.

**Explanation:** Git is the version-control tool. The local repository stores the developer's commits. A remote repository (GitHub or a bare Git repository) is the shared server. A feature branch isolates work from the main branch and makes collaboration safer.

## Q14. Configure Selenium WebDriver and write tests for valid and invalid login attempts. (10 marks)

**Configuration:** The Maven `pom.xml` includes Selenium Java and JUnit Jupiter dependencies. `DriverFactory` creates a ChromeDriver. Selenium Manager, included with Selenium 4, can resolve a compatible driver automatically. `LoginTest` opens the local `login.html` page before each test and closes the browser after each test.

**Test cases**

| Test | Input | Expected result |
|---|---|---|
| Valid login | admin / password123 | Success message appears |
| Invalid login | wronguser / wrongpassword | Error message appears |

**Run:** `mvn clean test`

**Why both tests?** A positive test verifies that a legitimate user can sign in. A negative test verifies that incorrect credentials are rejected and an error is shown. Assertions compare the actual browser output with the expected output.

## Q15. Run Git and Selenium tasks. Explain how to resolve a merge conflict or failed test. (10 marks)

**Run Selenium:** `mvn clean test`. Review the Maven output and `target/surefire-reports/`.

**Run Git:** `git status`, `git add .`, `git commit -m "message"`, `git push`.

**Merge conflict procedure**

1. Run `git pull origin main` (or merge the latest main branch into the feature branch).
2. Git reports the files with conflicts.
3. Open each conflicted file. Locate `<<<<<<<`, `=======` and `>>>>>>>`.
4. Discuss/compare both versions and edit the file to retain the correct combined code. Remove all conflict markers.
5. Run the relevant tests.
6. Stage the resolved file: `git add <file>`.
7. Complete the merge: `git commit` (if Git has not already opened the merge commit).
8. Push the updated branch: `git push`.

**Failed Selenium test procedure**

1. Read the failure and stack trace in the Maven console or Surefire report.
2. Check that Chrome is installed and compatible driver resolution is working.
3. Verify the page loaded and element IDs (`username`, `password`, `loginButton`, `message`) are correct.
4. Check test data and expected text.
5. Use explicit waits if the real application loads elements asynchronously.
6. Fix the application/test, rerun `mvn clean test`, and commit the correction.

Do not change an assertion simply to hide a genuine application defect.

## Q16. Show expected browser behaviour and test results for both login cases, with Git status after pushing. (10 marks)

**Valid login:** Open the local demo login page, enter `admin` and `password123`, then click **Sign in**. The browser displays `Login successful. Welcome, admin!` and the message status is `success`.

**Invalid login:** Enter `wronguser` and `wrongpassword`, then click **Sign in**. The browser displays `Invalid username or password.` and the message status is `error`.

**Expected automated test summary**

```text
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

**Expected Git verification**

```bash
git status
git branch -vv
git log --oneline --decorate -5
git ls-remote --heads origin
```

After a successful push, the feature branch should appear on the remote. If the working tree is clean, Git reports `nothing to commit, working tree clean`. A clean status means there are no uncommitted changes; it does not by itself prove that a push succeeded, so verify the remote branch too.
