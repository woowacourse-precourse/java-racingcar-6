## 기능 목록
- [ ] 입력받은 이름들을 토대로 각 자동차에 이름을 부여한다. - RacingCarProvider
    - [x] 올바른 입력인지 확인한다. - RacingCarProvider #validate
        - [x] 각 이름이 5자 이하인지 확인한다. - RacingCarProvider #isValidLength
    - [ ] 해당 개수만큼 자동차를 생성한다. - RacingCarProvider #getRacingCars
        - [ ] 각 자동차에 이름을 부여한다. - RacingCar #createRacingCar


- [ ] 0부터 9 사이의 무작위 값을 생성한다. - NumberGenerator #createRandomNumbers


- [ ] 자동차를 전진시킨다(전진 횟수를 1 증가시킨다). - RacingGame #move


- [ ] 우승자를 확인한다.
    - [ ] 가장 많은 전진 횟수를 가진 자동차를 확인한다. - RacingGame #getWinner


## 기능 요구 사항
자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

각 자동차에 이름을 부여할 수 있다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun