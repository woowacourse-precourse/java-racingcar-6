# 초간단 자동차 경주 게임

## 기능 목록

### 자동차 생성, 이름 부여
- [v] 사용자 입력에 따라 `N` 대의 자동차가 주어진다. - Application#askCarName()
  - [v] 각 자동차는 이름이 부여된다.
  - [v] 자동차는 이름을 기준으로 쉼표(,)로 구분한다.
  - [v] 자동차 이름은 최대 5자까지 제한된다. - Car#nameLengthCheck()

### 이동 횟수 입력 
- [v] 사용자가 이동 횟수를 입력할 수 있게 안내한다. - Application#askPlayTurn()
  - [v] 사용자는 몇 번의 이동을 할 것인지 입력할 수 있다.

### 자동차 이동
- [ ] 0에서 9 사이의 난수 값을 생성하고, 각 자동차는 이에 맞춰 이동한다. - NumberGenerator#createRandomNumber()
- [ ] 값이 4 이상일 경우에만 자동차는 한 칸 전진한다. - Judgment#isMoreThanFour()
  - [ ] 값이 4 이상일 경우 `-`를 추가한다. - Car#Forward()
- [ ] 이동 횟수를 소진할 때마다 자동차 이름과 전진 횟수(`-`) 출력한다. Car#currentLocation()

### 우승자 결정
- [ ] 게임이 완료되면 각 자동차의 진행 상황을 추적하고, 우승자를 결정한다. - Referee#SelectionWinners()
  - [ ] 전진 거리가 가장 긴 자동차를 우승자로 식별한다.

### 우승자 발표
- [ ] 우승자 자동차 이름을 출력한다. - Application#announcementWinners()
- [ ] 우승자가 여러 명이라면 이름을 쉼표로 구분한다.

### 입력 유효성 검사
- [v] 사용자가 입력한 자동차의 이름이 유효한지 검사한다. (5자 이하)
- [v] 사용자가 입력한 움직임 횟수가 유효한지 검사한다.
- [v] 입력이 유효하지 않을 경우 `IllegalArgumentException`이 발생하고 게임이 종료된다.
