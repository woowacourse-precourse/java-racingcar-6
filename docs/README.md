# 기능 요구 사항
## 입력 데이터 <br>
> 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)<br>
>> 자동차 n개 (1개 이상?=입력하지 않을 경우), 자동차 5자 이하, 중복 가능? <br>
> 
>시도할 회수<br>
>> 제한된 요구사항 X, 입력하지 않을 경우 throw, 음수이거나 문자 입력시 throw
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


# 코드 구현
## Appication class
>Progress 클래스의 생성자 실행
> 

## Progress class
> 기본 생성자에서 입력 문구 출력과 입력문을 실행
> 
> 



## Car class
>클래스 변수: 자동차명, 해당 자동차가 이동한 거리

## Circuit class
> 한 개의 싸이클에 대한 실행
> ```java
> //RandomDistance 함수를 이용해 한 번의 경주 실행 결과를 출력하는 함수
> public Circuit(ArrayList<Car> carArrayList)
> ```
> ```java
> //Randoms.pickNumberInRange(0,9)를 이용해 전진 여부를 판단
> //4이상일 경우 전진
> public static boolean RandomDistance()
> ```



## Rules class
> 입력 규격에 맞지 않을 경우 예외처리를 위한 함수 집합 <br> <br>
> **이름 입력 에러**
> ```java
> //이름이 5자 이하가 아닐 경우 예외처리 함수
> public static void nameLengthErr()
> ```
> ```java
> //자동차명이 중복될 경우 예외처리 함수
> public static void nameOverlapErr()
> ```
>  ```java
> //입력된 자동차명이 없을 경우 예외처리 함수
> public static void nameNotInputErr()
> ```
>  ```java
> //시작과 마지막에 ,가 있을 경우 예외처리 함수
> public static void nameIsNotStartOrEndComma()
> ```
> **횟수 입력 에러**
>  ```java
> //정수가 아닐 경우 예외처리 함수
> public static void NotNumberErr()
> ```
>  ```java
> //자연수가 아닐 경우 예외처리 함수
> public static void NotNaturalNumberErr()
> ```
>  ```java
> //입력된 수가 없을 경우 예외처리 함수
> public static void numberNotInputErr()
> ```


