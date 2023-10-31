# 자동차 경주 게임

## 기능 목록

- [X] 사용자는 자동차의 이름을 입력할 수 있다. - InputManager#inputCarNames()
  - [X] 자동차의 이름은 여려개 입력할 수 있으며 각 이름은 쉼표[,] 로 구분된다 - InputManager#inputCarNames()
  - [X] 이 때 이름의 길이가 5자를 초과하면 IllegalArgumentExecption을 발생한다. - CarNameValidator#validate()
  - [X] 자동차의 이름이 서로 중복되어도 IllegalArgumentException을 발생한다. 
- [X] 사용자는 자동차들이 몇 번의 이동 시도를 할 지 입력할 수 있다. - InputManager#inputMoveNumber()
  - [X] 이 때 시도횟수는 1이상 10000이하의 자연수로 한정하고, 이외의 값이 오면 IllegalArgumentException을 발생한다 - MoveNumberValidator#validate()
- [X] 각각의 자동차는 시도별로 0에서 9사이의 무작위 값 중 무작위 값이 4이상일 경우 전진한다. - RandomCar#move()
- [X] 각 시도별로 자동차들의 위치 상황을 출력한다. - RandomCar#printPosition(), GameManager#moveRandomCars()
- [X] 모든 시도를 마친 후에 누가 우승했는지 출력한다. 이 때 우승자는 한 명 이상일 수 있다. GameManager#printWnnerCars()
  - [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. GameManager#printWnnerCars()