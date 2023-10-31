### 💻 기능 요구 사항
- [X] 자동차 이름을 입력받는다. -> InputView, InputCarName
    - [X] 이름은 쉼표(,)로 구분한다.
    - [X] 이름은 5글자이하만 가능하다.
    - [X] 5글자보다 크면 입력시 예외를 발생시킨다.
- [X] 게임 횟수 입력받기 -> Controller, TryNumber
    - [X] 숫자가 아닐 경우 예외를 발생시킨다.
- [X] 자동차 객체 생성 -> RacingCar, Car
    - [X] 이름을 가진다.
    - [X] 이름은 5글자 이하이다.
    - [X] 위치값을 가진다.
- [X] 0~9 사이의 랜덤값을 생성한다. -> RandomNumberFactory
- [X] 랜덤값이 4이상일 때 자동차를 전진시킨다. -> Car
    - [X] 전진값은 1이다.
- [X] 각 차수별 실행 결과를 출력한다. -> OutputView
    - [X] 자동차 이름과 위치값을 출력한다.
- [X] 주어진 횟수만큼 게임을 실행 후 종료한다. -> Controller
- [X] 우승자를 구한다. -> Winner
- [X] 우승자를 출력한다. -> OutputView
    - [X] 우승자는 1명이상일 수 있다.
    - [X] 우승자가 여러 명일 경우 쉼표로 구분한다.

### 프로그래밍 요구사항
- [X] build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
    - [X] while문 안에 if문이 있으면 들여쓰기는 2이다.
- [X] 3항 연산자를 쓰지 않는다.
- [X] ```JUnit 5와 AssertJ```를 이용하여 테스트 코드를 작성한다.
- [X] 랜덤값 : camp.nextstep.edu.missionutils.Randoms의 ```pickNumberInRange()```를 활용
- [X] 입력값 : camp.nextstep.edu.missionutils.Console의 ```readLine()```을 활용

### ⚠ 과제 제출 전 체크 리스트
- [X] 자바 17버전인지 확인(```java -version```)
- [X] 테스트코드 통과 확인(```./gradlew clean test```)
