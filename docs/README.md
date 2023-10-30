## 🚀 기능 요구 사항

- [ ] : 자동차 경주 게임을 구현한다
    - Game.start() : 게임을 시작한다

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - Car.currentLocation : 차의 현재 위치 속성
    - Car.movingForward() : 차가 전진하는 기능
    - Car.stop() : 차가 멈추는 기능
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - Car.name : 차의 이름 속성
    - Car.print() : 차의 이름 출력 기능
    - Car.setName() : 차의 이름 제한과 구분자 설정, 이름을 정하는 기능
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - Car.movingForward(Integer times) : 차가 전진 하는 기능에 몇번을 이동할지 입력
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    - Randoms.pickNumberInRange(0,9) : 라이브러리를 사용하여 0~9 사이의 값 얻기
    - Car.judgeForward() : 앞으로 갈것인지 판단하는 기능
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - Game.printResult() : 게임의 결과를 발표하는 기능
- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    - Game.printResult() : 여기서 우승자는 차의 이름
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - Game.userInput() : 유저는 게임을 시작하고 값을 입력한다

## 입출력 요구 사항

### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
    - Game.userInputCarName() : 자동차는 객체로 갯수에 맞게 생성해야함. 스플릿을 하여 갯수만큼 인스턴스 생성하기
    - Game.stringToListByComma(String userInputString) : 유저가 입력한 String 값을 리스트로 만들기

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 출력

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

### 실행 결과 예시

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