@echo off
chcp 65001 >nul
cd /d "%~dp0python-tdd"
python -m unittest -v
pause
