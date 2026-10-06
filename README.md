# Lab05 (TDD)

사칙연산 TDD 실습과 Android 계산기 앱입니다.

## 구성

- `python-tdd/`: 사칙연산 클래스와 unittest 테스트
- `android-calculator/`: Java/XML 앱과 JUnit 계산 엔진 테스트

Android 앱은 화면과 계산 엔진을 분리했습니다. 0으로 나누면 수업자료의 테스트 기준에 따라 0을 반환합니다.

## Python 실행

```powershell
cd python-tdd
python -m unittest -v
```

테스트 8개 모두 통과했습니다.

## Android 실행

Android Studio에서 `android-calculator`를 열고 Gradle 동기화 후 에뮬레이터 또는 기기에서 실행합니다.
JDK 17 이상, Android SDK 35가 필요하며 Windows에서는 영문 프로젝트 경로를 권장합니다.

계산 엔진 테스트는 Android 프로젝트 폴더에서 실행합니다.

```powershell
.\gradlew.bat testDebugUnitTest
```

테스트 10개 모두 통과했으며, 에뮬레이터에서 사칙연산과 입력 처리를 확인했습니다.
