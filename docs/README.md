# Racingcar

---

## —자동차 경주 Flow—

1. 자동차 이름 N개과 시도할 횟수를 입력받는다.
2. 한 자동차당 랜덤 넘버를 생성받아 4이상일 경우 한칸 전진시킨다.
3. 2의 과정을 시도할 횟수 만큼 반복한다.
4. 나아간 거리를 비교해 최종 우승자를 안내한다.

---

## 👉 입력

- 경주할 자동차 이름(이름은 쉼표로 구분)
- 시도할 횟수

---

## 👈 출력

- 각 차수별 실행 결과 ( ex) james : ----)
- 단독 우승자 안내 문구(최종 우승자 : 자동차 이름)
- 공동 우승자 안내 문구(최종 우승자 : 자동차 이름1, 자동차 이름2)

---

## ⚒️ 필요한 기능

- 자동차의 상태를 관리할 클래스 `Cars`
    - 필드변수 : 나아간 거리, 차 이름
    - 자동차가 한칸 전진하는 `goOneStep()`
    - 자동차 이름을 반환하는 `getName()`
    - 자동차가 나아간 거리를 반환하는 `askDistance()`
- 게임의 룰을 관리할 클래스 `GameModel`
    - 랜덤 숫자를 만들 `generateRandomNumber()`
    - 한칸 나아갈지 말지 결정할 `decideGoAndStop()`
    - 우승자를 결정할 `decideFinalWinner()`
    - 게임이 한 사이클(모든 자동차가 한칸 전진할지 말지 결정)을 돌릴 `tryOneCycle()`
- 잘못된 값을 검증할 클래스 `Validation`
    - 사용자의 이름 길이를 검증할 `ValidateLengthOfName()`
    - 사용자가 잘못된 값을 입력했는지 검증할 `isNotNumber()`
    - 잘못의 예)
        - 이름을 0자 미만, 6자 이상 입력했는지?
        - 시도할 횟수에 숫자가 아닌 값이 들어갔는지?
        - 이름 마지막이 comma 로 끝났는지?
        - 비어있는 입력을 했는지?
- 입력 담당 클래스 InputView
    - 자동차 이름을 입력받는 `getCarsName()`
    - 시도할 횟수를 입력받는 `getTryNumber()`
    - String을 콤마를 기준으로 Arraylist로 바꿔줄 `splitCarName()`
- 출력 담당 클래스 `OutputView`
    - 필드 : `DASH` 상수 “-”
    - 시작 메시지 출력할 `printStartMessage()`
    - 시도 횟수 출력할  `printAskTryNumber()`
    - “실행결과”를 출력할 `printResultMessage()`
    - 최종 우승자를 출력할 `printFinalWinner()`
    - 한 사이클의 게임을 출력할 `printSingleGame()`
- 자동차 경주 클래스 `RacingGame`
    - 필드 : `gameModel`, `inputView`, `outputView` 객체
    - 게임을 초기화할 `initializeGame()`
    - 사용자가 입력한 플레이어를 `Cars` 객체에 할당시켜주는 `insertPlayer()`
    - 실제 레이싱 경기를 담당할 `runRacing()`
    - 전체 레이싱 경기(시작메시지 출력 ~ 우승자 출력)을 담당할 `racingGame()`
- 유틸리티 클래스 `Utils`
    - String을 콤마를 기준으로 Arraylist로 바꿔줄 `splitCarName()`