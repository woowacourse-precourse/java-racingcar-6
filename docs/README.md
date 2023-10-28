### 구현할 기능 목록 

- [ ] 경주 게임을 시작한다. - RaceManager#startRace
  - [ ] 경주 게임을 준비한다. - RaceManager#prepareRace
    - [ ] 자동차 이름을 입력받는다. - InputView#getCarNames
    - [ ] 자동차 이름 입력을 검증한다. - InputValidator#validateCarNames
      - [ ] 이름은 쉼표를 기준으로 구분한다. - InputValidator#checkCommaSeparatedNames
      - [ ] 이름은 5자 이하만 가능하다. - InputValidator#checkNameLengthLimit
    - [ ] 경주할 자동차를 생성한다. - RaceManager#generateRaceCarList
    - [ ] 몇 번의 이동을 할 것인지를 입력받는다. - inputView#getNumberOfAttempts
      - [ ] 시도할 횟수는 양의 정수이다. - inputValidator#validateNumberOfAttempts

  - [x] 주어진 횟수만큼 경주 게임을 수행한다. - RaceManager#runRace
    - [x] 한 차수의 경주 게임을 수행한다. - RaceManager#runRaceRound
      - [x] 매 게임마다 자동차는 전진 조건에 부합하면 전진한다. - Car#moveOnRandomChance
        - [x] 전진 조건에 사용할 무작위 값을 생성한다. - Car#generateRandomNumber
        - [x] 전진인지 멈춤인지 판단한다. - Car#isForward
      - [x] 이동 결과를 보여준다. - OutputView#showResult

  - [ ] 누가 우승했는지 판단한다. - RaceManager#determineWinner
  - [ ] 우승자를 보여준다. - OutputView#showWinner

