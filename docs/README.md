#자동차 경주 게임

##기능 목록

- [x] 차 이름을 입력받는다. - InputView#carNames()
    - [x] 입력 사항에 예외가 있는지 확인한다. - Car#isCorrectNamesString()
    - [x] 각 차의 전진 횟수를 0으로 설정한다. - Car#Car()
- [x] 이동 횟수를 입력받는다. - InputView#timesToTry()
    - [x] 입력 사항에 예외가 있는지 확인한다. - GameConsole#isCorrectTimesToTry()
- [x] 경주를 진행하며 전진 여부를 판별한다. - GameConsole#moveAllowed()
    - [x] 총 전진한 횟수를 저장한다. - Car#moveAmount
- [x] 모든 차의 전진한 횟수를 형식에 맞게 출력한다. - GameConsole#carsMovement()
    - [x] 한 차의 전진한 횟수를 형식에 맞게 출력한다. - OutputView#printCarMovement()
- [x] 3,4를 입력받은 이동 횟수만큼 반복한다. - GameConsole#race()
- [x] 최종 우승자를 선정한다. - GameConsole#makeWinnerNamesList()
- [x] 최종 우승자를 출력한다. - OutputView#printWinnerNames()

##기능 요구 사항

차들과 이동 횟수를 입력받고 가장 많이 움직인 차가 승리하는 게임이다.

입력받은 이동 횟수만큼 차가 전진을 시도한다.<br/>
각 차는 전진 시도마다 0부터 9 사이의 무작위 숫자를 구한다.<br/>
숫자가 4 이상인 경우 차가 전진한다.<br/>
숫자가 3 이하인 경우 차가 전진하지 않는다.<br/>

유저는 차들의 이름과 이동 횟수를 입력한다.<br/>
컴퓨터는 전진 시도마다 진행 상황을 출력하여 보여준다.<br/>
컴퓨터는 모든 전진 시도 이후 승리한 차의 이름을 출력한다.<br/>