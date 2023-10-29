# 🗃 구현기능

## 문자열 처리 유틸리티
- 1.1. **문자열을 문자열 리스트로 변환**: 입력된 문자열을 쉼표를 기준으로 나누어 문자열 리스트로 변환하고 검증합니다.
- 1.2. **문자열 길이 검증 (5자 이하)**: 문자열의 길이가 5자 이하인지 검증합니다.`
- 1.3. **문자열 리스트를 자동차 리스트로 변환**: 문자열 리스트에서 자동차 객체 리스트로 변환합니다.
## 자동차 경주 도메인
- 2.1. **Cars 도메인 구현**: 자동차와 경주를 위한 도메인 모델을 구현합니다.
- 2.3. **0 ~ 9 사이의 랜덤한 값 생성**: 0부터 9 사이의 랜덤한 값을 생성합니다.
- 2.4. **자동차 전진 전략 구현**: 자동차의 전진 전략을 구현합니다.
- 2.5. **자동차 이동 구현**: 자동차를 이동시키는 로직을 구현합니다.

## 경주 결과 처리
- 3.1. **각 라운드 결과 저장 (RoundResultDto)**: 각 라운드에서의 경주 결과를 저장하는 DTO를 구현합니다.
- 4.1. **우승자 계산 구현**: 경주의 우승자를 계산하고 출력합니다.

## 입출력 처리
- 5.1. **입력 구현**: 사용자 입력을 받아 처리하는 기능을 구현합니다.
- 6.1. **출력 구현**: 경주 결과를 사용자에게 출력하는 기능을 구현합니다.

## 경주 게임 처리
- 7.1. **카레이스 구현**: 자동차 경주 게임을 실행하고 결과를 출력합니다.

## 코드 리팩토링
- 8.1. **리팩토링**: 코드의 가독성과 유지보수성을 향상시키는 리팩토링을 수행합니다.
---

## 🗂 폴더 구조

### 🛠 util

- 🛡️ validator
    - [ ] **ForwardValidator**: 전진 가능 여부 검증 클래스
    - [ ] **CarNameLengthValidator**: 자동차 이름 글자 수 검증 클래스
    - [ ] **CarNameDuplicateValidator**: 자동차 이름 중복 글자 수 검증 클래스

- 🎉 converter
    - [ ] **StringToNumberConverter**: 입력받은 숫자를 숫자로 변환하는 클래스
    - [ ] **StringToStringListConverter**: 입력받은 문자열을 쉼표를 기준으로 나눠서 리스트로 변환하는 클래스
    - [ ] **StringListToCarListConverter**: 문자열 리스트를 자동차 리스트로 변환하는 클래스

- generator
    - [ ] **🎰 NumberGenerator**: 1~9 사이의 랜덤값을 생성하고 반환하는 클래스

### 🏢 domain

- [ ] 🚗 **Cars**: (일급 컬렉션)
    - [ ] 🚖 **Car**: 자동차의 움직임을 맡는다.
        - [ ] **CarName**: 자동차의 이름을 저장하는 불변 객체
        - [ ] **CarLocation**: 현재 자동차의 위치를 저장하는 객체

- 🏁 CarForwardService: 전진 가능 여부를 확인하고 가능하면 `car.move()`를 실행
    - 🚀 ForwardStrategy: 자동차의 전진 전략을 정의하는 추상 클래스
        - [ ] **ConditionBasedForwardStrategy**: ForwardStrategy를 구현하는 구체적인 전략 클래스. 특정 조건에 따라 자동차가 전진
    - [ ] **ResultFormatter**: RoundResultDto의 값을 출력하기 좋게 변환하는 클래스

- 🏆 CarRaceResultEvaluator: 자동차 경주의 우승자를 찾아주는 클래스
- [ ] **CarFactory**: 자동차 객체를 생성하는 클래스

### 🚥 racing

- [ ] **CarRacing**: Racing을 구현한 클래스
- [ ] **Racing** (Racing 인터페이스): 여러 레이싱을 위한 인터페이스

### 👀 view

- 📥 input
    - [ ] **Input**: 입력을 받는 인터페이스

- 📤 output
    - [ ] **Output**: 출력을 받는 인터페이스

- 🖼️ [ ] **ConsoleInputView**: input 인터페이스를 구현하는 클래스
- 🖼️ [ ] **ConsoleOutputView**: output 인터페이스를 구현하는 클래스

### 📝 dto

- [ ] **RoundResultDto**: 각각의 경기 결과를 기록하는 DTO
- [ ] **WinnerInfoDto**: 우승자를 기록하는 DTO

### enum
- [ ] **RaceMessages**: 출력 메세지 상수를 가지고 있는 이넘  