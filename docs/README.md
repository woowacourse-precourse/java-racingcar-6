# 자동차 경주

## 🎯 기능 목록

- [X] n대의 자동차 이름들을 입력 받는다.
    - [X] 각 자동차 이름은 쉼표(,) 로 나눈다.
    - [X] 자동차 이름은 1글자 이상, 5글자 이하이어야 한다.
    - [X] 자동차 이름에 공백이 포함되면 안된다.
    - [X] 자동차 이름이 중복되면 안된다.
    - [X] 잘못된 입력이면 `IllegalArgumentException` 을 발생시키고 어플리케이션을 종료한다.
- [X] 시도 횟수를 입력 받는다.
    - [X] 시도 횟수는 0 초과의 정수이어야 한다.
    - [X] 잘못된 입력이면 `IllegalArgumentException` 을 발생시키고 어플리케이션을 종료한다.
- [X] 자동차 객체는 조건에 따라 움직인다.
    - [X] 자동차 객체의 초기 위치는 0이다.
    - [X] 자동차 객체는 주어진 거리에 따라 움직인다.
    - [X] `Randoms.pickNumberInRange` 를 사용해서 무작위 숫자를 구한다.
    - [X] `Randoms.pickNumberInRange` 에서 Range 는 0 이상 9 이하이다.
    - [X] 무작위 숫자가 4 이상이면 자동차의 position을 1 전진시킨다.
- [X] 시도 횟수마다 각 자동차의 position 을 출력해야 한다.
- [X] 모든 시도 횟수가 끝난 후 우승자를 판별해야 한다.
    - [X] 우승자는 position 이 가장 큰 자동차이다.
    - [X] 우승자는 한명 이상일 수 있다.
    - [X] 우승자가 여러 명일 경우, 쉼표(,)를 이용하여 구분한다. 

## 자동차 경주 세상

### 객체

<img width="800" alt="image" src="https://github.com/ddoddii/ddoddii.github.io/assets/95014836/3f614c97-47ee-414a-a7fa-1da07219267a">

### Model-View-Controller
<img width="847" alt="image" src="https://github.com/ddoddii/ddoddii.github.io/assets/95014836/1ea355b7-58dd-4b38-9cb8-9f30d3b7b99a">

## 🤖 객체의 행동
- `Car`
  - Car 객체는 name, position 을 속성으로 가진다.
  - Car 객체는 조건에 따라 position 을 움직인다. 
- `CarName`
  - CarName 객체는 자동차의 이름을 나타내는 객체이다.
  - 1글자 미만, 5글자 초과이지 않은지 검증한다.
  - 이름안에 공백이 없는지 검증한다. 
- `CarPosition`
  - CarPosition 의 초기값은 0이다.
  - CarPosition 은 주어진 DISTANCE 만큼 position 을 증가시킨다.
- `Cars`
  - Cars 객체는 carNames 가 주어지면 자동차 이름을 파싱해 Car 객체의 리스트로 저장한다.
  - 주어진 carNames 에서 중복된 자동차 이름이 없는지 검증한다. 
  - Cars 객체는 리스트 안에 있는 Car 들을 움직일 수 있다.
  - Cars 객체는 리스트 안에 있는 Car 중에 가장 큰 position 값을 구할 수 있다.
- `Winners`
  - Cars에게 가장 큰 position 값을 달라고 메세지를 보낸다.
  - 가장 큰 position 값을 가진 Car 들을 리스트에 저장한다.
- `TrialNumber`
  - TrialNumber 가 정수인지 검증한다.
  - TrialNumber 가 0 초과의 정수인지 검증한다.
  - TrialNumber 를 하나씩 감소시킨다.
  - TrialNumber 0 인지 확인한다. 
- `MoveRule`
  - 조건에 따라 움직일지 말지 여부를 알려준다.   
- `Game`
  - Cars 객체에게 모든 자동차를 움직이라고 메세지를 보낸다.
  - 다음 라운드로 가면 TrialNumber 에게 하나 감소하라고 메세지를 보낸다.
  - 게임이 끝났는지 여부를 판별하기 위해 TrialNumber에게 값이 0인지 확인하는 메세지를 보낸다. 