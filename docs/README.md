## 필요한 기능

### 객체
1. Car 
   - 자동차의 이름, 이동 횟수를 저장하는 객체


2. RacingGame
   - Game 인터페이스를 상속 받는 레이싱 게임 객체
   - startGame() 메서드로 게임 정보 input을 받고 초기화
   - playGame() 메서드로 게임을 진행
   - determineMove() 메서드로 전진 or 멈춤 파악
   - printResultOfRounds() 메서드로 게임의 라운드 당 결과 출력
   - printWinner() 메서드로 최종 우승자 출력

   
3. InputCarInfo
   - Racing Game에서 쓸 Car 정보 입력 받는 기능
   - 정보 입력이 vaild 한지 검증
   - valid 하다면, 이를 기반으로 Car 객체 생성 (개수 세기)


4. InputTryNumber
   - 게임 회수 입력 받는 기능
   - number 입력이 valid 한지 검증
   - valid 하다면 게임 계속 진행


5. Winner
   - MaxDistance를 계산하는 기능
   - MaxDistance를 기반으로 최종 Winner(s) 찾아서 return



### 인터페이스
1. Game: 게임 기본 기능이 들어가 있는 인터페이스
   - startGame, playGame 메서드