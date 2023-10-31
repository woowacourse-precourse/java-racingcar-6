# 자동차 게임 구조 및 기능 명세

## 프로젝트 기능
- 경주할 자동차 이름 입력받기
- 시도할 횟수 입력받기
- 실행 결과 출력하기
- 최종 우승자 출력하기

## 프로젝트 패키지 구조
- baseball
    - Application (class)
    - controller - Controller
    - view - Message, Input, Output
    - domain - Car, Round, Rule
    - dto - Naming, Rounding
    - service -  Game
    - utilities - Parse, Compare

## 프로젝트 클래스 및 기능 구조
### baseball/Application
- racingcar 어플리케이션 실행
    - racingcar.start
- Application -> Controller

### Controller
- setGame :
  - 게임 생성 setGame
    - 경주할 자동차 이름 입력받기
      - -> view -> Input requestCarName
      - 출력 : '경주할 자동차 입력하세요' -> Presentation -> Output -> namingMessage
      - 입력 : Dto -> Naming -> Car -> Rule
    - 시도할 횟수 입력받기
      - 출력 : Presentation -> messageController -> roundingMessage
      - 입력 : Dto -> Rounding -> Round -> Rule (string parsing, 길이, null 체크)
- startGame :
  - 게임 시작 Game -> startGame
    - 실행 결과 출력하기 -> '실행 결과' 출력 ->
        \[round만큼 반복 시작 startRound -> {n대의 자동차 수만큼 반복 시작 getCarConditionNumber 조건수 가져오기 ->
        decideAction 조건수가 전진인지 정지인지 판별 -> 전진이면 차 위치 1 증가, 정지면 아무일 없음 ->
        차 이름 + " : " 출력 -> 자동차 위치만큼 개수의 '-' 출력 (gameMessage}] 
    - 최종 우승자 출력하기 -> compareCarLocation 자동차 전진 위치 비교 ->
        제일 많이간 차 출력 resultMessage ('최종 우승자 : ' + 우승자들)

### Presentation
- messageController(flag)
    - Message : 메시지 저장
        - startMessage
        - namingMessage
        - gameMessage
        - resultMessage
    - Flag : 메시지에 해당하는 플래그 저장

### Domain
- Car
- Round
- Rule
  
### Dto
- Naming
- Rounding

### service
- Game

### utilities
- Parse
- Compare

