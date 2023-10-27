### 객체 생각하기

- 사용자
    - 입력
        - 몇 번의 이동을 할 것인지
    - 잘못된 입력값일 경우 예외처리
- 자동차
    - 행동
        - 전진
            - 0-9 사이 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진
        - 멈춤
            - 0-9 사이 무작위 값을 구한 후 무작위 값이 3 이하일 경우 멈춤
    - 상태
        - 이름 (5자 이하만 가능)
- 게임
    - 입력
        - 자동차 이름
            - 이름은 쉼표를 기준으로 구분
            - 예외처리
                - 아무런 입력을 하지 않았을 경우
                - 5자 이상 입력했을 경우
        - 시도할 횟수
            - 예외처리
                - 숫자가 아닌 숫자를 입력할 경우
    - 출력
        - 전진하는 자동차
            - 자동차 이름 같이 출력
            - 전진할 시 `-` 로 표시
        - 누가 우승했는지
            - 우승자는 한 명 이상일 수 있음
            - 우승자가 여러 명일 경우 ,를 이용하여 구분

### 기능목록

- Game.class
    - ArrayList<Car> cars
    - void play()
    - void startGame()
    - void endGame()
    - void printCarMove()
    - void printWinner()
    - void inputCarName();
    - void inputGameRound();
- Car.class
    - string name
    - int distance
    - car(String name, int distance)
    - void move()
    - boolean isMove()
    - int makeRandomNum()
    - ArrayList<String> findWinner();

### 흐름도

- 우선 클래스와 메소드 작성하기
- 메소드는 우선 void로 두기
- 큰 흐름도만 우선 작성해보기
- 데이터가 어떻게 흐르고 있는지 보기