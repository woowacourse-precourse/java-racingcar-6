# 신경써서 진행해야할 것

- [ ]  요구사항을 정확히 준수

- [ ]  커밋 메시지를 의미있게 작성

- [ ]  git 에 필요한 자원만 올라갔는지 확인

- [ ]  PR 시, 브랜치 확인

- [ ]  변수명이 명확한 의도를 지니고있는가

- [ ]  공백 라인의 의도가 명확한가

- [ ]  IDE 자동 정렬 기능을 최종적으로 진행했는가

- [ ]  JAVA API 로 대체할 수 있는가*`assertRandomNumberInRangeTest`*

- [ ]  배열 대신 Java Collectiopn 을 사용했는가

- [ ]  indent(인덴트, 들여쓰기) depth 를 3이 넘지 않도록 구현한다.

  - 2까지만 허용한다.
  - 예를 들어, while 문 안에 if 문이 들어가있으면 들여쓰기는 2이다.

- [ ]  3항 연산자를 쓰지 않는다

- [ ]  함수가 한 가지 일만 하도록 한다

- [ ]  JUnit5 , AssertJ 를 이용해 본인이 정리한 기능 목록을 테스트 코드로 확인한다.

- [ ]  확인사항

  - JDK에서 제공하는 Random 및 Scanner API 대신 

    ```
    camp.nextstep.edu.missionutils
    ```

    에서 제공하는 

    ```
    Randoms
    ```

     및 

    ```
    Console
    ```

     API를 사용하여 구현해야 한다.

    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

# Mail Content

> 요구사항을 이해하는 게 어려울 수 있지만 **주어진 요구사항을 잘 파악하는 것**도 좋은 개발자의 역량 중 하나라고 생각합니다.

> 2주 차 미션에서는 1주 차에서 학습한 것에 더해 **함수를 분리**하고, 각 **함수별로 테스트를 작성하는 것**에 익숙해지는 것을 목표로 하고 있어요. 이번에 테스트를 처음 접하시는 분들은 언어별 테스트 도구를 학습하고 작은 단위의 기능부터 테스트를 작성해보길 바랍니다.

> 과제를 제출할 때 이번 주 차 목표를 중심으로 학습하면서 느낀 점을 **소감문**으로 작성해 주세요. **이때 학습한 '과정’을 잘 드러내 주세요.**

# 2주차 미션 - 자동차 경주

# 기능 요구사항

<aside> 💡 **초간단 자동차 경주 게임을 구현한다.**

</aside>

- 기능 요구사항

  - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

- 입출력 요구사항

  ### [입출력 요구 사항](https://github.com/woowacourse-precourse/java-racingcar-6#입출력-요구-사항)

  ### [입력](https://github.com/woowacourse-precourse/java-racingcar-6#입력)

  - 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

  ```
  pobi,woni,jun
  ```

  - 시도할 회수

  ```
  5
  ```

  ### [출력](https://github.com/woowacourse-precourse/java-racingcar-6#출력)

  - 각 차수별 실행 결과

  ```
  pobi : --
  woni : ----
  jun : ---
  ```

  - 단독 우승자 안내 문구

  ```
  최종 우승자 : pobi
  ```

  - 공동 우승자 안내 문구

  ```
  최종 우승자 : pobi, jun
  ```

  ### [실행 결과 예시](https://github.com/woowacourse-precourse/java-racingcar-6#실행-결과-예시)

  ```java
  경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
  pobi,woni,jun
  시도할 회수는 몇회인가요?
  5
  
  실행 결과
  pobi : -
  woni : 
  jun : -
  
  pobi : --
  woni : -
  jun : --
  
  pobi : ---
  woni : --
  jun : ---
  
  pobi : ----
  woni : ---
  jun : ----
  
  pobi : -----
  woni : ----
  jun : -----
  
  최종 우승자 : pobi, jun
  ```

- [x]  자동차를 만든다

  - [x]  자동차는 이름이 있다
    - [x]  자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. → `IllegalArgumentException`
    - [x]  이름이 5자 이하인가 → `IllegalArgumentException`
    - [x]  쉼표로 구분되어 있는가 → `IllegalArgumentException`

- [x]  자동차가 움직인다

  - [x]  전진
    - [x]  0 ~9 사이의 무작위 값을 반환한다
    - [x]  0 ~ 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
  - [x]  정지

- [x]  시도할 횟수를 정한다

  - [x]  횟수가 0을 제외한 양의 정수인가 → `IllegalArgumentException`

- [x]  주어진 횟수 동안 자동차가 움직인다

- [x]  전진하는 자동차는 이름을 같이 출력한다

- [x]  자동차 게임을 종료한다

  - [x]  자동차 경주 게임을 완료한 후 우승자를 출력한다

- [x]  우승자를 선정한다

  - [x]  우승자는 한 명 이상일 수 있다
  - [x]  여러 명일 경우 쉼표(,)를 이용하여 구분한다

- [x]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

------

# 회고

가장 기억에 남는 단어라고하면 ‘분리’다.

기본적으로 코드를 짤 때, 다른 사람이 읽었을 때도 잘 읽히는 코드가 좋은 코드라고 생각하는 사람으로서 맹목적으로 분리와 역할에 대해 집중했었던 경험이 있다.

이번 미션을 진행하면서도 맹목적으로 분리를 했다. 다만, 이제는 구조가 눈에 보이기 시작했다.

분리된 것들을 분류해보니 비슷한 역할을 하는 것들이 꽤나 많았다. 이를 다시 분류하고 조립하는 역할을 반복하다 보니 왜 프로그래밍에 디자인 패턴이 필요한 것인지도 몸으로 느끼게 되었다.

다시 한 번 느끼는 거지만, 프로그래밍에 있어서 ‘왜’가 없는 행동은 있어선 안 된다. 결과에 집중하기 보단 과정에 대해 한 번 더 고민할 수 있는 자세를 관철하자.

------

# 고민한 목록

## 1. 기능 목록 작성

- 1주차에서는 간단하게만 기능 목록을 작성하고 진행했었다

  결과적으로 기능을 작성하는 부분에 시간이 더 소모되었다

  누락된 부분을 놓치는 경우가 많았기 때문이다.

- 따라서, 2주차 미션은 미리 디테일하게 기능 목록을 작성하고 진행해보고자 했다

  다만, 패턴 관련(어떻게 객체를 나눌 것인가?)에 대해선 크게 고민하지 않고

  기능 그 자체에 집중했다.

## 2. MVC 패턴

- Springboot 로 프로젝트를 진행하면서 아무 생각없이 디자인 패턴을 이에 맞춰서 진행했던 경험이 있다.

  따라서, “그냥 하라니깐 해야겠다”로 진행했었기에 그 이유에 대해 알 수가 없었다.

- 1주차와 2주차를 진행하면서 느꼈던 부분은, ‘분리’를 중심으로 개발을 진행하다보면 자연스럽게

  기능, 출력, 조율 하는 부분으로 크게 나눠졌다.

- 기능은 말 그대로 프로세스에 있어서 필요한 기능들, 예를 들어 우승자 선정 이라던지?

  출력은 위 기능에서 구한 우승자를 출력하고

  조율은 기능과 출력을 엮어주는 역할을 하게 되었다.

- 조율 부분이 왜 필요했냐면, 출력과 기능 부분이 서로 엮여 있다보면

  출력 부분이 기능의 비즈니스 로직에 크게 얽히게 되기 때문이었다.

  따라서, 출력은 정말 출력만 담당하고 기능은 이 기능으로 만든 결과값을 어디에 쓰던지

  상관하지 않고 기능을 만드는 각자의 기능에만 충실하면 된다.

## 3. 분리

- 다음과 같은 코드가 있다. 이는 참가차량 별로 현재 위치값을 출력하는 역할들 담당하고 있다.

- 다만, 이는 최초 작성 시 Controller 단에 작성된 터라 이를 분리해야할 필요가 있었다.

  따라서, 기존에 작성되어있었던 Game Model 과 View 를 활용해서 분리를 진행해보고자 했다.

```java
public class GameController {

		private void displayCarPosition() {
	        for (Car participantCar : participantCars) {
	            String positionBar = game.getPositionBarByCar(participantCar);
	            System.out.println(positionBar);
					}
		}
}
public class Game {

    private final List<Car> participantCars;

    public Game(List<Car> participantCars) {
        this.participantCars = participantCars;
    }
}

public class GameView { } 
```

## 5. 다시 분리

https://github.com/JAY-Winter/java-racingcar-6/commit/0b87a9ada84eeeba05fadd7725acf1a6b445a9aa

- 위 커밋을 보면서 글을 적어보자.

  기존 구조같은 경우 main Application 단에서 모든 것을 처리하고 있었다.

  이것을 어떻게 ‘잘’ 표현할 수 있을까? 에 대한 물음에서 시작해 “게임을 제어하는 객체를 만들자”라는 답으로

  `GameController` 가 등장했고, 게임 로직을 처리하기 위해 `Game Model` 이 등장했고 그리고

  이 과정의 출력을 담당하기 위한 `Game View` 가 등장했다.

- 기존 코드에서는 컨트롤러가 모델과 뷰를 제어해야한다고 생각해서, Controller 생성 시 매개변수로 Model, View 를 주입시켰는데, `Game Model` 을 생성하기 위해선 `ParticipantCars` (참가차량)가 필요했다.

  근데, 이 참가 차량 데이터는 `GameController` 내부 메서드 `playGame` 에서 처리하고있었다.

- 엥? 컨트롤러를 실행하기 위해선 모델이 필요한데, 이 모델은 컨트롤러 내부에서 처리하는 값으로 생성된다?

  로직이 단단히 꼬였다.

- 이를 처리하기 위해서 컨트롤러 생성시 주입하던 Model 객체를 제거하고, 컨트롤러 내부 메서드 `setupGame` 를 통해

  `Game` 객체를 생성해 이를 필드로 직접 주입받는 방법을 선택했다.

  다만, 이 과정이 좋은 코드인지는 모르겠다. 추가로 고민해야봐야할 부분.

## 6. 입력값 검증

- 자동차의 이름을 검증하는 절차를 어떤 식으로 걸쳐야할까?

- 유저의 입력값에 콤마가 있는 지 없는 지를 판단해서 해야할까?

  ```java
  public Input(String input) {
          // 1. 입력값이 숫자, 영문, 쉼표로만 구성되어있는지 확인한다
          CarValidator.validateNameUsingCommas(input);
  
          // 2. 입력값에 콤마가 들어가있는지 확인한다
          // -> 이걸 분기 처리하는게 맞을까?
          // -> 입름에 콤마가 들어가 있는지 확인하지 않고도
          // -> Car 객체들을 생성할 수 있는 방법은 없을까?
          List<String> carNameList = Arrays.asList(Console.readLine().split(","));
  
          // 3. 이름이 5글자 이하인지 확인한다
          for (String carName : carNameList) {
              CarValidator.validateNameLength(carName);
  
              Car car = new Car(carName);
          }
      }
  ```

## 7. ParticipantCars

- 해당 객체가 왜 필요할까?

- 이는 입력값 검증과 얽혀있다.

  위에서 고민했던 부분은 “입력값에 “,” 쉼표가 들어가 있는지를 분기 처리해야할까?”로 부터 시작됐다.

  결과적으로 있는 지에 대한 여부는 상관없이 List<Car> 콜렉션으로 처리하면 되겠다 싶었다.

- 따라서, `List<Car>` 를 멤버 변수로 둔, `ParticipantCars` 일급 컬렉션이 등장하게 되었다.

  해당 멤버 변수는 절대 바뀔 일이 없고, 자동차 관련한 비즈니스 로직에서만 사용될 것이다.

  ```java
  public class ParticipantCars {
  
      private final List<Car> participantCars;
  
      public ParticipantCars(List<Car> participantCars) {
          this.participantCars = participantCars;
      }
  }
  ```

## 8. 의존성

- MVC 패턴으로 아키텍처를 구성하다보니 문득 이런 생각이 들었다.

  “Controller 에서 Model 을 주입받는게 과연 올바른 구조일까?”

- 현재는 Game Model 밖에 없고, Controller 도 Game Controller 하나 밖에 없으니, 대응하는 것은 어렵지 않다.

  다만, Game Controller 에서 처리해야할 Model 의 수가 늘어나면? 어떻게 될까?

  해당 컨트롤러는 너무 많은 Model 에 의존하게 될 수 밖에 없다.

- 이렇게 되면, Controller 의 역할이 너무 늘어날 수도 있고 이에 따라, 역할이 불분명해질 수도 있다.

## 8-1. 의존성으로 인한 단위 테스트가 어지럽다

- 현재 Controller 에서 게임 진행 프로세스를 담당하고 있다.

  따라서, 아래 테스트 코드를 작성하고자 할 때, 문제가 발생한다.

- `GameController` 에서 `playRounds()` 을 통해 `game` 인스턴스의 `moveCar()` 를 호출한다.

- 이에 따라서, “자동차는 숫자가 3이면 움직이지 말아야 한다”라는 테스트를 실행하기 위해서

  컨트롤러를 생성하고 → 게임 모델을 생성하고 → 테스트를 해야하는 말도 안되는 과정이 발생해버렸다.

- 이를 해결하기 위해선 **8.의존성** 고민의 연장선에 따라 `Service`  단이 등장해야할 것 같다.

```java
@Test
void 랜덤_숫자가_3이면_정지한다() { }

// GameController
private void playRounds() {
    for (int i = 0; i < rounds; i++) {
        game.moveCar();

        gameView.displayCurrentCarPosition(game.getCurrentParticipantCarPosition());
    }
}

// Game
public void moveCar() {
    for (Car car : participantCars) {
        if (isCarMoveToForward()) {
            car.move();
        }
    }
}

private boolean isCarMoveToForward() {
    return new RandomNumber().getNumber() >= 4;
}
```

## 9. Service Layer

> 이제 왜 프로젝트를 하면서 Service Layer 를 분리해야하는지 알겠다..!

- 게임 프로세스 관련 진행 로직을 서비스 단위로 분리했다.

- 이에 따라서, 단위 테스트 또한 편리하게 진행할 수 있게 되었다.

  기존 로직에서는 컨트롤러 → 게임 객체 생성 및 할당 → 로직 처리 테스트

  세 단계에 거쳐서 테스트 코드를 작성해야했는데,

  서비스 레이어로 분리하게 되면 해당 레이어에서 게임 객체 생성 및 테스트 까지 진행할 수 있다.

- (덤으로, 테스트 코드를 다 뜯어서 확인하니 테스트 코드를 작성하는 것도 수월해졌다!)

```java
public class GameService {

    public Game createGame(List<Car> participantCars) {
        return new Game(participantCars);
    }

    public List<Car> setupParticipantCars(List<String> carNameList) {
        return carNameList.stream()
            .peek(CarValidator::validateNameLength)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public int setupRounds(String input) {
        RoundValidator.validateRounds(input);
        return Integer.parseInt(input);
    }

    public void controlCar(Game game) {
        game.moveCar();
    }

}
public class GameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final GameService gameService = new GameService();

    @Test
    void 전진_정지_단위_테스트() {
        Game GAME = gameService.createGame(
            gameService.setupParticipantCars(List.of("jay", "ted")));

        assertRandomNumberInRangeTest(
            () -> {
                for (int i = 0; i < 4; i++) {
                    gameService.controlCar(GAME);
                }
                assertThat(output()).contains("1", "1", "1", "2");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
    }
}
```

# Java 공부

## 1. Test

```java
@Test
void 이름이_5자_이하인가() {
    String acceptName = "김수한무";
    String unAcceptName = "김수한무거북이";

    assertDoesNotThrow(() -> carValidator.validateNameLength(acceptName));

    assertThrows(IllegalArgumentException.class,
        () -> carValidator.validateNameLength(unAcceptName));
}
```

- ```
  assertDoseNotThrow()
  ```

  - 주어진 람다 표현식 또는 실행 가능한 코드가 예외를 발생시키지 않는지 확인한다.
  - 예외를 발생시키지 않으면 테스트는 통과한다.

- ```
  assertThrows()
  ```

  - 주어진 코드가 예외를 발생시키는지 확인한다.
  - **첫 번째 인자로 예상되는 예외 클래스를 전달하고, 두 번째 인자로 예외 발생을 기대하는 코드를 작성한다.**

## 2. args

```java
public String format(Object... args) {
        return String.format(message, args);
}
```

## 3. 우테코 Test 구조 분석

```java
@Test
void 게임종료_후_재시작() {
    assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
            },
            1, 3, 5, 5, 8, 9 // Random.pickNumberInRange 가 반환해야하는 예상 난수 값의 시퀀스
    );
}

-> pickNumberInRange 로 "135", "589" 가 만들어짐

===
// 난수 생성 테스트
public static void assertRandomNumberInRangeTest(
    final Executable executable, // 실행할 테스트 로직을 람다 형식으로 전달
    final Integer value, // 난수 생성기가 반환해야할 순차적인 값들
    final Integer... values // 난수 생성기가 반환해야할 순차적인 값들
) {
		// 실제 난수 생성기의 결과를 제어함
    assertRandomTest(
        () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
        executable,
        value,
        values
    );
}

===
// 주어진 입력 (args) 로 애플리케이션을 실행함
protected final void run(final String... args) {
    try {
				// command 를 사용하여 입력 스트림을 설정하고
        command(args);
				// runMain 메소드를 호출
        runMain();
		// 테스트 실행이 끝나면 Console.close 메소드를 호출하여 콘솔을 닫음
    } finally {
        Console.close();
    }
}

===
// 테스트를 위한 입력 데이터를 준비
private void command(final String... args) {
		// 입력 문자열 args 를 바이트 배열로 변환
    final byte[] buf = String.join("\\n", args).getBytes();
		// System.setIn 을 통해 ㅅ시스템 입력 스트림으로 설정
		// -> 테스트 중에 사용자 입력을 시뮬레이션 하는데 사용됨
    System.setIn(new ByteArrayInputStream(buf));
}

===
// 테스트 실행 결과의 출력을 캡처하고 반환한다
protected final String output() {
    return captor.toString().trim();
}
```

## 3-1. Application Test 를 뜯어보자

```java
package game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.controller.GameController;
import racingcar.view.GameView;

public class GameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jay", "1");
                assertThat(output()).contains("pobi : ", "woni : ", "jay : -", "최종 우승자 : jay");
            },
            STOP, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
```

- 결과값

```java
> Task :compileJava UP-TO-DATE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
> Task :test
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
시도할 회수는 몇회인가요?
실행결과
pobi : 
woni : 
jay : -

최종 우승자 : jay
```

- 테스트 코드 어디서 뭘 호출했길래 명세에 작성된 아래 문자열이 나오는 걸까?

  “경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)”

  “시도할 회수는 몇회인가요?”

  “실행결과”

- 파일의 실행 순서

  - 우선, 해당 `[GameTest.java](<http://GameTest.java>)` 파일이 JVM 의 컴파일을 거쳐 바이트코드로 변환된다.

    JVM 의 클래스 로더가 해당 바이트코드를 메모리에 로드한다.

    이후 JVM 은 클래스의 main() 메서드를 찾아 실행하는데, 테스트의 경우 JUnit 테스트 러너가

    `@Test` 어노테이션으로 표시된 모든 테스트 메서드를 실행하게 된다.

    이렇게 할 수 있는 이유는, `JUnit` 내부적으로 `Reflection API` 를 사용해서 이러한 메서드를 찾고 실행한다.

    `Reflection API` 가 어노테이션 정보(`@Test, @BeforeEach, @AfterEach`) 등을 읽고 이를 실행한다.

    - ```
      Reflection API
      ```

      - 클래스 정보 얻기 : 런타임 시, 클래스의 이름, 슈퍼클래스 등의 정보를 얻는다
      - 객체 생성 : 런타임  시, 개겣를 동적으로 생성한다
      - 필드 접근 및 수정 : 클래스의 필드에 접근하거나 수정한다. private 필드에도 접근할 수 있다
      - 메서드 호출
      - 어노테이션 정보 읽기

- `Refelection API` 가 `@Test` 어노테이션을 읽고 이를 실행한다.

  이때, `assertRandomNumberInRangeTest` 가 실행되는데 람다식으로 넘어온 `run()` 메서드를 호출하게된다.

  `run()` [메서드 내부 호출을 살펴보면](https://www.notion.so/2-d72902087da848c6ba94ef8f246d0e53?pvs=21) `runMain()` 을 호출하는데, 이는 `NsTest` 를 상속받아 구현한 해당 `GameTest` 의 `runMain()` 를 호출하게 된다. 이에, 실제 `Application.java - main()` 가 호출되는 것이다.

  `Application.java - main()` 메서드에 아래 출력문을 실행하는 메서드가 작성되어 있었기에

  이와 같은 결과를 확인할 수 있는 것이다.

  > 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) 시도할 회수는 몇회인가요? 실행결과

- 그러면 “경주할 자동차 이름을 입력하세요” 에 따라, `Console.readLine()` 이 실행되는데,

  이를 입력하지 않음에도 불구하고 후속 메서드가 실행되는 이유는 무엇일까?

## 3-2. 입력값을 어떻게 처리하지?

- 우선, 위 코드를 따라가다 보면 `assertRandomNumberInRangeTest` 의 `run()` 가 호출된다는 것을 알 수 있다.

  그럼 `run()` 을 뜯어보면 `command()` 메서드를 호출한다는 것을 알 수 있다.

```java
protected final void run(final String... args) {
        try {
            command(args);
            runMain();
        } finally {
            Console.close();
        }
    }
private void command(final String... args) {
        final byte[] buf = String.join("\\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
```

- `command` 메서드에서 매개변수로 받은 입력값을 `String` 클래스의 `join()` 메서드를 호출해 결과값을 바이트 코드로 변환한다.

- 그리고, `Java` 표준 입력 스트림 `[System.in](<http://System.in>)` 을 대체하는 `System.setIn()` 을 변환된 입력값을 매개변수로 할당하며 이를 호출한다.

  즉, `Console.readLine()` 을 대체한다고 생각하면 된다.