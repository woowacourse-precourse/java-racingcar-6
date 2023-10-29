# 기능할 구현 목록
기능 구현 목록 초안입니다.  

----
차 목록 입력 받기
```
Stadium.inputCars()
    경주할 차 목록을 입력받는다.
```
```
Stadium.saveInputCars()
    입력받은 차 목록을 저장한다.
```

전진 횟수 입력 받기
```
Stadium.inputTryCount()
    전진 횟수를 입력받는다. 
```
```
Stadium.saveTryCount()
    전진 횟수를 저장한다.
```
자동차 전진 기능
```
Stadium.runAllCars()
    모든 차를 전진한다.
```
```
Car.run()
    전진한다.
```
```
Car.isRunnable()
    전진 가능한지 확인한다.
```

최종 승자 띄우기
```
Snapshot.findWinner(int order)
    order번째 경기의 승자를 찾는다.
```
```
Snapshot.printWinner(int order)
    order번째 경기의 승자를 출력한다.
```

경기 중 진행기록을 남기는 스냅샷 기능
```
Snapshot.printSnapshot(int order)
    order번째 전진의 스냅샷을 출력한다.
```
```
Snapshot.numberToHyphen(int number)
    number만큼의 하이픈 문자열을 리턴한다.
```
```
Snapshot.setSnapshot(int order)
    order번째 전진의 스냅샷을 세팅한다.
```
```
Snapshot.getSnapshot(int order)
    order번째 전진의 스냅샷을 가져온다.
```

유틸
```
Util.getRandomSingleDigit()
    랜덤으로 한 자리 숫자를 리턴한다.
```
```
Util.getBooleanByNumber()
    숫자 값에 따라 true/false를 생성한다.
```