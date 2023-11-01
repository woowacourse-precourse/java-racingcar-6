## 구현 기능 목록 작성

- [x] 입력 메시지 출력 (printInputRacersNameMessage) [OutputView]


- [x] n대의 자동차를 입력 (readRacersName) [InputView]

  - [x] 쉼표(,) 기준으로 이름 분리 후 List로 반환(seperateCarName) [RacerManager]

  - [x] 5자 이하의 이름들을 가졌는지 확인 (validateRacersName) [InputValidator]


- [x] 자동차 객체 [Racer]

  - [x] name, moveCount, state 조작 (plusMoveCount, goState, stopState)

  - [x] name, moveCount, state, moveState 확인 (getName, getMoveCount, getState, getMoveSate)


- [x] 전체 게임 진행 (play) [RaceController]

- [x] List를 통해 racer 생성 + 이름 지정 (createRacers) [RacerManager]


- [x] 입력 메시지 출력 (printInputMoveNumberMessage) [OutputView]

  - [x] 시도할 횟수 moveNumber 입력 (readMoveNumber) [InputView]

  - [x] moveNumber이 숫자가 맞는지 비어있지 않은지 확인 (validateMoveNumber) [InputValidater]


- [x] 자동차들의 전진 또는 정지 판단 (getGoOrStop) [StateMaker]

  - [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 (decideGoOrStop) [RaceMaker]

  - [x] 전진일 경우 MoveCount에 1 더해주기 (increaseMoveCount) [Racer]


- [x] 실행 횟수 moveNumber 만큼 반복 (repeatMove) [RaceController]

  - [x] 실행 결과 출력 (printMoveResult) [OutputView]

  - [x] moveState에 moveCount 만큼 "-" 추가 기능 (increaseGoMark) [RaceReferee]


- [ ] 최종 우승자 쉼표로 구분하여 출력(printWinner) [OutputView]

  - [x] 우승자 판단 (getWinner) [WinnerDecider]

  - [x] 전진 횟수가 가장 많은 racer (findWinner) [WinnerDecider]