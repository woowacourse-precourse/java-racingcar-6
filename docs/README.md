-[]주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
    -[] 자동차는 전진 할 수 있다. Car#moveForward()
    -[] 자동차는 멈출 수 있다. Car#moveStop()
-[]자동차를 위치를 나타낸다.  Car#locate()
-[]자동차의 위치를 초기화한다. Car#clear()

-[]각 자동차에 이름을 부여할 수 있다. User#nameForCar()
    -[]자동차 이름은 쉼표(,)를 기준으로 구분한다. 
    -[]이름은 5자 이하만 가능하다. User#vailedName()
-[]사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. User#fillInMovingNumber();


-[] 0에서 9사이의 무작위 값을 구해야 한다. Random#createNumber()

-[] 무작위 값이 4이상인지 판단해야 한다.   Judgment#IsNumberFourOrMore();

-[]자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. Referee#announceWinner()
    -[]우승자를 판단해야 한다. Referee#decideWinner()
    -[]우승자의 숫자가 두명 이상인지 판단 한다. Referee#isNumberOfWinnerTwoOrMore();
    -[]우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.  Referee#makeWinnerWithCommas()
    -[]우승자를 발표한다. Referee#announceWinner()

-[]전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. OutputView#printCar();
    -[] 자동차의 위치와 이름을 받는다. OutputView#CarState();
-[]사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.    Error#processError()