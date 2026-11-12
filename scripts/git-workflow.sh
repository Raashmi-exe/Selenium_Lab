#!/usr/bin/env bash
# Run from the project root after configuring the remote named origin.
set -e
git status
git switch -c feature/selenium-login-validation
# Make a small edit before continuing.
git add src/test/resources/login.html
git commit -m "Add e-commerce login page heading"
git push -u origin feature/selenium-login-validation
git status
git branch -vv
