# [ 기능 목록 ]

### Input

- [x]  플레이어로부터 이동 횟수를 입력받는다.
    - [x]  `[예외]` 숫자가 아닌 경우 IllegalArgumentException
    - [x]  `[예외]` 0인 경우 IllegalArgumentException
- [x]  경주할 자동차 이름을 입력받는다.
    - [x]  `[에외]` 자동차 개수가 1개 이하인 경우 IllegalArgumentException
    - [x]  `[예외]` 자동차 이름이 5자 초과인 경우 IllegalArgumentException
    - [x]  `[예외]` 자동차 이름 값이 없는 경우 IllegalArgumentException
    - [x]  `[예외]` 자동차 이름이 공백인 경우 IllegalArgumentException
    - [x]  `[예외]` 자동차 이름에 공백이 포함된 경우 IllegalArgumentException

### Racing-car

- [x]  플레이어로부터 입력받은 이동 횟수만큼 게임을 진행한다.
- [x]  0에서 9사이의 무작위 값을 추출한다.
- [x]  무작위 값이 4이상인 경우 해당 자동차를 전진시킨다.
- [x]  경주가 끝나면, 우승자를 반환한다.
    - [x]  가장 많이 전진한 자동차를 찾는다.
    - [x]  해당 자동차들의 이름을 반환한다.

### Output

- [x]  자동자 경주 시작 문구를 출력한다
- [x]  실행결과를 출력한다
    - [x]  각 자동차의 전진 상태를 출력한다.
- [x]  우승자를 출력한다
    - [x]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
