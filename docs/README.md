# readme.md

## 목차

- 프로젝트 진행 상황
- 특징
- 테스트

## **자동차 경주 프로젝트 진행 상황**

### **기본 구현**

- 프로그램 실행과정 구상
    - 경주할 자동차 입력 => 횟수 입력 => 각 차별 전진 => 결과출력 => 우승자(들) 판별 => 결과출력, 에러처리
    - 구현시 유의 사항
        - 함수가 한가지 일만 하도록 최대한 작게 구현
        - depth를 3이 넘지 않도록 구현 (최대한 함수를 분리)

- 기능 목록
    - CarControler
        - [x] 주어진 횟수(세트수) 동안 n대의 자동차는 전진 또는 멈출 수 있다. \
            - [x] n대의 자동차 - List<String> cars
            - [x] 전진 혹은 멈추는 조건 확인 - isForward
                - [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. isForward()
                    - [x] 0~9 사이의 무작위값 구현 - makeRandomNumbers()
                    - [x] 4를 기준으로 전진 조건 확인 - isBiggerThanFour()
            - [x] 1세트 경주 결과 기록후 해시맵 반환
                - [x] 결과 기록 해시맵 - LinkedHashMap<String, Integer> resultRacing
                - [x] 경주 이후 결과 해시맵에 기입. gameStart()
    - RacingRuleMaker
        - [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
            - [x] 자동차에 이름 부여 - namingCar()
                - [x] 자동차의 이름을 입력받기 - 제공된 Console 활용
                - [x] 입력받은 문자열을 리스트로 변환 - split() 활용
                - [x] n대의 자동차 리스트 - List<String> cars
                - [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. - 제공된 Console 활용 (틀릴시 에러처리)
        - [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
            - [x] 몇번의 이동을 할것인가 입력 (주어진 횟수(게임세트수)) int roundCount

    - ReadRacingResult
        - [x] 각 전진 세트당 현황 출력
            - [x] 경주 현황 해시맵을 토대로 문자열 반환 - readHashMap()
            - [x] 정수를 "-" 의 갯수로 반환해주는 기능 - String.reapeat() 로 대체
            - [x] 경주 현황 기록 해시맵 키값을 하나씩 읽기 - Map.Entry 활용
            - [x] 하나씩 읽어들인 자동차 이름을 키값으로 해서 자동차 이동거리 받아오기 - Map.Entry의 getKey, getValue 활용

        - [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. - judgmentWinner()
            - [x] resultRacing를 토대로 경주 우승자 알려주는 기능 - judgmentWinner()
            - [x] 우승자 확인 - findWinner()

        - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. - String.join을 활용
            - [x] 우승자 쉼표로 구분

    - ErrorCheck
        - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
            - [x] 예외 발생시 `IllegalArgumentException` 에러 적용후 종료
            - [x] 입력시 요구사항을 지키는 입력인지 체크하는 기능
                - [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. - carNameCheck()
                - [x] 몇번의 이동을 할것인가 입력(올바른 정수 입력 확인) - inputNumberCheck()

### **문서**

- [x] README.md 작성

## 특징

- 객체지향 프로그래밍에 맞춰 설계
    1. 기능을 가지고 있는 클래스를 인스턴스화 한다.
       - 기능을 가진 클래스들을 만든다
       - 인스턴스화 한다

    2. 역할에 맞는 필요한 기능을 인스턴스가 수행하게 한다.
    3. 각 결과를 종합한다.

## 테스트

- CarControllerTest
    - gameStartTest
    - isForwardTest
    - isBiggerThanFourTest
- RacingRuleMakerTest
    - namingCar
    - inputRacingRoundTest
- ReadRacingResultTest
    - readHashMap
    - judgmentWinnerTest
- ErrorCheckTest
    - carNameCheckTest
    - isNoValueTest
    - biggerThanFiveTest
    - inputNumberCheckTest

 
