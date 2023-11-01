# 🚗 자동차 경주 게임 🚗

## 🚨 게임 진행 방식 🚨

- 자동차 경주에 참여할 자동차의 이름을 쉼표 (,)로 구분하여 입력한다.
    - 이때 한 자동차의 이름은 다섯 글자가 이하여야 한다.
- 자동차 경주가 반복될 횟수를 입력한다.
    - 자동차의 경주 횟수는 자연수로 입력해야 한다.
- 입력한 숫자만큼 자동차 경주를 반복한다.
    - 경주가 진행되면, 각각의 자동차는 0부터 9까지의 숫자를 랜덤으로 배정받는다.
    - 배정받은 숫자가 4 이상일 경우 한 칸 전진한다.
- 경주가 반복될 때마다 어떤 자동차가 얼마나 전진했는지 현 상황을 중계한다.
- 경주가 모두 끝나면, 가장 많이 전진한 자동차가 우승했음을 출력한다.
    - 이때 가장 많이 전진한 자동차가 여럿이라면 쉼표 (,)로 구분해서 출력한다.

## 🎱 게임 진행 예시 🎱

```java
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
ranu, nclu, lus
시도할 회수는 몇회인가요?
5

실행 결과
ranu : -
lus : -
nclu : 

ranu : -
lus : -
nclu : -

ranu : --
lus : -
nclu : --

ranu : --
lus : --
nclu : ---

ranu : --
lus : ---
nclu : ---

최종 우승자 : lus, nclu
```

## 🚀 기능 요구 사항 🚀

- 게임 진행
    - [x]  [경주 회수만큼 경주를 진행한다](https://github.com/woowacourse-precourse/java-racingcar-6/pull/762/commits/ebda297f02d627444b58aa97a63a08de6332e9a2)
    - [x]  [한 경주마다 0부터 9까지의 랜덤 번호를 배정받고, 이 값이 4 이상일 경우 전진한다](https://github.com/woowacourse-precourse/java-racingcar-6/pull/762/commits/ebda297f02d627444b58aa97a63a08de6332e9a2)
    - [x]  [한 턴의 경주가 끝날 때마다 진행 상황을 중계한다](https://github.com/woowacourse-precourse/java-racingcar-6/pull/762/commits/c1e810b282d02d239c9acdb7af4830fa808f4abb)
    - [x]  [모든 경주가 끝나면 가장 많이 전진한 자동차를 집계하고 우승자를 발표한다](https://github.com/woowacourse-precourse/java-racingcar-6/pull/762/commits/fe911f44d2acd463fa5f0ed7810a46bc0bd78c91)
- 입력
    - [x]  [자동차 경주에 참여할 자동차의 이름을 쉼표 (,)로 구분하여 입력받는다](https://github.com/woowacourse-precourse/java-racingcar-6/pull/762/commits/dc65b0b0b097a301a27969540e26e0414827be64)
        - [x]  자동차의 이름이 다섯 글자 이하여야 한다 → `InvalidRacingCarNameLengthException`
    - [x]  [경주 회수는 자연수로 입력받는다](https://github.com/woowacourse-precourse/java-racingcar-6/pull/762/commits/12e410316f13d23b0c743d9310b0492c2f80ba9a) → `InvalidRaceCountException`
- 출력
    - [x]  경주가 끝날 때마다 진행 상황을 중계한다
        - [x]  자동차 이름 : 전진 정도 출력
        - [x]  전진 정도만큼 “-” 문자열을 반복
    - [x]  경주가 끝난 후 가장 많이 전진한 자동차의 이름을 발표한다
        - [x]  가장 많이 전진한 자동차가 여럿일 경우, 쉼표 (,)로 구분하여 모두 발표한다

## 📂 프로젝트 구조 📂

```
📦src
 ┣ 📂main
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂racingcar
 ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┗ 📜racingCarGameController.java
 ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┣ 📜racingCar.java
 ┃ ┃ ┃ ┃ ┗ 📜racingCars.java
 ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┗ 📜InvalidRacingCarNameLengthException.java
 ┃ ┃ ┃ ┣ 📂view
 ┃ ┃ ┃ ┃ ┣ 📜inputView.java
 ┃ ┃ ┃ ┃ ┗ 📜outputView.java
 ┃ ┃ ┃ ┗ 📜Application.java
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┣ 📂racingcar
 ┃ ┃ ┃ ┗ 📜ApplicationTest.java
 ┃ ┃ ┗ 📂study
 ┃ ┃ ┃ ┗ 📜StringTest.java
```