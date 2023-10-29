## 기능 구현 목록

- [x] 자동차는 전진할 수 있다. -Car# moveForward();
- [ ] 전진을 결정할 수 있어야 한다 -Referee# whetherMoveForward();
  - [x] 무작위 숫자 0 ~ 9를 생성한다 -Number# generateRandomNumbers();
  - [x] 숫자가 4이상인지 판단한다 - Number# isEqualOrGreaterThanFour();
- [ ] 사용자는 자동차의 갯수와 이름을 입력한다 - InputView# askCarCountsAndNames();
- [x] 사용자는 몇 라운드를 실행할지 입력한다 - InputView# askHowManyRounds();
  - [ ] 입력된 숫자를 검증후 Number로 생성 - Number# Number(String userInput);
- [ ] 입력된 이름으로 자동차를 생성한다 - Car# constructor();
- [ ] 각 라운드의 전진 결과를 출력한다- OutputView# printRoundResult();
- [ ] 최종 승자를 결정한다 - Referee# determineWinner();
- [ ] 사용자 입력 값 예외 처리 - Validator#

## 예외 상황 목록
-[ ] 자동차 이름 입력
  -[ ] 비어 있는 입력   
  -[ ] 6자 이상의 이름  
  -[ ] 중복 되는 이름   
-[ ] 실행 라운드 입력
  -[ ] 비어 있는 입력 
  -[ ] 0이하의 수
  -[ ] 정수가 아닌 수

## 테스트 코드 목록
-[ ] 숫자에 따라 전진 결정 확인
-[ ] 사용자가 입력한 이름으로 자동차 생성
-[ ] 실행 라운드 횟수 입력 예외 처리
-[ ] 입력된 회수에 맞게 진행되는지 확인
-[ ] 공동우승 확인