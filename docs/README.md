- 구현할 기능 목록

Application.java
- getInputCarList() -> 경주할 자동차 이름 input 받을 list
- getCarList() -> getInputCarList 에서 가져온 carList 담는 list
- getInputTryCount() -> 시도할 회수 입력하기
- getTryCount() -> tryCount 출력하기
- moveTotalCar() -> carList의 car movement 출력하기
- printTotalCar() -> CarList의 car 출력하기
- getMaxPosition() -> 차의 position
- getWinnerList() -> 우승자 List 출력하기
- printWinner() -> 우승자 출력하기
- printCarData() -> car의 이름과 car의 movement 출력
- run() -> 함수 실행
-------------
Car.java

- Car() -> car의 이름 가져오기
- movement() -> 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 사용
- getPosition()-> 현재 위치 출력
- getName() -> name 가져오기
--------------
inputView.java 

- getUserData() -> 입력받은 값을 문자열로 반환
---------------
OutputView.java

- print() -> data print 하기
- println() -> data println 하기
- printBlank() -> 공백 println 하기
- printError() -> ERROR_PREFIX 와 error 값 출력하기
---------------
Validators.java

- validateCarName() -> car의 이름이 5 이상인 경우 CAR_LENGTH_ERROR 출력
- validateTryCount() -> tryCount가 숫자가 아닌 경우 TRY_COUNT_NUMBER_ERROR 출력
