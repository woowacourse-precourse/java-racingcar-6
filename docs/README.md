# 🏎️ 자동차 경주 🏁

## 🛠 기능 목록

### GameController
- [x] 게임을 실행한다. `void run()`
- [x] 게임의 초기값을 설정한다.
  - 자동차 이름을 입력 받아, 자동차를 생성한다.
  - 시도 횟수를 입력 받는다.
- [x] 게임을 진행한다.
  - 각 자동차를 전진시킨다.
  - 차수별 실행 결과를 출력한다.
  - 시도 횟수를 1 차감한다.
  - 우승자를 선정하여 출력한다.

### Car
- [x] 자동차를 생성한다. `Car()`
- [x] 생성된 값이 4 이상인 경우 한 칸 전진한다. `void moveForward(int value)`

### RandomNumberGenerator 
- [x] 0~9 사이의 무작위 숫자를 생성한다. `int generate()`

### Referee
- [x] 각 자동차의 전진 횟수를 비교하여 최종 우승자를 결정한다. `List<Car> judge(List<Car> cars)`

### InputView
- [x] 경주할 자동차 이름을 입력 받는다. `List<String> readCarNames()`
- [x] 시도 횟수를 입력 받는다. `int readNumberOfAttempts()`

### OutputView
- [x] 실행 결과 문구를 출력한다. `void printRacingResultMessage()`
- [x] 차수별 실행 결과를 출력한다. `void printRacingResult()`
- [x] 최종 우승자를 출력한다. `void printWinners()`
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### Validation
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 자동차는 2대 이상 10대 이하만 가능하다.
- [ ] 자동차 이름은 1자 이상 5자 이하만 가능하다.
- [ ] 자동차 이름은 중복되지 않아야 한다.
- [x] 시도 횟수는 정수만 가능하다.
- [ ] 시도 횟수는 0보다 커야 한다. “최소 1회 이상 시도해야 합니다.”
- [ ] 시도 횟수는 최대 100회까지 허용한다.

## 실행 과정
<img src="racing flow.png">

## 🗣️ 요구 사항
- [ ] JDK 17 버전에서 실행 가능해야 한다.
- [ ] Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- [ ] indent depth를 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다. 
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다. 
- [ ] 구현한 기능이 정상 동작함을 테스트 코드로 확인한다.