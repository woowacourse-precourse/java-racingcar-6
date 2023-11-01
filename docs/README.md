## 필요한 기능

### 객체
1. Car 
   - 자동차의 이름, 이동 횟수를 저장하는 객체
2. RacingGame
   - Game 인터페이스를 상속 받는 레이싱 게임 객체
   - 
3. InputCarInfo
   - Racing Game에서 쓸 Car 정보 입력 받는 객체
   - 정보 입력이 vaild 한지 검증
   - valid 하다면, 이를 기반으로 Car 객체 생성 (개수 세기)


### 인터페이스
1. Game: 게임 기본 기능이 들어가 있는 인터페이스
   - startGame, playGame 메서드