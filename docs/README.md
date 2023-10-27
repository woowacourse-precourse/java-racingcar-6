# 자동차 경주

## 2주차 목표
- 함수를 하나의 기능만 책임지도록 분리하기.
- 각 함수별로 테스트를 작성하는 것에 익숙해지는 것.

## 기능 목록
- [x] 자동차 이름 입력 메세지 출력 - printCarNameInputMessage()
- [x] 자동차 이름 입력 - carNameInput() - Car
	- [ ] 유효성 검사 - Validator
- [x] 자동차 이름 저장 - addCars(carNameInput()) - Cars

- [x] 시도할 횟수 입력 메세지 출력 - printNumberOfattempsInputMessage()
- [x] 시도할 횟수 입력 - numberOfattempsInput()
	- [ ] 유효성 검사
- [x] 시도한 횟수 저장 - saveCount(carNameInput()) - Attemps

- [x] 시도할 횟수가 될 때까지 loop
	- [x] 실행결과 : 자동차의 수만큼 loop
		- [x] 각 자동차는 0~9 랜덤 숫자 생성 - NumberGenerator#generateRandomNumber() - Randoms 사용
		- [x] 생성한 수가 4 이상 이라면 현재 상황에 '-' 추가 - boolean overStandard(generateRandomNumber()) - STANDARD_NUMBER = 4
			- [x] 현재 상황에 '-' 추가 - moveForward()
		- [x] 현재 자동차의 정보 담기
		- ~~[x] 각 자동차의 이름 및 현재 상황 출력 - car.getName() + : + car.getDistance()~~
		- [x] 결과 리스트에 현재 자동차의 정보 담기
	- [x] 결과 리스트 받아서 출력
	- [x] 골라인에 도착하였는가? : 자동차의 수만큼 loop
		- [x] 현재 자동차의 거리의 수가 시도할 회수와 같은게 있다면 멈춰

- [x] 최종 우승자 결과 계산
	- [x] 자동차의 수만큼 loop - 
		- [x] 현재 거리가 시도할 횟수와 같다면 우승자 목록에 추가
- ~~최종 우승자 결과 출력 printWinners(List<String> winners) - join 함수 사용해보기~~
- [x] 최종 우승자 출력하기 - stream을 이용하여 쉽게 ,로 구분된 값을 가져올 수 있었다.

### 만들 객체들
- [x] RacingGame (controller) - 출력과 입력 제어
- [x] RacingGameService (service) - DATA를 가져와서(?) 출력과 입력을 제어 및 검증
- [x] model
	- [x] Car - 자동차 - 이름, 진행상황, 전진하는 기능
	- [x] Cars - 자동차 목록 - 자동차 목록 저장 기능
	- [x] Winners - 우승자 목록 - 우승자들을 저장하는 기능
	- [x] Attemps - 시도할 횟수 저장 - 변수로 해도 될거 같긴한데 진짜 게임들을 생각해보면 나중에 게임 기록들을 남기니까 만들어 보기로 함
- view
	- [x] InputView 입력값 가져오기 담당
	- [x] OutputView 출력하기 담당


### 상수로 지정할 만한 것들
- STANDARD_NUMBER = 4
- MIN_NUMBER = 0
- MAX_NUMBER = 9

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