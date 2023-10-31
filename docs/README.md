# 자동차 경주 게임

---

## 기능 목록

- [X] 경주할 자동차 이름 문자열을 입력받는 기능 - GameController.*receiveRaceCarNames*
  - [X] 자동차 이름 문자열을 파싱하는 기능 - RaceCarNames.*parseCarNamesFromInput*
  - [X] 자동차 이름 문자열이 콤마로 끝나는지 확인하는 기능.*isEndsWithComma*
  - [X] 자동차 이름이 유효한지 확인하는 기능 - Car.*isNameValid*
    - [X] 자동차 이름이 빈 문자열인지 확인하는 기능 - CarName.*isEmpty*
    - [X] 자동차 이름이 다섯 글자 이하인지 확인하는 기능 - CarName.*isUnder5Characters*
- [X] 시도할 회수를 입력받는 기능 - GameController.*receiveTryCount*
  - [X] 시도 횟수가 숫자인지 확인하는 기능 - TryCount.*isNumeric*
- [X] 매회차 게임 진행 기능 - GameController.*playGame*
  - [X] 자동차를 전진시키는 기능 - Car.*moveForward*
- [X] 각 자동차의 위치를 보여주는 기능 - GameController.*showCarPositions*
- [X] 우승자를 알아내서 출력하는 기능 - GameController.*showRaceWinners*

---

## 세부 사항

### *receiveRaceCarNames*
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 경주 할 자동차 이름(이름은 `쉼표(,)` 기준으로 구분)
```
pobi,woni,jun
```

### *receiveTryCount*
```
5
```

### *moveCarForward*
- 전진하는 조건은 `RandomNumber`가 4 이상일 경우이다.

### *generateRandomNumber*
- 0에서 9 사이에서 무작위 값을 구한다.
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- 사용 예시
```
Randoms.pickNumberInRange(0,9);
```

### *printRaceWinners*
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 `쉼표(,)`를 이용하여 구분한다.
- 단독 우승자 안내 문구
```
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```
최종 우승자 : pobi, jun
```

### *printCurrentRacingResult*
- 각 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```

---

## 실행 결과 예시

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