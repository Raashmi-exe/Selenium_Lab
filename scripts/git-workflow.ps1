# Run from the project root after configuring the remote named origin.
$ErrorActionPreference = "Stop"
git status
git switch -c feature/selenium-login-validation
Write-Host "Make a small edit to src/test/resources/login.html, then press Enter."
Read-Host
git add src/test/resources/login.html
git commit -m "Add e-commerce login page heading"
git push -u origin feature/selenium-login-validation
git status
git branch -vv
