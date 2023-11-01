# 2주차 미션 : 자동차 경주 게임

---

## 순서

1. [구현 기능 리스트 (구현전)](#1.-구현-기능-리스트-(구현전))

2. [구현 기능 리스트 (구현중 추가 사항)](#2.-구현-기능-리스트-(구현중-추가-사항))

3. [프로젝트 구성](#3.-)

---

## 1. 구현 기능 리스트

- 필요한 기능 리스트와 설명
- 양식 : [구현여부] (기능 설명) (메서드 이름)

---

### Car

- [x] 자동차를 전진시킨다. moveForward()


- [x] 각 자동차의 이름과 이동 거리를 설정한다. Car()

### Race

- [x] 자동차들의 상태를 초기화한다. setCarList()
    - [x] 입력받은 모든 자동차의 이름을 쉼표(,)로 나누어 저장할 수 있어야 한다.


- [x] 매 번 이동마다 각각의 자동차가 전진하거나 멈춘다. moveCars()
    - [x] 무작위 값이 4 이상일 때만 한 칸 전진해야 한다.


- [x] 우승자를 계산한다. getWinners()
    - [x] 가장 멀리 간 자동차를 우승자로 저장해야 한다. getMaxDistance()
    - [x] 동점인 경우 여러 명을 저장해야 한다.

### Round

- [x] 이동 회수를 설정한다. Round()

### RandomGenerator

- [x] 0에서 9사이의 무작위 값을 생성한다. createNumber()


### InputView

- [x] 자동차의 이름을 입력받는다. readCarNames()


- [x] 이동 회수를 입력받는다. readRoundNumber()

### OutputView

- [x] 매 번 이동마다 자동차의 이동 결과를 출력한다. printRoundResult()
    - [x] 자동차의 이름과 전진한 칸이 출력되어야 한다.


- [x] 우승자를 출력한다. printGameWinners()
    - [x] 우승자가 여러 명인 경우 쉼표와 공백(, )으로 구분해야 한다.


### ValidateInput

- [x] 입력한 이름이 유효한지 검사한다. validateNamesInput()
    - [x] 이름이 5글자를 초과하면 예외를 발생시킨다. checkNameLength()


- [x] 입력받은 이동 회수가 유효한지 검사한다. validateRoundInput()
    - [x] 이동 회수가 정수가 아니면 예외를 발생시킨다. checkIsNumber()

---

## 2. 구현 기능 리스트 (구현중 추가 사항)

- 구현중 추가된 기능의 리스트와 설명
- 양식 : [구현여부] (기능 설명) (메서드 이름)

---

### Car

- [x] 자동차의 이름을 반환한다. getName()


- [x] 자동차의 전진 거리를 반환한다. getDistance()

### Race

- [x] 입력된 자동차 이름 문자열을 분리해 리스트로 반환한다. makeStringToList()


- [x] 자동차 리스트의 크기를 반환한다. getCarListSize()


- [x] 자동차들의 이름 리스트를 반환한다. getCarNames()


- [x] 현재 라운드의 자동차들 이동 거리를 반환한다. getRoundResult()

### Round

- [x] 남은 이동 회수가 있는지 확인한다. isRoundRemaining()


- [x] 이동 회수를 1회 줄인다. subtractOneRound()

### RandomGenerator

- [x] 랜덤 숫자로 이루어진 특정 크기의 리스트를 반환한다. getNumbers()

### OutputView

- [x] 게임의 결과를 출력하기 전 "실행 결과" 메시지를 출력한다. printResultStartMessage()


- [x] 출력할 게임 결과 문자열을 만든다. buildResultString()
    - [x] 자동차의 이름과 "-"로 이루어진 게임 결과 문자열을 만든다. makeResultString()

### Game

- [x] 게임 전체 과정을 실행한다. run()

### ValidateInput

- [x] 자동차 이름이 비었다면 예외를 발생시킨다. checkNameEmpty()


- [x] 이동 회수가 0보다 작으면 예외를 발생시킨다. checkRoundRange()
