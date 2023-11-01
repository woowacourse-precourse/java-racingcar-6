# 💻 구현 기능 정리 💻

지금까지 객체지향프로그래밍을 해본 경험이 없어서 이번 기회에 MVC 패턴을 적용한 객체지향프로그래밍을 하기로 했다. 
먼저, MVC 패턴에 대해 공부를 하기 위해 여러 자료를 살펴보았다. 그런데 MVC 패턴은 사람마다 정의하는 방식이 다르고 명확한 해답이 없다는 것을 알게 되었다. 

따라서 나는 아래와 같은 MVC 패턴을 참고하여 코드를 작성하였다.

> 1. **Model은 Controller와 View에 의존하지 않아야 한다.**
> 
> - Model 내부에 Controller와 View에 관련된 코드가 있으면 안 된다.
>
> 2. **View는 Model에만 의존해야 하고, Controller에는 의존하면 안 된다.**
>
> - View 내부에 Model의 코드만 있을 수 있고, Controller의 코드가 있으면 안 된다.
>
> 3. **Controller는 Model과 View에 의존해도 된다.**
>
> - Controller 내부에는 Model과 View의 코드가 있을 수 있다.
>
> 4. **View가 Model로부터 데이터를 받을 때는 사용자마다 다르게 보여줘야 하는 데이터에 대해서만 받아야 한다.**
> 
> 
> 5. **View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다.**


위와 같은 다섯 가지 원칙을 따라 클래스를 정의하고, 그에 해당하는 메소드 및 필드를 정의했다.
각각의 메소드는 최소한의 기능만 하도록 작성하였다.

**구분을 위해 클래스, 메소드, 필드 각각에 아이콘을 부여하였다.**

### 📦 | class

### 🛠️ | method

### 📃 | field

<br>
<br>
<br>

## Model

> 프로그램에서 사용될 데이터 모델.
>

### 📦 Car

> 자동차 객체를 만들 클래스.
>

**📃 private String name**

- 자동차의 이름을 저장할 변수

**📃 private Integer steps**

- 자동차의 전진 수를 저장할 변수

**🛠️ public Car(String)**

- 생성자 메소드

**🛠️ public String name()**

- 자동차의 이름 반환

**🛠️ public Integer steps()**

- 해당 자동차 인스턴스의 현재 전진 수 반환

🛠️ **public void addStep(Integer)**

- 랜덤 정수 인자 값에 따라 해당 자동차 인스턴스의 전진 수 += 1 (정수값 ≥ 4일 때 + 1)

### 📦 CarStorage

> 자동차를 리스트 단위로 관리하는 클래스. 객체를 한 번에 관리하기 때문에 모든 필드와 메소드를 static으로 정의.
>

**📃 private static List<Car> winners**

- 우승 자동차 객체를 담을 변수

**📃 private static List<Car> cars**

- 모든 자동차 객체를 담을 변수

**📃 private static List<Integer> stepsList**

- 모든 자동차의 전진 수를 담을 변수

**🛠️ public CarStorage()**

- 생성자 메소드

**🛠️ public static void init()**

- 필드 초기화

**🛠️ public static List<Car> cars()**

- 자동차 객체 리스트 반환

**🛠️ public static void addCar(Car)**

- 자동차 객체 추가

**🛠️ public static List<Car> winners()**

- 우승 자동차 객체 리스트 반환

**🛠️ public static void addWinner(Car)**

- 우승 자동차 객체 추가

**🛠️ public static Integer getMaxSteps()**

- 최대 전진 수를 계산하여 반환

**🛠️ private static List<Integer> getStepsList()**

- 모든 자동차들의 전진 수를 리스트에 저장하고 반환

## View

> 사용자에게 보여지는 부분.
>

### 📦 UserView

> 사용자에게 보여질 화면을 출력하기 위한 메소드들을 정의한 클래스.
>

**🛠️ public UserView()**

- 생성자 메소드

**🛠️ public void printInputNameMessage()**

- 자동차 이름을 입력받기 위한 메시지 출력

**🛠️ public void printInputCountMessage()**

- 실행 횟수를 입력받기 위한 메시지 출력

**🛠️ public void printResultMessage()**

- 실행 결과를 출력하기 위한 메시지 출력

**🛠️ public void printCurrentResult()**

- 현재 실행 결과를 출력

**🛠️ public void printWinners()**

- 우승자를 출력

## Controller

> Model과 View를 연결.
>

### 📦 GameManager

> 프로그램의 시작점.
>

**📃 private UserView userView**

- userView 객체

**📃 private User user**

- user 컨트롤러 객체

**📃 private Integer tryCount**

- 게임 실행 횟수 변수

**🛠️ public GameManager()**

- 생성자 메소드
- userView와 user 객체를 초기화

**🛠️ public void play()**

- 게임 실행 메소드
- 사용자 입력받기
- 실행 결과 출력
- …

**🛠️ private void choiceWinner()**

- 우승자를 계산하는 메소드

### 📦 User

> 사용자의 입력을 받는 클래스.
>

**🛠️ public void inputCarNames()**

- 자동차 이름을 입력받는 메소드

**🛠️ public Integer inputTryCount()**

- 실행 횟수를 입력받는 메소드

**🛠️ public Integer pickRandomInt()**

- 0~9 사이의 랜덤 정수를 입력받는 메소드 (사용자 입력 x)

### 📦 InputException

> 입력에 대한 예외를 처리하는 클래스.
>

**🛠️ private InputException()**

- 생성자 메소드 (생성자를 사용하지 못하도록 private으로 선언)

**🛠️ public static void checkAllCarName(String)**

- 자동차 이름에 대한 모든 예외를 실행

**🛠️ public static void checkAllTryCount(String)**

- 실행횟수에 대한 모든 예외를 실행

**🛠️ private static void checkNameLength(String)**

- 자동차 이름의 길이가 5 초과라면 예외 발생

**🛠️ private static void checkOnlyInt(String)**

- 자동차 이름이 숫자로만 이루어져 있으면 예외 발생

**🛠️ private static void checkExistCar(String)**

- 자동차 이름이 이미 존재한다면 예외 발생

**🛠️ private static void checkTryCountOverZero(String)**

- 자동차 이름이 이미 존재한다면 예외 발생

**🛠️ private static void checkTryCountNonInteger(String)**

- 자동차 이름이 이미 존재한다면 예외 발생

## Utility

> MVC 외의 것들이 여기에 해당한다. 이 프로그램에서는 상수를 정의하는 용도로 사용하였다.
>

### 📦 Constants

> 프로그램에서 사용할 메시지 혹은 정규식 등을 상수로 정의
>

**📃 public static final String *INPUT_CAR_NAME***

- "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)”

**📃 public static final String *INPUT_TRY_COUNT***

- "시도할 회수는 몇회인가요?”

**📃 public static final String *RESULT***

- "실행결과”

**📃 public static final String *COLON***

- " : “

**📃 public static final String LINE**

- "-”

**📃 public static final String *COMMA***

- ",”

**📃 public static final String WINNERS**

- "최종 우승자”

**📃 public static final Integer MAX_LENGTH**

- 5

**📃 public static final String ONLYINT**

- "\\d+” (정규식 표현)

## Test

> 사용자가 입력하는 예외 경우에 대한 테스트 코드를 추가하였다.
>

**🛠️ void 숫자로만_이루어진_이름에_대한_예외_처리()**

- 이름이 정수로만 이루어지도록 입력하는 경우

**🛠️ void 이미_존재하는_이름에_대한_예외_처리()**

- 자동차 이름이 이미 존재하는 것을 다시 입력하는 경우

**🛠️ void 이름이_공백인_경우에_대한_예외_처리()**

- 자동차 이름 리스트 중 하나가 공백인 경우

**🛠️ void 이름이_공백인_경우에_대한_예외_처리_2()**

- 자동차 이름 전체가 공백인 경우

**🛠️ void 실행횟수가_음수인_경우에_대한_예외_처리()**

- 실행횟수가 음수인 경우

**🛠️ void 실행횟수가_0인_경우에_대한_예외_처리()**

- 실행횟수가 0인 경우

**🛠️ void 실행횟수가_정수가_아닌_경우에_대한_예외_처리()**

- 실행횟수가 정수 타입이 아닌 경우


## 참고 자료
[[10분 테코톡] 🧀 제리의 MVC 패턴](https://www.youtube.com/watch?v=ogaXW6KPc8I)

[[10분 테코톡] 도기의 MVC 패턴](https://youtu.be/Yzx-z6kCD2A?si=mRZmMu1oGRt8mnEs)

[MVC 패턴이란?](https://velog.io/@seongwon97/MVC-패턴이란)
