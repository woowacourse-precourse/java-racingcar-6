일단 한번에 구현후에 진행

객체 Car
- 이름
  - 5자 이하만 가능 -> 글자수 6을 넘어가면 예외
  - 공백 안됨 -> isBlank면 예외
  - 문자만? 숫자만? 모르겠음

- 위치
  - 위치

라운드별 각 차가 위치를 갱신하는 과정 -> 각 라운드별, 각 차별이니까 이중 for문
- 랜덤으로 넘버를 생성
- 4이상인지 미만인지를 판별
  - 이상이면 한칸 더가고
  - 미만이면 그대로 스테이
- 이 결과를 출력


객체지향 설계는 협력에 참여하기 위해 어떤 객체가 어떤 책임을 수행해야 하고 
어떤 객체로부터 메시지를 수신할 것인지를 결정하는 것으로부터 시작된다.

사용자의 입력에 따라서 차가 위치를 움직여야 함. 이름에 따라 구분.
랜덤 넘버 생성 -> 판단 -> 결과 출력 -> 입력된 라운드만큼의 진행을 끝내면 그 중 winner 가르기




Control.class

- startGame()
- playGame()
- raceProcess()
- savingCarPositions()
- judgingWinner()
- printWinner() -> OutputView 클래스로 빼야함

position 변수 Car.class로 옮길 수 있도록 할 것

Car.class
- 차에 대한 변수 저장
- name
- position

CarService.class
- generateRandomNumber()
~~- isForwardorStop() : 전진인지 정지인지 감별하는 메서드~~


Validation.class
- 사용자의 입력에 대한 검증 메서드
- validateNameInput()
- validateNumber()
- 더 자세하고 정교하게 구현 필요

InputView.class
- car 이름 입력받는 메서드
- 몇 번 시도할 건지 rounds 입력받는 메서드

OutputView.class
- 해당 라운드의 해당 차량에 따라 racing 진행상황을 "-"을 통해 보여주는 메서드
- winner 보여주는 메서드

* 약어 사용하지 말 것!!
* 리팩터링 전에 구현이 먼저다!! 이것저것 찾아보기 전에 구현 먼저 완료할 것!