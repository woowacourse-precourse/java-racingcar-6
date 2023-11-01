# 💻 구현기능 목록

---
## 🏁 Racing

---
### 📙 Variable

- `Car[] cars` - 자동차 객체를 담을 배열

### 📘 Method

- `startRacing()` - 자동차 경주 실행
  - `setCarName`메소드를 사용하여, `Car`객체들을 생성한다.
  - `phase`변수를 사용하여, 몇 번의 move를 시도할 지 입력받는다.
  - `phase`값만큼 `moveCar`메소드를 실행하고, 결과값을 출력한다.
  - `checkWinner`메소드를 통해 최종 우승자를 출력한다.


- `winnerDistance()` - 가장 멀리 이동한 자동차 거리 반환
  - `getDistance`메소드를 사용하여, 가장 멀리 이동한 자동차의 거리를 반환한다.


- `checkWinner()` - 우승자를 찾아, 최종 우승자를 출력
  - `String winner`변수를 생성하여 우승자의 이름을 추가한다.
  - `int winner_count`변수를 통해 다수의 우승자가 나올 경우 winner에 이름을 추가하는 방식을 바꾼다.
  - `winnerDistance()`메소드를 사용하여, 가장 멀리 이동한 거리를 찾는다.
  - 만약 처음 추가되는 우승자일 경우, `winner`변수에 `getCarName`메소드를 사용하여 초기화한다.
  - 만약 복수 우승자일 경우, ",  + `getCarName`"형식으로 `winner`변수에 추가한다.
  - 이후 최종 우승자를 출력한다.
  

- `setCarName()` - 자동차 이름 설정
  - `Console`의 `readline()`메소드를 사용하여 사용자에게 입력을 받는다.
  - `String`의 `split`메소드를 사용하여 ','단위로 파싱해 `String[] temp`배열을 생성한다.
  - `temp`를 활용하여 `cars` 배열에 객체를 생성한다.
  
  ❗️**예외처리**❗
  
    ➡ 자동차 이름은 5글자 이하
  
    ➡ ',' 앞뒤에 존재하는 공백은 무시


- `moveCar()` - 자동차가 움직일 지 결정
  - `Car`객체의 `move`메소드를 사용하여 자동차의 움직임을 결정한다.
  - `postResult()`메소드를 사용하여, 움직임의 결과를 출력한다.


- `postResult()` - 자동차의 move 결과 출력
  - `Car`객체의 `getdistance`메소드를 사용하여 `distance`가져온다.
  - `distance`의 값만큼 "-"표시한다.
## 🏎️ Car

---
### 📙 Variable

- `String carName` - 자동차의 이름
- `int distance` - 자동차가 이동한 거리

### 📘 Method
- `getCarName()` - Car 객체의 carName 반환
  - `carName` 변수를 반환한다.


- `getDistance()` - Car 객체의 distance 반환
  - `distance` 변수를 반환한다.


- `move()` - Car이 이동할 지, 이동하지 않을 지 결정
  - `Randoms`의 `pickNumberInRange()`메소드를 한다.
  - 무작위 수가 4이상이면 `distance`를 1 더한다.