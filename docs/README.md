# 미션 - 자동차 경주

## 기능요구사항
- [x] 자동차 이름과 총 이동거리 클래스를 생성한다. Car.name, Car.distance
- [x] (입력) 자동차 이름을 입력받는다. InputManager.inputCarName
- [x] (예외) 자동차 이름은 5자 이하만 가능하다. InputManager.checkLimitCarName
- [x] (입력) 시도 횟수를 입력받는다.  InputManager.inputRepeat
- [x] 전진 조건을 판별한다. GameManager.checkMovePossible
    - [x] 각 자동차는 0~9 사이의 무작위 값이 생성된다. GameManager.createRandomNumber
    - [x] 무작위 값이 4 이상일 경우 전진한다. Car.move
- [x] 시도 횟수 종료 후, 우승자를 선정한다. GameManager.selectWinner

## 프로그래밍 요구사항
- [] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료된다.
- [] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- [] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
