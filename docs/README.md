### 객체 간의 협력관계 파악하기

<img src="./racing-car-object-collaborate.png" >

### 프로그래밍 요구사항

- JDK 17버전에서 동작해야한다. [ ✅ ]
- 들여쓰기 depth를 3이 넘지 않도록 구현해야한다. (ex: while문 안에 if문이 있으면 들여쓰기는 2이다.) [ ✅ ]
- 3항 연산자를 쓰지 않는다. [ ✅ ]
- Random  및 Scanner API대신 `camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()`를 사용한다. [ ✅ ]
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다. [ ✅ ]


MVC패턴으로 작성한다.

### View

- **InputView (입력화면)**
  - `public` **’경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)’** 를 출력 및 사용자는 경주할 자동차 이름을 입력한다.  [ ✅ ]
    - 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException` 을 발생시킨다. [ ✅ ]
  - `public`  ‘**시도할 회수는 몇회인가요?’** 를 출력 및 시도횟수를 입력한다.  [ ✅ ]
    - 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException` 을 발생시킨다.  [ ✅ ]

- **OutputView (출력화면)**
  - `-` 을 이용하여, n대의 자동차의 이동 현황을 출력한다. 이때, 자동차 이름을 같이 출력한다. [ ✅ ]
  - `최종 우승자 :`  출력 및 우승자가 여러명일 경우, `,` 를 이용하여 구분한다. [ ✅ ]

### Controller

- **RacingController (자동차 경주를 담당하는 컨트롤러)**
  - `public` 사용자가 입력한 자동차 이름과 시도횟수를 토대로, n대의 자동차는 `RandomGenerator`에서 생성된 랜덤의 값으로 전진 혹은 멈출 수 있다. [ ✅ ]

### Util

- **RandomGenerator**
  - `public` 0에서 9사이의 무작위 값을 구하기 위해 `Randoms.pickNumberInRange(0,9);` 를 이용한다.  [ ✅ ]
- **StringUtils**
  - `public` 사용자가 입력한 자동차의 문자열을 구분자인 ,를 기준으로 String[]배열에 저장한다. [ ✅ ]
  - `public` 자동차 이름의 양 끝 공백을 제거하여 올바르게 자동차 이름이 저장될 수 있도록 한다. [ ✅ ]
- **ErrorMessages**
  - `public`  예외메시지를 처리한다. [ ✅ ]

### **Model**

- **Car**
  - 자동차의 이름과 위치를 저장하기 위한 객체
  - `private` 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. [ ✅ ]
  - `public` 전진하는 조건은 0에서 9 사이에서 얻은 무작위값이 4 이상일 경우이다. [ ✅ ]

- **Cars**
  - n대의 를 저장하기 위한 객체
  - `private` 자동차 이름이 중복될 경우, `IllegalArgumentException` 을 발생시킨다. [ ✅ ]

- **TryCount**
  - 사용자가 입력한 시도횟수를 저장하기 위한 객체
  - `private` 사용자가 입력한 시도횟수가 음수거나, 숫자가 아닌 경우 `IllegalArgumentException` 을 발생시킨다. [ ✅ ]

- **Winners**
  - 우승자와 우승자의 위치를 저장하기 위한 객체
  - `public` 위치가 가장 큰 것을 기준으로 우승자를 판별한다. 이때 위치의 최댓값으로 하는 자동차가 여러개라면, 공동 우승자로 처리한다.  [ ✅ ]