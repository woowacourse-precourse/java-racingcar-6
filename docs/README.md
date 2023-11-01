# 기능 구현 목록

### 자동차 이름 입력 받기

- 입력받은 자동차 이름을 ','로 분할하여 `Arraylist`에 저장하기

### 움직일 횟수 입력 받기

- 숫자 아닐 경우 `IllegalArgumentException` 발생시키기

### 자동차 이동시키기

- 랜덤 값이 4 이상일 경우 앞으로 전진
- 이동 결과 출력
- 입력받은 이동 횟수만큼 반복

### 우승자 출력하기

<br>

# 클래스 및 메소드 설명

## Application.main

`GameController`와 `Carview`를 초기화하고 `controller`에 `view`를 설정해준 뒤 게임을 시작한다.

## model: Car

- **name** variable

자동차의 이름

- **position** variable
 
경주가 진행되는 동안 이동한 거리

- Initialization

자동차의 이름이 5자를 넘지 않는지 확인한 후 `name`을 할당하고, `position`을 0으로 초기화한다.

- **move** method
 
랜덤 값을 추출하고 값이 4 이상일 경우 앞으로 전진(`position`을 1 증가)한다.

## model: Race

- **cars** variable

자동차들을 리스트로 저장한다.

- Initialization

'자동차 이름(문자열)' 리스트를 받아 `Car` 클래스로 이루어진 `cars` 리스트에 저장한다.

- **moveCars** method

`Car` 클래스의 `move` 메소드를 이용하여 자동차를 이동시킨다.

## view: CarView

- **printRaceResult** method

`Car` 클래스로 이루어진 `cars` 리스트를 받아 자동차의 이름과 현재 진행 상황을 출력한다. 
이는 한 회기마다 출력되어 총 움직임 횟수 n만큼 출력된다.

- **printWinners** method

`Car` 클래스로 이루어진 `winners` 리스트를 받아 자동차의 이름만 리스트로 따로 저장하고,
`String.join` 메소드를 활용하여 콤마로 연결해 출력한다.

## controller: ReceiveController

- **carNames** method

사용자로부터 경주할 자동차 이름을 받아 `StringTokenizer`을 이용하여 쉼표 기준으로 분할하고,
이름(문자열)으로만 이루어진 리스트를 반환한다.
이 리스트는 추후 `Race` 클래스에 전달 및 initialize 되어 `car` 클래스의 `name` 변수에 저장된다.

- **moveNum** method

사용자로부터 이동 횟수를 입력받는다.

## controller: GameController

- **race** variable

`Race` 클래스이다.

- **view** variable

`CarView` 클래스이다.

- **receive** variable

`ReceiveController` 클래스이다.

- Initialization

`receive` 변수를 초기화한다.

- **playGame** method

`receive`(`ReceiveController`) 변수의 메소드들을 이용하여 사용자로부터 입력을 받는다.
그 후 race 변수를 초기화하고 실제 경기를 시작 및 결과를 출력한다.

- **startRace** method

이동 횟수를 받아 해당 횟수만큼 차들을 움직인다.
이때 `race.moveCars` 메소드를 이용하여 랜덤값 추출 및 그에 따른 이동을 실행하고,
한 회차가 끝날 때마다 해당 회차의 결과를 출력하여 총 n번 출력한다.

- **getWinners** method

`Car` 클래스로 이루어진 `winners` 리스트를 생성하고 최대 이동 거리를 구해
해당 거리를 이동한 차(하나 이상)를 `winners` 리스트에 삽입하고 이를 반환한다.

- **announceWinners** method

`getWinners` 메소드를 사용하여 승자를 알아내고 이를 출력한다.