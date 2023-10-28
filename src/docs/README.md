# 미션 - 자동차 경주

## 📝 구현 기능 정리

### Model
1. Car
   - createCar() : 하나의 Car 객체를 생성하는 메서드
   - plusWinCount() : 하나의 라운드에서 우승시 count 업데이트 메서드

### View
1. InputView
    - inputRacingCar() : 자동차 경주에 참여할 차의 이름을 입력받는 메서드
    - inputTryCount() : 자동차 경주를 시도할 횟수를 입력받는 메서드 

2. OutPutView
   - appendRaceStatus() : 게임의 전체 진행 상태를 StringBuilder 저장하는 메서드
   - printRaceStatus() : 전체 진행 상태가 저장된 StringBuilder 출력하는 메서드
   - printVictoryPlayers() : 우승자를 출력하는 메서드

### Controller
1. RacingController
   - playRacing() : 시도 횟수 + service 연결 + StringBuilder
   - createCarList() : 경주자동차를 입력 + service 로직 연결
   - readVictoryPlayers() : 게임 최종 우승자 확인 및 View 출력
   
### Service
1. RacingService
   - playRacingCar() : 자동차 경주를 진행하는 메서드
   - createCarList() : 게임에 참여하는 Car의 List를 생성
   - findByVictoryPlayers() : 게임 최종 우승자를 찾는 메서드