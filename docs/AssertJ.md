공식 문서 [https://assertj.github.io/doc/#assertj-overview](https://assertj.github.io/doc/#assertj-overview)를 번역하며 필요한 부분을 정리한 가이드이다.

## 1\. AssertJ란 무엇인가?

assertion과 유용한 오류 메시지를 제공하는 자바 라이브러리이다.

테스트 코드의 가독성을 높이고 IDE에서 매우 쉽게 사용될 수 있도록 고안되었다.

```java
// entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.*;

// basic assertions
assertThat(frodo.getName()).isEqualTo("Frodo");
assertThat(frodo).isNotEqualTo(sauron);

// chaining string specific assertions
assertThat(frodo.getName()).startsWith("Fro")
                           .endsWith("do")
                           .isEqualToIgnoringCase("frodo");

// collection specific assertions (there are plenty more)
// in the examples below fellowshipOfTheRing is a List<TolkienCharacter>
assertThat(fellowshipOfTheRing).hasSize(9)
                               .contains(frodo, sam)
                               .doesNotContain(sauron);

// as() is used to describe the test and will be shown before the error message
assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);

// exception assertion, standard style ...
assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");
// ... or BDD style
Throwable thrown = catchThrowable(() -> { throw new Exception("boom!"); });
assertThat(thrown).hasMessageContaining("boom");

// using the 'extracting' feature to check fellowshipOfTheRing character's names
assertThat(fellowshipOfTheRing).extracting(TolkienCharacter::getName)
                               .doesNotContain("Sauron", "Elrond");

// extracting multiple values at once grouped in tuples
assertThat(fellowshipOfTheRing).extracting("name", "age", "race.name")
                               .contains(tuple("Boromir", 37, "Man"),
                                         tuple("Sam", 38, "Hobbit"),
                                         tuple("Legolas", 1000, "Elf"));

// filtering a collection before asserting
assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                               .containsOnly(aragorn, frodo, legolas, boromir);

// combining filtering and extraction (yes we can)
assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                               .containsOnly(aragorn, frodo, legolas, boromir)
                               .extracting(character -> character.getRace().getName())
                               .contains("Hobbit", "Elf", "Man");

// and many more assertions: iterable, stream, array, map, dates, path, file, numbers, predicate, optional ...
```

## 2\. 엔트리포인트 사용방법

Assertions 클래스 또는 WithAssertions를 이용하면 AssertJ를 이용할 수 있다.

Assertions :

```java
import static org.assertj.core.api.Assertions.*;
```

또는

```java
import static org.assertj.core.api.Assertions.assertThat;  // main one
import static org.assertj.core.api.Assertions.atIndex; // for List assertions
import static org.assertj.core.api.Assertions.entry;  // for Map assertions
import static org.assertj.core.api.Assertions.tuple; // when extracting several properties at once
import static org.assertj.core.api.Assertions.fail; // use when writing exception tests
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown; // idem
import static org.assertj.core.api.Assertions.filter; // for Iterable/Array assertions
import static org.assertj.core.api.Assertions.offset; // for floating number assertions
import static org.assertj.core.api.Assertions.anyOf; // use with Condition
import static org.assertj.core.api.Assertions.contentOf; // use with File assertions
```

## 3\. 가이드

### 1\. 간단한 예

```java
import static org.assertj.core.api.Assertions.assertThat; 

import org.junit.jupiter.api.Test;

public class SimpleAssertionsExample {

  @Test
  void a_few_simple_assertions() {
    assertThat("The Lord of the Rings").isNotNull()   
                                       .startsWith("The") 
                                       .contains("Lord") 
                                       .endsWith("Rings"); 
  }

}
```

-   'org.assertj.core.api.Assertions.assertThat' 를 static 임포트 한다.
-   assertThat() 의 파라미터로 테스트를 할 object를 넘겨준다.
-   코드 완성을 사용하여 assertions를 발견하고 호출한다.
-   최대한 많이 assertion을 사용한다.

위의 예시에서 isNotNull은 기본 assertion이며, 나머지는 String의 assertion이다.

### 2\. Assertion 설명

boolean값을 비교하는 Assertions의 경우, 기본 에러 메시지가 true대신 false를 반환한다.

이 경우 결과가 모호할 수 있기 때문에 as(String description, Object…​ args)로 Assertion을 부연설명해주는 것이 좋다.

-   Assertion 이전에 사용해야 한다.
-   Assertion 이후에 호출할 경우 Assertion이 실패할 때 무시된다.

```java
TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);

// failing assertion, remember to call as() before the assertion!
assertThat(frodo.getAge()).as("check %s's age", frodo.getName())
                          .isEqualTo(100);
```

```
[check Frodo's age] expected:<100> but was:<33>
```

Assertion description이 정해져 있을 경우 각각을 Assertions.setPrintAssertionsDescription(true)로 출력할 수 있다.

description이 맘에 들지 않을 경우 Consumer<Description>로 설정하여 커스텀 할 수 있다.

```java
// initialize the description consumer
final StringBuilder descriptionReportBuilder = new StringBuilder(String.format("Assertions:%n"));
Consumer<Description> descriptionConsumer = desc -> descriptionReportBuilder.append(String.format("-- %s%n", desc));

// use the description consumer for any following assertions descriptions.
Assertions.setDescriptionConsumer(descriptionConsumer);

// execute some assertions
TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
assertThat(frodo.getName()).as("check name")
                          .isEqualTo("Frodo");
assertThat(frodo.getAge()).as("check age")
                          .isEqualTo(33);

// get the report
String descriptionReport = descriptionReportBuilder.toString();
```

```
Assertions:
-- check name
-- check age
```

### 3\. 에러메시지 오버라이딩

-   overridingErrorMessage()
-   withFailMessage()

```java
TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
TolkienCharacter sam = new TolkienCharacter("Sam", 38, Race.HOBBIT);
// failing assertion, remember to call withFailMessage/overridingErrorMessage before the assertion!
assertThat(frodo.getAge()).withFailMessage("should be %s", frodo)
                          .isEqualTo(sam);
```

```
java.lang.AssertionError: should be TolkienCharacter [name=Frodo, age=33, race=HOBBIT]
```

오류 메시지를 생성하는데 많은 리소스가 소모되는 경우 Supplier<String>를 사용하여 더 효율적으로 처리할 수 있다.

```java
assertThat(player.isRookie()).overridingErrorMessage(() -> "Expecting Player to be a rookie but was not.")
                             .isTrue();

assertThat(player.isRookie()).withFailMessage(() -> "Expecting Player to be a rookie but was not.")
                             .isTrue();
```

### 4\. 부정확한 사용 피하기

assertThat() 메소드 이후에 메인 오브젝트를 매개변수로 넣고 assertion을 호출해야한다.

Bad
```java
// DON'T DO THIS ! It does not assert anything
assertThat(actual.equals(expected));
```

Good

```java
// DO THIS:
assertThat(actual).isEqualTo(expected);

// OR THIS (less classy but ok):
assertThat(actual.equals(expected)).isTrue();
```

Bad

```java
// DON'T DO THIS ! It does not assert anything and passes
assertThat(1 == 2);
```

Good

```java
// DO THIS: (fails as expected)
assertThat(1).isEqualTo(2);

// OR THIS (less classy but ok):
assertThat(1 == 2).isTrue();
```

assertion에 대한 설명은 assertion 호출 이전에 이루어져야 한다. 그렇지 않다면 실패한 assertion은 as()의 호출을 막을 것이다.

Bad

```java
// DON'T DO THIS ! as/describedAs have no effect after the assertion
assertThat(actual).isEqualTo(expected).as("description");
assertThat(actual).isEqualTo(expected).describedAs("description");
```

Good

```java
// DO THIS: use as/describedAs before the assertion
assertThat(actual).as("description").isEqualTo(expected);
assertThat(actual).describedAs("description").isEqualTo(expected);
```

에러 메시지의 세팅은 assertion 호출 이전에 이루어져야 한다. 그렇지 않다면 실패한 assertion()은 withFailMessage() / overridingErrorMessage()의 호출을 막을 것이다.

Bad

```java
// DON'T DO THIS ! overridingErrorMessage/withFailMessage have no effect after the assertion
assertThat(actual).isEqualTo(expected).overridingErrorMessage("custom error message");
assertThat(actual).isEqualTo(expected).withFailMessage("custom error message");
```

Good

```java
// DO THIS: use overridingErrorMessage/withFailMessage before the assertion
assertThat(actual).overridingErrorMessage("custom error message").isEqualTo(expected);
assertThat(actual).withFailMessage("custom error message").isEqualTo(expected);
```

Comparator의 세팅은 assertion 호출 이전에 이루어져야 한다. 그렇지 않다면 실패한 assertion()은 usingComparator() / usingElementComparator()의 호출을 막을 것이다.

Bad

```java
// DON'T DO THIS ! Comparator is not used
assertThat(actual).isEqualTo(expected).usingComparator(new CustomComparator());
```

Good

```java
// DO THIS:
assertThat(actual).usingComparator(new CustomComparator()).isEqualTo("a");
```

### 5\. Common assertions

[https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractAssert.html#method.summary](https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractAssert.html#method.summary)

[AbstractAssert (AssertJ Core 3.24.2 API)

Type Parameters: SELF - the "self" type of this assertion class. Please read "Emulating 'self types' using Java Generics to simplify fluent API implementation" for more details. ACTUAL - the type of the "actual" value. All Implemented Interfaces: Assert ,

www.javadoc.io](https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractAssert.html#method.summary)

### 6\. Object assertions

[https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractObjectAssert.html#method.summary](https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractObjectAssert.html#method.summary)

[AbstractObjectAssert (AssertJ Core 3.24.2 API)

Type Parameters: SELF - the "self" type of this assertion class. Please read "Emulating 'self types' using Java Generics to simplify fluent API implementation" for more details. ACTUAL - the type of the "actual" value. All Implemented Interfaces: Assert ,

www.javadoc.io](https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractObjectAssert.html#method.summary)

### 7\. String assertions

[https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractCharSequenceAssert.html#method.summary](https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractCharSequenceAssert.html#method.summary)

[AbstractCharSequenceAssert (AssertJ Core 3.24.2 API)

Type Parameters: SELF - the "self" type of this assertion class. Please read "Emulating 'self types' using Java Generics to simplify fluent API implementation" for more details. ACTUAL - the type of the "actual" value. All Implemented Interfaces: Assert ,

www.javadoc.io](https://www.javadoc.io/static/org.assertj/assertj-core/3.24.2/org/assertj/core/api/AbstractCharSequenceAssert.html#method.summary)

### 8\. Iterable and array assertions

-   iterables: [https://www.javadoc.io/doc/org.assertj/assertj-core/latest/org/assertj/core/api/AbstractIterableAssert.html#method.summary](https://www.javadoc.io/doc/org.assertj/assertj-core/latest/org/assertj/core/api/AbstractIterableAssert.html#method.summary)
-   arrays: [https://www.javadoc.io/doc/org.assertj/assertj-core/latest/org/assertj/core/api/AbstractObjectArrayAssert.html#method.summary](https://www.javadoc.io/doc/org.assertj/assertj-core/latest/org/assertj/core/api/AbstractObjectArrayAssert.html#method.summary)

[AbstractIterableAssert - assertj-core 3.24.2 javadoc

Latest version of org.assertj:assertj-core https://javadoc.io/doc/org.assertj/assertj-core Current version 3.24.2 https://javadoc.io/doc/org.assertj/assertj-core/3.24.2 package-list path (used for javadoc generation -link option) https://javadoc.io/doc/org

www.javadoc.io](https://www.javadoc.io/doc/org.assertj/assertj-core/latest/org/assertj/core/api/AbstractIterableAssert.html#method.summary)

#### 1) Iterables/arrays 컨텐트 체크

| Method | Name 설명 |
| --- | --- |
| contains | 실제 반복 가능한/배열이 주어진 값을 어떤 순서로든 포함하는지 확인한다. |
| containsOnly | 실제 그룹이 주어진 값만 포함하며, 중복을 무시하고 어떤 순서로든 다른 값은 포함하지 않는지 확인한다. |
| containsExactly | 실제 반복 가능한/배열이 주어진 값을 정확한 순서로만 포함하고 다른 값은 포함하지 않는지 확인한다. |
| containsExactlyInAnyOrder | 실제 반복 가능한/배열이 주어진 값을 어떤 순서로든 정확히 포함하고 다른 값은 포함하지 않는지 확인한다. |
| containsSequence | 실제 그룹이 주어진 순서의 시퀀스를 포함하고 시퀀스 값 사이에 추가 값이 없는지 확인한다. |
| containsSubsequence | 실제 그룹이 주어진 부분 순서의 시퀀스를 포함하며 해당 시퀀스 사이에 다른 값이 있을 수 있는지 확인한다. |
| containsOnlyOnce | 실제 반복 가능한/배열이 주어진 값을 한 번만 포함하는지 확인한다. |
| containsAnyOf | 실제 반복 가능한/배열이 주어진 값 중 하나 이상을 포함하는지 확인한다. |

> 💡 위의 assertions는 iterable/array 인자를 수용하는 변형을 갖는다.  
> ex) containsExactly(E…​), containsExactlyElementsOf(Iterable)

#### 2) element에 대한 assertion 검증

**1️⃣ satisfy**

-   allSatisfy
-   anySatisfy
-   noneSatisfy

```java
List<TolkienCharacter> hobbits = list(frodo, sam, pippin);

// all elements must satisfy the given assertions
assertThat(hobbits).allSatisfy(character -> {
  assertThat(character.getRace()).isEqualTo(HOBBIT);
  assertThat(character.getName()).isNotEqualTo("Sauron");
});

// at least one element must satisfy the given assertions
assertThat(hobbits).anySatisfy(character -> {
  assertThat(character.getRace()).isEqualTo(HOBBIT);
  assertThat(character.getName()).isEqualTo("Sam");
});

// no element must satisfy the given assertions
assertThat(hobbits).noneSatisfy(character -> assertThat(character.getRace()).isEqualTo(ELF));
```

2️⃣ **Match**

Predicate을 제공한다.

-   allMatch
-   anyMatch
-   noneMatch

```java
List<TolkienCharacter> hobbits = list(frodo, sam, pippin);

assertThat(hobbits).allMatch(character -> character.getRace() == HOBBIT, "hobbits")
                   .anyMatch(character -> character.getName().contains("pp"))
                   .noneMatch(character -> character.getRace() == ORC);
```

> 💡 테스트가 실패할 경우에 더 명확한 에러 메시지를 만들기 위해 predicate 설명을 전달할 수 있다.

3️⃣ **주어진 element로 이동**

first, last, any element by index를 통해 이동하거나 element가 오직 한 개일 경우 singleElement를 사용할 수 있다.

> ⚠️ 현재는 iterable만 사용 가능

```java
// only object assertions available after navigation
Iterable<TolkienCharacter> hobbits = list(frodo, sam, pippin);
assertThat(hobbits).first().isEqualTo(frodo);
assertThat(hobbits).element(1).isEqualTo(sam);
assertThat(hobbits).last().isEqualTo(pippin);

// strongly typed String assertions after navigation
Iterable<String> hobbitsName = list("frodo", "sam", "pippin");
// STRING is an InstanceOfAssertFactory from org.assertj.core.api.InstanceOfAssertFactories.STRING
// as() is just synthetic sugar for readability
assertThat(hobbitsName).first(as(STRING))
                       .startsWith("fro")
                       .endsWith("do");
assertThat(hobbitsName).element(1, as(STRING))
                       .startsWith("sa")
                       .endsWith("am");
assertThat(hobbitsName).last(as(STRING))
                       .startsWith("pip")
                       .endsWith("pin");

// alternative for strongly typed assertions
assertThat(hobbitsName, StringAssert.class).first()
                                           .startsWith("fro")
                                           .endsWith("do");
                                           
Iterable<String> babySimpsons = list("Maggie");

// only object assertions available
assertThat(babySimpsons).singleElement()
                        .isEqualTo("Maggie");

// to get specific typed assertions, pass the corresponding InstanceOfAssertFactory from
// org.assertj.core.api.InstanceOfAssertFactories.STRING), as() is just synthetic sugar for readability
assertThat(babySimpsons).singleElement(as(STRING))
                        .endsWith("gie");

// alternative for strongly typed assertions
assertThat(babySimpsons, StringAssert.class).singleElement()
                                            .startsWith("Mag");
```

**4️⃣ Filtering**

람다를 이용한 간단한 필터링이 가능하다.

```java
assertThat(fellowshipOfTheRing).filteredOn( character -> character.getName().contains("o") )
                               .containsOnly(aragorn, frodo, legolas, boromir);
```

필터링할 속성/필드 이름을 지정한 다음 예상 값을 지정한다. 필터는 속성에서 값을 가져온 다음 필드에서 값을 가져오려고 시도한다. 비공개 필드 읽기는 기본적으로 지원되지만 Assertions.setAllowExtractingPrivateFields(false)를 호출하여 전역적으로 비활성화할 수 있다.  
필터는 중첩된 속성/필드를 지원한다. 중간 값이 null이면 중첩된 속성/필드 전체가 null로 간주된다(예: 'address.street'가 null이면 'address.street.name'을 읽으면 null을 반환).  
기본 연산을 지원한다: not, in, notIn

```java
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.not;
import static org.assertj.core.api.Assertions.notIn;
...

// filters use introspection to get property/field values
assertThat(fellowshipOfTheRing).filteredOn("race", HOBBIT)
                               .containsOnly(sam, frodo, pippin, merry);

// nested properties are supported
assertThat(fellowshipOfTheRing).filteredOn("race.name", "Man")
                               .containsOnly(aragorn, boromir);

// you can apply different comparison
assertThat(fellowshipOfTheRing).filteredOn("race", notIn(HOBBIT, MAN))
                               .containsOnly(gandalf, gimli, legolas);

assertThat(fellowshipOfTheRing).filteredOn("race", in(MAIA, MAN))
                               .containsOnly(gandalf, boromir, aragorn);

assertThat(fellowshipOfTheRing).filteredOn("race", not(HOBBIT))
                               .containsOnly(gandalf, boromir, aragorn, gimli, legolas);

// you can chain multiple filter criteria
assertThat(fellowshipOfTheRing).filteredOn("race", MAN)
                               .filteredOn("name", not("Boromir"))
                               .containsOnly(aragorn);
```

반환값이 있는 함수를 필터링 하는 방법은 유연하지만 not, in, notIn을 지원하지 않는다.

```java
assertThat(fellowshipOfTheRing).filteredOn(TolkienCharacter::getRace, HOBBIT)
                               .containsOnly(sam, frodo, pippin, merry);
```

property/field가 null인 elements를 필터링한다. nested property/field를 지원한다. 중간값이 null일 경우 중첩된 값 모두 null이다. 예를 들어, "address.street"이 null이면 "address.street.name"이 null이다.

```java
TolkienCharacter pippin = new TolkienCharacter("Pippin", 28, HOBBIT);
TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
TolkienCharacter merry = new TolkienCharacter("Merry", 36, HOBBIT);
TolkienCharacter mysteriousHobbit = new TolkienCharacter(null, 38, HOBBIT);

List<TolkienCharacter> hobbits = list(frodo, mysteriousHobbit, merry, pippin);

assertThat(hobbits).filteredOnNull("name"))
                   .singleElement()
                   .isEqualTo(mysteriousHobbit);
```

assertion과 매칭되는 element를 필터링한다.

예시 : check habbits whose age < 34

```java
TolkienCharacter pippin = new TolkienCharacter("Pippin", 28, HOBBIT);
TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
TolkienCharacter merry = new TolkienCharacter("Merry", 36, HOBBIT);
TolkienCharacter sam = new TolkienCharacter("Sam", 38, HOBBIT);

List<TolkienCharacter> hobbits = list(frodo, sam, merry, pippin);

assertThat(hobbits).filteredOnAssertions(hobbit -> assertThat(hobbit.age).isLessThan(34))
                   .containsOnly(frodo, pippin);
```

주어지는 조건에 맞는 element만을 통해 iterable/array를 필터링한다.

```java
import org.assertj.core.api.Condition;

Condition<Player> mvpStats= new Condition<Player>(player -> {
    return player.pointsPerGame() > 20 && (player.assistsPerGame() >= 8 || player.reboundsPerGame() >= 8);
  }, "mvp");

List<Player> players;
players.add(rose); // Derrick Rose: 25 ppg - 8 assists - 5 rebounds
players.add(lebron); // Lebron James: 27 ppg - 6 assists - 9 rebounds
players.add(noah); // Joachim Noah: 8 ppg - 5 assists - 11 rebounds

// noah does not have more than 20 ppg
assertThat(players).filteredOn(mvpStats)
                   .containsOnly(rose, lebron);
```

5️⃣ **elements 값을 추출**

서비스에 전화를 걸어 톨킨 캐릭터 목록(또는 배열)을 얻었다고 가정해 보자. 예상되는 톨킨 캐릭터를 구축하는 데 필요한 결과를 확인하려면 상당히 지루할 수 있다.

```java
List<TolkienCharacter> fellowshipOfTheRing = tolkienDao.findHeroes();  // frodo, sam, aragorn ...

// requires creation of frodo and aragorn, the expected TolkienCharacters
assertThat(fellowshipOfTheRing).contains(frodo, aragorn);
```

field나 property를 체크하기 전에 특정 field/property를 추출할 수 있다.

```java
// extract the names ...
List<String> names = fellowshipOfTheRing.stream().map(TolkienCharacter::getName).collect(toList());
// ... and finally assert something
assertThat(names).contains("Boromir", "Gandalf", "Frodo", "Legolas");
```

이 과정은 많은 부담을 안겨주기 때문에, AssertJ는 테스트 하에 element로부터 값을 추출하는 것을 도와준다.

1) element로부터 single value 추출

추출할 field/property를 특정하고 추출된 값에 assertion을 수행한다.

이름으로 추출하면 비공개 field/property에 액세스할 수 있으므로 공개 방법으로 노출되지 않은 내부를 확인하기에 편리하다. (여기서는 lambda가 작동하지 않음). 또한 "race.name "과 같은 중첩 field/property도 지원한다.

```java
// "name" needs to be either a property or a field of the TolkienCharacter class
assertThat(fellowshipOfTheRing).extracting("name")
                               .contains("Boromir", "Gandalf", "Frodo", "Legolas")
                               .doesNotContain("Sauron", "Elrond");

// specifying nested field/property is supported
assertThat(fellowshipOfTheRing).extracting("race.name")
                               .contains("Man", "Maia", "Hobbit", "Elf");

// same thing with a lambda which is type safe and refactoring friendly:
assertThat(fellowshipOfTheRing).extracting(TolkienCharacter::getName)
                               .contains("Boromir", "Gandalf", "Frodo", "Legolas");

// same thing map an alias of extracting:
assertThat(fellowshipOfTheRing).map(TolkienCharacter::getName)
                               .contains("Boromir", "Gandalf", "Frodo", "Legolas");
                               
// to have type safe extracting, use the second parameter to pass the expected property type:
assertThat(fellowshipOfTheRing).extracting("name", String.class)
                               .contains("Boromir", "Gandalf", "Frodo", "Legolas")
                               .doesNotContain("Sauron", "Elrond");
```

2) multiple value 추출

여러 값을 추출하고 tuple로 체크할 수 있다.

```java
// when checking several properties/fields you have to use tuples:
import static org.assertj.core.api.Assertions.tuple;

// extracting name, age and and race.name nested property
assertThat(fellowshipOfTheRing).extracting("name", "age", "race.name")
                               .contains(tuple("Boromir", 37, "Man"),
                                         tuple("Sam", 38, "Hobbit"),
                                         tuple("Legolas", 1000, "Elf"));

// same assertion with functions for type safety:
assertThat(fellowshipOfTheRing).extracting(TolkienCharacter::getName,
                                            tolkienCharacter -> tolkienCharacter.age,
                                            tolkienCharacter -> tolkienCharacter.getRace().getName())
                                .contains(tuple("Boromir", 37, "Man"),
                                          tuple("Sam", 38, "Hobbit"),
                                          tuple("Legolas", 1000, "Elf"));
```

3) multiple value를 추출하고 확장

```java
Player jordan = ... // initialized with Pippen and Kukoc team mates
Player magic = ... // initialized with Jabbar and Worthy team mates
List<Player> reallyGoodPlayers = list(jordan, magic);

// check all team mates by specifying the teamMates property (Player has a getTeamMates() method):
assertThat(reallyGoodPlayers).flatExtracting("teamMates")
                             .contains(pippen, kukoc, jabbar, worthy);

// alternatively, you can use a Function for type safety:
assertThat(reallyGoodPlayers).flatExtracting(BasketBallPlayer::getTeamMates)
                             .contains(pippen, kukoc, jabbar, worthy);

// flatMap is an alias of flatExtracting:
assertThat(reallyGoodPlayers).flatMap(BasketBallPlayer::getTeamMates)
                             .contains(pippen, kukoc, jabbar, worthy);

// if you use extracting instead of flatExtracting the result would be a list of list of players so the assertion becomes:
assertThat(reallyGoodPlayers).extracting("teamMates")
                             .contains(list(pippen, kukoc), list(jabbar, worthy));
```

> 💡 flatExtracting대신 flatMap을 사용할 수 있다.

extracting과 tuple을 사용하고 싶지 않을 때 Flat Extracting을 사용할 수 있다.

```java
// extract a list of values, flatten them and use contains assertion
assertThat(fellowshipOfTheRing).flatExtracting("name", "race.name")
                               .contains("Frodo", "Hobbit", "Legolas", "Elf");

// same assertions with Functions:
assertThat(fellowshipOfTheRing).flatExtracting(TolkienCharacter::getName,
                                               tc -> tc.getRace().getName())
                               .contains("Frodo", "Hobbit", "Legolas", "Elf");
```

**6️⃣ 특정 Comparator로 비교**

usingElementComparator는 비교 방법을 바꿀 수 있도록 해준다.

```java
List<TolkienCharacter> fellowshipOfTheRing = list(frodo, sam, merry, pippin, gandald, legolas, boromir, aragorn, gimli);

// the fellowshipOfTheRing includes Gandalf but not Sauron ...
assertThat(fellowshipOfTheRing).contains(gandalf)
                               .doesNotContain(sauron);

// ... but if we compare only races, Sauron is in fellowshipOfTheRing since he's a Maia like Gandalf
assertThat(fellowshipOfTheRing).usingElementComparator((t1, t2) -> t1.getRace().compareTo(t2.getRace()))
                               .contains(sauron);
```

### 9\. Exceptions assertions

#### 1) 예외 메시지를 확인한다.

```java
Throwable throwable = new IllegalArgumentException("wrong amount 123");

assertThat(throwableWithMessage).hasMessage("wrong amount 123")
                                .hasMessage("%s amount %d", "wrong", 123)
                                // check start
                                .hasMessageStartingWith("wrong")
                                .hasMessageStartingWith("%s a", "wrong")
                                // check content
                                .hasMessageContaining("wrong amount")
                                .hasMessageContaining("wrong %s", "amount")
                                .hasMessageContainingAll("wrong", "amount")
                                // check end
                                .hasMessageEndingWith("123")
                                .hasMessageEndingWith("amount %s", "123")
                                // check with regex
                                .hasMessageMatching("wrong amount .*")
                                // check does not contain
                                .hasMessageNotContaining("right")
                                .hasMessageNotContainingAny("right", "price")
```

####  2) cause와 root cause를 확인한다.

**1️⃣ cause 확인**

원인을 알고 있다면 직접 확인할 수 있지만 항상 가능한 것은 아니다. 기본적으로 유형만 확인할 수 있다. 이는 상당히 제한적이지만 getCause()를 사용하여 원인을 탐색하고 기존의 모든 예외 주장을 활용하는 것이 더 나은 접근 방식이다.

```java
NullPointerException cause = new NullPointerException("boom!");
Throwable throwable = new Throwable(cause);

assertThat(throwable).hasCause(cause)
                     // hasCauseInstanceOf will match inheritance.
                     .hasCauseInstanceOf(NullPointerException.class)
                     .hasCauseInstanceOf(RuntimeException.class)
                     // hasCauseExactlyInstanceOf will match only exact same type
                     .hasCauseExactlyInstanceOf(NullPointerException.class);
```

원인을 탐색하면 모든 exception assertions을 탐색할 수 있다.

```java
// navigate before checking
assertThat(throwable).getCause()
                     .hasMessage("boom!")
                     .hasMessage("%s!", "boom")
                     .hasMessageStartingWith("bo")
                     .hasMessageEndingWith("!")
                     .hasMessageContaining("boo")
                     .hasMessageContainingAll("bo", "oom", "!")
                     .hasMessageMatching("b...!")
                     .hasMessageNotContaining("bam")
                     .hasMessageNotContainingAny("bam", "bim")
                     // isInstanceOf will match inheritance.
                     .isInstanceOf(NullPointerException.class)
                     .isInstanceOf(RuntimeException.class)
                     // isExactlyInstanceOf will match only exact same type
                     .isExactlyInstanceOf(NullPointerException.class);
```

havingCause를 가진 assertThatExceptionOfType을 사용한다.

```java
assertThatExceptionOfType(RuntimeException.class)
         .isThrownBy(() -> { throw new RuntimeException(new IllegalArgumentException("boom!")); })
         .havingCause()
         .withMessage("boom!");
```

**2️⃣ root cause 확인**

hasRootCause, hasRootCauseMessage 및 hasRootCauseInstanceOf를 사용하여 루트 원인을 직접 확인할 수 있다. 항상 엑세스가 가능한 것은 아니지만, getRootCause()를 사용하여 루트 원인으로 이동하고 기존의 모든 예외 주장을 활용하는 것이 더 나은 방법이다.

```java
NullPointerException rootCause = new NullPointerException("null!");
Throwable throwable = new Throwable(new IllegalStateException(rootCause));

// direct root cause check
assertThat(throwable).hasRootCause(rootCause)
                     .hasRootCauseMessage("null!")
                     .hasRootCauseMessage("%s!", "null")
                     // hasRootCauseInstanceOf will match inheritance
                     .hasRootCauseInstanceOf(NullPointerException.class)
                     .hasRootCauseInstanceOf(RuntimeException.class)
                     // hasRootCauseExactlyInstanceOf will match only exact same type
                     .hasRootCauseExactlyInstanceOf(NullPointerException.class);

// navigate to root cause and check
assertThat(throwable).getRootCause()
                     .hasMessage("null!")
                     .hasMessage("%s!", "null")
                     .hasMessageStartingWith("nu")
                     .hasMessageEndingWith("!")
                     .hasMessageContaining("ul")
                     .hasMessageContainingAll("nu", "ull", "l!")
                     .hasMessageMatching("n...!")
                     .hasMessageNotContaining("NULL")
                     .hasMessageNotContainingAny("Null", "NULL")
                     // isInstanceOf will match inheritance.
                     .isInstanceOf(NullPointerException.class)
                     .isInstanceOf(RuntimeException.class)
                     // isExactlyInstanceOf will match only exact same type
                     .isExactlyInstanceOf(NullPointerException.class);
```

havingRootCause를 가진 assertThatExceptionOfType을 사용한다.

```java
assertThatExceptionOfType(RuntimeException.class)
         .isThrownBy(() -> { throw new RuntimeException(new IllegalArgumentException(new NullPointerException("root error"))); })
         .havingRootCause()
         .withMessage("root error");
```

**3️⃣ No cause**

hasNoCause()를 사용하여 Throwable이 cause가 없다는 것을 검증할 수 있다.

#### 3) BDD Style

WHEN과 THEN 단계로 나누며 Throwable을 추적하고 assertion을 수행하기 위해 catchThrowable(ThrowingCallable)를 쓴다.

```java
// GIVEN
String[] names = { "Pier ", "Pol", "Jak" };
// WHEN
Throwable thrown = catchThrowable(() -> System.out.println(names[9]));
// THEN
then(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
            .hasMessageContaining("9");

// assertThat is also available but is less "BDD style"
assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class)
                  .hasMessageContaining("9");
```

> 💡 catchThrowable은 예외를 반환하지 않는 경우 null을 반환하지만 다음이 더 좋은 방법이다.
>
> ```java
> // standard style
> assertThatNoException().isThrownBy(() -> System.out.println("OK"));
> // BDD style
> thenNoException().isThrownBy(() -> System.out.println("OK"));
> 
> // standard style
> assertThatCode(() -> System.out.println("OK")).doesNotThrowAnyException();
> // BDD style
> thenCode(() -> System.out.println("OK")).doesNotThrowAnyException();​
> ```

catchThrowableOfType은 catchThrowable의 변형이며 예외의 타입을 검증하고 커스텀 예외 fields/properties를 체크한다.

```java
class TextException extends Exception {
   int line;
   int column;

   public TextException(String msg, int line, int column) {
     super(msg);
     this.line = line;
     this.column = column;
   }
 }

 TextException textException = catchThrowableOfType(() -> { throw new TextException("boom!", 1, 5); },
                                                    TextException.class);
 // assertions succeed
 assertThat(textException).hasMessageContaining("boom");
 assertThat(textException.line).isEqualTo(1);
 assertThat(textException.column).isEqualTo(5);

 // fails as TextException is not a RuntimeException
 catchThrowableOfType(() -> { throw new TextException("boom!", 1, 5); }, RuntimeException.class);
```

#### 4) assertThatThrownBy

catchThrowable의 변형이며 더 가독성이 좋다.

```java
assertThatThrownBy(() -> { throw new Exception("boom!"); }).isInstanceOf(Exception.class)
                                                           .hasMessageContaining("boom");
```

> 💡 예외가 반환되지 않는다면, assertion error가 던져진다.

#### 5) assertThatExceptionOfType

더 자연스럽다.

```java
assertThatExceptionOfType(IOException.class).isThrownBy(() -> { throw new IOException("boom!"); })
                                            .withMessage("%s!", "boom")
                                            .withMessageContaining("boom")
                                            .withNoCause();
```

> 💡 예외가 반환되지 않는다면, assertion error가 던져진다.

-   assertThatNullPointerException
-   assertThatIllegalArgumentException
-   assertThatIllegalStateException
-   assertThatIOException

위 예시는 다음으로 대체할 수 있다.

```java
assertThatIOException().isThrownBy(() -> { throw new IOException("boom!"); })
                       .withMessage("%s!", "boom")
                       .withMessageContaining("boom")
                       .withNoCause();
```

### 10\. recursive comparsion

동등성을 비교하는데 사용된다. 객체의 순서, 구조와 상관없이 같은 내용을 가지고 있는지 확인한다.

usingRecursiveComparison()를 사용한다.

```java
public class Person {
  String name;
  double height;
  Home home = new Home();
}

public class Home {
  Address address = new Address();
  Date ownedSince;
}

public static class Address {
  int number;
  String street;
}

Person sherlock = new Person("Sherlock", 1.80);
sherlock.home.ownedSince = new Date(123);
sherlock.home.address.street = "Baker Street";
sherlock.home.address.number = 221;

Person sherlock2 = new Person("Sherlock", 1.80);
sherlock2.home.ownedSince = new Date(123);
sherlock2.home.address.street = "Baker Street";
sherlock2.home.address.number = 221;

// assertion succeeds as the data of both objects are the same.
assertThat(sherlock).usingRecursiveComparison()
                    .isEqualTo(sherlock2);

// assertion fails as Person equals only compares references.
assertThat(sherlock).isEqualTo(sherlock2);
```

```java
// equals not overridden in TolkienCharacter
TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
TolkienCharacter frodoClone = new TolkienCharacter("Frodo", 33, HOBBIT);
TolkienCharacter youngFrodo = new TolkienCharacter("Frodo", 22, HOBBIT);

// Pass as equals compares object references
assertThat(frodo).isNotEqualTo(frodoClone);

// Fail as frodo and frodoClone are equals when doing a field by field comparison.
assertThat(frodo).usingRecursiveComparison()
                 .isNotEqualTo(frodoClone);

// Pass as one the age fields differ between frodo and youngFrodo.
assertThat(frodo).usingRecursiveComparison()
                 .isNotEqualTo(youngFrodo);
```

ignoringActualNullFields()를 이용해 object를 무시할 수 있다.

```java
Person sherlock = new Person("Sherlock", 1.80);
sherlock.home.address.street = "Baker Street";
sherlock.home.address.number = 221;

// strangely moriarty and sherlock have the same height!
Person moriarty = new Person("Moriarty", 1.80);
moriarty.home.address.street = "Crime Street";
moriarty.home.address.number = 221;

// assertion succeeds as name and home.address.street fields are ignored in the comparison
assertThat(sherlock).usingRecursiveComparison()
                    .ignoringFields("name", "home.address.street")
                    .isEqualTo(moriarty);

// assertion succeeds as once a field is ignored, its subfields are too
assertThat(sherlock).usingRecursiveComparison()
                    .ignoringFields("name", "home")
                    .isEqualTo(moriarty);

// ignoring fields matching regexes: name and home match .*me
assertThat(sherlock).usingRecursiveComparison()
                    .ignoringFieldsMatchingRegexes(".*me")
                    .isEqualTo(moriarty);

// ignoring null fields example:
sherlock.name = null;
sherlock.home.address.street = null;
assertThat(sherlock).usingRecursiveComparison()
                    .ignoringActualNullFields()
                    .isEqualTo(moriarty);

// ignore height and address fields by type:
Person tallSherlock = new Person("sherlock", 2.10);
tallSherlock.home.address.street = "Long Baker Street";
tallSherlock.home.address.number = 222;
assertThat(sherlock).usingRecursiveComparison()
                    .ignoringFieldsOfTypes(double.class, Address.class)
                    .isEqualTo(tallSherlock);
```

오버라이드 된 equals 메소드를 사용하지 않고 비교한다. ignoring을 통해 이를 무시할 수 있다.

```java
public class Person {
  String name;
  double height;
  Home home = new Home();
}

public class Home {
  Address address = new Address();
}

public static class Address {
  int number;
  String street;

  // only compares number, ouch!
  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof Address)) return false;
    Address castOther = (Address) other;
    return Objects.equ
```