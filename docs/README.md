## ❏ TO-DO

### ❍ 기능 목록 🌱

- [x] 애플리케이션 실행 시, 경주를 시작할 준비를 한다. **- [ RaceController_#run() ]**
- [x] 자동차 이름을 입력하라는 문구를 출력한다. **- [ OutputView_#carNamesOutput()]**
- [x]  경주할 자동차의 이름을 쉼표를 기준으로 구분하여 입력받는다. **- [ InputView_#carNamesInput()]**
- [x]  잘못된 입력은 `IlleagalArgumentException`로 예외 처리 **- [ RaceService_#validateCarNamesInput()]**
    - [x]  입력이 공백인 경우, 예외 처리 **- [ RaceService_#validateEmptyInput() ]**
    - [x]  자동차의 이름이 5자를 초과한 경우, 예외 처리 **- [ RaceService_#validateLengthInput() ]**
    - [x]  자동차의 이름이 중복인 경우, 예외 처리 **- [ RaceService_#validateDuplicateInput() ]**
- [x]  각 자동차에 이름을 부여한다. **- [ RaceService_#createCars() ]**
- [ ]  몇 번의 이동을 할 것인지 입력받는다.
    - [ ]  입력이 숫자가 아닌 경우, 예외 처리
- [ ]  주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - [ ]  전진하는 조건은 0에서 9 사이에서 무작위 값을 구한다.
    - [ ]  무작위 값이 4 이상인 경우, 전진
    - [ ]  무작위 값이 4 미만인 경우, 정지
- [ ]  전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ]  자동차 게임을 완료한 후 누가 우승했는지 알려준다.
    - [ ]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ]  잘못된 입력으로 인한 예외 처리는 `IlleagalArgumentException` 을 발생시킨 후 애플리케이션은 종료되어야 한다.

<br />

### ❍ Check Point❗

- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ]  3항 연산자를 쓰지 않는다.
- [ ]  함수 (또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- [ ]  JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.