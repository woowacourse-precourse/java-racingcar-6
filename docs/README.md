# 💡 진행 흐름 설명
- ```경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)``` 출력
- 경주 할 자동차 이름 입력 처리
  - 입력 예외 처리
- ```시도할 회수는 몇회인가요?``` 출력
- 시도 회수 입력 처리
  - 입력 예외 처리
- ```실행 결과``` 출력
  - n회차 경주 실행 처리
  ```
  자동차A : 
  자동차B : -
  자동차C : --
  ```
- 우승자 판별 처리
  - 어떤 자동차가 우승한지 판단
    - 우승: 가장 많이 전진한 자동차
- 최종 우승자 목록 출력
  - 인원 수에 따라 다음의 형식을 따른다.
  ```
  // 단독 우승
  최종 우승자 : pobi
  
  // 공동 우승
  최종 우승자 : pobi, jun
  ```

---

# 🔨 구현 기능 목록

### 경주 제어 기능(메인)
- 자동차 이름 입력 안내 메시지를 출력한다.
- 자동차 목록을 관리한다.
- 경주 회수를 관리한다.
- 시도 회수 입력 안내 메시지를 출력한다.
- 처리 결과 안내 메시지를 출력한다.

### 자동차 이름 입력 기능
- 경주 할 자동차 이름을 입력 받는다.
  - 이름은 쉼표(,) 기준으로 구분한다.
  - 이름은 5자 이하만 가능하다.
- 다음과 같은 경우 예외 처리를 한다.
  - 이름이 5자 초과인 경우
  - 이름이 공백인 경우
  
### 경주 회수 입력 기능
  - 경주를 시도할 회수를 입력 받는다.
  - 다음과 같은 경우 예외 처리를 한다.
    - 정수형 숫자가 아닌 경우
    - 음수 또는 0인 경우

### 전진 거리 판단 기능
  - 0 ~ 9 사이에서 무작위 값을 뽑아서 4 이상인 경우 1을, 미만인 경우 0을 반환한다.

### 자동차 이동 기능
  - 전진 여부 판단 기능 값에 따라 전진 처리를 한다.
  - 반환값을 기존 전진 거리에 더한다.

### 우승 자동차 지정 기능
  - 시도할 횟수를 모두 끝낸 후, 가장 많이 전진한 자동차가 우승한다.

### 우승 자동차 출력 기능
  - 우승자가 1명인 경우, 콤마 없이 단일 출력하기
  - 우승자가 2명 이상인 경우, 콤마를 넣어서 모두 출력하기

---

# 🔍 구현 메서드 목록

## 🚗 main/java/racingcar/*
### Application 클래스
- 경주 제어 기능
  - `void main(String[] args)`

- 전진 거리 지정 기능
  - `int setForwardStep()`

- 우승 기준 거리 탐색 기능
  - `int findWinnerForward(Car[] cars)`

- 우승 자동차 목록 생성 기능
  - `List<String> makeWinnerList(Car[] cars)`

- 우승 자동차 목록 출력 기능
  - `printWinner(List<String> winners)`

### Car 클래스
- 자동차 전진 기능
  - `void forward(int step)`

- 자동차 전진 거리 출력 기능
  - `void printForwardState()`

### UserInput 클래스
- 자동차 이름 입력 기능
  - `List<String> getCarNamesInput(String inputNames)`

- 경주 회수 입력 기능
  - `int getTryTimeInput(String inputTime)`

- 입력값 검사 기능
  - `boolean isNumberInteger(String input)`
  - `boolean isUnderSixDigit(List<String> inputs)`
  - `boolean isNotEmpty(List<String> inputs)`
  - `boolean isNumberOverZero(int input)`


## 🚗 test/java/racingcar/*
### RacingTest 클래스
  `void setForwardStep_랜덤값에_따라_전진값으로_1또는0_반환()`
  `void findWinnerForward_우승_기준_전진값을_찾아_반환()`
  `void makeWinnerList_우승_자동차_리스트_반환_단수()`
  `void makeWinnerList_우승_자동차_리스트_반환_다수()`
  `void setOutputStream()`: 출력을 콘솔이 아닌 ByteArrayOutputStream로 변경
  `void resetOutputStream()`: 출력을 다시 콘솔로 되돌림
  `void printWinner_우승_자동차_출력()`

### UserInputTest 클래스
  `void 회수가_숫자_아닌_경우_예외_처리()`
  `void 회수가_0보다_작은_경우_예외_처리()`
  `void 이름이_공백인_경우_예외_처리()`
  `void 자동차_이름_입력_기능()`
  `void 입력에_따른_리스트생성_보기()`
  `void 경주_회수_입력_기능()`

