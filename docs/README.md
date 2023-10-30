### ⚙️ 구현할 기능 목록

#### Application
- [x] 자동차 경주 게임 시작 - main()

#### Game
- [x] 문구 출력 - printMessage()
  - [x] 경주할 자동차 입력 요청하는 문구 출력
  - [x] 실행 결과 출력
  - [x] 우승자 출력
- [x] 자동차 이름 입력 받기 - setCarNames()
- [x] 시도할 횟수 입력 받기 - setTrialNumber()

#### NumberGenerator
- [x] 0에서 9 사이의 무작위 값 생성하기 - generate()

#### MovingRule
- [x] 무작위 값에 따라 전진/정지 판단 - isMovable()
  - [x] 무작위 값이 4 이상인 경우, 전진
  - [x] 무작위 값이 4 미만인 경우, 정지

#### GameManager
- [x] 자동차 이동 - moveCars()
- [x] 실행 결과 문구 생성 - makeResult()
- [x] 자동차 경주 게임 우승자 문구 생성 - makeWinnerResult()
  - [x] 우승자가 한 명 이상인 경우, 쉼표(,)를 이용하여 구분

#### Car
- [x] 자동차의 이름, 위치 저장 - name, location
- [x] 자동차 위치 이동 - move()
- [x] 자동차 이름 반환 - getName()
- [x] 자동차 위치 반환 - getLocation()

#### InputValidator
- [x] 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`
    - [x] 자동차 이름이 1자 미만, 5자 초과하는 경우 - validCarNameLength()
    - [x] 시도할 횟수 입력 받을 때, 숫자 외 다른 문자 입력한 경우 - validTrialNumber()
    - [x] 시도할 횟수 입력 받을 떄, 음수 입력한 경우 - validTrialNumber()