# 2주차) 자동차 경주 미션

## 필수 기능 구현 목록 순서 정리

### 1. 입력 안내 메시지를 받는다.

- [x] 메시지 내용 : ``경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`` - MessagePrinter#printStartMessage()

### 2. 사용자는 경주에 참여시킬 자동차 이름을 입력한다.

- [x] 각 자동차에 이름을 부여할 수 있다. - UserInputValue#inputCarName()
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다. - InputValueValidator#checkComma()
- [x] 자동차 이름은 5글자 이하만 가능하다. - InputValueValidator#checkNameLength()
  - [x] 영어 및 숫자, 쉼표 이외의 기호 입력은 문자 갯수를 기준으로 5글자를 판별한다.
  - [x] 한글 입력은 음절을 기준으로 5글자를 판별한다.
- [x] 상기의 조건 외의 값을 입력할 경우, ``IllegalArgumentException`` 를 발생시키고 애플리케이션을 종료한다. - InputValueValidator
  - [x] 빈 칸을 입력하는 경우
  - [x] 5글자를 넘겨서 입력하는 경우
  - [x] 쉼표로 끝나는 경우

### 3. 이동 횟수 안내 메시지를 받는다.

- [x] 메시지 내용 : ``시도할 회수는 몇회인가요?`` - MessagePrinter#printCountMessage()

### 4. 사용자는 이동 횟수를 입력한다.

- [x] 이동 횟수는 1 이상의 정수를 입력한다. - UserInputValue#inputCountNumber()
- [x] 입력한 이동 횟수가 1 이상의 정수인지 판별한다. - InputValueValidator#checkDigit()
- [x] 상기의 조건 외의 값을 입력할 경우, ``IllegalArgumentException`` 를 발생시키고 애플리케이션을 종료한다. - InputValueValidator
  - [x] 빈 칸을 입력하는 경우
  - [x] 0 혹은 음수를 입력하는 경우
  - [x] 정수 이외의 실수를 입력하는 경우
  - [x] 숫자 이외의 문자를 입력하는 경우

### 5. 경주를 실행시킨 후, 그 결과를 표기한다.

- [x] 각 자동차별로 단위 횟수마다 전진 여부를 결정한다. - CarEngine#moveCar()
  - [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - [x] 전진하는 조건은 ``pickNumberInRange()``를 사용해서 판별한다.
- [x] 각 자동차별로 전진할 경우, "-" 표시를 추가해서 몇 번 전진했는지 출력한다. - CarEngine#countMovement()
- [x] 사용자가 입력한 이동 횟수에 도달한 자동차를 판별한다. - CarEngine#arrive()
- [x] 먼저 도달한 자동차의 이름을 메시지로 출력한 다음, 프로그램을 종료한다. - CarEngine#finishRace()

---

## 추가 기능 고려

### 1. 재시작 기능

### 2. 이동 횟수 최댓값 제한 기능