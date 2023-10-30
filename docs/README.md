# 구현할 기능

## Car

- method
    - getName : 차량의 이름을 반환합니다.
    - getLocation : 차량의 위치를 반환합니다.
    - moveForward : 차량의 위치를 한칸 전진합니다.

## PlayGame

- method
  - statusPrint : 현재 각 차량의 진행 상황을 출력합니다.
  - createRandomNumber : 0~9사이의 무작위 값을 생성합니다.
  - playGame : 게임을 진행합니다.
  - getResult : 게임의 결과를 반환합니다.

## UserInput

- method
  - carName : 입력 받은 차량의 이름을 조건에 맞나 검증합니다.
  - attemptsNumber : 입력 받은 시도할 횟수를 조건에 맞나 검증합니다.

## InputValidator

- method
    - carName : 차량의 이름을 입력받습니다.
    - attemptsNumber : 시도 횟수를 입력받습니다.

## Application

- method
  - run : 게임을 실행합니다.