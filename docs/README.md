## 기능 요구 사항

- [X] 자동차의 이름을 입력받는다. -InputView#askCarNames()
    - [X] 입력받을 자동차의 이름은 5글자 이하로 구성된다. Validator#isValidCarNames()
    - [X] 입력받을 자동차는 쉼표(,)로 구분된다.
    - [X] 잘못된 값이 들어올 경우 `IllegalArgumentException`을 발생시키고 종료시킨다.
- [X] 몇 번 이동할 것인지 입력받는다. -InputView#askMoveCount()
    - [X] 잘못된 값이 들어올 경우 `IllegalArgumentException`을 발생시키고 종료시킨다.
- [X] 0에서 9사이의 무작위 숫자를 생성한다. NumberGenerator#createRandomNumber()
- [X] 생성한 숫자가 4이상인지 확인한다.
    - [X] 4이상이면 자동차를 전진시킨다. car#move()
- [X] 각 회차마다 각 자동차의 이름과 진행 상황을 출력한다. OutputView#printCarInfo
    - [X] 출력 형식은 "이름 : -(이동 거리)" 로 한다.
- [X] 우승 자동차를 판별하고 반환한다. Referee#getWinner()
    - [X] 우승자는 여러 명일 수 있다.
- [X] 우승자를 출력한다. OutputView#printWinner()
    - [X] 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다.
    - [X] 출력 형식은 "최종 우승자 : user1, user2" 로 한다.
