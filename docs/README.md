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

### ErrorDetector 클래스

- 사용자가 입력한 값에 대한 유효성 검사 진행
  - public static String[] throwIfCarNameIsLong(String cars)
    - 입력한 차들의 이름의 길이가 5를 초과할 경우 IllegalArgumentException을 발생
  - public static int throwIfInputIsString(String count)
    - 입력한 시도 횟수가 숫자가 아닐 경우 IllegalArgumentException을 발생

### Input, Output 클래스

- Input 클래스
  - public static List<String> readCars()
    - 차들의 이름을 입력 받고 ErrorDetector를 통한 유효성 검사를 진행
  - public static int readCount()
    - 시도 횟수를 입력 받고 ErrorDetector를 통한 유효성 검사를 진행

- Output 클래스
  - public static void printMessage(String message)
    - System.out.println() 메소드를 가독성이 좋게 변경