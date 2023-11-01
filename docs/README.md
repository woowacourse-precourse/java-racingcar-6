# 구현할 기능 목록

## 1. 상수 값 관리
### 1) 콘솔 메시지 ConsoleMessages
- [x] 콘솔 메시지를 상수 값으로 관리
  - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
  - 시도할 회수는 몇회인가요?
  - 실행 결과

### 2) 예외 메시지 ExceptionMessages
- [ ] 예외 메시지를 상수 값으로 관리

### 3) 게임 세부 옵션 GameOptions
- [x] 게임 세부 옵션을 상수 값으로 관리
  - 이름 구분자 (,)
  - 이름 최대 길이 (5)
  - 무작위 값 관련 (최소값 0, 최대값 9, 기준값 4)

## 2. 입출력 관련
### 1) 콘솔 입력 ConsoleScanner
- [x] 자동차 이름을 입력받는 기능 - readCarName()
- [x] 횟수를 입력받는 기능 - readRound()

### 2) 콘솔 출력 ConsolePrinter
- [x] 자동차 이름 입력 메시지 출력 - printCarNameMessage()
- [x] 횟수 입력 메시지 출력 - printRoundMessage()
- [x] 실행 결과 메시지 출력 - printResultMessage()
- [x] 자동차 위치 출력 - printCarPosition(Car car)
- [x] 최종 우승자 출력 - printFinalWinner(List<String> names)

## 3. 유틸 함수
### 1) 문자열 파싱 StringParser
- [ ] 문자열을 자동차 이름 배열로 파싱하는 기능 - parseCarName(String str)
- [ ] 문자열을 횟수 값으로 파싱하는 기능 - parseRound(String str)

### 2) 값 검증 Validator
- [ ] 자동차 이름 값을 검증하는 기능 - validateCarName(String carName)
  - [ ] 빈 문자열이 아니어야 함
  - [ ] 길이가 5 이하여야 함
  - [ ] 앞 뒤에 공백이 없어야 함
- [ ] 자동차 이름 배열을 검증하는 기능 - validateCarNames(List<String> carNames)
  - [ ] 이름이 한 개 이상이어야 함
  - [ ] 중복 이름이 없어야 함
- [ ] 횟수 값을 검증하는 기능 - validateRound(Integer round)
  - [ ] 0 이상의 정수여야 함

## 4. 게임 로직
### 자동차 Car
- [x] 자동차 인스턴스 생성 시에 이름 속성을 부여 - Car(name)
- [x] 0 ~ 9 사이 무작위 값을 생성해 4 이상인지 판단하는 기능 - checkRandomNumber()
- [x] 자동차를 한 칸 전진시키는 기능 - moveForward()

### 자동차 컬렉션 Cars
- [x] 현재 시점의 최종 우승자를 확인하는 기능 - getFinalWinner()

### 레이싱 게임 RacingGame
- [ ] 게임을 시작시키는 기능 - play()
- [ ] 게임을 초기 설정하는 기능 - initiate()
  - [ ] 자동차 이름, 라운드 횟수
- [ ] 한 라운드 진행시키는 기능 - playOneRound()
