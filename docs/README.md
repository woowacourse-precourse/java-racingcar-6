# 자동차 경주 게임 기능 요구 사항
## 자동차 (Car)
- [x] 자동차는 이름과 위치를 갖는다
- [x] 자동차는 4이상의 값이 무작위로 입력되면 움직인다.
- [x] 자동차는 4미만의 값이 무작위로 입력되면 멈춘다.
- [x] 자동차 객체가 같은지를 비교할 수 있다.(equals)
## 자동차 이름 (Name)
- [x] 이름 초기화 (생성자)
- [x] 이름 검증 (validName)
- [x] equals & hashcode 재정의
- [x] toString 재정의
## 자동차 위치 (Position)
- [x] 위치 0으로 초기화
- [x] 특정 위치로 초기화
- [x] 위치 증가 (move)
- [x] 매개변수로 받은 위치가 4보다 큰지 확인 (isMoreThanMaxNumber)
- [x] 매개변수로 받은 Position과 어떤 Position이 더 큰지 비교 (compareTo)
- [x] equals & hashcode 재정의 
- [x] toString 재정의
## 자동차 게임(RacingCarGame)
- [ ] 시도할 횟수 만큼 자동차를 전진시키는 게임을 진행한다.
- [ ] 0~9 사이의 값을 랜덤으로 생성한다.
- [ ] 4이상의 값이 생성되면 자동차를 전진시킨다.
- [ ] 자동차를 전진시킨 후 위치를 출력한다.
- [ ] 자동차를 전진시킨 후 우승자를 판단한다.
## 자동차 게임을 하고 있는 차를 관리하는 클래스 (Cars)
- [x] 자동차를 생성한다. (CarFactory.createCars)
- [x] 자동차를 경주를 1라운드 시작한다. (race)
- [x] 자동차를 랜덤한 숫자를 받아 움직인다(carMove)
## 사용자 출력 (OutputView)
- [ ] 자동차 이름 안내문을 출력한다
- [ ] 자동차 레이싱 시도 횟수 안내문을 출력한다
- [ ] 자동차 레이싱 결과를 출력한다.
## 사용자 입력 (InputView)
- [x] ,을 기준으로 구분한다. (divideByComma)
- [x] 라운드 매개변수로 받아 int 형으로 변환한다. (receiveTotalRound)
- [x] 자동차 이름을 입력받는다. (receiveCarNames)
