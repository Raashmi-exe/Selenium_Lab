# Expected browser behaviour and results

## Browser case 1 — Successful login

1. Chrome opens the local demo login page.
2. Enter username `admin`.
3. Enter password `password123`.
4. Click **Sign in**.
5. Expected message: **Login successful. Welcome, admin!**
6. The message element has `data-status="success"`.

## Browser case 2 — Unsuccessful login

1. Chrome opens the local demo login page.
2. Enter username `wronguser`.
3. Enter password `wrongpassword`.
4. Click **Sign in**.
5. Expected message: **Invalid username or password.**
6. The message element has `data-status="error"`.

## Maven test output

The exact duration and formatting vary by machine. The important expected summary is:

```text
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Git output after pushing

Run:

```bash
git status
git branch -vv
git ls-remote --heads origin
```

Expected:
- `git status` reports a clean working tree if all changes are committed.
- `git branch -vv` shows the feature branch tracking `origin/feature/selenium-login-validation`.
- `git ls-remote --heads origin` lists the remote feature branch.
