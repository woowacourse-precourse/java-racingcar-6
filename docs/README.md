### 기능 목록 ###

[o] 사용자에게 자동차 이름과 전진횟수를 입력받는다. -Input.carName(), Input.gameRound()

[o] 전진횟수만큼 난수를 발생시킨다. -RandomNum.number()

[o] 발생시킨 난수가 4이상 시 자동차를 전진시킨다. -Action.moveCar()

[o] 횟수가 1회 진행될때의 상황을 출력한다. -Output.printResult()

[o] 마지막 회차까지 진행했을때 우승자를 출력한다.(동차는 허용한다.) -Output.printWinner()



### 예외 처리 ###

[o] 자동차 이름이 5자를 초과하거나 1보다 작을 수 없다. -carNameLengthException()

[o] 자동차의 이름은 서로 중복 될 수 없다. -carNameSameException()

[o] 이름을 구분할때 띄어쓰기가 들어갈 수 없다. -blankException()

[o] 라운드는 정수로만 입력할 수 있다. -noIntRoundException()



### 테스트 코드 ###

[-] 난수가 1~3일 때 움직이지 않고, 4~9일때 전진하는지 확인 -ActionTest / 전진및정지확인()

[-] 여러 자동차의 거리를 비교해 올바른 우승자를 구하는지 확인 -WhoIsWinner / 우승자비교()

[-] 자동차 이름이 1글자 이상 5글자 이하 인지 확인 -CarNameExceptionTest / 자동차이름길이확인()

[-] 자동차 이름이 각각 다른 이름인지 중복 확인 -CarNameExceptionTest / 자동차이름중복확인()

[-] 자동차 이름에 공백이 들어있는지 확인 -CarNameExceptionTest / 자동차이름공백확인()

[-] 라운드 수가 정수로 입력되었는지 확인 -RoundExceptionTest / 정수로입력된라운드수()