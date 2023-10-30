## 기능 명세서

⭐️ 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException을` 발생시킨 후 애플리케이션은 종료되어야 한다.

### 사용자 입력 기능 - [InputView](../src/main/java/racingcar/view/InputView.java)

- [x] 사용자로부터 자동차의 이름을 입력받는다. #inputCarNames()
    - [x] ❗️빈 문자열, 공백일 경우 예외처리 한다. #validateString()
- [x] 시도 횟수를 입력받는다. #inputTryNumber()
    - [x] ❗️ 숫자가 아닐 경우 예외처리 한다. #validateNumber()
    - [x] ❗️ 자연수가 아닐 경우 예외처리 한다. #validatePositiveNumber()

### 사용자 출력 기능 - [OutputView](../src/main/java/racingcar/view/OutputView.java)

- [x] 각 차수별 실행 결과를 출력한다. #printResult()
- [x] 우승자 안내 문구를 출력한다. #printWinnerNames()
    - 단독 우승자 안내 문구는 `최종 우승자 : {이름}`을 따른다.
    - 공동 우승자 안내 문구는 `최종 우승자 : {이름1}, {이름2}`를 따른다. (공동 우승자는 `,` 로 구분한다.)

### 게임 제어 기능 - [GameController](../src/main/java/racingcar/controller/GameController.java)

- [x] 자동차를 생성하라고 지시한다. #generateCars()
- [x] 자동차 경주 게임을 진행하라 지시한다. #racing()
- [x] 결과를 출력하라고 지시한다. #printResult()

### 자동차 리스트 기능 - [Cars](../src/main/java/racingcar/model/Cars.java)

- [x] 자동차를 생성한다. #from()
    - [x] ❗️ 빈 자동차 리스트일 경우 예외처리 한다. #validateEmpty()
    - [x] ❗️ 자동차의 이름이 중복될 경우 예외처리 한다. #validateDuplicate()
- [x] 자동차들에게 경주하라 지시한다. #race()
- [x] 자동차 우승자의 이름을 조회한다. #getWinnerNames()

### 자동차 기능 - [Car](../src/main/java/racingcar/model/car/Car.java)

- [x] 랜덤수와 비교하여 전진하거나 머무른다. #race()
- [x] 서로의 위치를 비교한다. #isSamePosition()

### 자동차 이름 - [Name](../src/main/java/racingcar/model/car/Name.java)

- [x] 자동차의 이름을 생성한다. #from()
    - [x] ❗️이름의 길이가 유효하지 않을 경우 예외처리 한다. #validateNameLength()

### 자동차 위치 - [Position](../src/main/java/racingcar/model/car/Position.java)

- [x] 자동차의 위치를 증가한다. #plus()

### 랜덤 수 생성 기능 - [RandomNumberGenerator](../src/main/java/racingcar/model/RandomNumberGenerator.java)

- [x] 0보다 크고 9보다 작은 랜덤 수를 생성한다. #generate()
