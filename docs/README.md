# 기능 요구 사항 - 자동차 경주

## 🚀 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. - tryForward()
    - [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. - tryForward()
    - [X] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. - setTryIteration(String inputtext)
- [X] 각 자동차에 이름을 부여할 수 있다. - RacingCarGame()
    - [X] 자동차 이름은 쉼표(,)를 기준으로 구분한다. - split()
    - [X] 이름은 5자 이하만 가능하다. - RacingCar.name
- [X] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. - toString()
- [X] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. - printWinner()
    - [X] 우승자는 한 명 이상일 수 있다.
    - [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [X] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

#### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

#### 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

#### 실행 결과 예시

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
```

---

### 고려해야할 점(최종 제출 전 check)

- [X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않는다.
- [X] 3항 연산자를 쓰지 않는다.
- [X] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [X] JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야
  한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- Git의 커밋은 [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
