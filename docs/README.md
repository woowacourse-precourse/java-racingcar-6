# 기능 요구 사항
## 입력 데이터 <br>
> 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)<br>
>> 자동차 n개 (1개 이상?), 자동차 5자 이하, 중복 가능?, 입력하지 않을 경우<br>
> 
>시도할 회수<br>
>> 제한된 요구사항 X, 입력하지 않을 경우 throw
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
> public static LinkedHashMap<String, Integer> makeCarMap(String names)
>```

> #### 출력 함수
>입력받은 횟수만큼 차수별 실행 결과 출력 numberTimesLoop
> ```java
> public static LinkedHashMap numberTimesLoop(LinkedHashMap cars_map, long number)
>```
> 횟수 한번의 carsDistance를 구하는 함수 oneTimeLoop
> ```java
> public static LinkedHashMap oneTimeLoop(LinkedHashMap cars_map)
>```
> 우승자를 출력하는 함수 winners
> ```java
> public static void winners(LinkedHashMap cars_map)
>```

<br>
<br>

https://docs.oracle.com/javase/8/docs/api/
https://github.com/AdoptOpenJDK/openjdk-jdk8u/blob/master/jdk/src/share/classes/java/util/LinkedHashMap.java