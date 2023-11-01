# 숫자 야구 게임 기능 설명 

## 자동차 이름 부여 
```java
 System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
 String input = readLine();
```
## 자동차 쉼표(,) 구분자를 기준(단, 이름이 5자 이하)
```java
String[] cars = input.split(",");
```
## 사용자가 원하는 이동 횟수
```java
System.out.println("시도할 회수는 몇회인가요?");
int gameCount = Integer.parseInt(readLine());
```
## 전진하는조건(0에서 9사이 무작위 값을 구한 후 무작위 값이 4 이상일 경우)
```java
int moveCountInit() {
    return Randoms.pickNumberInRange(0, 9);
}
```
## 자동차 경주 우승자 추출
```java
public static String whoWinner(int max) {
    ArrayList<String> resRacing = new ArrayList<>();
    String winners = "";

    for (Map.Entry<String, Integer> car : race.racingCars.entrySet()) {
        if (max == car.getValue()) {
            resRacing.add(car.getKey());
        }
    }
    //우승자가 여러 명일 경우 쉼표(,)를 기준으로 하여 구분
    winners = String.join(",", resRacing);
    return winners;
}
```
## 사용자가 잘못된 입력을 했을 경우 
```java
public static void racingCarNameCheck(String[] cars) {
    for (int i = 0; i < cars.length; i++) {
        if (cars[i].length() > 5) throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해주세요");
    }
}
```