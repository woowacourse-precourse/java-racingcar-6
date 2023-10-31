

- [x] 사용자에게서 2개의 값을 입력받는다. `Application`
  - [x] 자동차의 이름을 입력받는다. `Application`#`askCarNames`
    - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - [x] 몇 번의 이동을 할 것인지를 입력받는다. `Application`#`askMoveCount`
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
- [x] 자동차들이 전진 또는 멈춤으로 경주할 수 있다. `Race`
  - [x] 무작위 값이 4 이상일 경우 전진한다. `Race`#`isForward`
    - [x] 0에서 9사이 무작위 값을 구한다. `RandomNumber`#`createRandom`
- [x] 우승자를 구할 수 있다. `Referee`#`winner`
  - [x] 각 자동차들이 총 전진한 횟수를 알 수 있다. `Race`#`racing`
    - 우승자는 한 명 이상일 수 있다. 
    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
          