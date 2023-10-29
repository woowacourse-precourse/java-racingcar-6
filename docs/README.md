## 구현할 기능 목록 정리

### Domain
* RacingCar
  * 이름과 거리를 속성으로 가짐
  * 랜덤하게 거리를 1 증가시키는 go 메서드
* RacingGame
  * RacingCar 리스트를 속성으로 가짐
  * 게임을 한턴 진행시키는 progress 메서드
  * 게임 결과를 알려주는 result 메서드

### View
* InputView
  * racingCars : 차를 입력받는 인풋
  * gameTurn : 턴을 입력받는 인풋
* OutputView
  * gameProgress : 게임 진행 상황 출력
  * gameResult : 게임 결과 출력
  
### Main 함수
* 필요한 객체들 생성
* 게임 진행 및 결과 출력
----
### + 고민 거리
* 기존처럼 컨트롤러를 만들까 하다가 생각해보니 도메인으로 로직을 진행하는건
  Main 함수에서도 가능해서 Main에서 진행하는걸로 결정