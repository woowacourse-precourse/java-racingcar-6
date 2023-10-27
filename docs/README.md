## 기능 구현 목록

- [ ] 자동차는 전진할 수 있다. -Car# moveForward();
- [ ] 전진을 결정할 수 있어야 한다 -Referee# whetherMoveForward();
  - [ ] 무작위 숫자 0 ~ 9를 생성한다 -Number# generateRandomNumbers();
  - [ ] 숫자가 4이상인지 판단한다 - Number# isEqualOrGreaterThanFour();
- [ ] 사용자는 자동차의 갯수와 이름을 입력한다 - InputView# askCarCountsAndNames();
- [ ] 사용자는 기능이 몇 번 반복될 지 입력한다 - InputView# askHowManyRounds();
- [ ] 입력된 이름으로 자동차를 생성한다 - Car# constructor();
- [ ] 각 라운드의 전진 결과를 출력한다- OutputView# printRoundResult();
- [ ] 최종 승자를 결정한다 - Referee# determineWinner();
- [ ] 사용자 입력 값 예외 처리 - Validator#