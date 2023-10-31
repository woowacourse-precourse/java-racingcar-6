# 🚗 자동차 경주

## MVC 기반 기능 구현

### model
1. RaceGame
	- inputcarName : 입력한 자동차 이름 저장 (String)
		- [O] 공백 제거 후 저장하기
    - carNames : 전체 자동차 이름 입력 데이터 저장
	- raceNumber : 경주 시도 횟수 입력 데이터 저장
	- randomNumber : 전진/멈춤 난수 데이터 저장
	- carMoveCounts : 각 차수별 전진 횟수 저장
	- winnerCarNames : 우승 차 이름 저장 

### view
1. InputView
	- enterCarName()
		- [O] 경주 할 자동차 이름 입력
	- enterRaceNumber()
		- [O] 경주 시도 횟수 입력

2. OutputView
	- printRaceResult()
		- [O] 각 차수별 실행 결과 출력
	- printRaceWiner()
		- [O] 경주 우승자 안내 문구 및 우승자 출력

### controller
1. GameController
	- 자동차 경주 게임 시작
	- startGame()
		- [O] 입력한 자동차 이름 모델(inputCarName)에 저장
		- saveCarNames()
		    - [O] 입력한 자동차 이름을 List형으로 변환하는 함수 호출
			- [O] 데이터 유효성 검사 호출
			- [O] 전체 입력한 자동차 이름 모델(CarNames)에 저장
		    - [O] 경주 시도 횟수 모델(raceNumber)에 저장
			- [O] 경주 게임 시작 호출
			- [O] 우승자 차 이름 String으로 변환하는 함수 호출
			- [O] 경주 모두 완료 시 우승자 메시지 출력 호출
		- [O] 게임 종료

2. CarRacingController
    - 게임 시작
	- playGame()
		- saveResetCarMoveCounts()
			- [O] 각 차수 별 전진 횟수 초기화
		- [O] 각 차수 별 전진 횟수 모델(carMoveCounts)에 저장
		- [O] 경주 시도 횟수 만큼 게임 진행
		- repeatCarRace()
			- [O] 각 차수 별 난수 생성 함수 호출
			- checkAdvenceAndStop() 
			    - [O] 전진/멈춤인지 확인
			- increaseAdvenceCount()
				- [O] 전진이면 해당 차의 전진 횟수 증가
			- [O] 각 차수별 실행 결과 출력 함수 호출
		- decideWiner()
			- 경주 우승자 결정
			- getWinnerMoveCount()
				- [O] 우승자 전진 횟수 구하기
			- getWinnerCarNames()
				- [O] 우승자 전진 횟수와 동일한 전진 횟수를 가진 차 이름 구하기
				- [O] 모델(winnerCarNames)에 저장

3. CarNameValidator
	- toValidateCarName()
		- 각 경우에 따라 데이터 유효성 검사 수행 및 예외처리
		- isBigRaceCarLength()
			- [O] 경주할 자동차가 2대 이상인지 확인
		- isNullCarName()
			- isCheckNull()
				- [O] 입력한 차 이름이 공백인지 확인
		- isSmallCarNameLength()
			- isCheckRange()
				- [O] 5자 이하 이름인지 확인
		- isDiffCarName()
		        - [O] 서로 다른 이름인지 확인

4. RandomUtility
	- generateRandomNumber()
		- [O] 0부터 9사이의 한 가지 난수 생성