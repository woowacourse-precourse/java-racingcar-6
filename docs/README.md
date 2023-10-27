# 미션 - 자동차 경주

## 프로그램 동작 순서

1. 사용자로부터 경주할 자동차의 이름을 입력받는다.
    - 이때 이름의 구분은 쉼표(,)를 기준으로 한다.
    - 각 이름은 5자이하여야 한다.
2. 입력받은 이름을 가진 자동차를 생성한다.
3. 자동차들을 관리하는 객체를 생성한다.
4. 사용자로부터 이동할 횟수(n)를 입력받는다.
   - 이때 숫자로만 입력을 받아야 한다.
5. n번의 횟수동안 아래의 행동이 수행되어진다.
   1. 각 자동차는 아래의 행동을 수행한다.
      1. 0에서 9 사이의 무작위 값을 생성한다.
      2. 해당 값이 4이상일 경우 자동차는 한칸 전진한다.
   2. 모든 자동차의 이동이 완료되면 해당 결과를 출력한다.
      - 이때 출력의 순서는 사용자에게 이름을 입력받은 순서이다.
6. n번의 행동을 반복한 후 우승한(가장 많이 전진한) 자동차의 이름을 출력한다.
    - 가장 멀리 전진한 자동차가 여러개일경우 전부 출력한다.
    - 출력 순서는 사용자에게 이름을 입력받은 순서이다.
    - 이름은 쉼표로 구분시킨다.


## 기능 목록  -메서드명

-[x] 사용자에게 자동차들의 이름을 입력받는다. -inputCarsName()
  - [x] 콘솔에서 사용자에게 이름들을 입력받는다. -inputNames()
  - [x] 입력받은 문자열을 쉼표(,)를 기준으로 나눠준다. -splitNames()
  - [x] 입력받은 이름을 담는 객체를 생성. Name()
    - [x] 이름의 적합성을 판단한다. -NameValidator.validateName()
      - [x] 이름에 공백이 포함되는 경우 공백을 지운다. -NameValidator.removeWhiteSpace()
      - [x] 이름의 길이가 0,즉 비어있는지 확인한다. -NameValidator.checkNameIsEmpty()
        - 길이가 0일경우 IllegalArgumentException을 발생하고 애플리케이션을 종료시킨다.
      - [x] 각 이름들의 길이가 5 이하인지 확인한다. -NameValidator.checkNameCorrectRange()
        - 길이가 5 초과일경우 IllegalArgumentException을 발생하고 애플리케이션을 종료시킨다.
  -[x] 각 이름들을 담은 자동차 객체를 만든다. 
-[x] 자동차 객체들을 담은 객체를 만든다. -Cars()
-[ ] 사용자에게 이동을 시도할 횟수를 입력받는다. -inputAttemptCount()
  - [x] 입력값이 정수인지 확인한다. -checkAttemptCountIsInteger()
    - 정수가 아닌경우 IllegalArgumentException을 발생하고 애플리케이션을 종료시킨다.
- [ ] 각 자동차들의 전진을 시도한다. -Cars.attemptForward()
  - [x] 무작위 값이 4 이상일 경우 자동차를 전진시킨다. -Position.attemptForward()
    - [x] 0에서 9 사이의 무작위 값을 만든다. -Position.makeRandomValue()
    - [x] 해당 값이 4 이상의 값인지 판단한다. -Position.checkValueIsOverFour()  
    - [x] 자동차의 전진 상태값을 증가시킨다. -Position.moveForward()
- [ ] 현재 자동차들의 전진 결과를 출력한다. -printCurrentCarResult()
  - 자동차들의 출력순서는 입력받은 순이다.
  - [x] 자동차의 전진 상태값을 작대기(-)로 바꿔준다. -switchMovePositionToSlash()
- [ ] 자동차들중 우승한 (가장 많이 전진한) 자동차의 이름을 출력한다. -findWinningCarsAndPrint()
  - [ ] 자동차들 중 가장 멀리 나간 자동차를 구한다. -findWinningCars()
    - 가장 멀리 나간 자동차가 여러대 일수도 있다.
  - [ ] 해당 자동차의 이름을 출력한다. -printCarName()
    - [ ] 여러대인 경우 쉼표(,)를 이용해 구분한다. -splitByComma()

## 구현 클래스 및 하위 메서드
- Car: 자동차의 이름과 위치상태를 가진 클래스
  - attemptForward(): 앞으로 전진을 시도하는 기능
- Cars: 자동차들의 상태를 가진 클래스
  - attemptForward(): 자동차들의 전진을 시도하는 기능
- Name: 자동차의 이름이라는 상태를 관리하는 클래스
- Position: 자동차의 현재 위치상태를 관리하는 클래스 
  - attemptForward(): 전진을 시도하는 기능을 가진 기능
    - makeRandomValue(): 0부터 9사이의 무작위 값을 만들어내는 기능 
    - moveForward(): 자동차를 한칸 전진시키는 기능
    - checkValueIsOverFour(): 인자의 값이 4 이상안지 확인하는 기능
  - swithcMovePositionToSlash():위치 상태값을 작대기(-)로 바꿔주는 기능 
- View: 콘솔로 보여지는 입력 문구, 결과 출력에 관한 기능들을 가진 클래스 
  - inputNames():콘솔에서 사용자에게 이름들을 입력받는 기능
- NameValidator:이름의 적합성을 판단하는 클래스
  - removeWhiteSpace(): 이름의 존재하는 공백을 지우는 기능
  - checkNameIsEmpty(): 이름이 비어있는지 확인하는 기능
  - checkNameCorrectRange(): 이름이 미션에서 제한하는 범위(5자)를 넘었는지 확인하는 기능