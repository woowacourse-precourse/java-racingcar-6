# 미션 - 자동차 경주

---

## ✏️ 기능 요구 사항

### ⓘ 조건
- 자동차 이름 쉼표를 기준 (5자 이하만)
  - splitNames(userInput) : 입력값을 쉼표로 분리하는 메서드 
- 우승자는 한 명 이상일 수 있음 (여러명일 경우 쉼표로 구분)
- 전진하는 조건은 0에서 9사이 무작위 수 중 4이상일 경우
- 전진하는 자동차 출력시 이름을 같이 출력
- 라이브러리
  ```jsx
   camp.nextstep.edu.missionutils.Randoms
   pickNumberInRange();
  
   camp.nextstep.edu.missionutils.Console
   readLine();
  ```

### 💬 사용자 입력 사항
- getNamesFromUser() : 자동차 이름 입력 메서드(쉼표구분)
   - 입력
     ```jsx
     경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
     ```
      ```jsx
      camp.nextstep.edu.missionutils.Console
      readLine();
     ```
- getAttemptCountFromUser() : 시도할 횟수 입력 메서드
   ```jsx
     시도할 회수는 몇회인가요?
     ```
    ```jsx
      camp.nextstep.edu.missionutils.Console
      readLine();
     ```
      
### ‼️ 에러 처리
- IllegalArgumentException 이 발생하는 경우
  - validateUserInput(String userInput) : 자동차 이름 입력시 <br> (숫자입력하는 경우, 중복되는 경우, 쉼표로 구분짓지 않는 경우, 아무것도 입력하지 않는 경우, 5자를 초과하는 경우)
    ```jsx
    String userInput = getUserInputFromConsole();
    ```
  - validateAttemptCount(String countInput) : 시도할 횟수 입력시 <br> (문자열을 입력할 경우, 아무것도 입력하지 않는 경우, 0을 입력하는 경우)
    ```jsx
    String countInput = getAttemptCountFromUser();
    ```

### UserInputHandler 클래스 
: 사용자 입력 사항과 에러 처리

- List<String> getNamesFromUser() :
  ```jsx
  return validateUserInput(userInput);
  ```
- validateUserInput(String userInput) : 자동차의 이름이 입력되지 않는 경우와, List<String> names = splitNames(userInput)로 입력된 이름을 쉼표로 구분
- splitNames(userInput) : 쉼표로 분리하는 메서드
- validateName(String name) : 입력된 자동차의 이름이 5자를 초과할 때 에러 처리하는 메서드
- checkDuplicateName(List<String> names) : 입력된 자동차의 이름의 중복을 체크하고 에러를 처리하는 메서드
- getAttemptCountFromUser() : 시도할 횟수 입력 메서드
  ```jsx
  String countInput = Console.readLine();
  return validateAttemptCount(countInput);
  ```
- validateAttemptCount(String countInput) : 시도 횟수들의 에러를 처리하는 메서드

### Car 클래스
: 자동차 모델링 (움직임과 상태 저장)
- move() : 0에서 9까지의 난수 생성 후 생성된 난수가 MIN_NUMBER_FOR_MOVE보다 크거나 같으면 자동차의 위치를 1 증가
- Car(String name): 자동차의 이름을 인자로 받아서 초기화함
- isMovable(int randomNumber): 전달된 난수가 MIN_NUMBER_FOR_MOVE보다 크거나 같은지 확인
- getName(): 자동차의 이름을 반환
- getPosition(): 자동차의 현재 위치를 반환, 위치는 move() 메서드를 호출할 때마다 1씩 증가

###  GameController 클래스
: 게임의 로직을 처리 (전진과 멈춤)

- setUp(String names): 게임을 설정하는 역할, 이름을 입력받아 쉼표(,)로 분리한 후, 각 이름을 가진 자동차 객체를 생성하고, 이를 cars 리스트에 추가
- run(int rounds): 게임을 실행하는 역할. 입력받은 라운드 수만큼 자동차들을 움직이고, 각 라운드의 결과를 출력
- moveCars(): 모든 자동차들을 움직이는 역할. 또한, 이동한 후의 자동차 위치를 확인하여 maxPosition을 업데이트 
- printRoundResult(): 각 라운드의 결과를 출력하는 역할
- getWinners(): 우승한 자동차들의 이름을 반환, maxPosition과 동일한 위치에 있는 자동차들을 우승자로 판단

### ResultView 클래스
: 게임의 결과를 출력

- printCarPosition(Car car): 각 자동차의 이름과 위치를 출력
- appendCarPosition(StringBuilder result, int position): 자동차의 위치만큼 - 기호를 추가
- printNewLine(): 각 라운드의 결과를 구분하여 출력
- printWinners(List<String> winners): 우승자들의 이름을 ,로 구분하여 문자열에 추가

---

## 💻 프로그래밍 요구 사항
- JDK 17
- 프로그램 실행의 시작점은 Application main()
- build.gradle 파일 변경 금지
- System.exit() 호출 금지
- ApplicationTest의 모든 테스트가 성공해야 함
- 패키지 이름 수정이나 이동 금지
- Java 코드 컨벤션 가이드 준수

