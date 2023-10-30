# 기능 목록 작성

## `Name`

`String name` 을 래핑한 클래스

- [Exception] 이름이 1글자 미만이거나 5글자 이상이면 `IllegalArgumentsException`을 발생시킨다.
- [Exception] 공백 혹은 빈 문자열이 들어오면 `IllegalArgumentsException`을 발생시킨다.
- `name`을 반환할 수 있다.

---

## `MovingCount`

`int movingCount`를 래핑한 클래스

- 멤버 변수 movingCount를 증가시킬 수 있다.
- 다른 `MovingCount`와 비교 가능하다.
- `movingCount`를 반환할 수 있다.

---

## `Car`

`Name name`과 `MovingCount movingCount`를 멤버로 갖고있는 클래스

- 다른 `Car`객체와 `movingCount`로 서로 같은지 비교할 수 있다.
- 임의의 수가 기준 값보다 크면 `MovingCount`를 증가시킨다.
- 현재 경주 상태를 반환할 수 있다.
- 내림차순 정렬을 위한 정렬을 한다.

---

## `Cars`

`List<Car>`를 멤버로 갖고 있는 클래스

- 가장 큰 `movingCount`를 가진 `Car`객체를 반환할 수 있다.
- 멤버변수 `List<Car> cars`의 모든 `Car`객체에 임의의 수 와 기준 값을 넘겨 `movingCount`를 업데이트 할 수 있다.
- 멤버변수 `List<Car> cars`의 모든 `Car`객체의 경주 상태를 반환할 수 있다.

---

## `Attempts`

`int attemps`를 래핑한 클래스

- [Exception] 문자가 들어오면 `IllegalArgumentsException`을 발생시킨다.
- [Exception] 공백 혹은 빈 문자열이 들어오면 `IllegalArgumentsException`을 발생시킨다.
- `attemps`를 반환할 수 있다.

---

## `RacingController`

- 입력 받은 시도 횟수만큼 경주를 진행한다.
- 최종 우승자를 `List`형태로 반환할 수 있다 (여러명도 가능).

---

## `InputView`

- 사용자들의 자동차 이름을 입력받을 수 있다.
- 시도 횟수를 입력받을 수 있다.

## `OutputView`

- 최종 우승자를 출력할 수 있다.
- 현재 경주 상태를 출력할 수 있다.
