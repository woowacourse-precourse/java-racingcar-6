
## 기능 목록
- [x] n 대의 자동차(이름 쉼표(,)로 구분)를 입력 받는 기능 -> InputView#getCarNames()
- [x] 몇 번의 이동을 할 것인지 입력 받는 기능 -> InputView#getMoveCount()
- [x] 0~9 사이에서 무작위 값을 구하는 기능 -> RandomNumber#randomNumber()
- [x] 무작위 값 중 4 이상을 뽑은 자동차를 전진시키는 기능 -> RacingCarGameController#moveCarForward()
- [x] 우승자를 뽑는 기능(여러명이면 쉼표(,)로 구분) -> RacingCarGameController#findWinners()
- [x] 실행 결과를 출력하는 기능 
  -[x] 자동차 전진 결과를 출력하는 메서드 -> OutputView#printPositions()
  -[x] 최종 우승자를 출력하는 메서드 -> OutputView#printWinners()

## 예외 처리 기능
- [ ] 이름이 5자를 초과하면 예외 처리 후 종료
- [ ] 중복된 이름이 있을 경우 예외 처리 후 종료
- [ ] 시도할 횟수를 숫자가 아닌 것을 입력하였을 경우 예외 처리 후 종료
- [ ] 시도 횟수를 0 이하의 숫자를 입력하였을 경우 예외 처리 후 종료

## 객체 생성 목록

- Car 라는 객체를 생성
  - name 과 position 을 인스턴스 변수로 가짐
  - getName() : 자동차 이름을 반환하는 메서드
  - getPosition() : 자동차의 현재 위치를 반환하는 메서드
  - move() : 자동차의 position 은 한칸 전진하는 메서드
