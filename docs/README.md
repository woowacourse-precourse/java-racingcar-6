# 자동차 경주
***

## 기능 목록

* 자동차 이름을 입력 받는다.(쉽표를 기준으로 구분)
* 이동 횟수를 입력 받는다.
* 전진 조건은 무작위 값 중 4 이상의 숫자일 때이다.
    * pickNumberInRange()를 활용하여 무작위의 값을 구한다.
    * 무작위의 값이 4이상이면 전진이다.
* 실행 결과를 출력한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.

## 폴더 별 기능
* model : 데이터 생성 및 처리 영역
  * Car
* service : 기능 생성 영역
  * Input, Output, Random, Move 
* exception : 예외 처리 영역
  * CheckException 
* view : 화면 입력 및 출력 영역
  * RacingCar 
