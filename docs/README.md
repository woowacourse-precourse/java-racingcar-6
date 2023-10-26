# :notebook_with_decorative_cover: 우아한테크코스 프리코스 2주차 : 자동차 경주

## 목차

- [1. 구현 기능 목록](#ballotboxwithcheck-구현-기능-목록) 
- [2. 문제 해결 과정](#bookmark_tabs-문제-해결-과정)
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


- [ ] handler Package
    - [ ] InputHandler
        - view Package의 ConsoleInput의 확장성과 변경 용이성을 위한 인터페이스
        - `inputCarName` 메서드의 추상화
        - `inputTryCount` 메서드의 추상화
    - [ ] OutputHandler
        - view Package의 ConsoleOutput의 확장성과 변경 용이성을 위한 인터페이스
        - `printGameProgress` 메서드의 추상화
        - `printGameResult` 메서드의 추상화
    - [ ] ErrorHandler
        - Enum 클래스를 활용하여 프로그램에서 발생하는 에러 코드들을 관리하는 클래스
        - ErrorMessage와 함께 `IllegalArgumentException` 예외를 발생시키는 `getException` 메서드


- [ ] service Package
    - [ ] RacingCarGameService
        - 자동차 경주 게임에 대한 비즈니스 로직을 담당하는 클래스
        - 자동차 경주 게임의 각 차수별 진행을 담당하는 `RacingCarGameProgress` 메서드
        - 자동차 경주 게임의 최종 우승자를 반환하는 `RacingCarGameResult` 메서드


- [ ] view Package
    - [ ] ConsoleInput
        - 입력을 담당하는 클래스
        - 경주 할 자동차 이름을 입력받는다. 단, 이름은 쉼표(,) 기준으로 구분하는 `inputCarName` 메서드 구현
        - 시도할 회수를 입력하는 `inputTryCount` 메서드 구현
    - [ ] ConsoleOutput
        - 출력을 담당하는 클래스
        - 각 차수별 실행 결과를 출력하는 `printGameProgress` 메서드 구현
        - 최종 우승자를 출력하는 `printGameResult` 메서드 구현

---

# :bookmark_tabs: 문제 해결 과정

---

# :ledger: 다음 미션에 적용할 학습 내용
