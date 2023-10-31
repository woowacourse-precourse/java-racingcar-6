## ︎📝 구현할 기능 목록
### ⌨️ 입력 및 입력 값의 유효성 검사
* 컨트롤러 : 게임 참여자로부터 경주에 참여할 자동차 이름과 게임을 시도할 회수를 입력받는다.
* Validator : 게임 참여자로부터 입력받은 값들을 검증한다.
* 잘못된 값이 있을 경우, IllegalArgumentException을 발생시킨 후 애플리케이션은 종료시킨다. 
  * 게임 참여자로부터 입력받은 자동차 이름이 5자 이하인지 검사한다.  
    만약에 자동차 이름에 빈값이 입력되거나, 이름이 5자 초과이면 컨트롤러에게 메시지를 보낸다.
  * 게임 참여자로부터 입력받은 자동차 이름에 ','가 없다면 1대만 입력받은 것이므로, 컨트롤러에게 메시지를 보낸다.
  * 게임 참여자로부터 입력받은 자동차 이름에 중복된 이름이 존재하면 컨트롤러에게 메시지를 보낸다.
  * 게임 참여자로부터 시도할 회수를 입력받았을 때,  
    빈값이 입력되거나, 입력값이 0이거나, 숫자가 아니라면 컨트롤러에게 메시지를 보낸다.

### 🧮 RacingCar게임의 데이터 처리 및 저장
* 개별 자동차의 이름과 자동차가 전진할 횟수를 가진 RacingCar를 RacingCarRepository에 보관한다.
* RacingCar :
  * 각각의 개별 자동차 클래스
  * 개별 자동차의 이름과 자동차가 전진할 횟수를 가짐
  * Random 값(전진할 값) : camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 사용
  * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우에만 전진한다.
* RacingCarRepository :
  * RacingCar를 가진 일급객체

### 🖨 레이싱 게임 진행 및 출력
* 각각의 시도 횟수마다 레이싱 게임을 진행 한 뒤, RacingCarRepository가 가진 RacingCar들의 이름과 전진한 값을 OutputGameStateView에 출력
* RacingCarRepository가 가진 RacingCar들의 역순 정렬처리 멤버 함수 추가
* RacingCarRepository가 가진 RacingCar들의 최종 우승자 출력 멤버 함수 추가

## ☕️ 구현할 객체 종류
* GameController
* Validator
* RacingCar
* RacingCarRepository
* OutputGameStateView