# 자동차 경주 게임

## 기능 목록

- [x] 각 자동차에 이름을 부여할 수 있다. CarGenerator#createCarList()
    - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다. Judgment#splitCarNames()
    - [x] 자동차 이름은 5자 이하만 가능하다. Judgment#validateCarNames()
- [x] 자동차는 전진 또는 멈출 수 있다. Car#moveOrStop()
    - [x] 0에서 9 사이에서 무작위 값을 생성한다. NumberGenerator#createRandomNumber()
    - [x] 전진하는 조건은 무작위 값이 4 이상일 경우이다.