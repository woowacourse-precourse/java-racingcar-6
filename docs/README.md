# 📝구현할 기능 목록

## 유저 플로우

![Untitled](https://github.com/GDSC-Hongik/2023-2-OC-Java-Study/assets/66353672/b2b789aa-0a40-4770-a3a4-611da435c879)

## 경주할 자동차 입력 기능

- 경주할 자동차이름을 쉼표(,)를 기준으로 입력할 수 있다. - inputCarNames()
- 이름은 5자 이하만 가능하다. 예외시, 에러를 발생시킨다. - validateCarNames()

## 시도할 횟수 입력

- 몇번의 이동을 할 것인지 입력할 수 있다. - inputTryCount()
- 숫자가 아닐 경우, 에러를 발생시킨다. - validateTryCount()

## 무작위 값 생성

- 0에서 9사이에서 무작위 값을 생성한다. - createRandomNumbers()

## 자동차 전진 기능

- 생성된 무작위 값이 4 이상일 경우를 판단할 수 있다. - isForward()
- 전진조건이 성립하면, 전진 할 수 있다. - moveForward()

## 우승자 출력 기능

- 제일 많이 전진한 우승자를 출력한다. - outputWinner()
- 공동 우승인 경우 쉼표(,)로 구분해 출력한다.

## 자동차 경주 게임 진행

- 자동차 경주 게임을 시작한다. - run()
- 시도 횟수가 남았는지 알 수 있다. - isTryCountRemaining()