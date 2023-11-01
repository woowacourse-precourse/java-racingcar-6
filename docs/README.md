## 목표 및 기능 목록

### 목표
- 자동차 경주 만들기
  - n대의 자동차가 m번 전진하며 각 진행률 출력
  - m번의 전진이 끝나면 최종 우승자 출력 (1대 이상)

### 기능 목록
1. 사용자로 부터 경주 할 n대의 자동차 이름을 입력받는다.
   - 각 자동차는 `,` 를 기준으로 구분된다.
   - 이때 각 자동차의 이름은 이후에 출력될 때 활용된다.
   - 이름이 5글자 넘어가는 경우 `IllegalArgumentException` 예외를 발생시킨다.
2. 사용자로 부터 몇 번 전진할 것인지 입력받는다.
   - 숫자 이외의 값을 입력하는 경우 `IllegalArgumentException` 예외를 발생시킨다.
3. 컴퓨터가 생성한 0~9의 무작의 값의 결과가 4 이상일 경우 전진한다.
4. 모든 차량이 0~9의 결과에 따라 전진 후 `-` 를 통해 각각의 실행 결과를 누적해서 보여준다.
   - 이때 위에서 입력받은 자동차의 이름과 함께 출력된다.
5. 가장 많이 이동한 차량이 우승한다.
   - 최종 우승자는 1명 이상일 수 있다.
   - 자동차 이름으로 출력한다.
6. 예외가 발생하면 어플리케이션을 종료시킨다.

## 파일 구조
```bash
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── constant
│           │   ├── ExceptionMessage.java
│           │   ├── NumberConstant.java
│           │   └── OutputConstant.java
│           ├── controller
│           │   ├── InitController.java
│           │   └── ProgressController.java
│           ├── domain
│           │   └── Car.java
│           ├── dto
│           │   └── InitDto.java
│           ├── exception
│           │   ├── InvalidValueException.java
│           │   └── LengthExceedException.java
│           ├── repository
│           │   ├── CarRepositoryImpl.java
│           │   └── Repository.java
│           ├── service
│           │   ├── InputService.java
│           │   ├── InputServiceImpl.java
│           │   ├── NumberGenerateService.java
│           │   ├── NumberGenerateServiceImpl.java
│           │   ├── RacingService.java
│           │   └── RacingServiceImpl.java
│           ├── validate
│           │   └── InputValueValidate.java
│           └── view
│               ├── InputView.java
│               └── OutputView.java
└── test
    └── java
        ├── racingcar
        │   ├── ApplicationTest.java
        │   ├── CarRepositoryTest.java
        │   ├── RacingServiceTest.java
        │   ├── TotalTest.java
        │   └── ValidateTest.java
        └── study
            └── StringTest.java
```

## 커밋 컨벤션
**태그** : 제목의 형태이며, :뒤에만 space가 있도록 한다.

feat : 새로운 기능 추가

fix : 버그 수정

docs : 문서 수정

style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우

refactor : 코드 리펙토링

test : 테스트 코드, 리펙토링 테스트 코드 추가

chore : 빌드 업무 수정, 패키지 매니저 수정
