# 자동차 경주 게임

### 흐름

1. 자동차 이름을 입력받는다.
2. 시도할 횟수를 입력받는다.
3. 시도할 횟수만큼 입력받은 각 자동차마다 무작위 수를 뽑아 4 이상이 나올 경우 한 칸 전진한다.
4. 매 회차마다 전진 횟수를 저장한다.
5. 매 회차마다 자동차들의 기록을 출력한다.
6. 모든 회차가 끝난 후 각 자동차들의 전진 횟수를 비교한다.
7. 최종 우승자를 출력한다.

## 기능 목록

### Cars

- `List<Car>`를 가지고있는 일급 컬렉션.
- move(): 자동차의 수 만큼 반복하여 자동차들을 전진시킨다.
    - [x] 각 자동차의 moveForward() 메서드를 호출하여 움직이게 한다.

### Car

- `자동차의 이름`, `Position`, `Engine`을 가지고있다.
- startEngine(): 엔진에 시동을 걸어 움직인다.
    - [x] Engine의 start() 메서드를 호출한다.
    - [x] 반환값이 `true` 라면 position의 값을 `1` 증가시킨다.

### Position

- 자동차가 현재 몇 번째 위치에 있는지 `int` 타입으로 가지고있다.
- moveForward(): Position의 value를 1 증가시킨다.
- getValue(): Position이 가진 value를 반환한다.

### CarEngine

- 자동차가 움직일 수 있는지 없는지를 반환하는 start() 메서드가 정의된 인터페이스.

### RandomCarEngine

- start(): 자동차가 움직일 수 있는지 없는지를 반환한다.
    - [x] `Randoms.pickInRange()` 메서드로 0 ~ 9 사이의 숫자를 뽑아 `4` 이상인지 `boolean`으로 반환한다.

### RacingCarInputView

- inputCarNames(): 경주할 자동차 이름을 입력받는다.
    - [x] `"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"` 출력.
    - [x] 자동차의 이름을 입력받을 때 `,`를 기준으로 구분.

- inputAttemptCounts(): 시도할 횟수를 입력받는다.
    - [x] `"시도할 횟수는 몇회인가요?"` 출력.
    - [x] 시도할 횟수를 입력받는다.

### RacingCarOutputView

- printStartMessage(): `"실행 결과"` 메세지를 출력한다.
    - [x] `"실행 결과"` 출력.

- printEachRacingResult(): 각 차수별 실행 결과를 출력한다.
    - [x] 경주할 자동차의 이름 순서에 맞게 `"이름 : -"` 형태로 출력.
    - [x] 줄바꿈을 한다.

- printWinner(): 최종 우승자를 출력한다.
    - [x] 우승자가 2명 이상일 경우 `,`를 구분한다.
    - [x] `"최종 우승자 : pobi, jun"` 형태로 출력한다.

### RacingCarInputValidator

> 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

- validateCarNames(): 사용자에게 입력받은 자동차 이름을 검증한다.
    - [x] 각 자동차 이름은 `1자 이상 5자 이하`만 가능.
    - [x] 각 자동차 이름은 `한글, 영어, 숫자`만 포함 가능.

- validateAttemptCounts(): 사용자에게 입력받은 시도 횟수를 검증한다.
    - [x] 입력된 횟수가 `숫자`가 아닐 경우 에러 반환.
    - [x] 입력된 횟수가 `음수`일 경우 에러 반환.

### RacingResult

- List<RacingRoundResult> 타입을 가지는 일급 컬렉션.
- addResult(): 매 회차 레이스 결과를 추가한다.
- getFinalWinners(): 최종 레이스 결과의 우승자를 반환한다.
    - [x] 매 회차 기록이 누적되기 때문에 마지막 회차에서 승자를 찾는다.

### RacingRoundResult

- List<Car> 타입을 가지는 일급 컬렉션.
- getWinners(): 해당 라운드의 레이스 우승자를 반환한다.
    - [x] 동점자가 있을 수 있기 때문에 최고 기록을 찾는다.
    - [x] 최고 기록과 같은 기록을 가진 자동차의 이름을 리스트로 반환한다.

### RacingCarController

- run(): 레이싱 게임을 시작한다.
    - [x] 사용자에게 자동차 이름을 입력 받는다.
    - [x] 사용자에게 시도 횟수를 입력 받는다.
        - [x] 사용자에게 입력받은 시도 횟수만큼 RacingCarService에 레이싱을 수행한다.
        - [x] 매 회차 레이싱 결과를 출력한다.
    - [x] 최종 승자를 출력한다.

### RacingCarService

- race(): 사용자가 입력한 자동차 이름과 시도 횟수를 바탕으로 레이스를 시작해 결과를 반환한다.
    - [x] 자동차들을 사용자가 입력한 시도 횟수만큼 진행시킨다.
    - [x] 매 회차 기록을 저장한다.
    - [x] 레이싱 결과를 반환한다.
- determineWinner(): 최종 승자를 반환한다.
    - [x] 최종 승자 리스트를 반환한다.

### RacingCarAssemblyService

- assemble(): 사용자가 입력한 자동차 이름을 받아서 객체로 만든다.
    - [x] 사용자가 입력한 자동차의 이름을 String<List>로 받아서 Car로 변환한다.
    - [x] 변환한 Car를 List로 만들어 Cars를 생성하여 반환한다.

### CarInfo

- 출력에 필요한 Car 도메인의 정보들을 담아서 넘겨주는 DTO.
