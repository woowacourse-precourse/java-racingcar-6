# 기능 명세서
- - - 
```java
public boolean saveName(String userCarName)
```
문자열을 받아서 문자열을 분리하는 메소드, Map 자료구조를 만들어주는 메소드<br/>
그리고 올바른 값을 입력했는지 확인하는 메소드를 순서대로 호출합니다.<br/>

```java
public boolean exceptionCheck(String userTimes)
```
예외를 확인하는 객체를 생성한 후 호출하고 받은 값은 리턴합니다.

```java
public void changeStatus() 
```
게임 상황을 변화시키는 객체를 생성하고 객체를 호출하여 상황을 변화시킵니다.
```java
public List<String> getWinner() 
```
우승자를 판별하는 객체를 생성하고 객체를 호출하여 우승자를 받아옵니다.
```java
public void changeGame(LinkedHashMap<String, StringBuilder> car,
                           List<Integer> generatedNumbers)
```
호출을 받은 후 게임 상황을 알맞게 조정합니다.
```java
public static List<String> judgeWinner(LinkedHashMap<String, StringBuilder> carName)
```
호출을 받아 적절한 우승자를 판별하여 반환합니다.

