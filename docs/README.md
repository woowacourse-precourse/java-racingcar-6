# 🗃 구현기능

## 📝 문자열 처리 유틸리티
- [x] 1.1 **문자열 형식 검증** : 정규식을 이용해 입력된 문자열이 문자와 ,로만 구성되었는지 검증합니다.
- [x] 1.2 **문자열을 문자열 리스트로 변환** : 입력된 문자열을 쉼표 기준으로 분리하여 문자열 리스트로 변환합니다.
- [x] 1.3 **문자열 길이 검증 (5자 이하)** : 문자열이 5자 이하인지 검증합니다.
- [x] 1.4 **문자열 리스트를 자동차 리스트로 변환** : 문자열 리스트를 자동차 객체 리스트로 변환합니다.

## 🚗 자동차 경주 도메인
- [x] 2.1 **Cars 도메인 구현** : 자동차와 경주를 위한 도메인 모델을 구현합니다.
- [x] 2.3 **0 ~ 9 사이의 랜덤한 값 생성** : 0부터 9 사이의 랜덤한 값을 생성합니다.
- [x] 2.4 **자동차 전진 전략 구현** : 자동차의 전진 전략을 구현합니다.
- [x] 2.5 **자동차 이동 구현** : 자동차를 이동시키는 로직을 구현합니다.

## 🏁 경주 결과 처리
- [x] 3.1 **각 라운드 결과 저장 ** : 각 라운드의 경주 결과를 저장하는 DTO를 구현합니다.
- [x] 4.1 **우승자 계산 구현** : 경주의 우승자를 계산하고 출력합니다.

## 📥 입출력 처리
- [x] 5.1 **입력 구현** : 사용자의 입력을 받아 처리하는 기능을 구현합니다.
- [x] 6.1 **출력 구현** : 경주 결과를 사용자에게 출력하는 기능을 구현합니다.

## 🎮 경주 게임 처리
- [x] 7.1 **카레이스 구현** : 자동차 경주 게임을 실행하고 결과를 출력합니다.

## 🛠 코드 리팩토링
- [x] 8.1 **리팩토링** : 코드의 가독성과 유지보수성을 향상시키기 위해 리팩토링을 수행합니다.

---

## 🗂 폴더 구조

### 🛠 util

- 🛡️ **validator**
  - [x] 📝 **StringLengthValidator**: 자동차 이름 길자 수 검증
  - [x] 📝 **RegexValidator**: 자동차 이름 형식 검증

- 🔄 **converter**
  - [x] 📝 **StringToNumberConverter**: 문자를 숫자로 변환
  - [x] 📝 **StringToStringListConverter**: 문자열을 리스트로 변환
  - [x] 📝 **StringListToCarListConverter**: 문자열 리스트를 자동차 리스트로 변환

- 🎰 **generator**
  - [x] 📝 **NumberGenerator**: 0~9 사이의 랜덤 값 생성

- 🎨 **formatter** 
  - [x] 📝 **RoundResultFormatter**: RoundResultDto 출력 형식 변환
  - [x] 📝 **WinnerFormatter**: WinnerDto 출력 형식 변환

### 🏢 domain

- [x] 🚗 **Cars**: 자동차들의 정보를 저장
  - [x] 🚖 **Car**: 자동차의 움직임 관리
    - [x] 📝 **CarName**: 자동차 이름 저장
    - [x] 📝 **CarLocation**: 현재 자동차 위치 저장

  - [x] 🚀 **MoveJudgement**: 자동차 전진 가능 여부 인터페이스
  - [x] 📝 **RandomMoveJudgment**: MoveJudgement 구현
  - [x] 📝 **MoveStrategy**: 자동차 움직임 전략 인터페이스
  - [x] 📝 **OneStepMoveStrategy**: MoveStrategy 구현
### 🚥 **Controller**

- [x] 📝 **CarRacing**: Racing 구현
- [x] 📝 **Racing**: 여러 레이싱을 위한 인터페이스

### 👀 view

- 📥 **input**
  - [x] 📝 **Input**: 입력 인터페이스

- 📤 **output**
  - [x] 📝 **Output**: 출력 인터페이스

- [x] 🖼️ **ConsoleInputView**: Input 인터페이스 구현
- [x] 🖼️ **ConsoleOutputView**: Output 인터페이스 구현

### 📝 dto

- [x] 📝 **RoundResultDto**: 각 경기 결과 기록 DTO
- [x] 📝 **WinnerInfoDto**: 우승자 기록 DTO

### 🔈 enum

- [x] 📝 **RaceMessages**: 출력 메세지 상수 이넘