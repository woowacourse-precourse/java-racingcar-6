## 자동차 경주

## 기능 목록

- [x] 자동차 이름을 입력한다.
  - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다. - splitCarNames()
  - [x] 이름은 5자 이하만 가능하다. (입력 오류 : IllegalArgumentException) - checkNamingError()

- [x] 이동을 시도할 횟수를 입력한다.
  - [x] 입력받은 숫자의 자료형을 String에서 int로 변환한다. - convertStringToInt()
  - [x] 숫자만 입력이 가능하다. (입력 오류 : IllegalArgumentException)

- [x] 각 자동차는 전진 또는 멈출 수 있다.
  - [x] 0에서 9 사이의 무작위 값을 생성한다.
  - [x] 무작위 값이 4 이상이면 전진이다. - generateAction()
  - [x] 각 자동차의 움직임을 저장한다. - recordCarAction()
  - [x] 각 자동차의 이동 여부를 이름과 함께 "-" 형태로 출력한다. - printCarRace()
  - [x] 입력한 시도할 횟수만큼 반복한다. - playCarRace()

- [x] 자동차 경주 게임 완료하면 누가 우승했는지 출력한다. - printWinner()
  - [x] 누가 가장 많이 전진했는지 알 수 있다. - decideWinner()
  - [x] 우승자는 1명 이상일 수 있다.
  - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용해 구분한다.

## 리팩토링 작업에 고려할 주요 요구 사항

- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기.
  - 리팩토링 작업 내용 및 결과
    - [x] decideWinner() 함수에서 winner의 index를 구하는 기능을 별도 함수 extractWinnerIndex()로 분리.
    - [x] inputCarNames()에서 readLine() 분리.
      - readLine()에서 받은 입력을 콤마 단위로 split하는 splitCarNames()로 수정.
    - [x] inputNumberOfRace()를 readLine()과 분리.
      - readLine()에서 입력한 횟수를 숫자일 경우 int로 반환, 숫자 아닐 경우 예외 처리하는 convertStringToInt()로 수정.
    - [x] 기존 printCarRace()의 다중 기능(반복 실행, 저장된 결과를 갱신, 실행 결과 출력)을 분리.
      - playCarRace() : 입력한 횟수만큼 recordCarAction()와 printCarRace()를 반복 실행.
      - recordCarAction() : 이전 기록을 반영하여 갱신된 실행 결과를 저장.
      - printCarRace() : 실행 결과를 출력.

## 함수(또는 메서드)별 기능 테스트 작성

- 함수 테스트는 ~~혹시 모를 테스트 코드 실패를 대비하여~~ ApplicationTest와 분리된 별도의 MethodsTest에서 테스트하기.
  - ~~ApplicationTest에서 테스트 실패시 0점 처리되기 때문.~~
  - 어차피 gradlew.bat clean test를 하면 ApplicationTest 뿐만 아니라 모든 테스트를 실행한다는 것을 알게됨!
  - 즉, MethodsTest를 분리해도 거기서 fail이 나타나면 어차피 0점 처리될 수 있음.
  - 테스트를 꼼꼼하게 하자!
- MethodsTest.java 테스트 목록
  - [x] splitCarNamesTest : splitCarNames()가 입력한 문자열을 콤마(,) 단위로 나누어 List 형태로 반환하는지 테스트.
  - [x] checkNamingErrorTest : checkNamingError()가 5자 초과의 이름이 있을 때 예외 처리하는지 테스트.
  - [x] convertStringToIntTest : convertStringToInt()가 시도 횟수를 int로 변환하고 입력 오류는 예외 처리하는지 테스트.

  - [x] playCarRaceTest : playCarRace()가 시도 횟수만큼 반복하여 각 자동차의 최종 실행 결과를 반환하는지 테스트.
  - [x] recordCarActionTest : recordCarAction()가 전진, 멈춤에 따라 이전 기록을 갱신하는지 테스트.
  - [x] generateActionTest : generateAction()가 난수에 따라 0(멈춤) 또는 1(전진)을 반환하는지 테스트.
  - [x] printCarRaceTest : printCarRace()가 자동차 이름과 전진 횟수를 반영하여 "이름 : -" 형태로 출력하는지 테스트.

  - [x] extractWinnerIndexTest : extractWinnerIndex()가 가장 멀리 간 자동차의 index로 구성된 List를 반환하는지 테스트.
  - [x] decideWinnerTest : decideWinner()가 우승자 이름으로 구성된 List를 반환하는지 테스트.
  - [x] printWinnerTest : printWinner()가 단독 우승자와 공동 우승자를 형식에 맞게 출력하는지 테스트.
