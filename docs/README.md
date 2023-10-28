## 2주차 미션 - 🚙 자동차 경주
### 🐣 구현 기능 목록
- [ ] 경주 할 자동차를 생성한다 (5글자 이하) -SetRace#createCar()
- [ ] 몇 번 이동할 것인지 입력한다 -SetRace#inputMovement()
  - [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. -Race#Movable()
  - [ ] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다. -Race
  - [ ] 우승자를 알려준다 -Race#RacingResult()