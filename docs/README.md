**프로젝트 구조**

- controller
    - RacingController.java
- model
    - Car.java
- repository
    - CarRepository.java
- domain
    - CarRacingGame.java
- view
    - InputView.java
    - OutputView.java
- utils
    - StringUtils.java
    - InputValidator.java
    - RandomUtils.java

---

**구현할 기능 목록**

- **controller는 다음 기능을 포함한다.**
  - `view`와 `domain`을 연결하여 `application`에서 `controller`에만 접근하여 본 프로그램을 실행할 수 있도록 하는 기능
  - 총 시도횟수만큼 반복하는 반복문을 생성하여 domain 로직을 수행한 뒤 view를 통해 출력하는 기능
- **model은 다음 기능을 포함한다.**
  - `carName`과 `carPosition` 변수를 포함하는 `Car` 클래스
- **repository는 다음 기능을 포함한다.**
  - `Car` 객체의 값을 저장, 수정 및 반환하는 기능
- **domain은 다음 기능을 포함한다.**
  - 처음에 차 이름과 위치값 0을 `Car Repository` 에 save하는 기능
  - 각 레이싱 결과를 계산하여 `Car Repository` 값을 갱신하는 기능
  - 최종 우승 차 이름들을 리턴하는 기능
- **view는 다음 기능을 포함한다.**
  - `InputView` - 사용자에게 차 이름, 시도횟수 등의 입력값을 받는 기능
  - `OutputView` - 사용자에게 각 레이싱 결과, 우승자를 출력해주는 기능
- **utils는 다음 기능을 포함한다**
  - `StringUtils` - 문자열 타입 변환, split 등 문자열 처리에 관한 기능
  - `InputValidator` - 사용자에게 받은 입력값이 정수인지, 1~5글자인지 등을 검증하는 기능
  - `RandomUtils` - 0~9까지의 랜덤값을 생성하는 기능