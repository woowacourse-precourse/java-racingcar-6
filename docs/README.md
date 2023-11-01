# 자동차 경주

## 자동차 클래스 `RaceCar`를 만든다.
- 자동차 이름과 현재 몇 칸을 갔는지 저장하는 기능을 구현한다.
- 추가적으로 모든 차량들 중에서 가장 많이 이동한 거리를 저장하는 static 변수를 만든다.
- 아래는 자동차 클래스 내부에 구현할 메소드들이다.
### 자동차들중에서 최대 이동 거리를 저장하고 갱신하는 기능
- static int 변수인 `maxDistanceTraveled`보다 현재 차량의 거리가 많다면 이 변수를 해당 차량의 거리로 바꿀 수 있도록 하는 메소드`renewMaxDistanceTraveld()` 구현.
### 자동차들의 통합 최대 이동 거리를 알려주는 기능
- `maxDistanceTraveled`의 값과 position의 값이 같다면 이 차량의 이름을 알려주는 메소드 `winnerCarName()` 구현
### 자동차를 전진하게 하는 기능
- 0~9사이의 난수를 생성해 4 이상이면 자동차 위치+1 해주는 매서드`raceForeward()`을 구현
- `renewMaxDistanceTraveld()`를 사용하여 자동차가 이동한 거리가 최대 이동거리인지 확인하는 기능.
### 차의 이름과 위치를 보여주는 기능
- 차의 이름이 garo이고 3칸을 전진했을때 이렇게 출력하는 메서드`currentPosition()` 구현.
```
garo : ___
```
## 자동차 경기를 주최하는 클래스 `Race`를 만든다.
- 참여 자동차들의 이름을 입력받고 그 설정에 맞는 `RaceCar`클래스의 인스턴스를 생성하여 리스트형 배열로 저장한다.
- 아래는 `Race` 클래스의 부가적인 메소드들이다.
### 자동차의 이름을 입력받는 기능
- 입력받은 자동차들의 이름을 `split()` 기능으로 나누고 스트링 리스트에 저장하는 메서드`inputRaceCars()` 구현.
    - 저장된 스트링 리시트형 배열 내부의 문자열들이 5자보다 많거나 아예 없다면 `IllegalArgumentException`을 발생시키는 메서드 `nameValiddation()`구현.
- `inputRaceCars()` 메서드로 자동차의 이름들을 가진 string 리스트형 배열을 입력받아, 해당 리스트형 배열 안에 있는 문자열들의 이름을 가진 `raceCar` 인스턴스 배열을 생성하는 메서드`makeRaceCars()`생성.
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
```
### 경기에 참여하는 자동차들이 전부 이동을 시도하게 하는 기능
- 경기에 참여하는 모든 차들이 `raceForeward()`를 실행하게 하는 메서드`carsTryMove()` 구현
### 경기에 참여하는 차들의 현재 상태를 출력해주는 기능
- 경기에 참여하는 모든 차들의 `currentPosion()`을 실행하게 하는 메서드`reportingLive()` 구현
### 최종 우승자를 판별하는 기능
- `RaceCar` 클래스의 `winnerCarName()` 메소드를 이용해 우승자의 이름을 출력하는 메서드 `winnerWinnerChikenDinner()` 구현.
```
최종 우승자 : pobi, jun
```
### 차들이 움직임을 몇번 시도할 수 있는지 입력받고 그만큼 게임을 진행시키는 기능
- 차들에게 전진의 기회를 몇 번 줄건지 입력받고, 그 수 만큼 `carsTryMove()`와`reportingLive()`를 수행하는 메서드`raceGame()` 구현.
- `winnerWinnerChikenDinner()` 메서드를 사용하여 최종 우승자를 출력.
```
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
