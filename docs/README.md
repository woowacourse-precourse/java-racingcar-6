# 기능 목록

## view

### InputView
- receiveUserInput - 사용자 입력을 받아 리턴

### OutputView
- printExecResult - "실행 결과"를 출력함
- printInputCarName - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"을 출력함
- printInputTryNum - "시도할 회수는 몇회인가요?"을 출력함
- printCarStatus - 자동차들의 현재까지 전진한 상태를 출력함
- printWinner - 최종 우승자를 출력함

## model

### CarInfo
- getCarStatus - 자동차 전진 상태를 리턴함
- getCarName - 자동차 이름을 리턴함
- initCarStatus - 자동차 상태 list에 자동차 수에 맞도록 0추가
- setCarName - 자동차 이름을 저장함
- updateCarStatus - 자동차 전진 상태를 업데이트함
- isMove - 자동차가 전진 가능한 값인지 리턴함
- getMaxMove - 자동차들 중 가장 전진을 많이한 회수를 리턴함
- getWinnerName - 우승자의 이름 리스트를 리턴함


## controller

### RacingGame
- racingStart - 경주를 시작함
- convertStringToInt - 문자열을 숫자로 변환 하여 리턴함
- tryMove - 자동차 수에 맞춰서 랜덤 숫자를 생성 하고 전진 업데이트 함수를 실행함

## util

### validation
- checkCarName - 자동차 이름이 조건에 맞는지 확인(잘못된 값인 경우 IllegalArgumentException 발생 시킴)
  - 조건: 자동차 이름은 5자 이하만 가능
- checkTryNumber - 시도 횟수가 조건에 맞는지 확인(잘못된 값인 경우 IllegalArgumentException 발생 시킴)
  - 조건: 자연수만 가능