## 기능적 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- -> Car클래스의 isMove() 메서드로 구현
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
- -> RaceGame클래스의 getResult() 메서드를 통해 출력
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- -> RaceGameController클래스의 splitCarNames(), validCarNames() 메서드로 구현
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- -> View클래스에서 사용자의 입력을 받기
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- -> Randoms.pickNumberInRange(0, 9)를 통해 0~9사이의 무작위 값을 받은 후 randomNumber <= 4이면 Car의 position++
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- -> raceGame의 getWinner() 메서드로 구현
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- -> raceGame의 getWinner() 메서드로 구현
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- -> 자동차이름을 split한 후, split된 문자열이 5자리를 초과한 경우, round값을 숫자가 아닌 문자열로 받은 경우 예외 발생시키기

