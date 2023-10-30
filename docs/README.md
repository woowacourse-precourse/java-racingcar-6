## 자동차 경주 기능 요구사항 정리
### 요구사항 분석
- 경주에 참여할 자동차의 이름을 입력받는다.
- 각 자동차의 정보는 쉼표로 구분한다.
- 자동차의 이름은 5자 이하만 가능하다.
- 게임 시도 횟수를 입력받는다.
- 각 횟수, 자동차마다 랜덤으로 값을 생성해야한다.
- 자동차가 전진하는 조건은 랜덤으로 생성한 값이 4 이상일 경우이다.
- 횟수가 모두 끝나면, 우승자를 표시한다.
- 우승자는 가장 멀리 간 사람이다.
- 우승자는 한 명 이상일수 있다.
- 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.

### 기능 요구사항 정리
#### 레이싱 게임(RacingGameController)
- [x] 자동차 목록 생성 - playGame()
  - [x] 자동차 생성
- [ ] 라운드 진행
  - [x] 라운드 입력 - playGame()
  - [x] 실행 결과 메시지 출력 - playGame()
  - [x] 자동차 전진 함수 호출 - runRound()
  - [ ] 라운드 결과 함수 호출
- [ ] 우승자 발표
  - [ ] 우승자 목록 출력
#### 자동차(Car)
- [x] 자동차 이름 생성
- [x] 자동차 이동거리 생성
- [x] 자동차 전진 함수 - moveForward()
  - [x] 0 ~ 9 사이의 수를 랜덤으로 생성하기
  - [x] 생성한 숫자가 4 이상이면 이동거리 1 증가시키기
#### 자동차 목록(Cars)
- [x] 자동차 목록 생성
- [x] 자동차 목록에 자동차 추가
- [x] 우승자 목록 알려주는 함수 - getWinners()
#### 입력(InputView)
- [x] 경주할 자동차 이름 입력 - inputNames()
- [x] 게임 횟수 입력 - inputRound()
#### 출력(OutputView)
- [x] 게임 시작 시, "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)" 출력 - printNameInputMessage()
- [x] 이름을 입력받은 후 "시도할 횟수는 몇회인가요?" 출력 - printRoundInputMessage()
- [x] 맨 첫 라운드 시작 시, "실행 결과" 출력 - printExecutionResultMessage()
- [x] 라운드마다 자동차의 이름과 이동거리 출력 - printCarNameAndPosition()
- [x] 라운드가 모두 끝나면 "최종 우승자" 문구 출력 후 최종 우승자 이름 출력 - printWinners()
  - [x] 우승자가 한명일 경우 이름만 출력
  - [x] 우승자가 여러명일 경우 이름 사이에 쉼표(,)와 공백 한칸으로 구분 후 출력
#### 예외처리
- 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
  - 자동차 이름 입력
    - [x] 이름이 공백일 경우 - Car의 validateInputNotEmpty()
    - [x] 이름이 5자 이상인 경우 - Car의 validateInputSize()
    - [x] 자동차가 1대인 경우 - InputView의 validateInputCount()
    - [x] 이름을 구분하는 기준이 쉼표가 아닌 경우 - InputView의 validateInputWithSeparator()
    - [x] 같은 이름이 있는 경우 - Cars의 validateDuplicateName()
    - [x] 아무것도 입력하지 않은 경우 - Cars의 getMaxPosition()
  - 시도 횟수 입력
    - [x] 아무것도 입력하지 않은 경우 - Round의 validateInputNotEmpty()
    - [x] 시도 횟수에 숫자가 아닌 다른 값이 들어오는 경우 Round의 validateInteger()
    - [x] 시도 횟수가 음수인 경우