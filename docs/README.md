# 2주차 미션 : 자동차 경주
------------

## 1. class Application 

> + Race 객체를 생성하고 start 메서드를 호출하여 게임을 시작<br/>
>+ 동작과정
>  1. Race 객체 생성
>  2. race 클래스의 start 메서드 호출


------------

## 2. Class Race

> + 사용자의 입력값 검증 및 경주 시작<br/>
>+ 동작과정

>   1. "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"를 출력하고 raceReady() 메서드 호출하여 게임을 준비
>   2. 2-1
------------

## 2-1. raceReady() - 경주 준비

> + 플레이어(사용자)의 숫자를 입력을 받고 playingGame() 메서드 호출<br/>
>+ 동작과정

>   1. inputCarNames 메서드를 호출해서 자동차 이름 들을 입력받는다.
>   2. convertToCarNameArray 메서드를 호출해서 입력 받은 자동차 이름들 문자열을 배열로 변환
>   3. validateinputCarNames, validateNumeric 메서드를 호출해서 배열을 매개변수로 전달하여 자동차 이름 중 5글자 이상인 이름이 있는지, 공백이 있는지 검사해서 있으면 IllegalArgumentException 예외 발생
>   4. askMoveCount() 호출해서 시도 횟수를 입력받는 문구 출력
>   5. stringToIntMoveCount 메서드를 호출해서 입력받은 횟수를 정수형으로 변경
>   6. makeForwardStatus 메서드를 호출해서 자동차명 : "" 를 요소로 HashMap 생성
>   7. Racing 객체 생성
------------

## 3. Class Racing - 경주 진행

> + 경주 실행<br/>
>+ 동작과정
>   1. foward 메서드 호출해서 각 자동차 마다 랜덤한 숫자가 4이상이면 전진 실행하고 전진 할때마다 "-"를 ForwardStatus에 저장하여 각 차수별 실행결과 출력
>   2. RaceEnd 객체 생성
>   3. RaceEnd 클래스 매개변수와 함께 호출
------------

## 4. Class RaceEnd - 경주 종료

> + 각 자동차의 경주 결과를 바탕으로 우승자를 뽑기 위해 가장 전진 많이 한 횟수 및 Winner 클래스에 매개변수 전달<br/>
>+ 동작과정
>   1. makeForwardCountArrayList 메서드를 호출해서 전진 횟수를 받는 배열생성
>   2. winner 클래스 호출
------------

## 5. Class Winner - 우승자 선정

> + 플레이어(사용자)의 숫자를 입력으로 받고,checkPlayerNumber에() 메서드 호출<br/>
>+ 동작과정
>   1. findWinner 메서드 호출 해서 가장 전진을 많이 한 자동차 이름을 파악해서 decisionWinner에 매개변수로 전달
>   2. decisionWinner 호출 해서 단일 우승자와 복수 우승자를 구분해서 단일 우승자는 우승자 출력하고, 복수 우승자는 쉼표를 붙여서 우승자 모두 출력
------------

