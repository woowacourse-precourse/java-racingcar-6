# 자동차 경주
## 개요:
- 사용자가 원하는만큼 **경주차량의 이름**을 입력한다.
- 사용자는 각 차량이 **얼마나 이동할 지**를 결정한다.
- 차량의 전진 조건은 매번 무작위로 숫자를 뽑았을 때, **4 이상**.
- 매 시행마다 결과를 출력하고, 우승자를 가린다. 공동 우승자가 나올 경우도 존재한다.

## 유의사항
- 잘못된 입력에 대해 `IllegalArgumentException`를 출력하고 그 자리에서 프로그램은 종료한다.
  - 이름을 입력할 때, 아무것도 입력하지 않을 경우
  - 이름을 입력할 때, 숫자를 입력하는 경우
  - 이름이 하나만 입력하는 경우 (경주의 의미가 퇴색되 버리기 때문에)
  - 입력된 이름이 5자를 넘어가는 경우
  - 시도횟수로 0을 입력하는 경우
  - 시도횟수로 음수를 입력하는 경우
- 입력할 때, 차량의 이름은 `,`로 구분한다.
- 공동 우승자가 나올 경우, 이 역시도 `,`로 구분한다.

## 기능설명

### `controller` 패키지
- `RacingGame` 클래스
  - `start`: 경주 시작
  - `gameReady`: 경주 준비
  - `exception`: 예외 처리

### `domain` 패키지
- `Car` 클래스 : `name`(경주차량이름), `forwardCount`(전진횟수) 
  - `Car(String name)`: 생성자 
  - `getName`: 해당 차량의 이름을 불러옴
  - `getForwardCount`: 해당 차량의 전진횟수를 불러옴
  - `move`: 랜덤으로 숫자를 뽑고 그 결과에 따라 전진
  - `currentLocation`: 현재 위치를 출력
- `Game` 클래스 : `cars`(Car의 리스트), `attemptCount`(시행횟수) 
  - `Game(String carNames, int numberOfAttempts)`: 생성자
  - `initializeCars`: 입력된 이름들을 저장
  - `setGame`: 게임의 진행상황을 가져옴
    - `currentCondition`: 매 시행마다 경주상황을 보여줌 
    - `isWinners`: 우승자들의 이름을 출력
- `ErrorMessage` 클래스 : 에러 메세지들이 저장
- `Validator` 클래스
  - `checkCarNames`: `carNames`를 검증
  - `checkNameRestriction`: 이름 제한 검증
  - `checkAttemptCount`: `attemptCount`를 검증

### `view` 패키지
- `Input` 클래스
  - `carNamesInput`: `carNames` 입력
  - `attemptCountInput`: `attemptCount` 입력
- `Output` 클래스 : 게임 진행에 필요한 메세지를 출력