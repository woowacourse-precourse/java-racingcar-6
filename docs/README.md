# 기능 목록 정리 - 자동차 경주

## 1. 사용할 객체

→ `GameController`, `Car`, `Game`, `GameService`, `Validate`, `Input`, `Output` 7개의 객체로 구성

### GameController (Controller)

게임을 진행 할 클래스

### Car (model)

차에 관한 이름과 위치 데이터 저장할 클래스

### Game (model)

게임에 참여한 차들과 게임을 진행할 횟수 저장할 클래스

### GameService (Service)

게임을 진행하면서 데이터의 변경을 해주는 클래스

### Validate

입력에 대한 예외처리 진행

### Input (View)

입력에 관한 클래스

### Output (View)

출력에 관한 클래스

---

## 2. 각 객체에서 사용할 함수 (기능)

### GameController (Controller)

- `void run()`

  자동차 경주 게임을 진행


### Car (model)

- `Car(String name)`

  차 이름과 시작위치(0)으로 Car 생성자

- `void moveForward()`

  전진할 경우 위치를 +1


### Game (model)

- `Game(List<Car> carList, int roundNumber)`

  게임에 참여하는 차와 라운스 수를 통해 Game 생성자


### GameService (Service)

- `Game playAllGame(Game game)`

  라운드 별로 게임을 진행하면서 객체의 상태값 업데이트

  최종 Game 결과를 반환

- `List<String> getWinner`

  최종 Game 결과를 바탕으로 우승자 반환


### Validate

- `void validateDuplicationCarsName(List<String> input) throws IllegalArgumentException`

  자동차 이름을 중복일 경우 예외처리

- `void validateLengthCarsName(List<String> input) throws IllegalArgumentException`

  자동차 이름이 5 이상일 경우 예외처리

- `void validateBlankCarsName(List<String> input) throws IllegalArgumentException`

  자동차 이름에 공백이 포함될 경우 예외처리

- `void validateIsNumber(String input) throws IllegalArgumentException`

  숫자가 아닌 입력일 경우 예외처리

- `validateNegativeNumber(String input throws IllegalArgumentException`

  반복횟수가 1보다 작을 경우 예외처리


### Input (View)

- `List<String> inputCarNames()`

  게임에 참여할 차의 이름을 입력

- `int inputRoundNumber()`

  게임을 진행할 라운드 횟수 입력


### Output (View)

- `void printScore()`

  각 라운드 별로 진행 상태 출력

- `void printWinner()`

  최종 우승자 출력