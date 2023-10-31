# 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - 이름 5자 이상이면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 공백도 글자 수에 포함해야할 지 고민해봐야겠다. 
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - 입력 받는 값이 문자열이면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 0번은 어떻게 처리해야할 지 고민해봐야겠다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    - 4 미만일 경우엔 전진하지 않는다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - 중복된 우승자를 처리하는게 관건일 듯 하다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 기능 구현

### ~~ErrorDetector 클래스~~ Validation 클래스

- 사용자가 입력한 값에 대한 유효성 검사 진행
  - ~~public static String[] throwIfCarNameIsLong(String cars)~~
  - public static String[] throwIfCarInputIsInvalid(String input)
    - 입력한 차의 개수가 1이하일 경우 IllegalArgumentException을 발생
    - 입력한 차들의 이름의 길이가 5를 초과할 경우 IllegalArgumentException을 발생
  - ~~- public static int throwIfInputIsString(String count)~~
  - public static int throwIfCountInputIsInvalid(String count)
    - 입력한 시도 회수가 0이하일 경우 IllegalArgumentException을 발생
    - 입력한 시도 횟수가 숫자가 아닐 경우 IllegalArgumentException을 발생

### Input, Output 클래스

- Input 클래스
  - public static List<String> readCars()
    - 차들의 이름을 입력 받고 Validation를 통한 유효성 검사를 진행
  - public static int readCount()
    - 시도 횟수를 입력 받고 Validation를 통한 유효성 검사를 진행

- Output 클래스
  - public static void printMessage(String message)
    - System.out.println() 메소드를 가독성이 좋게 변경

### RandomNumberGenerator 클래스

- RandomNumberGenerator 클래스
  - public static int getRandomNumber()
    - camp.nextstep.edu.missionutils.Randoms API를 이용한 무작위 수를 반환한다.

### Car 클래스 Comparable<Car> 구현

- Car 생성자
  - 차 이름을 받아서 name에 저장
  - distance를 0으로 초기화
- getName(), getDistance()
  - name 값과 distance 값을 반환
- move()
  - Randoms API 수를 받아서 상수 FORWARD_STANDARD 이상이면 distance +1
- @Override public int compareTo(Car o)
  - o.distance - this.distance를 리턴해서 역순 정렬을 위해서 오버라이드

### Track 클래스

- public void addCars()
  - 자동차를 개수만큼 트랙에 저장
- public void moveCars()
  - 자동차 이동
- public String showProgress()
  - 레이스 진행 상태 출력
- public String showResult()
  - list로 받은 레이스 결과 출력
- private Car findFirstPlace()
  - 배열을 통해 가장 멀리 간 자동차를 구해서 반환
- private List<String> findWinners()
  - 모든 우승자를 찾아서 list로 반환한다.


### Race 클래스

- Race 생성자
  - Track 클래스를 생성
- public void start()
  - 자동차 경주를 시작하는 메소드
  - private 메소드 실행
- private void ready()
  - GAME_START 메세지 출력
  - 자동차 이름 입력 받고 유효성 검사 진행
- private void set()
  - INPUT_COUNT 메세지 출력
  - 시도 횟수 입력 받고 유효성 검사 진행
- private void go()
  - GAME_RESULT 결과 및 내용 출력
- private void finish()
  - GAME_OVER 메세지 + 결과 출력

# 기능 테스트

### ValidationTest

-  void 차_개수_1이하_시_예외_발생()
  - 입력한 차의 개수가 1이하일 경우 IllegalArgumentException을 발생 여부 테스트
- void 음수_입력_시_예외_발생()
  - 입력한 시도 회수가 -1이하일 경우 IllegalArgumentException을 발생 여부 테스트
- void 제로_입력_시_예외_발생()
  - 입력한 시도 회수가 0일 경우 IllegalArgumentException을 발생 여부 테스트