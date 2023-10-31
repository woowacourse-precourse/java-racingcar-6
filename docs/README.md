# 기능 명세서
- - - 
<br>

## CarRacing클래스

<br>

### public 메소드

```java
public LinkedHashMap<String, StringBuilder> getCarName()
```
컬렉션의 복사본을 만들어서 반환합니다.

```java
public void changeGame()
```
숫자를 생성하고 그 숫자에 따라서 게임의 판도를 바꿉니다.
```java
public List<String> getWinner()
```
우승자를 가려내어 반환합니다.

<br>

### private 메소드
```java
private int getNumber(Iterator<Integer> temp)
```
생성된 숫자를 끝까지 하나하나 반환해줍니다.
```java
private GoOrNot changeStatus(int generatedNumber)
```
생성된 값이 4이상이라면 GO를 그렇지 않다면 NOTGO를 반환합니다.
```java
private int findMaxScore(Collection<StringBuilder> status)
```
가장 멀리 간 진행상태를 확인하고 리턴합니다.
```java
private void changeWinner(List<String> winners, String player, int length, int maxScore)
```
자동차의 진행상태가 가장 멀리간 경우라면 우승자에 추가합니다.

<br><br>

## MainControl 클래스
<br>

### public 메소드
```java
public void turnOn()
```
프로그램의 시작 셋팅을 합니다.

<br>

### private 메소드
```java
private void leadGame()
```
게임이 올바르게 진행되도록 메소드들을 호출합니다.
```java
 private void initializeCarRacingGame(String[] userInput) throws IllegalArgumentException
```
사용자로부터 받은 입력값을 가지는 컬렉션을 관리하는 객체를 초기화합니다.
```java
private String getUserInput() throws IllegalArgumentException
```
사용자의 시도횟수를 입력 받고 예외를 확인한 후 그것을 반환합니다.
```java
private void processWithResults(String times)
```
사용자의 시도 횟수를 받은 후 그만큼 게임을 진행시킵니다.

<br><br>

## CarMapGenerator

<br>

### public 메소드
```java
public static String[] cutName(String userCarName)
```
사용자가 입력한 이름을 받아서 분리한 후 반환합니다.
```java
public static LinkedHashMap<String, StringBuilder> makeLinkedHashMap
            (String[] userCarName)
```
사용자가 입력한 값은 LinkedHashMap에 저장한 후 반환합니다.

<br><br>

## InputReadear 클래스

<br>

### public 클래스
```java
static String inputCarName()
```
자동차 이름을 입력 받고 리턴합니다.
```java
static String inputTimes()
```
시도횟수를 입력 받고 리턴합니다.

<br><br>

## MainView 클래스

<br>

### public 메소드
```java
public void speakStart()
```
게임의 시작을 알립니다.
```java
public void askForTimes()
```
시도 횟수를 물어봅니다.
```java
public void speakResultStart()
```
결과발표의 시작을 알립니다.
```java
public void speakResult(LinkedHashMap<String, StringBuilder> map)
```
게임의 결과를 발표합니다.
```java
default void speakWinner(List<String> winner)
```
우승자를 발표합니다.

<br><br>

## NumberGenerator 클래스

<br>

### public 메소드
```java
public static List<Integer> numberGenerate(int carNumber)
```
숫자를 생성하고 List 자료구조에 저장한 후 반환합니다.

<br><br>

## ValidationMan 클래스

<br>

### public 메소드
```java
public static boolean checkException(LinkedHashMap<String, StringBuilder> map, int userInputNum)
```
중복된 이름이 있다면 false를 리턴합니다.
```java
public static boolean checkException(String userTimes)
```
시도횟수가 숫자가 아니라면 false를 리턴합니다.

<br>

### private 메소드
```java
private static boolean checkException(LinkedHashMap<String, StringBuilder> map)
```
이름이 5자를 넘지 않는지 확인하고 넘는다면 false를 리턴합니다.
```java

```

