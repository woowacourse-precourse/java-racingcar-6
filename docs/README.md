# 🚘 Car 클래스

#### 생성자 (public Car(String carName))

+ 주어진 이름(carName)으로 자동차를 초기화합니다. 초기 위치는 0입니다.

#### move() 메서드

+ 0에서 9 사이의 랜덤한 숫자를 선택하여, 4 이상이면 자동차가 전진합니다.

#### isValidName() 메서드

+ 자동차의 이름이 5글자 이하인지 확인합니다. 5글자를 초과하면 오류를 발생시킵니다.

#### getCarName(), getCarPosition(), getMovement() 메서드

각각 자동차의 이름, 현재 위치, 그리고 지금까지의 움직임을 가져옵니다.
🏁 Application 메서드

#### carListMoving(List<Car> carList, StringBuilder sb) 메서드

+ 주어진 자동차 목록(carList)에 대하여 각 자동차를 움직이게 합니다.
움직인 결과는 StringBuilder(sb)에 추가됩니다.

#### winnerCheck(List<Car> carList, StringBuilder sb) 메서드

+ 주어진 자동차 목록에서 우승한 자동차(들)를 확인하고, 그 이름을 StringBuilder(sb)에 추가합니다.

#### isBiggerThanPosition(int position, int winner) 메서드

+ 주어진 position이 winner보다 큰 경우, position을 반환하고, 그렇지 않으면 winner를 반환합니다. 이 메서드는 우승자의 위치를 결정하기 위해 사용됩니다.

#### main(String[] args) 메서드

사용자로부터 자동차 이름과 경주 횟수를 입력받습니다.
입력받은 경주 횟수만큼 자동차 목록에 대해 경주를 진행합니다.
마지막으로 우승자를 확인하고 결과를 출력합니다.