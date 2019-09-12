@echo off
rem   just kills stray local chromedriver.exe instances.
rem   useful if you are trying to clean your project, and your ide is complaining.

wmic process where name="chrome.exe" call terminate > kill_chrome.txt