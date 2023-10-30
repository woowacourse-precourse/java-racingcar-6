# 우아한 테크코스 프리코스 #2 - 자동차 경주
## 기능 목록
### 1. 자동차 경주 게임 시작 전, 경주 할 자동차 이름과 시도할 횟수 입력
- 1.1. getCarName()
  - 자동차 이름을 입력하라는 문구 출력 및 사용자로부터 input 입력 받기
- 1.2. getAttemptNumber()
  - 시도할 횟수 입력하라는 문구 출력 및 사용자로부터 input 입력 받기
- 1.3. isValidCarName(String input)
  - 자동차 이름의 유효성 검사 
- 1.4. isValidAttemptNumber(String input)
  - 시도 횟수의 유효성 검사
- 1.5. convertCarList(List<String> carInputList)
  - 자동차 이름 input을 Car 객체 리스트로 변환하여 반환
### 2. 입력된 횟수만큼 자동차 게임을 실행
- 2.1. startOneRoundGame()
  - 게임 1회 실행 및 결과 출력
- 2.2. oneGameStart()
  - 0-9 사이의 무작위 숫자를 생성하여 조건에 따라 전진 또는 멈춤 실행
- 2.3. generateRandomNumber()
  - 0-9 사이의 무작위 숫자 생성 
- 2.4. forwardCar(int randomNumber)
  - 무작위 숫자가 4 이상이라면 1 전진 
- 2.5. printGameResult(Car car)
  - 자동차의 이름과 전진 상태를 출력 
### 3. 게임 종료 후, 우승자를 출력
- 3.1. getMaxForwardCountCar()
  - 가장 많이 전진한 자동차 객체를 반환
- 3.2. setWinnerList(Car maxForwardCar)
  - 최종 우승자를 선정
- 3.3. printWinner(List<String> winnerList)
  - 최종 우승자를 형식에 맞게 출력 (공동 우승자라면 쉼표(,)로 구분)
### 4. 사용자 input에 대한 Validation
- 4.1. isValidType(List<String> inputList)
  - 자동차 이름들이 문자인지 검사
- 4.2. isLetter(String word)
  - 자동차 이름에 숫자가 포함되는지 검사
- 4.3. isValidLength(List<String> inputList)
  - 자동차 이름이 5자 이하인지 검사
- 4.4. isIntegerNumber(String input)
  - 시도 횟수가 정수형 숫자인지 검사
- 4.5. isNull(String word)
  - String이 null인지 검사
- 4.6. isEmptyOrBlank(String word)
  - String이 공백이나 빈 문자열인지 검사
### 5. 출력
- 5.1. printLine()
  - 한 줄 띄우기 
- 5.2. printBeforeResult()
  - "실행 결과" 문구 출력
### 6. 테스트 코드
- 자동차_이름_숫자포함일경우
- 자동차_이름_숫자일경우
- 자동차_이름_5자_초과일경우
- 자동차_이름_공백일경우
- 자동차_이름_빈줄일경우
- 시도_횟수_문자일경우
- 시도_횟수_소수점_숫자일경우
- 시도_횟수_공백일경우
- 자동차_객체_리스트_변환
- 범위내_무작위_숫자_생성
- 자동차_한대_참여할경우
- 자동차_모두_공동_우승할경우
- 게임결과_출력_테스트











