### 구현할 기능 목록 

- [x] 경주 게임을 시작한다. - RaceManager#startRace
  - [x] 경주 게임을 준비한다. - RaceManager#prepareRace
    - [x] 자동차 이름을 입력받는다. - InputView#getCarNames
    - [x] 자동차 이름 입력을 검증한다. - InputValidator#validateCarNames
      - [x] 이름은 5자 이하만 가능하다. - InputValidator#checkNameLengthLimit 
      - [x] 하나 이상의 이름이 입력되어야 한다. - InputValidator#checkAtLeastOneName
    - [x] 경주할 자동차를 생성한다. - RaceManager#generateRaceCarList
    - [x] 몇 번의 이동을 할 것인지를 입력받는다. - inputView#getNumberOfAttempts
    - [x] 시도 회수를 검증한다. 시도할 횟수는 양의 정수이다. - inputValidator#validateNumberOfAttempts

  - [x] 주어진 횟수만큼 경주 게임을 수행한다. - RaceManager#runRace
    - [x] 한 차수의 경주 게임을 수행한다. - RaceManager#runRaceRound
      - [x] 실행 결과 타이틀을 보여준다. - OutputView#showResultTitle
      - [x] 매 게임마다 자동차는 전진 조건에 부합하면 전진한다. - Car#moveOnRandomChance
        - [x] 전진 조건에 사용할 무작위 값을 생성한다. - Car#generateRandomNumber
        - [x] 전진인지 멈춤인지 판단한다. - Car#isForward
      - [x] 이동 결과를 보여준다. - OutputView#showResult

  - [x] 누가 우승했는지 판단한다. - RaceManager#determineWinner
  - [x] 우승자를 보여준다. - OutputView#showWinner

