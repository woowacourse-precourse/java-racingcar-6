# 자동차 경주 게임

<b> 코드 구조 </b>

```java
.
└── racingcar
    ├── Application.java
    ├── domain
    │   ├── Car.java # 자동차의 정보를 저장할 클래스
    │   └── Race.java # 자동차들의 정보와 레이스 게임 정보를 저장할 클래스
    ├── global
    │   └── message
    │       ├── ErrorMessage.java # 에러 메시지 모음
    │       └── GameProgressMessage.java # 게임 진행 메시지 모음
    ├── racingmanager # 레이싱 게임을 진행할 클래스들을 모은 디렉토리
    │   ├── GameManger.java # 게임을 진행할 매니저 생성
    │   ├── HandleNumber.java # 게임 진행에 필요한 숫자 입력을 컨트롤하는 클래스
    │   ├── SettingGame.java # 게임 진행에 필요한 정보를 세팅하는 클래스
    │   └── StartGame.java # 게임을 진행하는 클래스
    └── view # 게임 결과를 화면에 출력하는 클래스를 모은 디렉토리
        ├── HandleInput.java # 사용자의 입력을 처리하는 클래스
        ├── InputValidator.java # 입력에 대한 예외 처리를 하는 클래스
        └── PrintRaceResult.java # 레이스 결과를 출력하는 클래스 (포매팅 기능 포함)
```

## 요구 기능 목록

### Input

- 사용자가 쉼표를 구분자로 n 대의 자동차 이름을 입력할 수 있다.
- 주어진 횟수 n 동안 각 자동차마다 전진 또는 멈춤을 반복한다.

### Domain

- 사용자가 입력한 Car 정보를 담는 Car 클래스가 있다.
- Car들의 정보를 이용해서 게임을 진행할 Race클래스가 있다.

### Control

- 게임 시도 횟수만큼 게임을 진행할 수 있다.
- 각 게임 시도마다 각 자동차에게 0~9 사이의 무작위 정수를 줄 수 있다
- 자동차는 4 이상의 숫자를 받으면 1칸 전진할 수 있다.
- 각 자동차마다 게임 진행상황을 저장할 수 있다.
- 제일 멀리간 자동차를 우승자로 지정할 수 있다.

### Output

- 각 게임마다 진행상황을 출력할 수 있다.
- 우승자를 출력할 수 있어야 한다.
- 우승자가 여러명일 경우 쉼표(,) 로 구분해서 출력한다.

### Error (Constraints) Handle

- 에러가 발생할 경우 `IllegalArgumentException` 을 발생시키며 종료한다.

- 자동차 이름은 5자 이하여야 한다.
- 자동차 이름이 공백이거나 NULL 값이 아니어야 한다.
- 전진하는 조건이 0~9 사이 무작위 정수여야 한다.
- 주어진 시도 횟수는 정수여야 한다.
- 주어진 시도 횟수가 공백이거나 NULL 값이 아니어야 한다.

---

### 생각해 볼 것들

- GameManager 클래스를 인터페이스화 하여 다른 게임도 진행할 수 있도록 추상화
  - 예를 들어, 1주차 숫자 야구도 진행 가능하도록 GameManager 생성
- 더 좋은 docs 작성 방법 고민
- 더 좋은 git commit 메시지 고민
- 코드 구조에 대해 global이 racingcar 안에 있어야 하는가? (racing 관련 코드만 존재함)
- 클래스 이름에 대한 고민
  - 이후 숫자를 다룰 메서드가 추가될 것을 생각해서 HandleNumber 라는 클래스를 생성했다. 하지만 추가 된다면 HandleNumber 디렉토리 밑에 GeneratorNumber와 다른 클래스가 있는 것이 더 나은가?
- Test 코드를 클래스마다, 메서드마다 만드는 것이 좋을까?
  - 당연한 결과가 예상되는 클래스는 오버 write가 아닐까 고민
- 출력 결과를 테스트하기 편하도록, Output을 최적화 하도록 StringBuffer를 이용했다
  - 이 방식은 코드가 좀 더 길어지는 단점이 있다. 그래도 Output을 다른 곳에서 이용할 수 있도록 System.out으로 바로 출력하는 것이 아니라 String으로 반환하도록 바꿔봤다. 이게 최선일까?
