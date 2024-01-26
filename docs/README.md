# [우테코 프리코스] 자동차 경주 게임

## 기능 요구사항

### 입력 (🟢BeforeGame)
**경주 참여 자동차들의 이름 입력** _enterCarsName(String cars)_ <br>
`경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- 자동차 이름은 쉼표를 기준으로 구분
- 이름은 5자 이하
- **각 자동차를 Key로, 전진 값을 Value로 가질 Map을 반환**

<br>

**몇 번의 이동을 할 것인지 입력** _enterMoves()_ <br>
`시도할 회수는 몇회인가요?`
- n회

<br>
<br>

### 게임 (🟢Ingame)
전역변수로 carsMap을 가진다.

**전진 여부 결정** _🟢Ingame / createRandomNumber(String carName)_
- 0 ~ 9 사이의 무작위 값을 구할 것 
- 무작위 값이 4 이상인 경우 전진 (각 자동차에 해당하는 값에 +1을 한다.)

<br>

**전진 자동차 출력**
```java
실행 결과
pobi : -
woni : 
jun : -
```
- 1회 전진 당 `-` 출력 (값만큼 `-`를 출력한다.) _🟢Ingame / printResult(String carName)_

이를 n회 반복한다.

<br>

### 최중 우승자
**우승자 출력** _🟢FinalWinner(Map carsMap)_

`최종 우승자 : pobi, jun` 
- 위 반복문이 끝난 후, `-`의 수가 가장 많은 자동차의 이름을 출력
  - Value의 최대값을 return하는 _🟢FinalWinner/maxValue()_
- 2명 이상인 경우, 각각의 자동차를 `,`로 구분
  - Value를 가진 Car들을 출력하는 _🟢FinalWinner/printWinner(int maxValue)_

<br>

## 기타 요구사항
1. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. **2까지만 허용한다.**
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
   - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
2. 3항 연산자를 쓰지 않는다.
3. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
4. JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
   - 테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.

