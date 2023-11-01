## 🚀 구현 기능 목록

- [x] 사용자가 입력한 자동차 이름을 기준 문자로 구분 - `NameSeparator#separateNamesByComma`
    - [x] 예외) 이름이 5자 이하인지 - `Validator#validateNameLengthLessThanEqualToFive`
    - [x] 예외) 이름을 빈 값으로 설정하지 않았는지 - `Validator#validateNameNotBlank`
    - [x] 예외) 이름 마지막 글자가 쉼표인지 - `Validator#validateNotEndsWithComma`
- [x] 예외) 사용자가 몇 번의 이동을 할 것인지 입력한 값이 자연수인지 - `Validator#validateMoveCountNaturalNumber`
- [x] 자동차들의 정보를 저장하고, 관리 - `CarManager`
  - [x] 자동차들에게 전진 명령 - `CarManager#orderCarsMoveForward`
- [x] 자동차 개별 객체 - `Car`
  - [x] 자동차를 전진 - `Car#moveForward`
      - [x] 0에서 9 사이의 무작위 값이 4 이상인 경우 전진
  - [x] 자동차 이름과 이동 횟수 반환 - `Car#getCurrentCondition`
- [ ] 우승자를 판단하는 기능 - `Referee#determineWinners`
