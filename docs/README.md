# 👩🏻‍💻 구현 기능 목록
## ☑️ 게임 로직 정리

1. 프로그램 시작 시 게임 시작 문구 `“경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)”`을 출력한다.


2. 플레이어에게 자동차 이름과 게임 진행 횟수를 입력받는다.<br>
   -**자동차 이름에 대한 유효성 검사를 실행한다.**<br>
   (유효성 검사를 실패할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.)<br>
   a. 각 자동차의 이름은 5자 이하여야 한다.<br>
   b. 플레이어의 입력값은 필수이다. <br>
   c. 자동차의 이름은 문자, 숫자만을 허용한다. <br>
   d. 자동차의 이름은 중복될 수 없다. <br>
   -**게임 진행 횟수에 대한 유효성 검사를 실행한다.**<br>
   a. 플레이어의 입력값은 필수이다. <br>
   b. 입력값은 정수여야 한다.


3. 플레이어가 입력한 게임 진행 횟수에 따라 게임을 진행하고 각 진행마다 실행 결과를 출력한다.  <br>
   -**자동차가 전진하는 조건** <br>
   a. 0부터 9 사이의 랜덤 값이 4 이상일 경우<br>
   -**출력 방식**<br>
   a. 실행 결과를 출력할 때 자동차 이름을 같이 출력한다. <br>
   b. 전진 방식은 `-`로 표현한다. <br>
   `출력 예) pobi : -`


4. 게임이 끝나면 우승자를 출력한다.<br>
   -**우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.**<br>
   a. 단독 우승일 경우 : `“최종 우승자 : ”` + 우승한 자동차의 이름<br>
   b. 공동 우승일 경우 : `“최종 우승자 : ”`+ 우승한 자동차의 이름 + `“,”` + 우승한 자동차의 이름
   <br>
## ☑️ 역할별 구현 기능 목록

### GameMainController & GameService

- 게임의 전체 흐름을 제어한다.
    - 플레이어의 입력값에 따라 게임을 세팅한다. `createCarList(), createGameCount()`
    - 플레이어가 입력한 게임 횟수에 따라 게임을 진행한다. `playGame()`
    - 게임이 끝나면 우승자를 출력한다. `printWinner()`

### Car

- 사용자가 입력한 자동차 도메인 객체이다.
    - car 객체는 이름과 position 값을 가진다.
    - 랜덤으로 구한 값이 4이상일 경우 position을 증가시킨다. `movePosition()`

### CarList

- car 객체들을 List로 관리하는 도메인 객체이다.
    - 사용자의 입력값에 대한 유효성 검사를 실시하고 객체를 생성할지 결정한다.
    - 게임이 진행될 때마다 자동차 전진 상황을 출력한다. `printGameProceed()`
    - car 객체들이 전진한 최댓값을 기준으로 우승자를 찾는다. `findWinner()`

### GameCount

- 사용자가 입력한 게임 진행 횟수 도메인 객체이다.
    - GameCount 객체는 count 값을 가진다.
    - 사용자의 입력값에 대한 유효성 검사를 실시하고 객체를 생성할지 결정한다.

### NumberGenerator

- 자동차 position 전진 결정에 사용될 랜덤값을 생성한다. `generateRandomNumber()`

### UserUtil

- 플레이어의 입력값을 받는다. `getUserInput()`

### CarNameValidator

- 자동차 이름에 대한 입력값을 검증한다. 아래의 경우를 위반할 시 `IllegalArgumentException`이 발생한다.
    - 각 자동차의 이름은 1자 이상 5자 이하여야 한다. `validateNameSize()`
    - 자동차의 이름은 중복될 수 없다. `validateNameDuplication()`
    - 자동차의 이름은 특수문자를 제외한 문자, 숫자만을 허용한다. `validateNameType()`

### GameCountValidator

- 게임 진행 횟수에 대한 입력값을 검증한다. 아래의 경우를 위반할 시 `IllegalArgumentException`이 발생한다.
    - 입력값은 자연수여야 한다. `validateGameCount()`

### ExceptionMessage && NumberConstant && StringConstant

- `ExceptionMessage` : 예외에 대한 메시지를 상수로 관리하는 enum 클래스이다.
- `NumberConstant` : 숫자에 대한 상수를 관리하는 enum 클래스이다.
- `StringConstant` : 문자열에 대한 상수를 관리하는 enum 클래스이다.

### InputView

- 입력에 관한 메세지를 출력한다.
    - 자동차 이름 입력 요청 메시지 `requestCarName()`
    - 게임 진행 횟수 입력 요청 메시지 `requestGameCount()`

### OutputView

- 게임 결과 메시지를 출력한다. `printResultMessage()`
- 최종 우승자 메시지를 출력한다. `printWinnerMessage()`