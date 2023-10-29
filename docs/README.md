##      

1. 게임을 시작한다.
    1. 시작할 때 시작 메세지를 출력시킨다.
2. 레이싱 자동차들의 이름을 `.`단위로 입력받는다.
3. 레이싱 횟수(count)를 입력받는다.
4. 입력받은 이름으로 Car객체를 생성한다.
    - Car객체는 이름과 전진한 횟수(위치)를 가져야한다.
5. 입력받은 횟수만큼 Car겍체들에 대해서 랜덤숫자를 구한다.(0-9)
    - 4이상일 경우만 전진한다.
6. 이후 Car객체들의 위치(결과)를 출력한다.
7. 3번에서 입력받은 count만큼 5,6번을 반복한다.
8. count민큼 반복했으면 가장 많이 전진한 횟수를 구하고 그 횟수를 가진 Car객체의 이름들을 출력한다.

##      

### domain

#### Car.class

- 레이싱 자동차에 대한 객체
- `name` : 자동차 이름
- `moveCount` : 전진한 횟수

### controller

#### RacingController.class

- `run()` : 게임을 동작시키는 함수

### service

#### RacingService

- `carList` : 생성한 Car객체들을 담고있는 List타입의 변수
- `startRacing()` : 레이싱을 시작하는 함수
    - 함수내에서 레이싱 자동차들에 대한 정보와 레이싱 횟수에 대한 정보를 입력받는다.
    - 그에 따른 메세지들도 출력한다. (`startMessage`, `askCountMessage`)
- `createRacingCar()` : 입력받은 자동차이름으로 Car객체와 그 Car객체들을 담고있는 List를 생성하는 함수
- `getCount()` : 레이싱 횟수를 입력받고 숫자인지 검증하는 함수
- `moveAllRacingCar()` : 입력받은 횟수만큼 carList에 대해서 전진할지 멈출지 함수를 실행시키는 함수