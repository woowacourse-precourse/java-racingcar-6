## 자동차 경주 - 기능 목록

---

1. **사용자 입력 처리**
    - [x] 사용자로부터 자동차 이름을 입력 받는 기능 👉 `view#InputView#inputCarNames()`
        - [x] 테스트: 쉼표(,)로 구분된 문자열 입력 시 올바르게 이름 목록으로 변환되는지 확인
        - [x] 테스트: 이름이 5자 이하인 경우 올바르게 이름 목록으로 반환되는지 확인
        - [x] 테스트: 이름이 5자를 초과할 경우 `IllegalArgumentException`이 발생하는지 확인
    - [x] 사용자로부터 시도할 회수를 입력 받는 기능 👉 `view#InputView#inputAttemptCount()`
        - [x] 테스트: 정수를 입력했을 때 정상적으로 회수로 반환되는지 확인
        - [x] 테스트: 문자나 음수 등 잘못된 형식의 입력 시 `IllegalArgumentException`이 발생하는지 확인

2. **자동차 객체**
    - [x] 자동차 이름을 가진다. 👉 `domain#Car#Car(String name)`, `domain#Car#getName()`
        - [x] 테스트: 자동차 객체 생성 시 주어진 이름을 정확히 저장하는지 확인
    - [x] 자동차는 전진할 수 있다. 👉 `domain#Car#move()`
        - [x] 테스트: 전진 명령을 내렸을 때 자동차의 위치가 1 증가하는지 확인
    - [x] 자동차는 현재 위치(전진 횟수)를 가진다. 👉 `domain#Car#getPosition()`
        - [x] 테스트: 자동차의 현재 위치를 올바르게 반환하는지 확인

3. **자동차 전진 조건 체크**
    - [x] 0에서 9 사이의 무작위 값을 구하는 기능 👉 `utils#RandomGenerator#generateNumber()`
        - [x] 테스트: 생성된 무작위 값이 0~9 사이인지 확인
    - [x] 무작위 값이 4 이상인 경우에만 전진하는 기능 👉 `domain#Car#tryMove()`
        - [x] 테스트: 값이 4 이상일 때 자동차가 전진하는지 확인
        - [x] 테스트: 값이 4 미만일 때 자동차가 전진하지 않는지 확인

4. **경주 진행**
    - [x] 주어진 횟수 동안 모든 자동차에 대해 전진 시도를 하는 기능 👉 `domain#Race#startRace()`
        - [] 테스트: 지정된 횟수만큼 경주가 진행되는지 확인
        - [] 테스트: 경주 중 각 자동차의 전진 조건이 올바르게 적용되는지 확인

5. **출력 기능**
    - [x] 각 차수별 실행 결과 출력 기능 👉 `view#ResultView#printRaceResult(List<Car> cars)`
        - [ ] 테스트: 주어진 자동차의 상태에 따라 올바르게 출력 문자열이 생성되는지 확인
    - [x] 단독 우승자 안내 문구 출력 기능 👉 `view#ResultView#printWinner(List<Car> winners)`
        - [ ] 테스트: 단독 우승자 안내 문구가 올바르게 출력되는지 확인
    - [x] 공동 우승자 안내 문구 출력 기능 👉 `view#ResultView#printWinner(List<Car> winners)`
        - [ ] 테스트: 공동 우승자 안내 문구가 올바르게 출력되는지 확인

6. **우승자 확인**
    - [ ] 가장 멀리 전진한 자동차(들)을 찾는 기능 👉 `domain#Race#findWinners()`
        - [ ] 테스트: 주어진 자동차 목록 중 가장 멀리 전진한 자동차(들)이 정확히 반환되는지 확인
    - [ ] 우승자가 여러 명일 경우 쉼표(,)로 구분하여 반환하는 기능 👉 `domain#Race#findWinners()`
        - [ ] 테스트: 여러 명의 우승자가 올바르게 쉼표(,)로 구분되어 반환되는지 확인

7. **예외 처리**
    - [x] 자동차 이름이 5자를 초과할 경우의 예외 처리 👉 `exception#InvalidCarNameException#validateNameLength()`
        - [x] 테스트: 5자를 초과하는 이름으로 자동차 객체를 생성하려 할 때 `IllegalArgumentException`이 발생하는지 확인
    - [x] 사용자 입력값이 잘못된 경우의 예외 처리 👉 `exception#InvalidAttemptCountException#validateAttempCount()`
        - [x] 테스트: 잘못된 형식의 입력(예: 문자, 음수) 시 `IllegalArgumentException`이 발생하고 프로그램이 종료되는지 확인
   - [x] 자동차 이름이 중복된 경우의 예외 처리 👉 `exception#InvalidCarNameException#validateUniqueNames(List<String> names)`
      - [x] 테스트: 중복된 이름으로 자동차 객체를 생성하려 할 때 `IllegalArgumentException`이 발생하는지 확인

8. **자동차 목록 변환**
   - [x] 자동차 이름 목록을 `List<Car>` 객체로 변환하는 기능 👉 `domain#CarFactory#fromNameString(String namesString)`
      - [x] 테스트: 주어진 자동차 이름 목록을 바탕으로 올바르게 `List<Car>` 객체가 생성되는지 확인
   - [x] `List<Car>` 객체를 자동차 이름 목록으로 변환하는 기능 👉 `domain#CarFactory#toNameString(List<Car> cars)`
      - [ ] 테스트: 주어진 `List<Car>` 객체를 바탕으로 올바르게 자동차 이름 목록이 추출되는지 확인