구현할 기능 목록

1. 경주할 자동차 이름 입력, 입력 시에 쉼표(,)를 기준으로 구분(잘못된 값 입력 시'IllegalArgumentException' 출력 후 종료, 각 상황에 맞는 예외출력 메시지)
2. 입력된 횟수 동안 n대의 자동차가 전진 or 멈춤
3. 각 자동차에는 이름을 부여할 수 있다. 전진 하는 자동차를 출력할 때 자동차 이름을 같이 출력
    - 자동차의 이름은 쉼표(,)를 기준으로 구분(자동차의 이름 5자 이하)
4. 몇 번 시도할 것인지 숫자 입력(틀린 입력값 'IllegalArgumentException' 출력 후 종료, 각 상황에 맞는 예외출력 메시지)
5. 무작위 값에서 4이상일 경우 전진
    - 모든 자동차에게 각각 실시
6. 결과
    - 가장 많이 전진한 자동차가 우승 -> 우승 자동차 출력
    - 단, 전진한 횟수가 같다면 공동우승 가능 -> 우승 자동차들을 쉼표(,)로 구분하여 출력
7. 종료(재시작 없음)

시스템 흐름
1. main()에서 RacingCar 인스턴스를 생성 후 run()이 실행된다.
2. 차의 이름들을 입력한다.
3. 숫자를 입력한다.
4. 입력한 횟수만큼 각 차들에서 랜덤으로 전진
5. 모든 횟수가 끝난 뒤 가장 멀리간 자동차가 우승
6. 우승 자동차 이름 출력

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 종료시에 System.exit()을 호출하지 않는다.