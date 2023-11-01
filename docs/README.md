## 🚀 구현 기능 목록

- [ ] 사용자가 입력한 자동차 이름을 기준 문자로 구분 - `NameSeparator#separateNamesByComma`
    - [ ] 예외) 이름이 5자 이하인지 - `Validator#validateNameLengthLessThanEqualToFive`
    - [ ] 예외) 이름을 빈 값으로 설정하지 않았는지 - `Validator#validateNameNotEmpty`
- [ ] 예외) 사용자가 몇 번의 이동을 할 것인지 입력한 값이 숫자인지 - `Validator#validateMoveCountNumber`
- [ ] 자동차들의 정보를 저장하고, 관리 - `CarManager`
- [ ] 자동차들에게 전진 명령 - `CarManager#orderCarsMoveForward`
- [ ] 자동차를 전진 - `Car#moveForward`
    - [ ] 0에서 9 사이의 무작위 값이 4 이상인 경우 전진
- [ ] 자동차 이름과 이동 횟수 반환 - `Car#getCurrentCondition`
- [ ] 우승자를 판단하는 기능 - `Referee#determineWinners`
