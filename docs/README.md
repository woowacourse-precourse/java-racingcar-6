# 자동차 경주

## 기능 목록

- [x] 자동차 이름 입력 - `InputView` `inputStringSplitByComma()`
  - [x] 쉼표로 문자열 분리 - `InputView` `splitByComma(String input)`
  - [x] 중복 이름 예외 처리 - `InputView` `checkForDuplicateStrings(List<String> stringList)`
  - [x] 빈 이름 예외 처리 - `InputView` `checkForEmptyString(List<String> stringList)`
  - [x] 길이 제한 확인 - `Car` `checkNameLength(String name, int nameMaxLength)`

- [x] 몇 번 시도할 것인지 입력 - `InputView inputDigit`
  - [x] 잘못된 문자 입력 예외 처리
- [x] 입력한 시도 횟수(n)만큼, 자동차 진행 조건에 따라 이동 - `Race tick`
  - [x] 0 ~ 9 사이의 무작위 값 생성 - `Race generateCarDistanceMovementList`
  - [x] 4 이상인 경우 해당 자동차 이동 - `Race moveCars`
- [x] 우승자 출력 - `OutputView showWinners`
  - [x] 단독 우승
  - [x] 공동 우승
  - [x] 모두 실패


## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 그대로 정지
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때, 자동차 이름을 같이 출력
- 자동차 이름은 쉼표(,)를 기준으로 구분, 이름은 5자 이하만 가능
- 사용자는 몇 번의 이동을 할 것인지를 입력 가능해야함
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후, 무작위 값이 4 이상일 경우 전진
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있음
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료함

## 요구 사항 외 정의

요구 사항에는 포함되지 않았지만, 더 나은 프로그램을 위해 명확히 정의한 사항들

### 모두 이동하지 못하는 경우

요구사항에서는 우승자만 명시했지만, 모두 이동하지 못한 경우에 대해서는 언급이 없다.

따라서 아무도 이동하지 못하는 경우, 우승자가 없다고 판단해서 우승자 대신에 다른 결과를 출력하는 게 더 좋은 프로그램이라고 판단
