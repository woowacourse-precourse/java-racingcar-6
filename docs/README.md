Control (메인 클래스)

- startGame()
- racingProcess()
- racingWinner()

Car.class
- 차에 대한 변수 저장
- name
- position

Position.class
- 차의 움직임, 전진하거나 멈추거나에 대한 클래스
- 차의 진행상황에 대한 저장을 진행하는 메서드

Round.class
- 몇 번 진행했는지에 대한 클래스
- 아마 round별 저장을 진행하는 메서드

CarService.class
- generateRandomNumber()
- isForwardorStop() : 전진인지 정지인지 감별하는 메서드

Converter
- toStringList() : String -> List<String> 으로 변환해주는 메서드

Validation.class
- 사용자의 입력에 대한 검증 메서드

InputView.class
- car이름들 입력받는 메서드
- 몇 번 시도할 건지 입력받는 메서드

OutputView.class
- 가장 어렵지 않을까..싶고
- 해당 라운드의 해당 차량에 따라 racing 진행상황을 "-"을 통해 보여주는 메서드

* 약어 사용하지 말 것!!
* 리팩터링 전에 구현이 먼저다!! 이것저것 찾아보기 전에 구현 먼저 완료할 것!