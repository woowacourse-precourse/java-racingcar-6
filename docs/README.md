# 간단 자동차 경주 게임

## 기능 목록
- [x] 입력받는 기능 구현 - InputView
  - [x] 경주할 자동차 이름을 입력받는다. (이름은 쉼표 기준으로 구분) - InputView.inputCarName
    - [x] [예외처리] 이름 구분을 쉼표로 하지 않은 경우 - InputValidator.validateInputCarName
      - [x] [예외처리] 하나의 이름에 공백 포함 가능
      - [x] [예외처리] 콤마 뒤 공백 허용 X
      - [x] [예외처리] 한글 이름 허용 X
  - [x] 시도할 횟수를 입력받는다. - InputView.inputTryCount
    - [x] [예외처리] 입력 값에 숫자가 아닌 것이 포함된 경우. - InputValidator.validateInputTryCount
      - [x] [예외처리] 맨 앞자리 0 허용 X
- [x] 자동차 구현 - Car
  - [x] 자동차는 각각 이름을 갖고 있다. - name
  - [x] 자동차는 각각 자신의 전진한 길이를 갖고 있다. - length
  - [x] 자동차의 전진 조건은 랜덤값 0~9를 추출하고, 그 값이 4이상이면 전진한다. - move
- [x] 자동차들을 담는 컬렉션 구현 - Cars
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
