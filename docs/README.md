## 🚀 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. - RacingCar#move()
- [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. - GameManager#printRacingCarsPosition()
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. - GameManager#validateUserInput()
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. - GameManager#readUserInput()
- [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. - GameManager#printWinners()
- [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. - GameManager#printWinners()
- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다. - GameManager#validateUserInput(),
  validateUserInputForTryCount()

### 입출력 요구 사항

#### 입력

- [x] 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분) - GameManager#readUserInput()
    - [x] 이름은 5자 이하만 가능하다. - GameManager#validateRacingCarName()
    - [x] 이름은 쉼표(,)를 기준으로 구분한다. - GameManager#validateUserInput()
        - [x] 구분된 이름이 `null`인 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateRacingCarName()
        - [x] 구분된 이름이 빈 문자열인 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateRacingCarName()
    - [x] 이름이 중복되는 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInput()
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.
        - [x] 잘못된 값이 `null`인 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInput()
        - [x] 잘못된 값이 빈 문자열인 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInput()

```
pobi,woni,jun
```

- [x] 시도할 회수 - GameManager#readUserInput()
    - [x] 회수는 숫자여야 한다. - GameManager#validateUserInputForTryCount()
        - [x] 숫자가 아닌 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInputForTryCount()
    - [x] 회수는 1 이상이어야 한다. - GameManager#validateUserInputForTryCount()
        - [x] 1 미만인 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInputForTryCount()
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInputForTryCount()
        - [x] 잘못된 값이 `null`인 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInputForTryCount()
        - [x] 잘못된 값이 빈 문자열인 경우 `IllegalArgumentException`을 발생시킨다. - GameManager#validateUserInputForTryCount()

```
5
```

#### 출력

- [x] 각 차수별 실행 결과 - GameManager#printRacingCarsPosition()

```
pobi : --
woni : ----
jun : ---
```

- [x] 단독 우승자 안내 문구 - GameManager#printWinners()

```
최종 우승자 : pobi
```

- [x] 공동 우승자 안내 문구 - GameManager#printWinners()

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

