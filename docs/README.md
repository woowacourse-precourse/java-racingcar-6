# 기능 구현 목록

## racingcar Package

### Application
    프로그램의 Entry Class다.
- [ ] RacingGamePlayer 객체를 초기화하고 실행한다.

### RacingGamePlayer
    게임의 진행을 관리하는 클래스다.
- [ ] RacingGame, RacingGameBridge 객체를 멤버로 갖는다.
- [ ] RacingGame 객체를 초기화하고 실행한다.
- [ ] RacingGame의 상태를 기반으로 RacingGameBridge에 메소드를 호출하여 유저 입출력을 처리한다.

## racingcar.game Package

### RacingGame
    게임의 룰(business logic)을 구현하는 클래스
- [ ] List<Car> cars 멤버를 갖는다.
- [ ] 게임 횟수를 멤버로 갖는다.
- [ ] RacingGameBridge를 통해 입출력을 처리한다.
  - [ ] RacingGameBridge의 입력은 검증하지 않는다.
- [ ] 0~9 사이의 정수를 랜덤하게 생성하여 진행 여부를 결정하고, cars의 상태를 수정한다.
- [ ] RacingGameBridge와 연동하는 Enum class를 갖는다.
  - [ ] READY_TO_START
  - [ ] RUNNING
  - [ ] RESULT_READY

## racingcar.game.io package

### RacingGameBridge
    입력을 Game 클래스에 전달하기 위해 사용하는 클래스
- [ ] RacingGamePrompter, RacingGameResponder 기능을 래핑하는 메소드를 제공한다.
    - [ ] 이 메소드는 RacingGame에서 정의하는 RacingGameState를 인자로 받으며, 그에 맞게 처리한다.

### RacingGamePrompter
    유저에게 입력 받는 클래스
- [ ] ','로 구분된 자동차 이름 목록을 받기
    - [ ] 반환 타입은 List<Integer>
- [ ] 시도 횟수 입력 받기
    - [ ] 반환 타입은 int

### RacingGameResponder
    결과를 유저에게 전달(stdout)하는 클래스
- [ ] 실행 결과 출력
    - [ ] 입력 타입은 RacingGame 결과다.
- [ ] 최종 우승자 출력
    - [ ] 입력 타입은 RacingGame 결과다.

## racingcar.entity Package

### Car
    하나의 자동차를 구현하는 클래스
- [x] String name
- [x] int position
- [x] 포지션에 대한 변경 메소드 proceedSingleUnit()를 제공한다.