# 자동차 경주

## 기능 목록
- [ ] 자동차 이름 입력 메세지 출력 - printCarNameInputMessage()
- [ ] 자동차 이름 입력 - carNameInput()
	- [ ] 유효성 검사
- [ ] 자동차 이름 저장 - saveCars(carNameInput()) - Cars, Car

- [ ] 시도할 횟수 입력 메세지 출력 - printCarNameInputMessage()
- [ ] 시도할 횟수 입력 - carNameInput()
	- [ ] 유효성 검사
- [ ] 시도한 횟수 저장 - saveCount(carNameInput()) - Counter

- [ ] 시도할 횟수 만큼 loop
	- [ ] 자동차의 수만큼 loop
		- [ ] 각 자동차는 0~9 랜덤 숫자 생성 - generateRandomNumber() - Randoms 사용 - 아마도 CAR에서 생성
		- [ ] 생성한 수가 4 이상 이라면 현재 상황에 '-' 추가 - boolean overStandard(generateRandomNumber()) - STANDARD_NUMBER = 4
			- [ ] 현재 상황에 '-' 추가 - forward() 
				- [ ] 저장 car.setCurrent(car.getCurrent() + "-");
	- [ ] 각 자동차의 이름 및 현재 상황 출력 - car.getName() + : + car.getCurrent()

- [ ] 최종 우승자 결과 계산
	- [ ] 자동차의 수만큼 loop
		- [ ] 현재 상황이 시도할 횟수와 같다면
			- 우승자 목록에 추가 - WinnerList
			- addWinner(winner); 
			- List<String> winnerList
- [ ] 최종 우승자 결과 출력 printWinners(List<String> winners) - join 함수 사용해보기

### 상수로 지정할 만한 것들
STANDARD_NUMBER = 4
MIN_NUMBER = 0
MAX_NUMBER = 9

---

## 🚀 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.