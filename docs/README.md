## 🚀기능정리

---
#### 시작 (사용자 입력)
- [x] 경주할 자동차 이름 쉼표로 구분하여 입력
- [x] 문자열인지 검증
- [x] 길이가 1이상 5이하인지 검증
---
- [x] 시도할 횟수 입력
- [x] 숫자인지 검증
- [x] 어느정도 범위까지 숫자를 입력받을 것인지 고민
---
#### 비즈니스 로직
- [x] 입력받은 시도 횟수 만큼 반복 기능
- [x] 시도 횟수마다 각각의 랜덤차 무작위 숫자 받기
- [x] 무작위 숫자가 4이상인 경우 전진 확정
---
#### 결과
- [x] 우승자가 2명 이상인 경우(쉼표를 이용하여 구분)
- [x] 우승자가 1명인경우
- [x] 우승자가 없는 경우(개인적으로 처리하고 싶어서 +추가)
- [x] 우승자 순서가 뒤집혔을 때도 맞는지 검증(개인적으로 처리하고 싶어서 +추가)

#### 리팩토링
- [x] controller 더 작은 기능으로 클래스 분리 (RacingGame -> RacingGame, CalculatingScore, MovingCars, PrizingWinners)
- [x] 필요한 Test 코드 작성
- [x] 접근제어자 및 가독성을 위한 네이밍 및 구조 변경
---

## 🎯과제를 수행하며 발생한 문제 및 해결방법 

**public, private, static, final 짚고가기**
: OutputView 출력문을 같은 레벨의 디렉토리 내 클래스에서 사용하려 했는데 잘못 알고 사용하여, 키워드에 대한 정확한 이해를 하고 있지 않아 명확히 알고자 정리한 부분이다.
결론은 OutputView에서 해당 상수를 private static final로 선언 후 이를 해당 메서드를 통해 출력하는 것이 안전할 것 같아 이렇게 구현하였다. 아래는 키워드의 간단 정의이다. 

1) 'public' 접근 제어자는 다른 클래스에서 접근 가능하다는 것을 의미합니다.
2) 'private' 접근 제어자는 해당 클래스에서만 접근 가능하다는 것을 의미합니다.
2) 'static' 키워드는 이 상수가 클래스 수준의 상수이며 객체가 아닌 클래스 자체에 속한다는 것을 의미합니다. 따라서 클래스의 인스턴스를 생성하지 않고도 접근할 수 있습니다.
3) 'final' 키워드는 이 상수가 변경될 수 없다는 것을 의미하며, 한 번 값을 할당하면 그 값을 변경할 수 없습니다.

추가로 리팩토링 하는 과정에서, 나의 과제 controller 구조를 RacingGame 하나에 여러 기능을 넣었는데 너무 많은 책임을 부여하는 것 같아 분리했다. 여기서 게임이 시작할 때
private final List를 선언하여 다른 컨트롤러로 넘어갈 때 선언한 이 List를 넘겨주었다.해당 리스트 객체는 변경할 수 없는것이 아니라, 변경할 수 없는(unchangeable) 참조(Reference)를 가지게 된다. 즉, list라는 변수는 다른 객체를 가리킬 수 없으며, 한 번 할당된 리스트에 대한 참조로 고정된다. 그러나 리스트 자체는 변경 가능하다.
따라서 list 변수가 가리키는 리스트 객체의 요소를 삭제하거나 추가하는 것은 문제가 없다. 이는 list 변수가 불변 참조를 가지고 있을 뿐이며, 리스트 객체 자체의 불변성과 무관하다는 것이다.
만약 list 변수가 다른 리스트 객체를 참조하지 않고 항상 같은 리스트를 참조하도록 보장되면(즉, 다른 곳에서 list에 새로운 리스트를 할당하지 않는다면), 해당 리스트 객체의 요소를 자유롭게 추가하거나 삭제할 수 있어서 괜찮다고 생각했다.

---

**controller 클래스의 여러 기능으로 많은 책임이 생겨, 작게 분리하면서 느낀 고민**

: 처음에는 RacingGame의 play() 메서드에서 작게 분리할 곳을 찾지 못했다. 하지만 controller의 코드가 120줄을 넘어가면서, 뭔가 잘못생각하고 있다고 느꼈다.
그래서 기능별로 메서드를 분리해서 여러개의 컨트롤러 클래스로 나누려고 했다.

```
    1) RacinGame() 내에서 -> 게임을 실행하는 절차를 관리하기로 했고, 이 메서드 내에서 차 이름을 입력받고, 저장하는 메서드
                        2) 차의 go Or stop을 확인하고, 출력하는 MovingCars 클래스
                        3) 움직임이 끝난 후 계산 결과를 저장하고, 우승자를 선출하는 CalculatingScore 클래스
                        4) 우승자 인원에 따라 해당 결과에 맞게 출력해주는 PrizingWinners 클래스 
```

---

**테스트코드를 작성하며 생긴 고민(private, public)?**

: 테스트 코드에 대해 작성하면서 내가 작성한 private 메서드를 public으로 교체해야했다. 어떤 방법이 맞는지 의문이 들었고, 구글링을 하게 되었다. 결론부터 말하면 테스트할 메서드 이름이나 파라미터가 바뀔 경우 테스트가 깨질 수 있고 관리가 어려워진다.
그래서 가능하면 private 메서드를 호출하는 접근이 가능한 메서드를 테스트하는 것으로 대체하는 것이 좋은 방법이라는 글이 많다. 추가로 Private 메서드를 테스트를 소개하는 글이 있었다.
Public 메서드를 통해 간접적으로 테스트 하거나, Reflection을 이용하여 테스트하는 방법이 존재했다.

블로그 참고: https://yearnlune.github.io/java/java-private-method-test/#do-not-test
```java
//Java Reflection API를 이용한 메소드 호출
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void max_sourceGreaterThanTarget_ShouldBeReturnedSource() throws Exception {
        /* REFLECTION */
        Method maxMethod = Calculator.class.getDeclaredMethod("max", int.class, int.class);
        maxMethod.setAccessible(true);

        /* GIVEN */
        int source = 10;
        int target = 5;

        /* WHEN */
        int maxValue = (int)maxMethod.invoke(calculator, source, target);

        /* THEN */
        assertThat(maxValue, is(source));
    }
}
```