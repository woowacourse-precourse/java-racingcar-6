# 6기 프리코스 2주차 (java-racingcar)

##### [2주차 할일 목록 및 과정 기록](priority.md)

## 개요

사용자와 게임횟수를 입력받아, 횟수동안 사용자들 각각의 자동차 이동정도를 난수생성을 사용하여 정하고, 이동정도가 제일 많은 사용자를 우승자로 출력하는 게임입니다.

## 기능구현 목록

MVC 패턴을 적용하여 기능을 구현하였으며, 클래스의 구성은 다음과 같습니다.

```
📁 main/java/racingcar
    ㄴ☕ Application.java             (애플리케이션 시작 호출)
    ㄴ☕ racingcarModel.java          (Model)
    ㄴ☕ racingcarView.java           (View)
    ㄴ☕ racingcarController.java     (Controller)
    ㄴ☕ DealWithExceptionCase.java   (예외처리)
```

## 클래스 별 구성

### 1. RacingcarView

다음과 같은 함수들로 구성되어 있습니다. 

```java
GetMembersAndTurn() 
StartRacing()  
printMemberStatus() 
printResult()
IsMaxValue()
```

#### `GetMembersAndTurn()`

- 멤버 이름과 시도횟수를 입력받습니다.

- 🚨 `racingcarController` > `IsNameAccurate()` 를 호출해 이름의 정확성을 검증합니다.

#### `StartRacing()`

- 🚨 `racingcarController` > `RaceIndividually()` 를 시도횟수만큼 호출해 레이스를 진행합니다.

#### `printMemberStatus()`

- 멤버의 이동횟수만큼 UPPER_DASH ("-") 를 붙여 출력합니다.

#### `printResult()`

- 🚨 멤버별로 `IsMaxValue()`를 호출합니다. 

#### `IsMaxValue()`

- 멤버를 순회하며 최댓값과 동일한 값을 가진 key들 (멤버이름)을 모두 출력하면서 winnerCount에도 1을 더합니다.

- 이 때, winnerCount가 0이라면 이름만 출력, 이외에는 이름 앞에 SPOT (",") 를 출력하도록 합니다. 

### 2. RacingcarController

다음과 같은 함수들로 구성되어 있습니다.

```java
run() 
RaceIndividually() 
MoveForward() 
GetMaxValues()
```

#### `run()`

게임의 시작 지점입니다. 

- 🚨 다음 함수를 순서대로 호출합니다. 
  
  - `racingcarView` >` GetMembersAndTurn()`
  
  - `racingcarView` > `StartRacing()`
  
  - `racingcarController` > `racingcarController()`

#### `RaceIndividually()`

- 🚨 각각 사용자에 대해 순서대로 `MoveForward()`를 수행합니다. 

#### `MoveForward()`

- 랜덤으로 뽑은 정수가 4 이상일 경우에만 이동횟수(members의 value)에 1 더하여 상태를 업데이트 합니다.

- 🚨`printMemberStatus()` 를 호출해 멤버별 이동횟수의 상태를 출력합니다.

#### `GetMaxValues()`

- 멤버들의 이동횟수에서 최댓값을 구합니다. 

- 🚨`racingcarView` 클래스의 `printResult()` 를 호출합니다. 

### 4. DealWithExceptionCase

다음과 같이 구성되어있습니다

```java
IsNameAccurate() 
IsNameDuplicate()
```

#### `IsNameAccurate()`

- 입력받은 이름이 정확한지를 검사합니다.

#### `IsNameDuplicate()`

- 입력받은 이름이 중복되는지를 검사합니다.



### 3. RacingcarModel

- racingcarModel은 다음과 같이 구성되어있습니다. 
  
  - 게임에 사용되는 상수들과 변수
  
  - 유저들의 게임진행도를 저장하는 해쉬맵
