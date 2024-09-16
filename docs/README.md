# 기능 목록
- [x] Game.process은 자동차 경주 게임을 실행시킨다.
- [x] Start는 attempts와 carList를 저장받는다.
  - [x] carList에서 자동차 이름이 6자리 이상이면 예외 처리한다.
  - [x] attempts에 integer로 변환할 수 없는 값이 들어오면 예외 처리한다.
- [x] CarMap은 carList를 LinkHashMap형태로 변경하여 저장한다.
  - [x] makeInitMap과 updateMap이 있다.
- [x] Play는 show를 통해 실행 결과를 attempts 만큼 반복 출력한다.
- [x] RandomValue는 랜덤값관련 class이다.
  - [x] forwardDecision메서드를 이용하여 전진 여부를 결정한다.
- [x] ExecutionResult는 map을 출력한다.
- [x] Referee는 최종 우승자를 가려낸다.
  - [x] find_maxKeys에 해당하는 members를 출력한다.

