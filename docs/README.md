# 미션 - 자동차 경주

## 기능 목록

### Input

#### Set the Entry List
- [x] n대의 자동차 이름을 입력받는다. - reception.receptionDesk.registering()
  - [x] 각각의 자동차 이름은 쉼표(,)를 통해 구분한다. - `.spiit(",")`
  - [x] 자동차 이름이 5자 이상이면 `IllegalArgumentException` - exception.Checker.lenCheck()

#### Laps
- [x] n대의 자동차가 몇 번의 이동을 할 것인지 입력받는다. - regulation.Regulation.setLaps()
  - [x] 숫자가 아니면 `IllegalArgumentException` - exception.Checker.typeCheck()


### Output

#### Racing Start
- [x] 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진한다. - regulation.Regulation.goStop()
- [x] 경기 현황을 자동차 이름을 같이 출력한다. - broadcast.Broadcast.broadcasting()

#### Winner Prize
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. - broadcast.Broadcast.prizeCeremony()
  - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
