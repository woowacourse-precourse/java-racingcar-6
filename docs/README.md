# :notebook_with_decorative_cover: 우아한테크코스 프리코스 2주차 : 자동차 경주

## 목차

- [1. 구현 기능 목록](#ballotboxwithcheck-구현-기능-목록) 
- [2. 문제 해결 과정](#bookmark_tabs-문제-해결-과정)
  - [2.1 🧪 1주차 미션 피드백과 적용 사항](#-1주차-미션-피드백과-적용-사항)
  - [2.2 ❓ DTO와 VO의 차이](#-dto와-vo의-차이)
  - [2.3 🧐 Arrays.asList vs List.of](#-arraysaslist-vs-listof)
  - [2.4 🚗 `RacingCar` 클래스의 유효성 검사와 정규 표현식](#-racingcar-클래스의-유효성-검사와-정규-표현식)
- [3. 다음 미션에 적용할 학습 내용](#ledger-다음-미션에-적용할-학습-내용) 

# :ballot_box_with_check: 구현 기능 목록
- [ ] controller Package
    - [ ] RacingCarGameController
        - view Package와 domain Package의 데이터를 전달하며 값을 출력하는 클래스
        - 프로그램을 실행하는 `run` 메서드
        - RacingCar객체를 반환하여 자동차 이름을 받아오는 `loadCarNames` 메서드
        - TryCount객체를 반환하여 시도 회수를 받아오는 `loadTryCount` 메서드
        - 게임을 진행시키는 `playGame` 메서드


- [ ] domain Package
    - [x] RacingCar
        - 게임을 위해 입력한 자동차 이름에 대해서 유효성 검사와 값의 반환을 담당하는 일급 컬렉션
        - 입력값이 영어와 한글인지 확인하는 (대문자와 소문자 영어, 한글만 가능하고 그 외의 숫자, 기호, 스페이스 바는 예외처리) `validateCarNames` 메서드
        - 입력값에 중복된 값이 있는지 확인하는 `validateDuplicate` 메서드
        - 입력한 값이 5자리 이하인지 확인하는 `validateRange` 메서드
        - 입력값을 꺼낼 수 있는 `getCarNames` 메서드
    - [x] TryCount
        - 시도할 회수에 대한 유효성 검사와 값의 반환을 담당하는 클래스
        - user가 입력한 값이 1 이상의 수 인지 확인하는 `validateRange` 메서드
        - 입력값을 꺼낼 수 있는 `getTryCount` 메서드
    - [ ] RandomNumber
        - 전진하는 조건이 되는 번호를 생성하고 전진 여부를 판단하는 클래스
        - 전진하는 조건이 되는 번호를 생성하는 `generateNumber` 메서드
        - 전진이 가능한지 판단하는 `isMovePossible` 메서드


- [x] handler Package
    - [x] InputHandler
        - view Package의 ConsoleInput의 확장성과 변경 용이성을 위한 인터페이스
        - `inputCarNames` 메서드의 추상화
        - `inputTryCount` 메서드의 추상화
    - [x] OutputHandler
        - view Package의 ConsoleOutput의 확장성과 변경 용이성을 위한 인터페이스
        - `printGameProgress` 메서드의 추상화
        - `printGameResult` 메서드의 추상화
    - [x] ErrorHandler
        - Enum 클래스를 활용하여 프로그램에서 발생하는 에러 코드들을 관리하는 클래스
        - ErrorMessage와 함께 `IllegalArgumentException` 예외를 발생시키는 `getException` 메서드
    - [x] ConstantsHandler
        - 프로그램내의 상수들을 관리하는 클래스


- [ ] service Package
    - [ ] RacingCarGameService
        - 자동차 경주 게임에 대한 비즈니스 로직을 담당하는 클래스
        - 자동차 경주 게임의 각 차수별 진행을 담당하는 `racingCarGameProgress` 메서드
        - 자동차 경주 게임의 최종 우승자를 반환하는 `racingCarGameResult` 메서드


- [ ] view Package
    - [x] ConsoleInput
        - 입력을 담당하는 클래스
        - 경주 할 자동차 이름을 입력받는다. 단, 이름은 쉼표(,) 기준으로 구분하는 `inputCarNames` 메서드 구현
        - 시도할 회수를 입력하는 `inputTryCount` 메서드 구현
        - string의 입력을 List로 변환하는 `stringToList` 메서드 구현
        - string의 입력을 int로 변환하는 `stringToInt` 메서드 구현
    - [ ] ConsoleOutput
        - 출력을 담당하는 클래스
        - 각 차수별 실행 결과를 출력하는 `printGameProgress` 메서드 구현
        - 최종 우승자를 출력하는 `printGameResult` 메서드 구현

---

# :bookmark_tabs: 문제 해결 과정

## 🧪 1주차 미션 피드백과 적용 사항

➡️ 2주차 미션에서는 1주차 미션에서 적용하고 싶었던 내용들을 적용해보는 시간을 가졌다.

1. 테스트 코드는 마지막이 아닌 기능이 완성되는 경우 바로 작성을 하도록 했고 이를 통해, 놓치고 있는 예외 사항에 대해서 체크할 수 있다는 사실을 알 수 있었다. 다만 구현에 걸리는 시간이 오래 걸렸기 때문에 상황에 맞게 사용하는 것이 좋겠다는 생각을 가졌다.


2. 커밋 주기를 메서드별 커밋이 아닌 기능별 커밋으로 적용했다. 메서드별 커밋을 할 때 보다 커밋 하는 부분에 대해서 고민이 많이 줄어들었다. 기능별 커밋을 하더라도 메서드가 다른 메서드를 의존하지 않는다면 하나의 메서드가 곧 기능이 되기 때문에 메서드별 커밋을 할 때와 큰 차이가 없었고, 의존하는 경우 커밋 시점을 고민하지 않아도 되기 때문에 앞으로의 미션은 기능별 커밋을 적용하기로 했다.


3. 2주 차 미션에서는 처음 커밋 하게 되는 구현 기능 목록을 처음부터 자세하게 작성함으로써 프로젝트의 전체적인 구조를 설계하고 시작했다. 인터페이스의 경우는 결합도를 느슨하기 위해서 사용하는 것이 좋다고 생각했고, 프로젝트의 구조를 더 명확하게 파악하기 위해서 UML을 그려봐야겠다고 생각했다.

➡️ 1주차 미션이 끝나고 코드 리뷰를 하며 저번 미션에 고민하던 부분에 대한 피드백을 받을 수 있었다. 피드백을 통해 2주차 미션에서는 `ConstantsHandler`로 상수들을 관리하는 클래스를 만들었다.

🔸 (리뷰어) : 3은 숫자 야구의 길이를 의미하는데, 3을 가진 상수가 여러 번 선언되어있는 것 같습니다. 같이 변경되는 상수라면 같은 변수를 참고하는 게 좋지 않을까요?

🔹 (본인) : 마침 제가 딱 고민하던 부분입니다! 말씀하신 것과 같이 3은 여러 클래스에서 사용하게 되는데 이런 경우 constants 혹은 util 이라는 package를 만들어서 관리할 수 있다고 생각했습니다. 하지만, 매직 넘버를 의미를 알 수 있도록 상수화 해주더라도 어떤 값으로 사용되었는지 직관적으로 파악할 수 있도록 클래스 상단에 작성하는게 좋지 않을까 라는 생각이 들더라고여🤔 혹시 이 부분에 대해서 어떻게 생각하시나요!?

🔸 (리뷰어) : 변수명을 잘 정해주면 무리 없다고 생각합니다. BASEBALL_LENGTH와 같이 도메인 차원의 네이밍을 하면 어느 클래스든지 의미를 파악할 수 있다고 생각해요. 저한테는 변경이 발생했을 경우 유지보수성이 떨어지는 부정적 측면이 더 커보입니다.

## ❓ DTO와 VO의 차이

🔹 코드 리뷰를 하면서 DTO를 사용한 코드를 많이 볼 수 있었다. 개인적으로 미션에서 DTO를 사용할 만한 부분이 보이지 않았었는데 문득 DTO와 VO의 정확한 차이를 모르고 있다는 생각이 들었다. 

DTO와 VO에 대해서 알아보며 느꼈던 점은 Data를 전달하는 객체로 동일한 개념을 갖고 있지만, VO는 값 자체를, DTO는 Data를 전달한다는 차이점을 알게 되었다. 즉, DTO는 getter/setter 두 가지의 메서드만 존재해야 하지만 VO의 경우는 불변성을 위해서 setter가 없어야 하고 다른 로직이 들어가도 된다고 이해했다. 그렇다면 미션에서는 VO를 통해 내부적으로 validate와 같은 유효성 검사 로직을 구현해도 좋고, DTO를 활용한다면 외부의 Validator 클래스를 두고 호출을 통해 검증하는 과정을 만든다면 어느 방식을 사용해도 괜찮다는 결론을 내렸다.

## 🧐 Arrays.asList vs List.of

🔹 저번 미션에서는 배열을 리스트로 변환할 때 `Arrays.asList`를 사용했지만 이번 미션을 진행하면서 `List.of`를 알게 되었다. 단순하게 둘은 같은 타입을 반환할 것이라고 생각했지만, 전혀 다른 타입을 반환한다는 사실에 놀랐다. 이 두 함수에 대해서 좀 더 자세하게 알아볼 필요성을 느끼게 되었다.

1. `.collect(Collectors.toList())`:

stream을 사용하여 데이터를 처리한 후, .collect(Collectors.toList())를 사용하면 ArrayList를 반환한다. 이 ArrayList는 변경 가능하며 요소를 추가, 제거 또는 변경할 수 있다.

2. `Arrays.asList()`:

`Arrays.asList()`를 사용하여 배열을 List로 변환하면 java.util.Arrays.ArrayList의 인스턴스를 반환한다. 이 ArrayList는 수정할 수 없으며 요소를 추가 또는 제거할 수 없다. 즉, 크기가 고정된 리스트.

3. `List.of()`:

`List.of()`를 사용하면 수정할 수 없는 불변한 List를 반환한다. 이 List는 크기가 고정되어 있으며 요소를 추가, 제거 또는 변경할 수 없다. 

🔹 학습을 진행하면서 `.collect(Collectors.toList())` 도 같은 타입을 반환할지 궁금해서 추가해서 학습하게 되었고 위와 같은 결과를 얻게 되었다. 추가적인 사실로는 `Arrays.asList()`는 `List.of()`보다 힙에 더 많은 개체를 생성하기 때문에 더 많은 오버헤드 공간을 차지한다. 따라서, 단지 값 요소가 필요한 경우라면 `List.of()`가 적합하다 라는 내용에 이번 미션은 `List.of()`를 활용했다.

```java
// 중략
public class ConsoleInput implements InputHandler {

    // 중략

    private List<String> stringToList(String input) {
        try {
            return List.of(input.split(","));
        } catch (Exception e) {
            throw INVALID_INPUT.getException();
        }
    }

    // 중략
}
```

## 🚗 `RacingCar` 클래스의 유효성 검사와 정규 표현식

🔹 `domain package`의 `RacingCar`의 코드를 작성하면서 유효성 검사와 정규 표현식에 대한 고민을 했다. 문제의 요구사항에는 자동차의 이름으로 한글, 스페이스 바 등의 입력이 가능한지 명시되어 있지 않았기 때문에 이런 부분은 개인적으로 판단해서 해결해야겠다고 생각했다. 

**예외 사항으로 체크한 항목**

1. 자동차 이름으로 가능한 것은 소문자와 대문자 영어, 한글만 가능하도록 했다. 보통의 자동차 이름은 현대, BMW와 같이 숫자, 스페이스바, 기타 기호가 들어가지 않기 때문에 앞에서 말한 값에 대한 예외가 발생하도록 처리했다. 이런 부분에 대해서 예외 처리를 함으로써 ,가 두번 들어가는 부분에 대해서도 처리가 가능했다. 이에 대한 정규 표현식은 아래와 같이 적용해 보며 활용했다. 

https://user-images.githubusercontent.com/122594223/278618923-23df4374-4c29-4ff0-8e63-0129f37585eb.mp4

2. 각 자동차의 이름이 중복되지 않도록 했다.

3. 요구사항에 나와있던 입력이 5자 이하가 아닌 경우 예외가 발생하도록 했다.

---

# :ledger: 다음 미션에 적용할 학습 내용
