# 자동차 경주

## 개요

자동차 경주 프로그램은 다음과 같이 동작한다.

1. 게임 설정
    1. 사용자에게 이름을 입력 받는다.
        1. 빈 값이나 공백을 사용한 이름은 잘못된 입력으로 간주한다.
        2. 5글자를 초과하는 이름은 잘못된 입력으로 간주한다.
        3. 중복된 이름이 입력되는 경우 잘못된 입력으로 간주한다.
    2. 사용자에게 라운드 횟수를 입력받는다.
        1. 라운드 횟수로 0이 입력된 경우 잘못된 입력으로 간주한다.
        2. 숫자가 입력되지 않는 경우 예외 처리를 해 준다.
2. 게임 동작
    1. 각 라운드마다 자동차는 전진을 시도한다.
    2. 라운드가 종료될 때 마다 라운드 결과를 출력한다.
3. 게임 종료
    1. 모든 라운드가 종료되면 우승자를 출력 후 게임을 종료한다.

## 구성

어플리케이션은 다음의 객체들로 구성한다.

### Model

#### Car

역할 : 각 자동차의 정보를 저장한다.<br>

- `boolean isMove()`
    - 이번 라운드에 해당 객체가 움직였는지를 반환한다.
- `String getRoundResult()`
    - 각 라운드의 진행 정보를 `String`으로 반환한다.
- `@Override boolean equals()`
    - 각 객체는 `Car.CarName`이 동일하면 같은 객체로 취급한다.

#### CarName

역할 : 자동차의 이름을 저장한다.

- 제한사항
    - 각 이름은 5글자 이하로 이루어져있다.
    - 이름은 `null`, 빈 값, 공백으로 구성될 수 없다.

#### RoundNumber

역할 : 진행할 라운드 수를 저장한다.

- 제한사항
    - 라운드 수는 양수로, 0을 허용하지 않는다.

### 일급 객체 컬렉션

#### CarList

역할 : 게임에 참여하는 자동차들을 `List<Car>` 형태로 저장한다. <br>

- `void addCar(Car car)`
    - `List<>`에 `Car` 객체를 저장한다.
    - 중복되는 객체 저장시 `IllegalArgumentException`을 발생시킨다.
- `void forEachCar(Consumer<Car> consumer)`
    - 컬렉션에 존재하는 각각의 `Car` 객체를 사용한다.

#### PositionMap

역할 : 각 자동차들의 위치 정보를 'Map<Car>' 형태로 저장한다. <br>

- `void putCar(Car car)`
    - `Car` 객체의 값을 초기 위치값 0으로 하여 `Map`에 저장한다.
    - 중복되는 객체 저장시 `IllegalArgumentException`을 발생시킨다.
- `void moveCar(Car car)`
    - `Car` 객체를 한 칸 전진시킨다.
- `List<Car> getWinners()`
    - 우승자에 해당하는 `Car` 객체들을 `List`에 담아 반환한다.

### 어플리케이션

#### Game

역할 : 전체 게임의 흐름을 제어한다.<br>

- `void play()`
    - 자동차 경주 게임을 진행한다.

#### GameBuilder

역할 : 사용자의 입력을 처리하고, 게임 객체를 생성한다.

- `GameBuilder getCarsName()`
    - 자동차의 이름을 입력받는다.
- `GameBuilder getRoundNumber()`
    - 라운드 수를 입력받는다.
- `Game build()`
    - 입력받은 정보들을 사용해 `Game` 객체를 생성한다.