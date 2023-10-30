# 구현할 기능 목록

- [ ] 시작 문구를 출력한다. (showMessage)

- [ ] 경주할 자동차 이름을 입력한다. (promptCarNames)
    - [ ] 입력한 자동차 이름을 콤마(,) 기준으로 구분하여 자동차를 생성해서 리스트로 저장한다. (registerCars)
    - [ ] 입력한 자동차 이름이 5자 이하인지 체크한다. (validateCarName)

- [ ] 시도할 횟수를 입력한다. (promptForRoundCount)
    - [ ] 사용자가 잘못입력했을때 IllegalException 에러를 발생시킨다. (validateUserInput)

- [ ] 입력한 시도 횟수 만큼 반복한다. (startRounds)
    - [ ] 차수별 자동차마다 랜덤한 숫자(0부터 9 사이의 무작위 값)를 생성한다. (createRandomSingleNumber)
    - [ ] 차수별 자동차마다 생성한 랜덤한 숫자가 4이상일경우 전진한다. (moveCars)
    - [ ] 차수별 실행 결과를 출력한다. (showResult)

- [ ] 우승자 안내 문구를 출력한다. (showWinner)