# 미션 - 자동차 경주

## 📄 파일 구조

```

├── main
│   └── racingcar
│       ├── Application.class
│       ├── CarPosition.class
│       ├── config
│       │   ├── RandomConfig.class
│       │   └── ValidatorConfig.class
│       ├── controller
│       │   └── RacingController.class
│       ├── domain
│       │   ├── Car.class
│       │   └── Game.class
│       ├── service
│       │   ├── CarService.class
│       │   └── GameService.class
│       ├── utils
│       │   ├── BuilderUtils.class
│       │   └── RandomUtils.class
│       │   ├── CarNameValidator.class
│       ├── validator
│       │   └── RoundCountValidator.class
│       └── view
│           ├── CarNameErrorMessage.class
│           ├── InputMessage.class
│           ├── OutputMessage.class
│           └── RoundCountErrorMessage.class
└── test
    ├── racingcar
    │   ├── ApplicationTest.class
    │   ├── domain
    │   │   ├── CarTest.class
    │   │   └── GameTest.class
    │   ├── service
    │   │   ├── CarServiceTest.class
    │   │   └── GameServiceTest.class
    │   ├── utils
    │   │   ├── BuilderUtilsTest.class
    │   │   └── RandomUtilsTest.class
    │   ├── validator
    │   │   ├── CarNameValidatorTest.class
    │   │   └── RoundCountValidatorTest.class
    │   └── view
    │       └── OutputMessageTest.class
    └── study
       └── StringTest.class
```
<hr>

##  📒 구현 기능 목록
### 1. 사용자는 자동차 이름을 입력한다.
- [x] 게임 시작시 문구 출력
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
```
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 예외처리
  - [x] 빈 문자를 입력하는 경우
  - [x] 자동차 이름에 공백이 있는 경우
  - [x] 자동차 이름이 중복되는 경우
  - [x] 자동차 이름에 특수문자가 포함되는 경우
  - [x] 자동차 이름이 5글자를 초과하는 경우
  
### 2. 사용자는 게임 횟수 n을 입력한다.
- [x] 회수 입력전 문구 출력
```
시도할 회수는 몇회인가요?
```
 - [x] 입력받은 n의 수만큼 게임을 진행한다.
 - [x] 예외처리
   - [x] 정수가 아닌 문자를 입력하는 경우
   - [x] 0 이하인 경우

### 3. 시스템은 자동차의 위치를 결정한다.
  - [x] 0~9 사이의 랜덤값을 생성한다.
    - [x] 0~3 이면 정지
    - [x] 4~9 이면 전진
  
### 4. 게임을 진행할때 마다 자동차의 위치를 이름과 같이 출력한다.
```
[ 자동차 이름 : 위치만큼 (’-’) 의 수 ]
```
    
### 5. 자동차 경주 게임을 완료한 후 우승자를 출력한다.
```
최종 우승 : "우승자 이름"
```
- [x] 가장 많이 전진한 자동차가 우승자로 결정된다.
   - [x] 우승자는 여러명 가능하다.
   - [x] 쉼표(,) 로 구분한다.
<hr>

## 📌 프로그래밍 요구 사항
#### 1. JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.
#### 2. 프로그램 실행의 시작점은 Application의 main()이다.
#### 3. build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
#### 4. Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
##### 5. 프로그램 종료 시 System.exit()를 호출하지 않는다.
#### 6. 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
#### 7. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
#### 8. ndent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
#### 9. 3항 연산자를 쓰지 않는다.
#### 10. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
#### 11. JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- 테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.

<hr>

## 📝 과제 진행 요구 사항
#### 1. 미션은 java-racingcar-6 저장소를 Fork & Clone해 시작한다.
#### 2. 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.
#### 3. Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가한다.
#### 4. 커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성한다.
#### 5. 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.

<hr>

## ❗️ 1주차 공통 피드백
#### 1. 요구사항을 정확히 준수한다.
#### 2. 커밋 메시지를 의미 있게 작성한다.
#### 3. Git을 통해 관리할 자원에 대해서도 고려한다.
#### 4. Pull Request를 보내기 전 브랜치를 확인한다.
#### 5. PR을 한 번 작성했다면 닫지 말고 추가 커밋을 한다.
#### 6. 이름을 통해 의도를 드러낸다.
#### 7. 축약하지 않는다.
#### 8. 공백도 코딩 컨벤션이다. 
#### 9. 공백 라인을 의미있게 사용한다.
#### 10. space와 tab을 혼용하지 않는다.
#### 11. 의미 없는 주석을 달지 않는다.
#### 12. IDE의 코드 자동 정렬 기능을 활용한다.
#### 13. Java에서 제공하는 API를 적극 활용한다.
#### 14. 배열 대신 Java Collection을 사용한다.
