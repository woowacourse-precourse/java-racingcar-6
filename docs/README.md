구현할 기능 목록

1. 입력
   (1) n대의 자동차에 이름을 부여할 수 있다.
    - 쉼표(,)를 기준으로 자동차 이름이 구분된다.
    - 5자를 초과하는 잘못된 값 입력하면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.
   (2) 사용자는 몇 번의 이동을 할 것인지 시도할 횟수를 정할 수 있다.

2. 자동차 객체
   (1) 자동차 객체는 각각 이름과 점수 값을 갖는다. 이름은 1-(1)을 통해 결정된다.
   (2) 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
   (3) 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우, 자동차는 1칸 전진한다 = +1의 점수 값을 가진다.
   - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.

3. 게임 결과 출력
   (1) 각 횟수마다 실행 결과를 출력한다.
   - 각 횟수마다 [이름 : 이동한 칸 수] 형식으로 실행 결과를 출력한다.
   - 칸 수는 시각화하여 1칸 - 2칸 -- 3칸 --- 형식으로 출력한다.
   (2) 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
   - 자동차 객체의 점수 값이 가장 큰 자동차가 우승한다.
   - 우승자는 한 명 이상일 수 있다.
   - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.


------------------------------
Input Class
-carNameInput() : 자동차 이름 입력
-roundNumInput() : 시도할 횟수 입력

Car Class
-Car(String name, int score) : 자동차 이름, 점수 초기화
-createCars(List<String> carNames) : (이름, 점수=0)으로 초기화 된 자동차 객체 배열 생성

RandomNum Class
-createRandomNum() : 0에서 9 사이에서 무작위 값을 생성

Play Class
-playRound(List<Car> Cars) : 생성된 무작위 값이 4이상일 경우 1칸 전진

Score Class
-scoreVisualization(int score) : 자동차 점수를 1칸 - 2칸 -- 3칸 --- 형식으로 시각화
-printRoundResult(List<Car> Cars) : 각 횟수마다 [이름 : 이동한 칸 수] 형식으로 실행 결과를 출력
-printWinnerResult(List<Car> Cars) : 자동차 경주 게임을 완료한 후 우승자(들) 출력
