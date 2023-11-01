## 자동차 경주 게임 - 구현 기능 목록

### ✔ Car 클래스
- 책임: 자동차를 생성하고 관리
- 역할: 경주에 참여하는 자동차와 자동차 생성하고 자동차의 정보를 관리하는 역할
- 속성: String name, int position
- 기능: <br>
  - public void move(int number): 자동차의 움직임을 파악하고 위치정보를 업데이트하는 기능

### ✔ RacingGame 클래스
- 책임: 자동차 경주 게임 운영
- 역할: 경주에 참하는 자동차 정보를 바탕으로 경주 게임을 운영하는 역할
- 속성: ArrayList<Car> cars, int numberOfRepetition
- 기능: <br>
  - public void startRace(): 자동차 경주를 시작하는 기능 <br>
  - private void moveOrStop(): 경주에 참가한 자동차의 상태(전진/멈춤)를 부여하는 기능 <br>
  - private void printCurrentPositions(): 자동차들의 현재 위치를 출력해주는 기능 <br>
  - private void findWinners(): 자동차 경주 게임의 결과 판정을 RacingGameWinner 클래스에서 받아 출력해주는 기능

### ✔ RacingGameWinner 클래스
- 책임: 자동차 경주 게임 우승자 판정
- 역할: 경주 게임의 우승자를 판정하는 역할
- 속성: private ArrayList<Car> cars
- 기능: <br>
  - private List<String> findWinners(List<Car> cars): 경주 게임 결과를 받아 우승자를 판별하는 기능(단, 우승자는 여러 명일 수 있음) 
  - public void printWinners(): 자동차 경주 게임 우승자를 출력하는 기능

### ✔ GameInterface 클래스
- 책임: 자동차 경주 게임 주최
- 역할: 게임에 참가하는 자동차를 모집(입력) 및 검증과 게임 개최하고 결과를 출력하는 역할
- 기능: <br>
  - public void play(): 자동차 경주 게임을 시작하는 기능
  - private static String[] getCarNames(): 경주 게임에 참여할 차의 이름을 입력받는 기능
  - private static int getNumberOfRepetition(): 이동할 횟수를 입력 받는 기능
  - private static ArrayList<Car> initializeCars(): 본 경주에 참여하는 차들을 세팅하는 기능
  - private static void checkCarNames(String[] carNames): 참가하는 차의 이름을 검증하는 기능
  - private static void checkCarNameLength(String carName): 이름의 길이를 검증하는 기능
