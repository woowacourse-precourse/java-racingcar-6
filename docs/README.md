# 미션 - 자동차 경주
## 클래스
- [x] RacingGame
  - 게임의 핵심 로직과 규칙을 가짐
  - 게임의 진행 상태, 참가자, 승자 등 게임에 관련된 주요 속성과 기능을 포함
- [x] Car
  - 이름과 현재 위치 상태를 저장
  - Car 인스턴스 생성
  - Car 오브젝트를 랜덤값을 기반으로 이동할지 결정
- [x] Referee
  - 우승자를 판별
- [x] InputHandler
  - 유저로 부터 입력값을 받음
  - 받은 입력값을 검증

## 기능 목록
- [x] 유저로 부터 검증된 이름을 입력 받는다. - InputHandler#getValidCarNamesFromUser()
  - [x] 유저로 부터 이름을 입력 받는다. - InputHandler#getUserInputForCarNames()
  - [x] 자동차 이름을 (,)을 기준으로 파싱한다. - InputHandler#splitByCommaAndTrim()
    - [x] 이름 좌우의 공백을 제거한다.
    - [x] 공백 입력값을 필터링한다.
  - [x] 중복된 이름을 리스트에서 제거한다. - InputHandler#removeDuplicate()
  - [x] 주어진 이름이 2개 이상인지 검증한다. - InputHandler#validateCarNames()
    - [x] 만약 검증에 실패하면 "경주를 위해 최소 2개 이상의 이름을 입력해야합니다." 에러메시지와 함께 `IllegalArgumentException`을 발생시킨다.
- [x] 검증된 이름으로 자동차 리스트를 생성한다 - Car#createCarsByNames()
  - [x] 각 자동차 이름을 검증한다. - Car#validateName()
    - [x] 만약 5자 이상이 "5자 이하의 이름만 입력해주세요." 에러메시지와 함께 `IllegalArgumentException`을 발생시킨다.
    - [x] 만약 1자 미만이면 "1자 이상의 이름만 입력해주세요." 에러메시지와 함께 `IllegalArgumentException`을 발생시킨다.
    - [x] 만약 null이면 "null은 이름이 될 수 없습니다." 에러메시지와 함께 `IllegalArgumentException`을 발생시킨다.
- [x] 유저로 부터 검증된 경주할 횟수를 입력받는다. - InputHandler#getValidAttemptsFromUser()
  - [x] 유저로 부터 경주 횟수를 입력받는다. - InputHandler#getUserInputForAttempts()
  - [x] 경주 횟수가 정수인지 검증한다. - InputHandler#validateInteger();
    - [x] 만약 검증에 실패하면 "정수를 입력해주세요." 에러메시지와 함께 `IllegalArgumentException`을 발생시킨다.
  - [x] 경주 횟수가 양의 정수인지 검증한다. - InputHandler#ValidatePositiveNumber()
    - [x] 만약 검증에 실패하면 "양의 정수를 입력해야합니다." 에러메시지와 함께 `IllegalArgumentException`을 발생시킨다.
- [x] 주어진 회수만큼 경주를 실행한다. - RacingGame#runRacingAndPrintResults()
  - [x] 1회 경기 진행한다. - RacingGame#getOneRoundResult()
    - [x] 자동차를 전진시키거나 멈춘다 - Car#moveForwardOrStop()
      - [x] 각 자동차마다 0에서 9사이에서 무작위 값을 구한다.
      - [x] 4 이상인 자동차를 전진시킨다.
  - [x] 결과를 출력한다.
- [x] 경주 우승자를 결정한다. - Referee#getWinners()
  - [x] 최대 이동거리 값을 찾는다. - Referee#getMaxMileage()
- [x] 결과를 출력한다. - RacingGame#printWinners()

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.