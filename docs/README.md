# 🚘 자동차 경주

### USER
1. [X] USER가 입력하는 함수 : `input()`
2. [X] USER가 입력한 CarName을 split해주는 함수 : `splitInput(String)`
3. [X] 시도 횟수 parseInt해주는 함수 : `stringToInteger()`

### GAME
1. [X] 0부터 9까지 랜덤으로 뽑아주는 함수 : `randomNumber()`
2. [X] 전진 혹은 멈추는 함수(각각 자동차의 moveCount + 1 : 전진) : `updateStatus(List<Car>)`
3. [X] 각 횟수마다 결과를 출력해주는 함수 : `printRacing(List<Car>)`
4. [X] 우승자를 찾는 함수 : `findWinner(List<Car>)`
5. [X] 우승자를 출력해주는 함수 : `printWinner(List<String>)`
6. [X] 랜덤 값이 4 이상인지 체크 해주는 함수 : `checkRandomNumber(Integer)`
7. [X] racingGame을 진행하는 함수(모두 합친 내용) : `run()`

### CAR
1. [X] 입력받은 자동차의 이름을 초기화하여 Car 객체에 리스트 생성하는 함수 : `initializeCars()`
2. [X] 자동차의 이름이 5글자 이하인지 체크해주는 함수 : `checkLength(List<Car>)`
3. [X] toString 메소드를 재정의 

### EXCEPTION
1. [ ] ~~자동차 이름이 중복되면 안된다.~~
2. [X] 자동차의 이름은 5글자 이하여야 한다 : `Car.checkLength`
3. [X] 몇 번 이동할 지에 0번을 입력하면 안된다 : `User.stringToInteger`
4. [ ] ~~자동차 경주는 2개 이상의 자동차를 입력해야한다.(1개 이하는 허용하지 않는다.)~~
5. [ ] ~~만일 자동차가 모두 0의 값을 유지한다면, 모두 위너인가 ?~~
