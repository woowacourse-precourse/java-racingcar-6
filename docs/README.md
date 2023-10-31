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
  * gameTurn : 턴을 입력받는 인풋거
* OutputView
  * inputCars : 차 이름을 입력하게 하는 안내 출력
  * inputTurn : 게임 턴수를 입력하게 하는 안내 출력
  * progressGameIntro : 실행 결과 텍스트 출력
  * gameProgress : 게임 진행 상황 출력
  * gameResult : 게임 결과 출력

### Dto
* RacingCarDto : 레이싱 카의 상태를 전달하기 위한 dto
  
### Main 함수
* 필요한 객체들 생성
* 게임 진행 및 결과 출력
----
### + 고민 거리
* 기존처럼 컨트롤러를 만들까 하다가 생각해보니 도메인으로 로직을 진행하는건
  Main 함수에서도 가능해서 Main에서 진행하는걸로 결정
* 실행 과정 출력을 위해서 원래는 RacingCar를 직접 노출할까 하다가 외부에 
  도메인을 그대로 노출하는게 안좋은 것 같아 속성만 전달하는 Dto를 따로 만듬.