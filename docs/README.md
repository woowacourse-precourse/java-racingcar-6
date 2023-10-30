# 자동차 경주 게임

이 프로젝트는 사용자로부터 자동차 이름과 이동 횟수를 입력받아 경주 게임을 진행하고, 최종 우승자를 알려주는 간단한 자바 프로그램입니다.

## 기능

1. 사용자로부터 n 대의 자동차 이름을 입력받음

   - 경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분) (inputCarName)
   - 자동차의 이름은 5자 이하여야 함 (validateCarName)
   - 자동차가 2대 이상일 경우 쉼표(,)로 구분 (haveComma, splitCarName)

2. 사용자가 몇 번 이동할 것인지 입력받음

   - 이동 횟수는 숫자여야 함 (validateNumber)
   - 전진하는 조건은 0에서 9 사이에서 랜덤값을 구한 후 4 이상일 경우 전진 (getRandomNumber, isMove)
   - 입력값에 따라 자동차가 이동한 결과를 출력 (반복) (printResult)

3. 최종 우승자를 알려줌

   - 중복 가능하며, 2명 이상일 경우 쉼표(,)로 구분 (splitWinner)

## 사용법

1. 프로그램을 실행하면 자동차 이름과 이동 횟수를 입력하는 메시지가 표시됩니다.

2. 자동차 이름을 쉼표(,)로 구분하여 입력하세요.

3. 이동 횟수를 입력하세요. (숫자만 입력 가능)

4. 각 자동차가 랜덤한 이동을 수행하며, 결과가 출력됩니다.

5. 게임이 종료되면 최종 우승자가 출력됩니다.

## 함수 및 설명

View
- `inputCarName()`: 사용자로부터 자동차 이름을 입력받아 리스트로 반환

- `inputMoveCount()`: 사용자로부터 이동 횟수를 입력받아 정수로 반환

- `printResult(Result result)`: 자동차의 이동 결과를 출력

- `printWinner(List<String> winners)`: 최종 우승자를 출력

Validation
- `validateCarName(String carName)`: 자동차 이름의 유효성을 검사

- `validateNumber(String number)`: 숫자 입력의 유효성을 검사

Controller
- `init()`: 자동차 경주 게임을 초기화
- `run()`: 자동차 경주 게임을 실행
- `end()`: 자동차 경주 게임을 종료
- `restart()`: 자동차 경주 게임을 재시작
- `isMoreThanTwoCars(List<Car> cars)`: 입력받은 자동차의 갯수가 2대 이상인지 확인

- `isLessThanFiveCharacters(String carName)`: 자동차 이름의 길이가 5자 이하인지 확인

- `isLessThanOne(String number)`: 입력받은 숫자가 1 이상인지 확인
- `isMoreThanNine(String number)`: 입력받은 숫자가 9 이하인지 확인
- `isNumber(String number)`: 입력받은 값이 숫자인지 확인

- `haveComma(String carName)`: 쉼표(,)가 포함되어 있는지 확인

- `splitCarName(String carName)`: 쉼표(,)로 구분된 문자열을 리스트로 분할

- `splitWinner(List<Car> winners)`: 최종 우승자를 쉼표(,)로 구분하여 리스트로 반환

- `getRandomNumber()`: 0에서 9 사이의 랜덤값을 반환

- `isMove(int number)`: 전진 여부를 반환

- `moveCar(Car car)`: 자동차를 이동시키고 결과를 반환

- `moveCars(Cars cars)`: 자동차들을 이동시키고 결과를 반환

- `getWinner(Result result)`: 최종 우승자를 반환

- `start()`: 자동차 경주 게임을 시작

- `restart()`: 자동차 경주 게임을 재시작

- `end()`: 자동차 경주 게임을 종료

Model
- `Car(String name)`: 자동차의 이름을 저장하는 클래스

- `Cars(List<Car> cars)`: 자동차의 리스트를 저장하는 클래스

- `Result(Map<Car, Integer> result)`: 자동차의 이동 결과를 저장하는 클래스

- `Winner(List<Car> winners)`: 최종 우승자를 저장하는 클래스

<!-- - `RacingGame(Cars cars, int moveCount)`: 자동차 경주 게임을 진행하는 클래스 -->

<!-- - `RacingGameResult(Result result)`: 자동차 경주 게임의 결과를 저장하는 클래스 -->

- `RacingGameWinner(Winner winner)`: 자동차 경주 게임의 최종 우승자를 저장하는 클래스

## 참고사항

- 각 자동차의 이동은 랜덤하게 결정됩니다.

- 게임에서 우승자가 나오지 않을 수 있습니다.

- 게임을 반복하려면 프로그램을 다시 실행하십시오.

## 메모
최종 우승자 출력시 ... 문법 생각해보기

## 소감 작성
함수의 모듈화에 집중하기 위해 layered architecture에서 mvc