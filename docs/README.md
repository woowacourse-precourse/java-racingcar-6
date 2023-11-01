# 자동차 경주

## 기능 구현 목록
### 자동차
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차는 이름을 가진다.(이름은 5자 이하만 가능)
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.

### 사용자
- 사용자는 몇번의 이동을 할 지 입력한다.

### Racing Game
- 사용자가 입력한 횟수 동안 Racing Game이 진행된다.
- 자동차가 전진하는 조건은 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자는 한명 이상일 수 있다. 

### 예외 처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다. 

## 구현 내용
### Class & Method
1. Car class
   - 사용자로부터 입력받은 Car name과 각 Car가 움직인 거리인 movingDistance를 멤버변수로 가진다.
   - moveForward()
     - 전진 조건에 해당하는 경우 movingDistance값을 1 늘려주기 위해 사용한다. 
2. Racing Game
   - Car 객체가 저장된 List를 멤버변수로 가진다. 
   - startGame()
     - 게임의 진행을 위한 메소드이다. 사용자의 입력을 받고, 입력이 올바른지 체크하기 위해 validator를 호출한다.
   - settingCar()
     - 입력받은 Car name으로 Car 객체를 생성한다.
   - progressCarGame()
     - 입력받은 게임의 횟수 만큼 반복문을 돌려서 게임을 진행한다. 
     - 0부터 9까지 중 랜덤으로 숫자 하나를 뽑고 그 숫자가 4이상인 경우 Car가 앞으로 한칸 전진하도록 Car 객체의 moveForward함수를 호출한다.
     - 게임 1회 실행마다 printRunResult를 호출해 현재 Car의 진행 상황을 출력한다.
     - 게임의 모든 횟수가 끝난 후 printWinner를 호출해 우승자를 출력한다.
   - printWinner()
     - Car 객체마다 이동 거리를 비교해 제일 멀리간 Car를 출력한다. 
   - printRunResult()
     - Car 객체마다 이동거리 만큼 -을 출력해 이동거리를 표시한다.
3. UserInputValidator
   - validateCarName()
     - 사용자로부터 입력받는 경주할 자동차 이름에 대해 validate한다.
     - 정규표현식을 사용해 car 이름이 5자 이하인지 확인하고 아닌 경우 IllegalArgumentException 예외를 발생시킨다.
   - validateGameNumber()
     - 사용자로부터 입력받는 게임 횟수에 대해 validate한다.
     - 정규표현식을 사용해 입력 값이 1이상인 정수가 아닌 경우 IllegalArgumentException 예외를 발생시킨다. 
