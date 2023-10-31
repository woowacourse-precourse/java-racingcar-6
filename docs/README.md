# 2주차 미션 : 자동차 경주 게임

---

## 1. 구현 기능 리스트 (구현전)

- 필요한 기능 리스트와 설명
- 양식 : [구현여부] (기능 설명)_ (클래스 이름)#(메서드 이름)

---

- [x] 자동차의 이름을 입력받는다. InputView#readCarNames()


- [x] 입력한 이름이 유효한지 검사한다. Game#validateNamesInput()
    - [x] 이름이 5글자를 초과하면 예외를 발생시킨다. Game#checkNameLength()


- [x] 자동차들의 상태를 초기화한다. Race#setCarList()
    - [x] 입력받은 모든 자동차의 이름을 쉼표(,)로 나누어 저장할 수 있어야 한다.
    - [x] 각 자동차의 이름과 이동 거리를 설정한다. Car#Car()


- [x] 이동 회수를 입력받는다. InputView#readRoundNumber()


- [x] 입력받은 이동 회수가 유효한지 검사한다. Game#validateRoundInput()
    - [x] 이동 회수가 정수가 아니면 예외를 발생시킨다. Game#checkIsNumber()


- [x] 이동 회수를 설정한다. Round()#Round()


- [x] 0에서 9사이의 무작위 값을 생성한다. RandomGenerator#createNumber()


- [x] 매 번 이동마다 각각의 자동차가 전진하거나 멈춘다. Race#moveCars()
    - [x] 자동차를 전진시킨다. Car#moveForward()
        - [x] 무작위 값이 4 이상일 때만 한 칸 전진해야 한다.


- [x] 매 번 이동마다 자동차의 이동 결과를 출력한다. OutputView#printRoundResult()
    - [x] 자동차의 이름과 전진한 칸이 출력되어야 한다.


- [x] 우승자를 계산한다. Race#getWinners()
    - [x] 가장 멀리 간 자동차를 우승자로 저장해야 한다. Race#getMaxDistance()
    - [x] 동점인 경우 여러 명을 저장해야 한다.


- [x] 우승자를 출력한다. OutputView#printGameWinners()
    - [x] 우승자가 여러 명인 경우 쉼표와 공백(, )으로 구분해야 한다.

---

## 2. 구현 기능 리스트 (구현중 변경 사항)

- 구현중 추가된 기능의 리스트와 설명
- 양식 : [구현여부] (기능 설명)_ (클래스 이름)#(메서드 이름)

---

- [x] 남은 이동 회수가 있는지 확인한다. Round#isRoundRemaining()


- [x] 이동 회수를 1회 줄인다. Round#subtractOneRound()


- [x] 입력된 자동차 이름 문자열을 분리해 리스트로 반환한다. Race#makeStringToList()


- [x] 자동차 리스트의 크기를 반환한다. Race#getCarListSize()


- [x] 자동차들의 이름 리스트를 반환한다. Race#getCarNames()
    - [x] 자동차의 이름을 반환한다. Car#getName()


- [x] 현재 라운드의 자동차들 이동 거리를 반환한다. Race#getRoundResult()
    - [x] 자동차의 전진 거리를 반환한다. Car#getDistance()


- [x] 자동차 이름이 비었다면 예외를 발생시킨다. Game#checkNameEmpty()


- [x] 이동 회수가 0보다 작으면 예외를 발생시킨다. Game#checkRoundRange()


- [x] 게임의 결과를 출력하기 전 "실행 결과" 메시지를 출력한다. OutputView#printResultStartMessage()


- [x] 출력할 게임 결과 문자열을 만든다. OutputView#buildResultString()
    - [x] 자동차의 이름과 "-"로 이루어진 게임 결과 문자열을 만든다. OutputView#makeResultString()


- [x] 랜덤 숫자로 이루어진 특정 크기의 리스트를 반환한다. RandomGenerator#getNumbers()