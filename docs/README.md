# **프로그램 흐름**

게임시작 → 자동차 명 입력 → 자동차 이름이 조건에 맞는지 예외처리 → 시도할 회수 입력 → 숫자가 잘 들어왔는지 예외처리 → 입력 받은만큼 각자 랜덤 수 뽑기 → 뽑을 때마다 4보다큰지 확인 후 점수추가 → 최종점수 확인 후 우승자 출력

# **기능 명세서**

## **도메인 (Domain)**

- [x]  레이싱 선수 모델 (**`RacingPlayer`**)

## **예외 처리 클래스 (Exception)**

- [x]  잘못된 이름 예외 (**`InvalidNameException`**)
- [x]  잘못된 횟수 예외 (**`InvalidCountException`**)

## **유틸리티 (Util)**

**NumberPicker**

- [x]  자동차 숫자 뽑기 함수 (**`pickRandomNumber`**)

## **서비스 (Service)**

### RacingService

- [x]  이름 예외처리 함수 (**`validateNames`**)
    - ,,혹은 ,  ,등 공백을 입력했을 경우
    - 5자가 초과될 경우
    - 이름이 중복일 경우
    - 레이서가 한명일 경우
- [x]  입력 수 예외처리 함수 (**`validateCount`**)
    - 숫자가 아닐 경우
    - 정수가 아닐 경우
    - 0보다 작거나 같을 경우
- [x]  자동차 이름 저장 함수 (**`storeCarNames`**)
- [x]  점수 증가 확인 함수(**`updateScoreIfNecessary`**)
- [x]  최종 점수 확인 함수 (**`checkFinalScores`**)
- [x]  레이서이름을 String에서 List로 변환하는 함수(**`racerNameStringToList`**)
- [x]  입력받은 숫자를 String에서 int로 변환하는 함수(**`countStringToInt`**)

## **뷰 (View)**

### InputView

- [x]  자동차 이름 입력 함수 (**`inputCarNames`**)
- [x]  시도할 횟수 입력 함수 (**`inputAttemptCount`**)

### OutputView

- [x]  경주 진행 상황 출력 함수 (**`outputRaceProgress`**)
- [x]  우승자 출력 함수 (**`outputWinners`**)

## **컨트롤러 (Controller)**

### GameController

- [x]  게임 실행 함수 (**`runGame`**)
- [x]  경주 진행 함수 (**`conductRace`**)