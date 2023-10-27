# 기능할 구현 목록
기능 구현 목록 초안입니다.  

----
## class Stadium

차 목록 입력 받기
```
String inputCars()
    경주할 차 목록을 입력받는다.
```
```
void saveInputCars()
    입력받은 차 목록을 저장한다.
```

전진 횟수 입력 받기
```
void inputTryCount()
    전진 횟수를 입력받는다. 
```
```
void goCars()
    모든 차를 전진한다.
```

최종 승자 띄우기
```
List findWinner()
    최종 승자를 찾는다.
```
```
void printWinner()
    최종 승자를 출력한다.
```
## class Car 
기능 목록
```
void run()
    전진한다.
```
```
isRunnable()
    전진 가능한지 확인한다.
```

## SnapShot
```
void printSnapshot(int order)
    order번째 전진의 스냅샷을 출력한다.
```
```
void setSnapshot(int order)
    order번째 전진의 스냅샷을 세팅한다.
```
```
Map getSnapShot(int order)
    order번째 전진의 스냅샷을 가져온다.
```

## class Util
```
int getRandomSingleDigit()
    랜덤으로 한 자리 숫자를 리턴한다.
```
```
boolean getBooleanByNumber()
    숫자 값에 따라 true/false를 생성한다.
```