# 프리코스 미션2 - 자동차 경주

## 기능 요구 사항 & 과제 진행 요구 사항
- start: [java-racingcar-6](https://github.com/woowacourse-precourse/java-racingcar-6) 저장소를 Fork & Clone해 시작한다.
### 입출력
#### 입력
- 경주 할 자동차 이름 입력
  - 이 때, 입력받은 string을 구분하는 기준으로 ","을 통해 구분하여 List에 저장
  - IllegalArgumentException()를 사용하여, 5글자를 초과하는 경우에 대한 예외 발생
    - 아래 구현할 기능에서 checkNamelength()에 대하여 설명
```java
System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
String racerNames = scanner.nextLine();     // 경주 할 자동차 이름 입력
// ","을 기준으로 하여 각 경주 참가자들을 Array에 임시 저장
String[] racerArray = racerNames.split(",");
checkNamelength(racerArray);    // racer들의 이름을 List<Stirng>에 저장
```
- 경주를 시도할 횟수 입력(int)
```java
// 시도할 횟수 입력
System.out.println("시도할 회수는 몇회인가요?");
int tryCount = scanner.nextInt();   // 경주 시도 횟수 입력
```


#### 출력
- tryCount 만큼 race를 반복하는 내용을 출력
  - tryRace(): 반복 횟수를 입력받아 해당 반복 횟수만큼 race 실행, 각 실행마다 결과 출력
```java
System.out.println("실행 결과");
tryRace(tryCount);
```
  
```
// 에시
poni : 
koni : 
jun : -
```
- tryCount 만큼 반복 후 최고로 멀리 간 winner 출력
```
// 에시
최종 우승자 : jun
```

### 구현할 기능 및 구현 내용
#### 'Car' class 생성
- 자동차 이름(carName)과 자동차의 위치(position) 정의
- 자동차가 이동하는 조건 정의(move())
  - 
```java
class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    // move 조건 설정
    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0,9);;
        if (randomNumber >= 4) {
            position++;
        }
    }
}
```

#### racing() 함수 생성
- 프로그램의 전체적인 기능 수행

```java

```



--- 

## 프로그래밍 요구 사항
### 

```java

```

```java

```
---
## test 결과
※ 노트북 환경에서 프로그램 실행할 경우, 출력 시 한글이 깨지는 문제가 발생하지만, test 진행시 정상임을 확인
1. 처음 시작 조건 : 만족
![img.png](img.png)
2. Test 확인

