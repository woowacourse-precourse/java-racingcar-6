# ****❗ 기본 제약****

---

1. 모든 변수는 private
    1. 모든 변수는 SET/GET으로만 접근 가능하다.
2. 모든 메서드는 public & private
3. indent(인덴트, 들여쓰기) depth 3 미만이다.
    1. ex) while문 안에 if 문 들어있으면 depth는 2
    2. 메서드를 분리해보기
4. 3항 연산자를 사용하지 않는다.
5. 메서드가 한가지 일만 하도록 작게 만든다.
6. JUnit 5 / AssertJ 이용해서 본인이 정리한 ****🛠기능목록****이 정상 동작함을 테스트 코드로 확인한다.
    1. `test/java/study` 참고하여 테스트 도구 사용법 학습 후 테스트 구현

# ****🛠 기능 목록****

---

## 🏎 Car `Class Car` 

- 변수
    - `String name`
    - `int position`
- 메서드
    - `void move(int distance)` 
        - 차 위치 이동 ✔
    - `void showPosition()`
      - 차 위치 이동 표시 ✔

## 🎮 Game `Class Game`

- 변수
    - `int trial`
    - `List <Car> cars`
- 메서드
    - `void setCars(List<String> carsName)`
      - cars 리스트 생성 ✔
    - `void playGame()`
      - 시도 횟수만큼 실행하기 ✔
    - `void playRound()`
      - 각 차수 별 실행 결과 출력하기 ✔
    - `int getRandomNumber()`
      - 무작위 숫자 반환 ✔
      - ex) `Randoms.pickNumberInRange(0,9);`
          - from) [README.md](..\README.md)


## 🚦 Game Manager `Class GameManager`

- 메서드
  - `List<String> inputListCarsName()`
    - 경주 자동차 이름 입력받기 ✔
  - `void checkValidationListCarNames(List<String> input)`
    - list 형태 예외처리 ✔
  - `String inputStringCarsName()`
    - String 형태 입력받기 ✔
  - `void checkValidationStringCarNames(String input)`
    - String 형태 예외처리 ✔
  - `int inputTrial()`
    - 시도횟수 입력받기 ✔
  - `void checkValidationTrial(String input)`
    - trial 예외처리
  - `void findWinner(List <Car> cars)`
    - 우승자 찾기 ✔
    - `comparePosition` , `judge`
      - 우승자 판별 & 출력 ✔

## 🚧 Validator `Class Validator`
예외 처리 검증
- 변수
  - `int CAR_NAME_MIN`
    - 차 이름 최소 길이
  - `int CAR_NAME_MAX`
    - 차 이름 최대 길이
- 메서드
  - `void checkListCarNames(List<String> carsName)`
    - list 형태 예외처리 ✔
      - `void checkCarNameLength(List<String> carsName)`
        - 길이 5 이상일 때 ✔
      - `void checkListDuplication(List<String> carsName)`
        - 같은 이름이 있을 때 ✔
    
  - `void checkStringCarNames(String input)`
    - string 형태 예외처리 ✔
    - `void checkEmpty(String input)`
      - 값이 입력 안됬을 때 ✔
    - `void checkLastIndex(String input)`
      - , 와 , 사이에 입력이 없을 때 ✔
    
  - `checkTrial(String input)`
    - trial 예외처리 ✔
    - `void checkEmpty(String input)`
      - 값이 입력되지 않았을 때 ✔
    - `void checkChar(String input)`
      - 숫자가 입력 되지 않았을 때 ✔

## 💻 Application `Class Application`
기본 클래스 객체 생성 & 게임 실행 ✔

## 📋 기능 테스트 `ApplicationTest.java`
- 입출력 기능 테스트 `RacingGameTest.java`
- 예외처리 기능 테스트 `ValidatorTest.java`
  - `void String_이름에_대한_빈문자_처리()`
  - `void String_이름에_대한_공백_처리()`
  - `void List_이름에_대한_5글자초과_처리()`
  - `void List_이름에_대한_중복_처리()`
  - `void List_이름에_대한_공백_처리()`
  - `void 시도횟수_빈문자_처리()`
  - `void 시도횟수_문자_처리()`

# ****📝 피드백****

---

- 10/30
  - 🚀 기능요구사항
    - 게임 진행 완성
    - 예외처리 미완성
  - 🎯 프로그래밍 요구사항
    - 예외 테스트 X
    - 함수 하나하나가 최대한 작게 고쳐볼것
    - 기능목록 테스트 공부 & 구현 필요
  - ✏ 추가사항
    - Validator.class 수정
    - GameManager.java 간단하게 수정

- 10/31
  - 🚀 기능요구사항
    - 예외처리 완성 ✔
  - 🎯 프로그래밍 요구사항
    - 함수를 최대한 작게 고쳤음
    - 기능목록 테스트 구현 필요
  - ✏ 추가사항
    - Validator 단위테스트 구현
    - 게임 기능 단위테스트 구현