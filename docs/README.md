🚀 구현할 기능 목록
자동차의 이름을 입력 받기(InputCarName)
1. 이름은 5자 이하면서 빈 값이 아니여야한다. 
2. 자동차의 이름은 ","로 구분해야한다.
3. 콤마로 구분된 배열을 자동차에서 객체를 생할 수 있도록 return 해야한다.

자동차 클래스 생성(Car)
1. 생성자를 통해 자동차의 position을 0으로, 입력받은 이름을 초기화한다.
2. Randoms.pickNumberInRange 메서드를 통해 무작위 숫자를 얻고 "4" 이상일 경우 position을 1만큼 더한다.
3. InputCarName에서 return된 배열을 받아서 리스트의 수 만큼 Car 클래스를 생성한다.
4. get 함수를 생성하여 private로 선언되었어도 다른 클래스에서 호출해 사용할 수 있어야한다.

시도할 횟수 입력 받기(InputNumOfAttempts)
1. 시도할 횟수는 숫자여야하고, 1 이상이여야한다.
2. 해당 시도한 횟수를 return 해야한다.

자동차 경주(RacingGame)
1. InputNumOfAttempts에서 return된 값 만큼 자동차 경주를 수행한다.
2. 자동차의 경주 수행 결과를 화면에 표시해야한다.
3. 자동차의 경주 진행도는 Car 객체에서 생성자를 통해 position을 불러와 수행한다.

경주 결과(RaceResult)
1. Car 객체의 리스트들을 받아와 우승자를 찾는다.
2. Max_Position 함수를 따로 생성하여, Car에서 get한 position들과 비교하여 가장 큰 값을 저장한다.
3. Max_Position과 같은 값을 가진 Car 객체의 position을 찾아서 이름을 get 한다.
4. Winners라는 리스트를 생성하여 가장 높은 position을 가진 자동차의 이름들을 저장하여 출력한다.