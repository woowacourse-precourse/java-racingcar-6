# 간단 자동차 경주 게임

## 기능 목록
- [] 입력받는 기능 구현 - InputView
  - [] 경주할 자동차 이름을 입력받는다. (이름은 쉼표 기준으로 구분) - InputView.inputCarName
    - [] [예외처리] 이름 구분을 쉼표로 하지 않은 경우 - InputValidator.validateInputCarName
  - [] 시도할 횟수를 입력받는다. - InputView.inputTryCount
    - [] [예외처리] 입력 값이 숫자가 아닌 경우. - InputValidator.validateInputTryCount
- [] 자동차 구현 - Car
  - [] 자동차는 각각 이름을 갖고 있다. - name
  - [] 자동차는 각각 자신의 전진한 길이를 갖고 있다. - length
  - [] 자동차의 전진 조건은 랜덤값 0~9를 추출하고, 그 값이 4이상이면 전진한다. - move
- [] 자동차들을 담는 컬렉션 구현 - Cars
- [] 입력받은 이름으로 이름을 구분하고 Car를 생성하는 객체 - GameService
  - [] 이름을 쉼표 기준으로 구분하고 이름의 개수를 추출.
  - [] 이름의 개수만큼 Car를 생성해 컬렉션에 담아 Cars를 생성.
- [] 심판 구현 - Referee
  - [] 자동차의 전진 길이를 가지고 우승자를 뽑는다. - Referee.checkResult
- [] 결과 출력 구현 - OutputView
  - [] 시도 횟수마다 각 자동차의 전진 결과를 출력한다. - OutputView.printMoveResult
  - [] 전진 길이가 같은 자동차가 여러대면 우승자도 여러명이다. 쉼표로 구분한다. - OutputView.printWinner

## 진행 순서
- [] 자동차 이름을 입력받는다.
- [] 시도할 횟수를 입력받는다.
- [] 자동차 이름의 수만큼 자동차를 생성한다.
- [] 시도할 횟수만큼 전진 길이를 계산한다.
- [] 시도된 각 횟수마다 자동차의 전진 결과를 출력한다.
- [] 각 자동차의 전진 길이를 가지고 우승자를 계산한다.
- [] 우승자를 출력한다.
