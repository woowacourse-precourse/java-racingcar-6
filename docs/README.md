기능요구사항

Car
1. void move(int diceNumber)
    - 전진한다.
2. boolean isMaxMoveNumber(int maxMoveNumber)
    - 최대전진횟수와 일치하는지 알 수 있다.
3. String toString()
    - 차의 이름과 전진횟수를 알 수 있다.

Dice
1. int getRandomNumber()
    - 0-9 사이의 무작위 값을 얻는다.

RacingCarGame
1. void run()
    - 게임을 시작한다.

RacingCarGameService
1. int getMaxMoveNumber(List<Car> carList)
    - 최대전진횟수를 얻는다.
2. List<String> getWinnerNames(List<Car> carList, int maxMoveNumber)
    - 우승자 리스트를 얻는다.
   
Validator
1. void validateContainsComma(String str)
    - Comma(,) 가 포함되어있는지 검증한다.
2. void validateNames(String names)
    - 입력 형식이 올바른지 검증한다.
3. void validateMoreThanOneNumber(String str)
   - 1이상의 숫자인지 검증한다.
4. void validateDuplicateName(String str)
   - 동명이인이 있는지 검증한다.

InputView
1. String inputNames()
   - 자동차의 이름을 입력 받는다. 
2. int inputTryNumber()
   - 시도할 횟수를 입력 받는다.

OutputView
1. void printResult(List<Car> carList) 
   - 차수별 실행 결과를 보여준다.
2. void printWinner(List<String> winnerNames)
   - 우승 결과를 보여준다.


