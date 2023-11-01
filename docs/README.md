# 기능 목록

## Application

1. 프로그램을 실행하는 기능 (main)
2. 본격적인 게임 시작 전 입력받는 기능(run)
3. 입력받은 자동차 이름을 저장하는 기능(saveName)
4. 입력받은 이름을 가지고 자동차 객체 생성하는 기능(makePlayers)

## CarRaceGame

1. 자동차 경주 게임 시작 기능(run)
2. 플레이어 랜덤한 값을 세팅하는 기능(generateRandomNumber)
3. 게임 결과를 보여주는 기능(printResult)
4. 최종 우승자 출력하는 기능(printWinner)
5. 제일 많이 간 거리를 리턴하는 기능(getMaxDistance)
6. 우승자(들) 리스트를 리턴하는 기능(getWinner)

## InputValidator

1. 입력한 이름이 5글자 초과면 에러 처리 하는 기능(validateCarNameLength)
2. 입력한 사용자들의 이름이 공백이면 에러 처리 하는 기능(checkIfInputExists)
3. 1번 2번 에러처리들을 통과하면 자동차 이름 배열을 리턴 하는 기능(exceptionHanding)
4. 입력한 게임 횟수가 숫자가 아니면 에러 처리하는 기능(isNumberic)
5. 입력한 게임 숫자가 공백이면 에처처리 하는 기능(isNotEmpty)
6. 4번 5번 에러처리들을 통과하면 입력한 숫자를 int형으로 리턴하는 기능(numberHandlingException)

## player

2. 이름 리턴하는 기능(getName)
3. 이동거리 설정하는 기능(setDistance)
4. 이동거리 리턴하는 기능(getDistance)
5. 이동거리 출력하는 기능(printDistance)
6. 랜덤값 설정하는 기능(setRandomNumber)
7. 랜덤값 리턴하는 기능(getRandomNumber)
8. 이동거리를 "-"로 리턴하는 기능(ReturnDistanceLine())



