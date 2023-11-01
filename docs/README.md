# 자동차 경주

## 구현 기능 목록 정리

##### 1. 경주 할 자동차 이름 쉼표 기준으로 구분하여 입력받기

* 조건1: 이름은 5자 이하
* 조건2: camp.nextstep.edu.missionutils.Console의 readLine()을 활용
* 출력: "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
* 입력: ex) pobi,woni,jun
* 예외: 이름이 같은 자동차 들어올 때 다른 자동차 처리, ",,"가 입력된 경우, 이름이 6자 이상인 경우

##### 2. 각 자동차에 이름 부여

##### 3. 시도할 횟수(몇 번의 이동을 할 지) 입력 받기

* 출력: "시도할 회수는 몇회인가요?"
* 조건: camp.nextstep.edu.missionutils.Console의 readLine()을 활용
* 입력: ex) 5

##### 4. 자동차 전진, 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력

* 조건1: 0~9 중 랜덤으로 뽑아 4 이상일 떄 전진
* 조건2: camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용 (Randoms.pickNumberInRange(0,9))
* 출력:

   ```
  pobi : ---
  woni : -----
  jun : -
   ```

##### 5. 우승자 출력 (여러 명일 경우 쉼표로 구분)

* 출력: "최종 우승자: pobi" or "최종 우승자: pobi, jun"

***

## 파일(클래스) 구조 설계

```
  java   
    └── racingcar
            └── Application : RacingcarGame 실행
            |
            └── RacingcarGame : 게임 진행
            |       속성 : (변수) List<Car> cars : 생성한 Car 인스턴스들을 담는 리스트
            |             (변수) int tryCount : 시도 회수
            |             (함수) void run() : 게임 시작하기
            |             (함수) void makeCar() : 입력받은 자동차 이름 개수만큼의 Car 인스턴스들을 생성하기
            |  
            └── Car
            |       속성 : (변수) String name : 이름
            |             (변수) int moveCount : 앞으로 움직인 회수
            |             (함수) void moveForward() : Car 인스턴스의 moveCount에 +1 (전진)
            |
            └── Validator : Exception 처리
                    속성 : (함수) void rightCarNames : input 받은 자동차 이름이 올바른 포맷이 아니면 IllegalArgumentException 발생
                                예외: 5자 이하
                                     이름 앞뒤 공백 가능? : Yes ('pobi  ,  jun'과 같이 공백을 함께 입력하는 경우는 허용한다.)
                                     이름이 공백 가능? : No ("")
                                     이름 사이 공백 가능? : No (일반적으로 이름 사이에 공백은 허용하지 않는다)
                                     이름 중복 가능? : No (중복된 이름이 우승했을때 어떤 차가 우승했는지 알 수 없다)
                                     
                          (함수) void rightTryCount : input 받은 시도회수가 올바른 포맷이 아니면 IllegalArgumentException 발생
            |
            └── InputOutput
            |       속성 : (함수) String getCarNames() : 자동차 이름들 달라고 출력하고 받기
            |             (함수) Integer getTryCount() : 시도 횟수 달라고 출력하고 받기
            |             (함수) void printResult() : 실행 결과(Car 인스턴스들이 전진한 회수를 그래픽화) 출력하기
            |             (함수) void printWinner() : 최종 우승자 출력하기
            |          
            └── Random
            |       속성 : (함수) boolean isNumOverFour() : 0부터 9 사이의 수를 랜덤으로 뽑아 4 이상이면 true 리턴/ 3 이하면 false 리턴
            |   
            └── Constant : 상수 관리
                    속성 : (변수) static final String ASK_TRYCOUNT_MESSAGE : 시도 회수 입력해달라는 출력 메시지 ("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
                          (변수) static final String ASK_CARS_NAME_MESSAGE : 자동차 이름을 입력해달라는 출력 메시지 ("시도할 회수는 몇회인가요?")
                          (변수) static final String MOVECOUNT_RESULT_MESSAGE : "실행 결과"
                          (변수) static final String PRINT_WINNER_MESSAGE : "최종 우승자 : "
                          (변수) static final String UNIT_MOVE_BLOCK : 실행 결과에 출력되는 한 칸("-")
```

***

## 추가된 프로그래밍 요구 사항 및 검토 사항

##### 1. indent depth는 2까지만 허용한다.

##### 2. 3항 연산자를 쓰지 않는다.

##### 3. 함수/메서드가 한 가지 일만 하도록 최대한 작게 만든다.

##### 4. JUnit 5와 AssertJ를 이용하여 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

* 테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한다.

##### 5. .gitignore에 올리지 않을 파일(.clsss, .idea, .metadata)을 추가한다.

##### 6. 변수명에 중복된 문맥 제거한다.

##### 7. if, for, while 문 사이 공백

##### 8. 의미 없는 주석문은 달지 않는다.

##### 9. IDE의 자동정렬 기능을 활용한다. (mac: option + L)

##### 10. 커밋 컨벤션을 지킨다. (우테코 https://github.com/woowacourse/service-apply/commits/master 참고)

* 포맷: type(scope): subject - Subject line

***

## 부가 사항

##### MVC 패턴에 대해 공부하고 미션에 적용 할 지 고민해본다.
