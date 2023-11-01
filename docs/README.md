### 요구사항 분석

**기본 셋팅 → setting()**

`경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` → View, printStartMention

자동차 이름 받기(각 자동차에 이름을 부여할 수 있고, 쉼표를 기준으로 구분하며 이름은 5자 이하만 가능) → Service, inputCarNames

Car 객체에 저장 → Domain, Car

- carName: 차 이름
- goCount: 전진 횟수 → default (0)

`시도할 회수는 몇회인가요?` → View, printGameCountMention

시도할 횟수 받기 → Service, inputGameCount

**실행 → play()**

전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우

- 무작위 값을 구한 후 4 이상이면 Car 객체의 goCount 증가
- 아니라면 그냥 continue

**실행 결과 출력 → printResult()**

`실행 결과` → printResultMention()

n번의 실행결과를 표시 → printResultAll()

```
pobi : --
woni : ----
jun : ---
```

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. → Service, judgeWinner

`최종 우승자 : pobi` → printWinner();

- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용해 구분한다. `최종 우승자 : pobi, jun`

**예외 처리 → util, Parser**

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

parserCarName → 차이름이 5글자 이하가 아닐 때

parserGameCount → 숫자가 아닌 문자가 들어왔을 때