# 미션 : 자동차 경주

## 기능 목록

### Car

- [x] 이름, 전진한 길이를 가진다.
- [x] 이동은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 을 이용하여 4이상이면 이동

### Cars

- Car이 모여있는 집합체이다.
- [x] Car들을 콜렉션에 담아둔다.

### InputView

- [x] 경주할 자동차의 이름들을 입력한다.(쉼표를 기준으로 구분)
    - [x] 잘못된 값을 입력 받으면 IllegalArgumentException 후 종료시킨다.
        -[x] 자동차의 이름 입력이 없는 경우
        -[x] 자동차 이름이 5자 이하가 아닌경우
- [x] 시도할 횟수를 입력 받는다.
    - [ ] 잘못된 값을 입력 받으면 IllegalArgumentException 후 종료시킨다.
        - 음수를 입력할경우
        - 정수가 아닌값을 입력할경우

### OutputView

- [x] 각 회차마다 이동한 실행결과를 출력한다.
- [x] 최종 우승자를 출력한다.
    - 만약 우승자가 복수라면 쉼표를 구분으로 출력한다.

### GameController

- 게임의 전체적인 흐름을 담당

### GenerageCarService

- [x] view에서 입력받은 자동차 이름을 토대로 car을 생성

### CarMovingService

- [ ] 생성된 cars로 회차에 대한 이동을 진행

### FindWinnerService

- [ ] 이동후 우승자 판별