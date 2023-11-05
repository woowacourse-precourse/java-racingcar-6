## 🚀 구현할 기능 목록

### 게임 데이터 초기화
- [x] 경주 할 자동차 이름을 입력받는다.
    - [x] `예외처리` : 이름이 5자를 초과하는 경우
- [x] 시도할 횟수를 입력받는다.
    - [x] `예외처리` : 횟수가 양의 정수가 아닌 경우

### 게임 진행
- [x] 0에서 9 사이에서 무작위 값을 구한다.
- [x] 자동차는 전진 또는 멈출 수 있다.
- [x] 무작위 값이 4 이상일 경우 전진한다.
- [x] 각 차수별 실행 결과를 출력한다.

### 게임 종료
- [x] 우승자 안내 문구를 출력한다.
    - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

## 🧠 확장 가능성
- [x] 자동차 이름 제한길이 변동 가능성
- [x] 무작위 값 범위의 변동 가능성
- [x] 자동차 행동 종류의 변동 가능성
- [x] 전진 기준의 변동 가능성
- [x] 각 차수별 실행 결과의 변동 가능성
- [x] 우승자 안내 문구의 변동 가능성
    - [x] 구분자의 변동 가능성

## 🧑🏻‍🏫 클래스 분리

## Game
- `GameData`
- `GameExecution`

## GameData
- `AttemptData`
- `AttemptNumber` : int

## AttemptData
- `GameAttempts` : List\<Attempt>
- `AttemptIndex` : int

## Attempt
- `RacingCars` : List\<Car>
- `RandomNumbers` : List\<Integer>

## Car
- `CarName` : String
- `CarPosition` : int

## GameExecution
- `GameInput`
- `GameOutput`