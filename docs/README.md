# 기능목록

## Model
- [x] 자동차의 위치를 저장하고 비교한다 - CarPosition
- [x] 자동차의 위치를 1 증가시킨 객체를 반환한다 - CarPosition
- [x] 자동차의 위치 비교 결과를 표현한 Enum - CarPositionCompareResult
- [x] 자동차의 이동 횟수를 저장한다 - CarMoveCount
- [x] 이동 여부에 따라 moveCount 를 증가한 객체를 반환한다 - CarMoveCount
- [x] 시도할 횟수, CarMoveCount 해를 저장하고 CarMoveCount 와 비교한다 - TotalNumberToMove
- [ ] CarPosition 을 저장하고 비교한다 - Car
- [ ] 자동차의 이름을 저장하고 이동 결과를 출력한다 - Car
- [ ] 자동차를 전진한다 - Car, CarPosition, CarMoveCount
- [ ] TotalNumberToMove 를 저장하고 업데이트한다 - Cars
- [ ] 자동차들을 저장한다 - Cars
- [ ] 자동차에 전진을 명령한다 - Cars
- [ ] 자동차 전진 여부를 확인한다 - Cars, Car, CarMoveCount
- [ ] 우승자를 선별한다 - Cars
- [ ] Car 를 생성한다 - Generator
- [ ] TotalNumberToMove 를 생성한다 - Generator
- [ ] Cars 를 생성한다 - Generator
- [ ] 이름을 쉼표 기준으로 자른다 - Util
## View
- [ ] 자동차 이름을 입력받는다 - InputView
- [ ] 시도할 회수를 입력받는다 - InputView
- [ ] 실행 결과를 출력한다 - OutputView
- [ ] 최종 우승자를 출력한다 - OutputView
## Controller
- [ ] Generator 를 통해 Car, TotalNumberToMove, Cars 를 생성한다 - GameController
- [ ] 자동차 전진여부 파악 후 전진을 명령한다
- [ ] 전진할 때 마다 실행 결과를 출력한다
- [ ] 최종 우승자를 출력한다