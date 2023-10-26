# :notebook_with_decorative_cover: 우아한테크코스 프리코스 2주차 : 자동차 경주

## 목차

- [1. 구현 기능 목록](#ballotboxwithcheck-구현-기능-목록) 
- [2. 문제 해결 과정](#bookmark_tabs-문제-해결-과정)
  - [2.1 ❓ DTO와 VO의 차이](#-dto와-vo의-차이)
  - [2.2 🧐 Arrays.asList vs List.of](#-arraysaslist-vs-listof)
- [3. 다음 미션에 적용할 학습 내용](#ledger-다음-미션에-적용할-학습-내용) 

# :ballot_box_with_check: 구현 기능 목록
- [ ] controller Package
    - [ ] RacingCarGameController
        - view Package와 domain Package의 데이터를 전달하며 값을 출력하는 클래스
        - 프로그램을 실행하는 `run` 메서드
        - RacingCar객체를 반환하여 자동차 이름을 받아오는 `loadCarName` 메서드
        - TryCount객체를 반환하여 시도 회수를 받아오는 `loadTryCount` 메서드
        - 게임을 진행시키는 `playGame` 메서드


- [ ] domain Package
    - [ ] RacingCar
        - 게임을 위해 입력한 자동차 이름에 대해서 유효성 검사와 값의 반환을 담당하는 일급 컬렉션
        - 입력값이 영어와 한글, 숫자 외의 값인지 확인하는 `validate` 메서드
        - 입력값에 중복된 값이 있는지 확인하는 `validateDuplicate` 메서드
        - 입력한 값이 5자리 이하인지 확인하는 `validateRange` 메서드
        - 입력값을 꺼낼 수 있는 `getCarName` 메서드
    - [ ] TryCount
        - 시도할 회수에 대한 유효성 검사와 값의 반환을 담당하는 클래스
        - 입력값이 숫자가 맞는지 확인하는 `validate` 메서드
        - user가 선택한 값이 int타입의 범위를 넘어가는지 확인하는 `validateRange` 메서드
        - 입력값을 꺼낼 수 있는 `getTryCount` 메서드
    - [ ] TargetNumber
        - 전진하는 조건이 되는 번호를 생성하고 전진 여부를 판단하는 클래스
        - 전진하는 조건이 되는 번호를 생성하는 `generateNumber` 메서드
        - 전진이 가능한지 판단하는 `isMovePossible` 메서드


- [x] handler Package
    - [x] InputHandler
        - view Package의 ConsoleInput의 확장성과 변경 용이성을 위한 인터페이스
        - `inputCarName` 메서드의 추상화
        - `inputTryCount` 메서드의 추상화
    - [x] OutputHandler
        - view Package의 ConsoleOutput의 확장성과 변경 용이성을 위한 인터페이스
        - `printGameProgress` 메서드의 추상화
        - `printGameResult` 메서드의 추상화
    - [x] ErrorHandler
        - Enum 클래스를 활용하여 프로그램에서 발생하는 에러 코드들을 관리하는 클래스
        - ErrorMessage와 함께 `IllegalArgumentException` 예외를 발생시키는 `getException` 메서드


- [ ] service Package
    - [ ] RacingCarGameService
        - 자동차 경주 게임에 대한 비즈니스 로직을 담당하는 클래스
        - 자동차 경주 게임의 각 차수별 진행을 담당하는 `RacingCarGameProgress` 메서드
        - 자동차 경주 게임의 최종 우승자를 반환하는 `RacingCarGameResult` 메서드


- [ ] view Package
    - [x] ConsoleInput
        - 입력을 담당하는 클래스
        - 경주 할 자동차 이름을 입력받는다. 단, 이름은 쉼표(,) 기준으로 구분하는 `inputCarName` 메서드 구현
        - 시도할 회수를 입력하는 `inputTryCount` 메서드 구현
        - string의 입력을 List로 변환하는 `stringToList` 메서드 구현
        - string의 입력을 int로 변환하는 `stringToInt` 메서드 구현
    - [ ] ConsoleOutput
        - 출력을 담당하는 클래스
        - 각 차수별 실행 결과를 출력하는 `printGameProgress` 메서드 구현
        - 최종 우승자를 출력하는 `printGameResult` 메서드 구현

---

# :bookmark_tabs: 문제 해결 과정

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

---

# :ledger: 다음 미션에 적용할 학습 내용
