# 구현할 기능 목록

### 1. 자동차 도메인 (Car)

- [X] 속성 : position, name
- [X] 자동차 이름 설정 (setName) -> 생성자 이용
- [X] 자동차 이름 조회 (getName)
- [X] 자동차 위치 조회 (getPosition)
- [X] 전진 시도 (attemptGo)
- [X] 현재 위치 출력 (printPosition)

### 2. 게임 도메인 (Game)

- [X] 속성 : cars, winners, totalTrialCount, curTrialCount
- [X] 자동차 이름 입력 (inputCarNames)
- [X] 경주할 자동차 생성 (generateCarsByCarNames)
- [X] 시도 횟수 입력 (inputTrialCount)
- [X] 게임 진행 (playGame)
- [X] 각 차수 실행 (attemptTrial)
- [X] 실행 결과 출력 (printTrialResult) -> Car.printPosition 이용
- [X] 우승자 판단 (judgeWinners)
- [X] 우승자 출력 (printWinners)

### 3. 게임에 필요한 도구 (GameUtil)

- [X] 자동차 이름을 쉼표로 구분 (splitNamesByComma)
- [X] 우승자 여러 명인 경우, 출력 포맷팅 (formatWinners) → Game.printWinners에서 진행

### 4. 자동차 메소드에 필요한 도구 (CarUtil)

- [X] 0에서 9 사이에서 무작위 값을 구하기 (generateRandomNumber)
- [X] 값이 4 이상인지(전진인지) 판단 (judgeGo)

### 5. 입력값을 판단하는 도구 (ValidationUtil)

- [X] 이름 5자 이하인지 확인 (validateCarName)
- [X] 숫자 입력인지 확인 (validateIsNumber)

<br>

# 기능 요구 사항

- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - [X] 시도할 횟수 입력
- [X] 각 자동차에 이름을 부여할 수 있다.
    - [X] 자동차 이름 입력
    - [X] 자동차에 이름 붙이기
- [X] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    - [X] 자동차 이름 출력
- [X] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - [X] 자동차 이름 쉼표(,) 기준으로 구분
    - [X] 이름 5자 이하인지 확인
- [X] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    - [X] 0 ~ 9 무작위 값 선택
    - [X] 값이 4 이상인지 판단
- [X] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - [X] 우승자 판단
    - [X] 우승자 출력
- [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    - [X] 우승자 출력 포맷팅
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - [X] 사용자가 입력한 값 판단