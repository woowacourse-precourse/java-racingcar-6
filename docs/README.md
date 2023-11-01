🚀domain
#Car
- [] Car 차 생성자 
- [] move 4 이상의 랜덤 숫자가 나오면 차 한 칸 이동
- [] getName 차 이름 return
- [] getPosition 차 위치 return
- [] getPositionString 차 위치를 '-'를 통해 표시

🚀service
#RacingGame
- [] play 차 이름과, 시도 횟수를 입력 받아 게임을 시작
- [] createCars 스트링 타입의 차 리스트를 Car 타입의 List로 변환
- [] moveCars 4 이상의 랜덤 숫자가 나오면 차를 한 칸 이동
- [] printCurrentStatus 라운드 마다의 차의 위치를 표시
- [] getWinners 우승자(들)을 return
- [] GetCarNames 차 이름을 입력 받음, 예외 발생 시 종료
- [] GetTrialRounds 시도 횟수를 입력 받음, 예외 발생 시 종료

#Validator
- [] isValidCar 모든 조건을 만족하면 유효한 차임을 나타내는 true return
- [] isValidNameLength 차 이름 6글자 이상인 경우 예외 처리
- [] hasNotContainSpace 차 이름에 널 값이 있거나 space 있는 경우 예외 처리
- [] streamDuplicateCheck 중복된 차 이름 있는 경우 예외 처리
- [] isValidListLength 차가 한 대 이하로 있는 경우 예외 처리
- [] isValidNum 유효한 숫자일 경우에만 true return
-

🚀view
#InputView
- [] inputCarNames 차 이름 입력 받는 view, 차 이름들 return
- [] inputRound  시도 횟수를 입력 받는 view, 시도 횟수 return
- 
#OutputView
- [] showStatus 실행 결과 return
- [] showWinners  최종 우승자를 보여줌
- [] showError 에러 보여줌

🚀Application
#main: racingGame 객체를 생성 후 play 를 통해 게임 시작