# 기능 요구 사항
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 기능 목록
- [x] n대의 자동차이름을 ,로 구분하 입력한다. - InputView#inputCarNames()
	- [x]  입력값이 공백일 때 예외처리한다. - Validator#validateIsEmpty()
- [x] ,로 자동차 이름을 구분하여 자동차들을 생성한다. - CreateCarsService#createCars()
	- [x] 자동차 이름의 길이가 5를 초과한다면 예외처리한다. - CarName#validateOutOfLength()
	- [x] 자동차 이름이 숫자가 포함된 경우 예외처리한다. - CarName#validateContainNumber()
	- [x] 자동차 위치가 0보다 작을 때 예외처리한다. - CarLocation#validateNegativeNumber()
- [x] 자동차들을 이동시킬 시도 횟수를 입력한다. - InputView#inputTryNumber()
	- [x] 입력값이 공백일 때 예외처리한다. - Validator#validateIsEmpty()
	- [x] 입력값이 숫자가 아니면 예외처리한다. - Validator#validateNumberFormat()
- [x] 시도 횟수만큼 자동차들의 이동을 시도한다.. - MoveCarsService#moveCars()
	- [x] 각 차별로 0부터 9까지의 무작위 값을 생성한다. NumberGenerator#generate()
	- [x] 무작위 값이 4 이상일 경우 전진한다. - MoveCarsService#moveCar()
- [x] 시도할 때마다 자동차들의 이름과 현재 위치를 출력한다. - OutputView#printCarLocationCurrentSituation()
	- [x] 현재 자동차들의 이름과 위치를 출력한다.  - OutputView#printCarLocationCurrentSituation()
- [x] 우승자를 구한다. - PickWinnerService#pickWinner()
- [x] 최종 우승한 자동차들을 출력한다. - OutputView#printWinner()
	- [x] 우승한 자동차의 이름을 쉼표로 구분한 메세지를 리턴한다.  - PickWinnerService#printWinner()