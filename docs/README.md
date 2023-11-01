# 자동차 경주 게임 과정
- 이 Application에서는 자동차 경주 게임이 진행됩니다.  
- Stadium 안에서 Racer들의 경기가 일어나고 있습니다.
- Stadium은 Racer들의 목록, 시도 횟수를 받고 경기를 진행합니다.
- 이번 게임에서 Racer는 Car입니다.
- 이번 게임에서 Car는 LinearMover 기능을 가지고 선형으로 전진합니다.  
- 하나의 횟수마다 경기 모습을 Snapshot으로 남겨 여러분께(콘솔 출력으로) 보여줍니다.   
- 경기가 끝나면, 마지막 Snapshot을 보고 승리자를 알아낼 수 있습니다.  


# 기능 목록

🪄 경기자 목록 입력 받기
```
Stadium.inputRacers()
    경주할 Racer 목록을 입력받는다.


Stadium.saveRacers()
    입력받은 Racer 목록을 저장한다.
```

🪄 전진 횟수 입력 받기
```
Stadium.inputTryCount()
    전진 횟수를 입력받는다. 

Stadium.saveTryCount()
    전진 횟수를 저장한다.
```
🪄 자동차 전진 기능  
현재 요구사항을 만족하기 위해  
Car(Racer)는 LinearMover 기능을 사용해 전진합니다.  
(Racer에 Mover가 컴포지션 되어있습니다)
```
Stadium.runAllRacers()
    모든 Racer를 전진한다.

Racer.run()
    전진한다.

LinearMover.moveForward()
    전진한다.

LinearMover.isMovable()
    조건(랜덤)에 의해 움직일 수 있는지 판단한다.

LinearMover.plusLocation()
    위치값을 더한다.
```

🪄 최종 승자 띄우기
```
Snapshot.printWinner(int order)
    order번째 경기의 승자를 출력한다.

Snapshot.findWinner(int order)
    order번째 경기의 승자를 찾는다.
```

🪄 경기 중 진행기록을 남기는 스냅샷 기능
- 스냅샷 세팅
```
Snapshot.set(int order)
    order번째 전진의 스냅샷을 세팅한다.

Snapshot.get(int order)
    order번째 전진의 스냅샷을 가져온다.
```
- 스냅샷 출력
```
Snapshot.print(int order)
    order번째 전진의 스냅샷을 출력한다.

Snapshot.numberToHyphen(int number)
    number만큼의 하이픈 문자열을 리턴한다.
```

🪄 유틸
```
Util.getRandomSingleDigit()
    랜덤으로 한 자리 숫자를 리턴한다.
```
```
Util.getBooleanByNumber()
    숫자 값에 따라 true/false를 생성한다.
```

# 클래스별 역할

### Stadium
경기의 행정 관리를 합니다.  
참가자 목록 받기, 경기횟수 받기, 경기 시작하기와 같은 경기전체를 관장합니다.

### Car extend Racer
Car는 Racer를 상속하고,
Racer는 이름(name)과 이동법(mover)을 가지고 있습니다.

### LinearMover implements Mover
선형으로 이동하는 방식을 정의하며, 위치는 정수값입니다. 전진하는 이동 자체를 담당합니다.

### Snapshot
경기 중 스냅샷(기록)을 담당합니다.

### ConsoleInputOutputHelper implements InputOutputHelper
콘솔 입출력 기능을 담당합니다.