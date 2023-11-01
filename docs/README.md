# 🏆자동차 경주

## 기능목록

### 📝 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)을 입력받는다. - Inputs#askCarNames()
- 경주 할 자동차 이름들을 쉼표(,) 기준으로 분리한다. - Inputs#splitCarNames()
- 자동차 이름이 **5글자 이하**인지 확인한다. -Inputs#checkCarNameLengthLowerThanOrEqualToFive()
- 시도할 회수를 입력받는다. - Inputs#askRaceNumbers()

### 🚗 자동차 경주 진행

- 게임을 시작한다. - Game#startGame()
- 자동차 경주를 실행한다. - Game#doRace()
- **0에서 9 사이**에서 무작위 값을 생성한다. - Car#createRandomNumber()
- 다수의 우승자가 존재하는지 확인한다. - Game#areWinners()
- 우승자를 선정한다. - Game#selectWinner()
- 전진 또는 멈춤을 선택한다. - Game#goOrStop()
- 전진한다. - Car#go()
- 최대 전진 회수를 체크한다. - Game#checkMaxGoNumber()

### 📃 출력

- 전체 차수 실행 결과를 출력한다. - Game#printResult()
- 차수별 실행 결과를 출력한다. - Game#printResultByRound()
    - 배열을 하나의 문자열로 바꾼다. - Game#arrayToStringByTurn()
- 우승자를 출력한다.(단일 우승자인 경우 / 우승자가 다수인 경우) - Game#printWinner() / Game#printWinners()
    - 우승자가 다수인 경우 컴마를 어디까지 붙일 지 결정한다. - checkCommaPrint()

## ✅기능 테스트 목록

### 📝 입력
- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)을 입력받는 메서드 Inputs#askCarNames()를 테스트한다. - 자동차_이름_입력_테스트()
- 경주 할 자동차 이름들을 쉼표(,) 기준으로 분리하는 메서드 Inputs#splitCarNames를 테스트한다(쉼표 관련 예외처리도 테스트한다). - 자동차_이름들을_쉼표로_분리()
- 시도할 회수를 입력받는 메서드 Inputs#askRaceNumbers를 테스트한다. - 반복_숫자_테스트_자연수(), 반복_숫자_테스트_오류()

### 🚗 자동차 경주 진행

- 게임을 시작하는 메서드 Game#startGame를 테스트한다. - 게임_시작()
- 자동차 경주를 실행하는 메서드 Game#doRace()를 테스트 한다. - 경주_실행()
- **0에서 9 사이**에서 무작위 값을 생성하는 메서드 Car#createRandomNumber를 테스트 한다. -무작위_값_생성_0에서_9사이()
- 다수의 우승자가 존재하는지 확인하는 메서드 Game#areWinners를 테스트한다. - 다수의_우승자_존재()
- 우승자를 선정하는 메서드 Game#selectWinner를 테스트한다. - 우승자_선정()
- 전진 또는 멈춤을 선택하는 메서드 Car#goOrStop를 테스트한다. - 전진_혹은_멈춤()
- 전진하는 메서드 Car#go를 테스트한다. - 전진()
- 최대 전진 회수를 체크하는 메서드 Game#checkMaxGoNumber를 테스트한다. - 최대_전진_회수_테스트()

### 📃 출력

- 전체 차수 실행 결과를 출력하는 메서드 Game#printResult를 테스트한다. - 전체_차수_실행_결과_출력()
- 차수별 실행 결과를 출력하는 메서드 Game#printResultByRound를 테스트한다. - 차수별_실행_결과_출력()
    - 배열을 하나의 문자열로 바꾸는 메서드 Game#arrayToStringByTurn를 테스트한다. - 배열을_문자열로_바꾸기()
- 우승자를 출력하는 메서드 Game#printWinner와 Game#printWinners를 테스트한다. - 우승자_출력() / 우승자들_출력()
    - 우승자가 다수인 경우 컴마를 어디까지 붙일 지 결정하는 메서드 checkCommaPrint를 테스트한다. - 컴마_출력_테스트()

## 🚀 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.