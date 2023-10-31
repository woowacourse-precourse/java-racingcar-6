## 프로젝트 구조 설계

### Domain

- [ ] Car - 자동차 객체
- [ ] RandomNumberGenerator - 무작위 값을 생성하는 클래스
### Service
- [ ] GameService - 게임관련 로직을 처리하는 클래스
  - [ ] moveCars() - 자동차 이동을 처리
  - [ ] isRoundWinner() - 라운드 승자 판별


### Controller
- [ ] GameController - 게임의 흐름을 제어하는 클래스
  - [ ] startGame() - 게임 시작
  - [ ] playRound() - 한 라운드를 진행
  - [ ] determineWinners() - 승자 결정
- [ ] Validator - 입력 값의 유효성을 검사하는 클래스 
  - [ ] validateCarNames() - 자동차 이름의 유효성 검사
  - [ ] validateRoundCount() - 라운드 횟수의 유효성 겁사

### View
- [ ] InputView - 사용자 입력을 처리하는 클래스
- [ ] OutputView - 결과 출력을 담당하는 클래스



- 입력값이 잘못됐을 경우 `IllegalArgumentException` 발생시킴