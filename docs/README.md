# 기능 요구 사항
## 입력 데이터 <br>
> 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)<br>
>> 자동차 n개 (1개 이상?), 자동차 5자 이하<br>
> 
>시도할 회수<br>
>> 제한된 요구사항 X
 <br>
> 


## 출력 데이터 <br>
>각 차수별 실행 결과<br>
>> 자동차명1 : 실행 결과, <br>
>> 자동차명2 : 실행 결과,<br>...
>
>단독 우승자 안내 문구<br>
>> 최종 우승자 : 자동차명
>
>공동 우승자 안내 문구<br>
>> 최종 우승자 : 자동차명1, 자동차명2
<br>
> 

## 함수
> #### 입력 함수
> 입력받은 자동차명 처리하는 함수 makeMapCars
> ```java
> //입력받은 이름을 해시맵의 key로 정리
> public static Map<Integer> makeMapCars(String names)
>```

> #### 출력함수
>입력받은 횟수만큼 차수별 실행 결과 출력 loopResult
> ```java
> public static void loopResult(int count)
>```
>  단독 우승자 안내 문구 출력 printWinner
> ```java
> public static void printWinner(list winner)
>```
>  공동 우승자 안내 문구 출력 printWinners
> ```java
> public static void printWinners(List winners)
>```

>#### 입력한 데이터를 출력하기 위한 함수
> 자동차별로 전진하는 함수 carsDistance
> ```java
> //각 자동차별 랜던값을 생성 후 출력 -> 4 이상일 경우 count
> //Randoms.pickNumberInRange(0,9)를 사용
> public static int randomDistance(Map cars)
>```
> 우승자 List를 만드는 함수 makeWinnerList
> ```java
> //각 자동차별 랜던값을 생성 후 출력 -> 4 이상일 경우 count
> public static List makeWinnerList(Map cars)
>```

