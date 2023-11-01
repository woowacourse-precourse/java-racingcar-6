<div align="center">

# 자동차 경주 미션 🏎️
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/><br>

</div>

## 👩🏻‍💻 구현할 기능 목록

1. 경주 할 자동차의 이름과 이동 횟수를 입력 받는다.<br>
   ✦ 이름은 _쉼표_ 로 구분되며 _5자_ 이하이다. <br><br>
2. 각 자동차는 무작위 정수를 뽑아 4 이상인 경우 전진한다.<br>
   ✦ 정수의 범위는 _0부터 9_ 이다.<br><br>
3. 각 이동 차수별 실행 결과를 아래와 같이 출력한다.<br>
   ```
      jongmi : --
      meoru : ----
      gari : ---
   ```
4. 자동차 경주 게임을 완료한 후 우승자(가장 많이 전진한 자동차)를 구하고 출력한다.<br>
   ✦ 우승자는 여러 명일 수 있고 쉼표로 구분하여 출력한다.<br><br>


## 🏛️ 프로젝트 패키지 구조

```bash
└── main
    ├── Application.java
    ├── configuration
    │   └── AppConfig.java
    ├── view
    │   ├── InputView.java
    │   └── OutputView.java
    ├── dto
    │   ├── request
    │   │   ├── CarNamesDto.java
    │   │   └── ActionCountDto.java
    │   └── response
    │       ├── MovementDto.java
    │       └── WinnersDto.java
    ├── controller
    │   └── RacingController.java
    ├── service
    │   └── RacingService.java
    ├── domain
    │   ├── CarRepository.java
    │   └── Car.java
    └── utility
        ├── Reader.java
        └── Writer.java
```

1. <b>Application</b><br>
   ✦ 프로그램을 실행한다.<br><br>
2. <b>Configuration</b><br>
   ✦ 각 클래스의 의존성을 주입해준다.<br>
   ✦ 생성자 주입으로 각 클래스의 의존성을 주입(<b>D</b>ependency <b>I</b>njection)했다. 
   의존성 주입을 통해 클래스 간의 결합도를 낮춰 리팩토링과 클래스 테스트를 하기 쉽도록 하였다.<br><br>
3. <b>View</b><br>
   ✦ 사용자의 입력을 받거나 프로그램의 결과를 출력한다.<br><br>
4. <b>Dto</b><br>
   ✦ 프로그램에서 주고 받는 데이터 객체이다.<br>
   ✦ 사용자의 입력으로 요청 받은 항목은 request 패키지에 위치한다. 입력 값을 프로그램에서 사용할 자료구조로 변환하고 검증한다.<br>
   ✦ 프로그램의 응답은 response 패키지에 위치한다.<br><br>
5. <b>Controller</b><br>
   ✦ View와 Service를 사용하며 프로그램을 제어한다.<br><br>
6. <b>Service</b><br>
   ✦ 핵심 로직을 담당한다.<br><br>
7. <b>Domain</b><br>
   ✦ 엔티티는 프로그램에서 저장할 데이터를 객체화 한 것이다. 같은 엔티티끼리는 같은 속성을 가진다.<br>
   ✦ 레포지토리는 데이터 저장소이다. 데이터를 삽입하거나 삭제, 조회하는 등 데이터 처리 메서드를 정의한다.<br><br>
8. <b>Utility</b><br>
   ✦ 프로그램에서 사용하는 도구들이다.<br>
   ✦ 다른 입출력 방식으로 변경이 쉽도록 Reader와 Writer 클래스를 생성하였다. <br><br>

## 🚨 입력 예외 처리
`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 통해 `String`으로 입력 받은 값은 아래의 형식을 지켜야 한다.

1. 자동차 이름은 쉼표로 구분되며 한 이름은 1자 이상 5자 이하이다.<br><br>
2. 자동차 이름은 서로 다르다.<br><br>
3. 시도할 회수(이동 회수)는 음이 아닌 정수이다.<br><br>

## 📑 로그
1. **첫 번째 구현 (2023.10.30)** <br><br>
   1. 프로젝트 <b>구조</b> 설계 시 고려한 부분 <br>
      ✦ <b>계층형 아키텍쳐</b> (Layered Architecture)를 사용하였다. <br>
      ✦ 직접 찾아보고 판단한 <b>장점</b>은 아래와 같다.<br>
        - 각 계층간 책임이 분명하므로 기능별로 코드를 분리할 수 있다. 코드의 가독성, 확장성, 재사용성을 높인다.
        - 기능별(presentation, application, domain)로 테스트 코드를 작성할 수 있다.
        - 각 계층은 같거나 아래의 계층에만 의존한다. 테스트 코드를 작성할 때 의존 관계 설정을 직관적으로 할 수 있다. 
          예를 들어, 서비스 코드(application 계층) 테스트를 위해 필요한 의존 설정은 레포지토리 설정이다.<br><br>
   2. 1주차 미션보다 <b>개선</b>된 부분 <br>
      ✦ <b>MVC 패턴</b>을 사용하였다. <br>
      ✦ Controller가 View와 Model을 잇고 프로그램을 제어한다. 특히 View와 Application의 main 메서드 간의 역할 분리를 분명히 하였다.<br>
      ✦ 기능을 구현한 뒤 단위 테스트를 바로 진행하였다. <br>
      ✦ 피어 리뷰를 통해 알게 된 ParameterizedTest, 일급 컬렉션을 도입하였다.<br><br>

2. **두 번째 구현 (2023.10.31~2023.11.1)** <br><br>
   1. <b>리팩토링</b> 중 집중한 부분<br>
      ✦ utility, constants 패키지와 같이 코드를 분리해서 관리하여 재사용성과 가독성을 높였다.<br>
         ➡️ 테스트코드를 작성하기 쉬워지는 이점도 얻을 수 있다.<br>
      ✦ 메서드를 분리하여 메서드의 역할을 분명히 하였다.<br>
         ```java
        /* 리팩토링 커밋 중 하나를 예시로 가져왔습니다 */ 
        // 기존
         public CarNamesDto(String carNames) {
           this.names = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
           validateNameLength(names);
         }
      
         // 리팩토링 후
         public CarNamesDto(String carNames) {
            this.names = parseNames(carNames);
            validateNameLength(names);
         }
         private List<String> parseNames(String carNames) {
           String[] names = carNames.split(CAR_NAME_DELIMITER);
           // 생략
         }
         ```