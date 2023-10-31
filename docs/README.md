# 미션2 - 자동차 경주
JAVA _ 자동차 경주 게임 프로젝트

## 기능 목록
### ✔ 입력
- [x]: 경주할 자동차들의 이름을 입력받고 저장한다. - CarRaceManager.createCarList()
    - [x]: 입력값이 아예 없거나 공백으로만 이뤄져 있으면 오류 발생시킨다. - Validation.checkIfNullOrBlankList()
    - [x]: 입력 받은 자동차 이름이 1자 이상이 아니면 오류 발생시킨다. - Validation.checkIfAnyBelowOneLength()
    - [x]: 입력 받은 자동차 이름이 5자를 초과하면 오류 발생시킨다. - Validation.checkIfAnyOverFiveLength()
    - [x]: 중복되는 자동차 이름이 있으면 오류 발생시킨다. - Validation.checkIfAnyOverlapping()
- [x]: 시도할 회수를 입력받고 저장한다. - Application.getAttemptNumber()
    - [x]: 입력값이 아예 없거나 공백으로만 이뤄져 있으면 오류 발생시킨다. - Validation.checkIfNullOrBlankString()
    - [x]: 입력값이 int type이 아니면 오류 발생시킨다. - Validation.checkIfNotInteger()
    - [x]: 입력값이 0이하면 오류 발생시킨다. - Validation.checkIfNotPositiveNumber()

### ✔ 각 시도별 경주 실행 - CarRaceManger.nthAttemptRace()
- [x]: 0~9까지 중에 무작위 값을 구한다. - Utils.generateRandomNumber()
- [x]: 무작위로 구한 값이 전진값인지 아닌 지 판단한다. - Utils.isMove()
    - [x]: 전진값이면 해당 차의 전진값을 +1 한다. - Car.moveForward()

- [x]: 각 시도별 경주 결과 출력. - CarRaceManager.printAttemptResult()

### ✔ 우승자 판단 및 출력
- [x]: 우승자를 판단한다. - carRaceManager.winnerJudgment()
- [x]: 우승자를 출력한다. - carRaceManager.printWinner()

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### ✔ 입출력 요구 사항

#### 입력
(추가) 입력 받은 문자열이 아예 비거나 공백으로만 이뤄지지 않은 이상, 공백은 무시하고 값을 판단한다.

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수
```
5
```

#### 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

#### 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

---