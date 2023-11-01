# 구현 목록 Todos
- [x] Car 클래스 구현
  - Car 클래스 생성  
    Car class private 멤버 변수 선언 (자동차 이름, 현재 위치)  
    생성자 정의  
    이동 조건에 따라 move 메서드 구현  
    getPosition 메서드 구현  
    getName 메서드 구현   
  - feat(Car): Implement Car class  
- [x] Race 클래스 구현
  - Race 클래스 생성  
    생성자 정의  
    각 차량에 대한 이동 시도를 run 메서드로 구현   
  - feat(Race): Implement Race class
- [x] ValidationUtil 클래스 구현
  -  사용자 입력값을 검증하는 메서드 구현 (이름의 길이, 시도 회수의 유효성 등)
  - feat(Utils): Add ValidationUtil for input validation
- [x] InputUtil 클래스 구현
  - 사용자로부터 자동차들의 이름을 입력받는 메서드 구현  
    사용자가 시도할 횟수를 입력받는 메서드 구현
  - feat(Utils): Add InputUtil for handling user input
- [x] Game 클래스 구현
  - Game 클래스 생성  
    Game class private 멤버 변수 선언 (자동차 리스트, 라운드 수 등)  
    생성자 정의  
    게임을 시작하는 start 메서드 구현
  - feat(Game): Implement Game class to run the car racing game
- [x] GameResult 클래스 구현
  - GameResult 클래스 생성  
    GameResult class private 멤버 변수 선언 (단계별 자동차 위치, 최종 우승자 등)  
    생성자 정의  
    우승자를 결정하는 decideWinner 메서드 구현  
    단계별 결과를 추가하는 addRoundResult 메서드 구현  
  - feat(Game): Add GameResult class to manage game results
- [x] Application 클래스 구현
  - 메인 메서드에서 게임 시작을 위한 코드 작성
  - feat(Application): Implement the application's main execution flow
- ####   각 테스트별
  - 테스트 코드 작성
  - 테스트 코드 실행
  - 테스트 코드 리팩토링
  - test($class): Add unit tests for $class class 
