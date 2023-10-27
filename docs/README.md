# 기능목록

## Model
-  ### CarComponent - Car, Cars 객체를 이루는 구성 요소
- ##### carPosition
- [x] 자동차의 위치를 저장하고 비교한다 - CarPosition
- [x] 자동차의 위치를 1 증가시킨 객체를 반환한다 - CarPosition
- [x] 자동차의 위치 비교 결과를 표현한 Enum - CarPositionCompareResult
- ##### carMove
- [x] 자동차의 이동 횟수를 저장한다 - CarMoveCount
- [x] 이동 여부에 따라 moveCount 를 증가한 객체를 반환한다 - CarMoveCount
- [x] 총 움직일 수 있는 횟수를 저장하고, carMoveCount 와 비교하며 움직일 수 있는지 boolean 반환한다 - TotalMoveCount
- [x] TotalCountToMove, CarMoveCount 해를 저장하고 CarMoveCount 와 비교한다 - CarMoveReader
-  ### Car - CarComponent 를 활용해 실제 Car 객체를 전진시키고, 우승자를 찾는 로직 보유
- [x] CarPosition 을 가지고 비교한다 - Car
- [x] 자동차의 이름을 저장하고 이동 결과를 출력한다 - Car
- [x] 자동차를 전진한다 - Car
- [x] Car 를 가지고 전진을 명령한 후 결과를 String 으로 반환한다. - Cars
- [x] CarMoveReader 와 Cars 를 가지고 자동차의 이동 여부를 파악한다 - CarMovement
- [x] Cars 에 이동명령을 내리며 그 결과를 String 으로 반환한다 - CarMovement
- [x] 자동자의 위치를 비교하며 우승자를 판단하고 우승자 메시지를 만든다 - WinCars
- [x] WinCar 객체를 통해 자동차들 중 우승자를 선별한다 - Cars
- ### Util - 어플리케이션에 필요한 도메인 생성
- [x] Car 를 생성한다 - Generator
- [x] CarMoveReader 를 생성한다 - Generator
- [x] Randoms 를 통해 자동차의 전진 여부를 Supplier 함수로 반환한다 - Generator
## View
- [ ] 자동차 이름을 입력받는다 - InputView
- [ ] 시도할 회수를 입력받는다 - InputView
- [ ] 실행 결과를 출력한다 - OutputView
- [ ] 최종 우승자를 출력한다 - OutputView
## Controller
- [ ] Generator 를 통해 Car, CarMoveReader, Cars 를 생성한다 - GameController
- [ ] 자동차 전진여부 파악 후 전진을 명령한다
- [ ] 전진할 때 마다 실행 결과를 출력한다
- [ ] 최종 우승자를 출력한다