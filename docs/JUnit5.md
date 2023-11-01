본인은 Java의 환경에서 IntelliJ툴을 사용한다.

따라서 이 외의 환경에 해당하는 부분은 정리하지 않았다.

---

## 1\. Overview

### 1.1 JUnit5

**JUnit5 = JUnit Platform + JUnit Jupiter + JUnit Vintage**

1\. JUnit Platform

-   테스트 프레임워크를 JVM에서 실행하기 위한 기반을 제공
-   **TestEngine**_(테스트를 발견, 실행하고 결과를 보고하는 역할)_ API를 지원하여 JUnit5 생태계 내에서 다른 테스팅 라이브러리와 프레임워크를 사용할 수 있게 함.

```java

/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.platform.engine;

import static org.apiguardian.api.API.Status.STABLE;

import java.util.Optional;

import org.apiguardian.api.API;
import org.junit.platform.commons.util.ModuleUtils;
import org.junit.platform.commons.util.PackageUtils;

/**
 * A {@code TestEngine} facilitates <em>discovery</em> and <em>execution</em> of
 * tests for a particular programming model.
 *
 * <p>For example, JUnit provides a {@code TestEngine} that discovers and
 * executes tests written using the JUnit Jupiter programming model.
 *
 * <p>Every {@code TestEngine} must {@linkplain #getId provide its own unique ID},
 * {@linkplain #discover discover tests} from
 * {@link EngineDiscoveryRequest EngineDiscoveryRequests},
 * and {@linkplain #execute execute those tests} according to
 * {@link ExecutionRequest ExecutionRequests}.
 *
 * <p>In order to facilitate test discovery within IDEs and tools prior
 * to launching the JUnit Platform, {@code TestEngine} implementations are
 * encouraged to make use of the
 * {@link org.junit.platform.commons.annotation.Testable @Testable} annotation.
 * For example, the {@code @Test} and {@code @TestFactory} annotations in JUnit
 * Jupiter are meta-annotated with {@code @Testable}. Consult the Javadoc for
 * {@code @Testable} for further details.
 *
 * @since 1.0
 * @see org.junit.platform.engine.EngineDiscoveryRequest
 * @see org.junit.platform.engine.ExecutionRequest
 * @see org.junit.platform.commons.annotation.Testable
 */
@API(status = STABLE, since = "1.0")
public interface TestEngine {

	/**
	 * Get the ID that uniquely identifies this test engine.
	 *
	 * <p>Each test engine must provide a unique ID. For example, JUnit Vintage
	 * and JUnit Jupiter use {@code "junit-vintage"} and {@code "junit-jupiter"},
	 * respectively. When in doubt, you may use the fully qualified name of your
	 * custom {@code TestEngine} implementation class.
	 */
	String getId();

	/**
	 * Discover tests according to the supplied {@link EngineDiscoveryRequest}.
	 *
	 * <p>The supplied {@link UniqueId} must be used as the unique ID of the
	 * returned root {@link TestDescriptor}. In addition, the {@code UniqueId}
	 * must be used to create unique IDs for children of the root's descriptor
	 * by calling {@link UniqueId#append}.
	 *
	 * @param discoveryRequest the discovery request; never {@code null}
	 * @param uniqueId the unique ID to be used for this test engine's
	 * {@code TestDescriptor}; never {@code null}
	 * @return the root {@code TestDescriptor} of this engine, typically an
	 * instance of {@code EngineDescriptor}
	 * @see org.junit.platform.engine.support.descriptor.EngineDescriptor
	 */
	TestDescriptor discover(EngineDiscoveryRequest discoveryRequest, UniqueId uniqueId);

	/**
	 * Execute tests according to the supplied {@link ExecutionRequest}.
	 *
	 * <p>The {@code request} passed to this method contains the root
	 * {@link TestDescriptor} that was previously returned by {@link #discover},
	 * the {@link EngineExecutionListener} to be notified of test execution
	 * events, and {@link ConfigurationParameters} that may influence test execution.
	 *
	 * @param request the request to execute tests for; never {@code null}
	 */
	void execute(ExecutionRequest request);

	/**
	 * Get the <em>Group ID</em> of the JAR in which this test engine is packaged.
	 *
	 * <p>This information is used solely for debugging and reporting purposes.
	 *
	 * <p>The default implementation returns an empty {@link Optional},
	 * signaling that the group ID is unknown.
	 *
	 * <p>Concrete test engine implementations may override this method in
	 * order to provide a known group ID.
	 *
	 * @return an {@code Optional} containing the group ID; never {@code null}
	 * but potentially empty if the group ID is unknown
	 * @see #getArtifactId()
	 * @see #getVersion()
	 */
	default Optional<String> getGroupId() {
		return Optional.empty();
	}

	/**
	 * Get the <em>Artifact ID</em> of the JAR in which this test engine is packaged.
	 *
	 * <p>This information is used solely for debugging and reporting purposes.
	 *
	 * <p>The default implementation assumes the implementation title is equivalent
	 * to the artifact ID and therefore attempts to query the
	 * {@linkplain Package#getImplementationTitle() implementation title}
	 * from the package attributes for the {@link Package} in which the engine
	 * resides. Note that a package only has attributes if the information is
	 * defined in the {@link java.util.jar.Manifest Manifest} of the JAR
	 * containing that package, and if the class loader created the
	 * {@link Package} instance with the attributes from the manifest.
	 *
	 * <p>If the implementation title cannot be queried from the package
	 * attributes, the default implementation returns an empty
	 * {@link Optional}.
	 *
	 * <p>Concrete test engine implementations may override this method in
	 * order to determine the artifact ID by some other means.
	 *
	 * @implNote Since JUnit Platform version 1.1 this default implementation
	 * returns the "module name" stored in the module (modular jar on the
	 * module-path) of this test engine.
	 *
	 * @return an {@code Optional} containing the artifact ID; never
	 * {@code null} but potentially empty if the artifact ID is unknown
	 * @see Class#getPackage()
	 * @see Package#getImplementationTitle()
	 * @see #getGroupId()
	 * @see #getVersion()
	 */
	default Optional<String> getArtifactId() {
		Optional<String> moduleName = ModuleUtils.getModuleName(getClass());
		if (moduleName.isPresent()) {
			return moduleName;
		}
		return PackageUtils.getAttribute(getClass(), Package::getImplementationTitle);
	}

	/**
	 * Get the version of this test engine.
	 *
	 * <p>This information is used solely for debugging and reporting purposes.
	 *
	 * <p>Initially, the default implementation tries to retrieve the engine
	 * version from the manifest attribute named: {@code "Engine-Version-" + getId()}
	 *
	 * <p>Then the default implementation attempts to query the
	 * {@linkplain Package#getImplementationVersion() implementation version}
	 * from the package attributes for the {@link Package} in which the engine
	 * resides. Note that a package only has attributes if the information is
	 * defined in the {@link java.util.jar.Manifest Manifest} of the JAR
	 * containing that package, and if the class loader created the
	 * {@link Package} instance with the attributes from the manifest.
	 *
	 * <p>If the implementation version cannot be queried from the package
	 * attributes, the default implementation returns {@code "DEVELOPMENT"}.
	 *
	 * <p>Concrete test engine implementations may override this method to
	 * determine the version by some other means.
	 *
	 * <p>implNote: Since JUnit Platform version 1.1 this default implementation
	 * honors the "raw version" information stored in the module (modular jar
	 * on the module-path) of this test engine.
	 *
	 * @return an {@code Optional} containing the version; never {@code null}
	 * but potentially empty if the version is unknown
	 * @see Class#getPackage()
	 * @see Package#getImplementationVersion()
	 * @see #getGroupId()
	 * @see #getArtifactId()
	 */
	default Optional<String> getVersion() {
		Optional<String> standalone = PackageUtils.getAttribute(getClass(), "Engine-Version-" + getId());
		if (standalone.isPresent()) {
			return standalone;
		}
		String fallback = "DEVELOPMENT";
		Optional<String> moduleVersion = ModuleUtils.getModuleVersion(getClass());
		if (moduleVersion.isPresent()) {
			return moduleVersion;
		}
		return Optional.of(PackageUtils.getAttribute(getClass(), Package::getImplementationVersion).orElse(fallback));
	}

}
```

-   플랫폼을 명령 줄에서 시작하기 위한 **Console Launcher** 제공

```java
java -jar junit-platform-console-standalone.jar --class-path build/classes/java/test --scan-class-path --include-package=com.example.tests
```

-   하나 이상의 TestEngine을 사용하여 사용자 정의 테스트를 실행하기 위한 **JUnit Platform Suite Engine** 제공
-   여러 IDE (IntelliJ IDEA, Eclipse, Visual Studio Code 등) 및 빌드 도구 (Maven, Gradle 등) 지원

2\. JUnit Jupiter

-   테스트 작성 및 실행을 담당
-   **Programming model** 지원 (@BeforeEach, @AfterEach, @Test 등) : 테스트를 작성하는 데 사용하는 규칙과 주석의 집합
-   **ExtensionModel** 지원 (@ExtendWith 등) : 테스트 수명 주기 동안 실행할 수 있는 사용자 지정 작업을 생성하기 위해 구현할 수 있는 일련의 API 및 인터페이스를 제공
-   자체 **TestEngine**을 제공하여 JUnit Jupiter 프로그래밍 모델로 작성된 테스트를 실행

3\. JUnit Vintage

-   JUnit3 또는 JUnit4로 작성된 테스트를 실행
-   JUnit4.12 이상일 시 사용 가능

### 1.2 Example Projects

main :

```java
/*
 * Copyright 2015-2022 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

}
```

test :

```java
/*
 * Copyright 2015-2022 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}
}
```

---

## 2\. Writing Tests

### 2.1 Annotations

| Annotation | 설명 |
| --- | --- |
| **@Test** | 테스트 메서드임을 나타낸다.   JUnit 4의 @Test 어노테이션과는 달리, 이 어노테이션은 어떤 속성도 선언하지 않는다.    ``` @Test void simpleTest() {     Assertions.assertTrue(true); }​ ```   |
| **@ParameterizedTest** | 파라미터화된 테스트임을 나타낸다.    ``` @ParameterizedTest @ValueSource(strings = {"apple", "banana"}) void parameterizedTest(String fruit) {     Assertions.assertNotNull(fruit); }​ ```   |
| **@RepeatedTest** | 반복 테스트를 위한 테스트 템플릿임을 나타낸다.    ``` @RepeatedTest(3) void repeatedTest() {     Assertions.assertTrue(true); }​ ```   |
| **@TestFactory** | 동적 테스트를 위한 테스트 팩토리임을 나타낸다.    ``` @TestFactory Stream<DynamicTest> dynamicTests() {     return Stream.of("apple", "banana").map(         fruit -> DynamicTest.dynamicTest("Testing: " + fruit, \         () -> Assertions.assertNotNull(fruit))     ); }​ ```   |
| ******@ExtendWith****** | 확장을 선언적으로 등록하는 데 사용된다. |
| **@TestTemplate** | 메서드가 여러 번 호출되도록 설계된 테스트 케이스의 템플릿이다.   다른 테스트의 인터페이스로서 쓰인다.    ``` @TestTemplate @ExtendWith(MyTestTemplateInvocationContextProvider.class) void testTemplate(String param) {     Assertions.assertNotNull(param); }​ ```   |
| **@TestClassOrder** | 어노테이션이 달린 테스트 클래스의 @Nested 테스트 클래스 실행 순서를 구성하는 데 사용된다. |
| **@TestMethodOrder** | 어노테이션이 달린 테스트 클래스의 테스트 메서드 실행 순서를 구성하는 데 사용된다. |
| **@TestInstance** | 어노테이션이 달린 테스트 클래스의 테스트 인스턴스 수명주기를 구성하는 데 사용된다. |
| **@DisplayName** | 테스트 클래스 또는 테스트 메서드의 사용자 정의 표시 이름을 선언한다. |
| **@DisplayNameGeneration** | 테스트 클래스의 사용자 정의 표시 이름 생성기를 선언한다. |
| **@BeforeEach** | 현재 클래스의 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory 메서드 각각 전에 실행되어야 할 메서드임을 나타낸다.    ``` @BeforeEach void setUp() {     System.out.println("Before each test"); }​ ```   |
| **@AfterEach** | 현재 클래스의 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory 메서드 각각 후에 실행되어야 할 메서드임을 나타낸다.    ``` @AfterEach void tearDown() {     System.out.println("After each test"); }​ ```   |
| **@BeforeAll** | 현재 클래스의 모든 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory 메서드 전에 실행되어야 할 메서드임을 나타낸다.    ``` @BeforeAll static void initAll() { }​ ```   |
| **@AfterAll** | 현재 클래스의 모든 @Test, @RepeatedTest, @ParameterizedTest, @TestFactory 메서드 후에 실행되어야 할 메서드임을 나타낸다.    ``` @AfterAll static void tearDownAll() { }​ ```   |
| **@Nested** | 어노테이션이 달린 클래스가 비정적 중첩 테스트 클래스임을 나타낸다.    ``` @Nested class NestedTests {      @Test     void nestedTest() {         Assertions.assertTrue(true);     } }​ ```   |
| **@Tag** | 클래스 또는 메서드 수준에서 테스트를 필터링하기 위한 태그를 선언하는 데 사용된다.    ``` @Tag("fast") @Test void taggedTest() {     Assertions.assertTrue(true); }​ ```   |
| **@Disabled** | 테스트 클래스 또는 테스트 메서드를 비활성화하는 데 사용된다.    ``` @Disabled @Test void disabledTest() {     Assertions.fail("This should never run"); }​ ```   |
| **@Timeout** | 테스트, 테스트 팩토리, 테스트 템플릿 또는 수명주기 메서드의 실행이 지정된 기간을 초과하면 실패하도록하는 데 사용된다.    ``` @Timeout(1) @Test void timeoutTest() throws InterruptedException {     Thread.sleep(2000); }​ ```   |
| **@RegisterExtension** | 필드를 통해 확장을 프로그래밍 방식으로 등록하는 데 사용된다. |
| **@TempDir** | 수명주기 메서드 또는 테스트 메서드에서 임시 디렉토리를 필드 주입 또는 매개 변수 주입으로 제공하는 데 사용된다.    ``` @TempDir Path tempDir;  @Test void testUsingTempDir() {     Assertions.assertTrue(Files.exists(tempDir)); }​ ```   |

> ⚠️ 어떤 어노테이션은 기한이 만료되었을 수 있다. [Experimental APIs](https://junit.org/junit5/docs/current/user-guide/#api-evolution-experimental-apis)를 참고하자.

JUnit Jupiter의 어노테이션은 메타 어노테이션으로 사용이 가능하다. 주석의 의미론을 이어받아 나만의 주석을 만들 수 있다.

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}
```

```java
@Fast
@Test
void myFastTest() {
    // ...
}
```

: 코드에 "fast"를 가진 Tag를 달았다면 테스트코드에서 @Fast라고 언급해주어도 된다.

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
@Test
public @interface FastTest {
}
```

```java
@FastTest
void myFastTest() {
    // ...
}
```

: "fast" Tag와 Test를 합쳐 FastTest로도 인지가 가능하다.

### 2.2 정의

**플랫폼 개념**

**컨테이너**

테스트 트리에서 다른 컨테이너 또는 테스트를 자식으로 포함하는 노드

**테스트**

실행 시 예상되는 동작을 확인하는 테스트 트리의 노드

---

**Jupiter 개념**

**라이프사이클 메소드**

@BeforeAll, @AfterAll, @BeforeEach 또는 @AfterEach로 직접 주석을 달거나 메타 주석을 다는 메서드

**테스트 클래스**  
테스트 메서드를 하나 이상 포함하는 최상위 클래스, 정적 멤버 클래스 또는 @Nested 클래스. 테스트 클래스는 추상적이지 않아야 하며 생성자가 하나만 있어야 한다.

**테스트 메서드**  
@Test, @RepeatedTest, @ParameterizedTest, @TestFactory 또는 @TestTemplate로 직접 주석을 달거나 메타 주석이 달린 인스턴스 메서드. Test를 제외하고는 테스트 트리에서 테스트를 그룹화하는 컨테이너를 생성하거나 잠재적으로 (@TestFactory의 경우) 다른 컨테이너를 생성한다.

### 2.3 Test 클래스와 메소드

-   테스트 메소드와 라이프사이클 메소드는 현재 테스트에 속하거나, 슈퍼테스트클래스에 속하거나, 인터페이스에 속한다.
-   추상적이지 않아야 한다.
-   반환값이 없어야 한다.
-   public일 필요는 없지만 private이면 안된다. 하지만 public인 것이 좋다.

### 2.4 Display Names

1\. @DisplayName

-   공백, 문자, 이모지로 테스트의 이름을 표현할 수 있다.
-   이름은 test runner와 IDE에 의해 보여진다.

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case") // class에도 이름을 붙일 수 있다.
class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯") // 특수문자
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱") // 이모지
    void testWithDisplayNameContainingEmoji() {
    }

}
```

2\. @DisplayNameGeneration

-   사용자 정의 이름을 생성할 수 있다.
-   우선순위 : @DisplayName > @DisplayNameGeneration

| DisplayNameGenerator | 행동 |
| --- | --- |
| Standard | JUnit Jupiter 5.0이 출시된 이후로 표준 디스플레이 이름 생성 행동과 일치 |
| Simple | 매개 변수가 없는 메서드의 괄호를 제거 |
| ReplaceUnderscores | 밑줄(언더스코어)을 공백으로 변환 |
| IndicativeSentences | 테스트와 내부 클래스의 이름을 연결하여 완전한 문장을 생성   @IndicativeSentenceGeneration을 사용하여 구분 기호와 기본 생성기를 사용자 지정 |

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DisplayNameGeneratorDemo {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = { -1, -4 })
        void if_it_is_negative(int year) {
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = ReplaceUnderscores.class)
    class A_year_is_a_leap_year {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = { 2016, 2020, 2048 })
        void if_it_is_one_of_the_following_years(int year) {
        }

    }

}

/* Result
+-- DisplayNameGeneratorDemo [OK]
  +-- A year is not supported [OK]
  | +-- A negative value for year is not supported by the leap year computation. [OK]
  | | +-- For example, year -1 is not supported. [OK]
  | | '-- For example, year -4 is not supported. [OK]
  | '-- if it is zero() [OK]
  '-- A year is a leap year [OK]
    +-- A year is a leap year -> if it is divisible by 4 but not by 100. [OK]
    '-- A year is a leap year -> if it is one of the following years. [OK]
      +-- Year 2016 is a leap year. [OK]
      +-- Year 2020 is a leap year. [OK]
      '-- Year 2048 is a leap year. [OK]
*/
```

3\. default Display Name Generator

-   junit.jupiter.displayname.generator.default configuration 파일을 이용하여 default를 설정할 수 있다.
-   ReplaceUnderscores를 default로 사용하고 싶다면 다음과 같이 설정한다.

```java
junit.jupiter.displayname.generator.default = \
    org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderscores
```

> 우선순위는 다음과 같다.
>
> 1\. @DisplayName  
> 2\. @DisplayNameGenerator  
> 3\. configuration파일에 있는 @DisplayNameGenerator  
> 4\. Standard (기본설정값)

### 2.5 Assertions

-   JUnit4 + Java 8 Lambda
-   static 메소드

```java
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;

import example.domain.Person;
import example.util.Calculator;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssertionsDemo {

    private final Calculator calculator = new Calculator();

    private final Person person = new Person("Jane", "Doe");

    @Test
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2),
                "The optional failure message is now the last parameter");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
            () -> assertEquals("Jane", person.getFirstName()),
            () -> assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
            () -> {
                String firstName = person.getFirstName();
                assertNotNull(firstName);

                // Executed only if the previous assertion is valid.
                assertAll("first name",
                    () -> assertTrue(firstName.startsWith("J")),
                    () -> assertTrue(firstName.endsWith("e"))
                );
            },
            () -> {
                // Grouped assertion, so processed independently
                // of results of first name assertions.
                String lastName = person.getLastName();
                assertNotNull(lastName);

                // Executed only if the previous assertion is valid.
                assertAll("last name",
                    () -> assertTrue(lastName.startsWith("D")),
                    () -> assertTrue(lastName.endsWith("e"))
                );
            }
        );
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
            calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), AssertionsDemo::greeting);
        assertEquals("Hello, World!", actualGreeting);
    }

    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    @Test
    void timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            new CountDownLatch(1).await();
        });
    }

    private static String greeting() {
        return "Hello, World!";
    }

}
```

> ⚠️ assertTimeoutPreemptively() 메소드는 ThreadLocal에 의존적이다. 따라서 Spring의 transaction 테스트에서 데이터베이스의 변경 사항이 취소되지 않으며 데이터베이스에 영구적으로 저장하게 된다. 
>
> 예시를 들어보자.  
> Tread는 사람을 의미하며, TreadLocal은 사람이 가지고 있는 주머니라고 할 수 있다. 한 사람의 주머니에 물건을 넣으면 다른 사람은 접근할 수 없다.  
> assertTimeoutPreemptively()는 다른 사람에게 작업을 요청하게 되고, 호출한 사람이 작업을 완료하는데 필요한 모든 것을 주머니에 가지고 있지 않을 수 있게 된다.
>
> Spring의 Transaction테스트는 일부 트랜잭션 상태 정보를 TreadLocal에 저장한다. 이를 통해 데이터베이스 변경 사항을 추적한 다음 테스트 종료 후 해당 변경 사항을 롤백하여 데이터베이스가 변경되지 않도록 유지할 수 있다.
>
> 이 상황에서 assertTimeoutPreemptively()를 사용할 경우, Spring의 Transaction 테스트가 사용하고 있는 TreadLocal이 아닌 다른 TreadLocal을 참조하게 되고, Spring의 Transaction은 원래 연결되어 있던 TreadLocal을 참조하고 롤백하기 때문에 assertTimeoutPreemptively()가 변경한 모든 정보는 데이터베이스에 저장되게 된다.

### 2.6 Assumptions

-   JUnit4 + Java 8 Lambda
-   static 메소드

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import example.util.Calculator;

import org.junit.jupiter.api.Test;

class AssumptionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
            () -> "Aborting test: not on developer workstation");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
            () -> {
                // perform these assertions only on the CI server
                assertEquals(2, calculator.divide(4, 2));
            });

        // perform these assertions in all environments
        assertEquals(42, calculator.multiply(6, 7));
    }

}
```

> ⚠️ Junit Jupiter 5.4의 경우, Junit 4의 org.junit.Assume 클래스를 사용할 수 있다. 또한, 테스트가 실패 대신 중단이 되었을 때 JUnit 4의 AssumptionViolatedException를 쓸 수 있다.

> 💡Assertion은 정확성을 요구하는 테스트이고, Assuming은 유효한 컨텍스트를 정의하는 것이다. 컨텍스트가 유효하지 않다면 테스트는 실패가 아닌 스킵이 된다.

### 2.7 Disabling Tests

@Disabled 어노테이션을 통해 클래스, 메소드의 테스트를 불가능하게 만든다.

> ⚠️ @Disabled는 명백한 이유가 있는 것이 좋다. 예를 들면, @Disabled("Disabled until bug #42 has been resolved")과 같다. 명백한 이유를 위해 이슈 트래킹 넘버를 추적하는 것이 좋다.

### 2.8 조건 테스트

-   프로그래밍 조건에 의해 테스트를 활성화/비활성화 시킬 수 있다.
-   가장 간단한 것은 @Disabled이다.

> 💡 사용자 지정 주석을 만들 수 있다. 예를 들어, @TestOnMac은 @Test와 @EnabledOnOs를 합친 것이다.

> ⚠️ 특별한 언급이 없는 한, 조건부 주석은 한 테스트 메소드, 클래스, 인터페이스에 대해 한 번만 사용할 수 있다. 여러 조건부 주석이 있을 경우, JUnit에 의해 발견된 첫번째 주석만 실행되며 나머지는 무시된다.

1\. OS와 아키텍쳐 조건

os :

```java
@Test
@EnabledOnOs(MAC)
void onlyOnMacOs() {
    // ...
}

@TestOnMac
void testOnMac() {
    // ...
}

@Test
@EnabledOnOs({ LINUX, MAC })
void onLinuxOrMac() {
    // ...
}

@Test
@DisabledOnOs(WINDOWS)
void notOnWindows() {
    // ...
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@EnabledOnOs(MAC)
@interface TestOnMac {
}
```

Architecture :

```java
@Test
@EnabledOnOs(architectures = "aarch64")
void onAarch64() {
    // ...
}

@Test
@DisabledOnOs(architectures = "x86_64")
void notOnX86_64() {
    // ...
}

@Test
@EnabledOnOs(value = MAC, architectures = "aarch64")
void onNewMacs() {
    // ...
}

@Test
@DisabledOnOs(value = MAC, architectures = "aarch64")
void notOnNewMacs() {
    // ...
}
```

2\. 자바 런타임 환경 조건

```java
@Test
@EnabledOnJre(JAVA_8)
void onlyOnJava8() {
    // ...
}

@Test
@EnabledOnJre({ JAVA_9, JAVA_10 })
void onJava9Or10() {
    // ...
}

@Test
@EnabledForJreRange(min = JAVA_9, max = JAVA_11)
void fromJava9to11() {
    // ...
}

@Test
@EnabledForJreRange(min = JAVA_9)
void fromJava9toCurrentJavaFeatureNumber() {
    // ...
}

@Test
@EnabledForJreRange(max = JAVA_11)
void fromJava8To11() {
    // ...
}

@Test
@DisabledOnJre(JAVA_9)
void notOnJava9() {
    // ...
}

@Test
@DisabledForJreRange(min = JAVA_9, max = JAVA_11)
void notFromJava9to11() {
    // ...
}

@Test
@DisabledForJreRange(min = JAVA_9)
void notFromJava9toCurrentJavaFeatureNumber() {
    // ...
}

@Test
@DisabledForJreRange(max = JAVA_11)
void notFromJava8to11() {
    // ...
}
```

3\. Native Image 조건

Gradle, Maven의 GraalVM 플러그인의 Native Image에 관한 테스트

```java
@Test
@EnabledInNativeImage
void onlyWithinNativeImage() {
    // ...
}

@Test
@DisabledInNativeImage
void neverWithinNativeImage() {
    // ...
}
```

4\. 시스템 특성 조건

```java
@Test
@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
void onlyOn64BitArchitectures() {
    // ...
}

@Test
@DisabledIfSystemProperty(named = "ci-server", matches = "true")
void notOnCiServer() {
    // ...
}
```

> 💡 중복 어노테이션이므로 여러 번 사용 가능하다. 직접적, 간접적, 메타 어노테이션으로 존재할 수 있다.

5\. 환경 변수 조건

```java
@Test
@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
void onlyOnStagingServer() {
    // ...
}

@Test
@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
void notOnDeveloperWorkstation() {
    // ...
}
```

> 💡 중복 어노테이션이므로 여러 번 사용 가능하다. 직접적, 간접적, 메타 어노테이션으로 존재할 수 있다.

6\. 커스텀 조건

컨디션 메소드와 결합하여 사용 가능하며, 컨디션 메소드는 boolean값을 반환해야 한다.

테스트 코드 밖에 생성될 수 있다. (하나의 클래스처럼)

```java
@Test
@EnabledIf("customCondition")
void enabled() {
    // ...
}

@Test
@DisabledIf("customCondition")
void disabled() {
    // ...
}

boolean customCondition() {
    return true;
}
```

> ⚠️ 커스텀 조건 어노테이션은 다음과 같은 상황에 static이어야 한다.  
> 1\. 클래스 레벨에서 쓰였을 때  
> 2\. @ParamiterizedTest 혹은 @TestTemplate과 함께 쓰일 때  
> 3\. 외부 클래스에서 쓰일 때  
> 이 때를 제외하고 커스텀 조건 어노테이션은 static이거나 instance일 수 있다.

### 2.10 테스트 순서

-   테스트는 특정 순서로 실행된다.
-   테스트를 실행할 때마다 동일한 순서로 실행된다.
-   이 순서의 논리는 쉽게 추측하거나 확인할 수 없다.

1\. 메소드 순서

실제 단위 테스트는 일반적으로 실행 순서에 의존해서는 안 되지만, 특히 @TestInstance(Lifecycle.PER\_CLASS)와 함께 테스트의 순서가 중요한 통합 테스트나 기능 테스트를 작성할 때와 같이 특정 테스트 방법 실행 순서를 강제해야 하는 경우가 있다.

@TestMethodOrder를 사용하거나 MethodOrder를 구현하여 custom 순서를 만들 수 있다.

> **MethodOrderer.DisplayName**: 이름의 알파벳순서로 테스트한다.  
> **MethodOrderer.MethodName**: 이름과 파라미터의 알파벳 순서로 테스트한다.  
> **MethodOrderer.OrderAnnotation**: @Order 어노테이션을 이용해 value의 순차적으로 테스트한다.
>
> ```java
> import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
> import org.junit.jupiter.api.Order;
> import org.junit.jupiter.api.Test;
> import org.junit.jupiter.api.TestMethodOrder;
> 
> @TestMethodOrder(OrderAnnotation.class)
> class OrderedTestsDemo {
> 
>     @Test
>     @Order(1)
>     void nullValues() {
>         // perform assertions against null values
>     }
> 
>     @Test
>     @Order(2)
>     void emptyValues() {
>         // perform assertions against empty values
>     }
> 
>     @Test
>     @Order(3)
>     void validValues() {
>         // perform assertions against valid values
>     }
> 
> }​
> ```
>
>
> **MethodOrderer.Random**: 랜덤으로 테스트한다.

Configuration 설정으로 default Order를 설정할 수 있다.

> junit.jupiter.testmethod.order.default = \\ org.junit.jupiter.api.MethodOrderer$OrderAnnotation

2\. 클래스 순서

일반적으로 실행 순서에 의존해서는 안 되지만, 특정 테스트 클래스 실행 순서를 적용하는 것이 바람직한 경우가 있다. 테스트 클래스 간에 우발적인 종속성이 발생하지 않도록 테스트 클래스를 임의의 순서로 실행하거나, 다음 시나리오에 설명된 대로 빌드 시간을 최적화하기 위해 테스트 클래스를 순서대로 실행할 수 있다.

-   이전에 실패한 테스트와 더 빠른 테스트를 먼저 실행 : "fail fast" mode
-   병렬 실행을 활성화한 상태에서 더 긴 테스트를 먼저 실행 : "shortest test plan execution duration" mode

> **ClassOrderer.ClassName**: 정규화된 클래스 이름에 따라 테스트 클래스를 영숫자로 정렬한다.  
> **ClassOrderer.DisplayName**: 표시 이름에 따라 테스트 클래스를 영숫자로 정렬한다.  
> **ClassOrder.OrderAnotation**: @Order 어노테이션을 통해 지정된 값에 따라 테스트 클래스를 숫자순으로 정렬한다.  
> **ClassOrderer.Random**: 테스트 클래스를 의사 무작위로 주문하고 사용자 지정 시드 구성을 지원한다.

> 💡 최상위 테스트 클래스는 서로를 기준으로 순서가 지정되며, @Nested 테스트 클래스는 동일한 중첩 클래스를 공유하는 다른 @Nested된 테스트 클래스를 기준으로 순서가 지정된다.

```java
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class OrderedNestedTestClassesDemo {

    @Nested
    @Order(1)
    class PrimaryTests {

        @Test
        void test1() {
        }
    }

    @Nested
    @Order(2)
    class SecondaryTests {

        @Test
        void test2() {
        }
    }
}
```

### 2.11 테스트 인스턴스 수명 주기

-   TestInstance(Lifecycle.PER\_CLASS)를 사용할 경우 동일한 테스트 인스턴스에서 모든 테스트 메서드를 실행한다.
-   위 모드 사용 시 테스트 클래스당 한 번씩 새 테스트 인스턴스가 생성된다.
-   테스트 메서드가 인스턴스 변수에 저장된 상태에 의존하는 경우 @BeforeEach 또는 AfterEach 메서드에서 해당 상태를 재설정해야한다.
-   "메소드 단위"에 비해 "클래스 단위"는 기본 메서드 뿐만 아니라 non-static 메서드에 대해서도 @BeforeAll 및 @AfterAll을 선언할 수 있으며, @Nested 클래스에 대해서도 위 어노테이션을 사용할 수 있다.

> 💡 Java16부터, @BeforeAll과 @AfterAll은 @Nested 클래스에서 static으로 선언될 수 있다.

-   테스트 인스턴스 주석이 달리지 않으면 기본 테스트 생명주기(PER\_METHOD)를 사용한다.
-   클래스의 경로에 junit-platform.properties 파일을 추가하여 default 수명 주기를 변경할 수 있다.

> junit.jupiter.testinstance.lifecycle.default = per\_class

> ⚠️ 기본 테스트 인스턴스 수명 주기 모드를 변경하면  지속적으로 적용되지 않으면 예측할 수 없는 결과와 취약한 빌드로 이어질 수 있다. 예를 들어, 빌드가 "클래스당" 의미를 기본값으로 구성하지만 IDE의 테스트가 "방법당" 의미론을 사용하여 실행되는 경우, 빌드 서버에서 발생하는 오류를 디버깅하기가 어려울 수 있다. 따라서 JVM 시스템 속성 대신 위와 같이 JUnit 플랫폼 구성 파일의 기본값을 변경하는 것이 좋다.

### 2.12 @Nested 테스트

-   내부 테스트가 실행되기 전에 외부 테스트의 설정 코드가 실행된다.
-   모든 테스트를 독립적으로 실행할 수 있게 해준다.
-   외부 테스트의 설정 코드는 항상 실행되기 때문에 외부 테스트를 실행하지 않고도 내부 테스트를 단독으로 실행할 수 있다.

> ⚠️ non-static nested 클래스(즉, 내부 클래스)만 @Nested 테스트 클래스로 사용할 수 있다. 중첩은 임의로 깊을 수 있으며 이러한 내부 클래스는 한 가지 예외를 제외하고 전체 라이프사이클 지원을 받는다. @BeforeAll 및 @AfterAll 메서드는 기본적으로 작동하지 않는다. 이는 Java가 Java 16 이전의 내부 클래스에서 static 멤버를 허용하지 않기 때문이다. 그러나 @Nested 테스트 클래스에 @TestInstance(Lifecycle.PER\_CLASS)를 주석으로 달면 이 제한을 피할 수 있다. Java 16 이상을 사용하는 경우 @BeforeAll 및 @AfterAll 메서드는 @Nested 테스트 클래스에서 정적으로 선언될 수 있으며 이 제한은 더 이상 적용되지 않는다.

### 2.13 생성자와 메소드를 위한 DI

-   이전의 JUnit은 생성자와 메소드가 변수를 가질 수 없게 하였다.
-   현재는 변수를 가질 수 있기 때문에 DI를 이용한 유연한 설계가 가능하다.

1\. TestInformParameterResolver

-   생성자 또는 메서드 매개변수가 TestInfo 유형인 경우, 매개변수 값으로 현재 컨테이너 또는 테스트에 해당하는 TestInfo 인스턴스를 제공한다.
-   TestInfo를 사용하여 표시 이름, 테스트 클래스, 테스트 메서드 및 관련 태그와 같은 현재 컨테이너 또는 테스트에 대한 정보를 검색할 수 있다.
-   표시 이름은 테스트 클래스 또는 테스트 메서드의 이름과 같은 기술적인 이름 또는 @DisplayName을 통해 구성된 사용자 지정 이름이다.

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("TestInfo Demo")
class TestInfoDemo {

    TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }

}
```

2\. RepetitionExtension

-   @RepeatedTest, @BeforeEach 또는 @AfterEach 메서드의 메서드 매개변수가 RepetitionInfo 유형인 경우 RepetitionInfo의 인스턴스를 제공한다.
-    RepetitionInfo를 사용하여 현재 반복, 총 반복 횟수, 실패한 반복 횟수 및 해당 @RepeatedTest의 실패 임계값에 대한 정보를 검색할 수 있다.
-   RepetitionExtension은 @RepeatedTest 컨텍스트 외부에서는 등록되지 않는다.

3\. TestReporterParameterResolver

-   생성자 또는 메서드 매개변수가 TestReporter 유형인 경우, TestReporter의 인스턴스를 제공한다.
-   테스트 리포터는 현재 테스트 실행에 대한 추가 데이터를 게시하는 데 사용할 수 있다.
-   이 데이터는 테스트 실행 리스너의 reportingEntryPublished() 메서드를 통해 소비할 수 있으며, IDE에서 보거나 보고서에 포함할 수 있다.
-   JUnit 4에서 stdout 또는 stderr에 정보를 출력하는 데 사용했던 것에 반하여 JUnit 5에선 TestReporter를 사용해야 한다.
-   RunWith(JUnitPlatform.class)를 사용하면 보고된 모든 항목이 stdout에 출력된다. 또한 일부 IDE는 보고서 항목을 stdout에 인쇄하거나 테스트 결과를 사용자 인터페이스에 표시합니다.

```java
class TestReporterDemo {

    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a status message");
    }

    @Test
    void reportKeyValuePair(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    void reportMultipleKeyValuePairs(TestReporter testReporter) {
        Map<String, String> values = new HashMap<>();
        values.put("user name", "dk38");
        values.put("award year", "1974");

        testReporter.publishEntry(values);
    }

}
```

> ⚠️ 다른 매개 변수 리졸버는 @ExtendsWith()을 이용해 확장되어야 한다.

### 2.14 Test interface와 default 메소드

@TestInstance(Lifecycle.PER\_CLASS) 어노테이션의 경우, @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, @TestTemplate, @BeforeEach 및 @AfterEach를 인터페이스 기본 메서드에서 선언할 수 있다.

```java
@TestInstance(Lifecycle.PER_CLASS)
interface TestLifecycleLogger {

    static final Logger logger = Logger.getLogger(TestLifecycleLogger.class.getName());

    @BeforeAll
    default void beforeAllTests() {
        logger.info("Before all tests");
    }

    @AfterAll
    default void afterAllTests() {
        logger.info("After all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        logger.info(() -> String.format("About to execute [%s]",
            testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        logger.info(() -> String.format("Finished executing [%s]",
            testInfo.getDisplayName()));
    }

}
```

```java
interface TestInterfaceDynamicTestsDemo {

    @TestFactory
    default Stream<DynamicTest> dynamicTestsForPalindromes() {
        return Stream.of("racecar", "radar", "mom", "dad")
            .map(text -> dynamicTest(text, () -> assertTrue(isPalindrome(text))));
    }

}
```

```java
@Tag("timed")
@ExtendWith(TimingExtension.class)
interface TimeExecutionLogger {
}

class TestInterfaceDemo implements TestLifecycleLogger,
        TimeExecutionLogger, TestInterfaceDynamicTestsDemo {

    @Test
    void isEqualValue() {
        assertEquals(1, "a".length(), "is always equal");
    }

}
```

### 2.15 RepeatedTest

-   JUnit Jupiter 5.10부터 남은 반복을 자동으로 건너뛰는 실패 횟수를 나타내는 실패 임계값을 사용하여 @RepeatedTest를 구성할 수 있다. 지정된 실패 횟수가 발생한 후 남은 반복의 호출을 건너뛰려면 failureThreshold 속성을 총 반복 횟수보다 작은 양수로 설정한다.
-   반복이 병렬로 실행되는 경우, 실패 임계값에 대해 보장할 수 없다. 따라서 병렬 실행을 구성할 때는 @RepeatedTest 메서드에 @Execution(SAME\_THREAD)를 주석으로 추가하는 것이 좋다.
-   반복 횟수 및 실패 임계값을 지정하는 것 외에도 @RepeatedTest 어노테이션의 이름 속성을 통해 각 반복에 대해 사용자 지정 표시 이름을 구성할 수 있다. 또한 표시 이름은 정적 텍스트와 동적 자리 표시자의 조합으로 구성된 패턴이 될 수 있다.

> **{displayName}**: @RepeatedTest의 이름 출력  
> **{currentRepetition}**: 현재 반복 횟수  
> **{totalRepetitions}**: 총 반복 횟수

### 2.16 ParamiterizedTest

1\. 의존성 추가

junit-jupiter-params 의존성을 추가한다.

2\. 규칙에 따라 인자 추가

> 0개 이상의 인덱싱된 인수가 먼저 선언  
> 0개 이상의 집계자가 다음에 선언  
> 파라미터리졸버가 제공하는 0개 이상의 인자는 마지막에 선언

3\. 인자의 소스

1.  ValueSource
    -   리터럴 값의 단일 배열을 지정할 수 있다.
    -   매개 변수화된 테스트 호출당 단일 인수를 제공하는 데만 사용할 수 있다.
    -   short, byte, int, long, float, double, char, boolean, java.lang.String, java.lang.Class를 지원한다.
2.  Null and Empty
    -   @NullSource : 단일 null 제공
    -   @EmptySource : empty 제공
    -   @NullAndEmptySource : @NullSource + @EmptySource
3.  EnumSource
    -   annotation의 value는 필수적이지 않다.
    -   value가 공백일 경우, 첫 번째 파라미터의 타입이 된다.
    -   annotation의 value와 첫 번째 파라미터의 타입이 다를 경우 에러가 발생한다.
4.  MethodSource
    -   테스트 클래스 혹은 외부 클래스의 하나 이상의 팩토리 메소드를 참조할 수 있다.
    -   각 팩토리 방법은 인수 스트림을 생성해야 하며, 스트림 내의 각 인수 세트는 주석이 달린 @ParameterizedTest 방법의 개별 호출에 대한 물리적 인수로 제공된다.
    -   "Stream"은 Stream, DoubleStream, LongStream, IntStream, Collection, Iterator, Iterable, 객체 배열, 객체 배열 또는 프리미티브 배열과 같이 JUnit이 스트림으로 안정적으로 변환할 수 있는 모든 것을 의미한다.
    -   스트림 내의 "인수"는 인수 인스턴스, 객체 배열(예, Object\[\]), 파라미터화된 테스트 방법이 단일 인수를 수락하는 경우 단일 값으로 제공될 수 있다.
    -   만약, 팩토리 메소드를 참조하지 않는다면 @ParameterizedTest가 메소드의 이름과 같은 팩토리 메소드를 찾아 참조한다.
    -   여러 개의 파라미터를 선언했다면, Arguments.of(...)로 여러 개의 인스턴스나 오브젝트를 반환해야한다.
5.  CSVSource
    -   콤마로 분리된 value를 표현한다
    -   따옴표가 붙지 않은 빈 값은 nullValues 특성을 통해 구성된 사용자 지정 값에 관계없이 항상 null 참조로 변환된다.
    -   기본 구분 기호는 쉼표(,)이지만 구분 기호 특성을 설정하여 다른 문자를 사용할 수 있다.
    -   기본적으로 @CsvSource는 하나의 따옴표(')를 따옴표 문자로 사용하지만 이는 quoteCharacter 특성을 통해 변경할 수 있다.
    -   ⚠️ 자바의 텍스트 블록 기능은 코드가 컴파일될 때 부수적인 공백을 자동으로 제거한다. 그러나 그루비나 코틀린과 같은 다른 JVM 언어들은 그렇지 않다. 따라서 자바가 아닌 프로그래밍 언어를 사용하고 있는데 텍스트 블록에 따옴표나 따옴표로 묶인 문자열 내의 새 줄이 포함되어 있다면 텍스트 블록 내에 선행하는 공백이 없는지 확인해야 한다.
6.  CSVFileSource
    -   @CsvFileSource를 사용하면 클래스 경로 또는 로컬 파일 시스템에서 CSV(쉼표로 구분된 값) 파일을 사용할 수 있다.
    -   첫 번째 레코드는 선택적으로 CSV 헤더를 제공하는 데 사용될 수 있다.
    -   Junit에게 numLinesToSkip 특성을 통해 헤더를 무시하도록 지시할 수 있다.
    -   표시 이름에 사용할 헤더를 원하는 경우 useHeadersInDisplayName 특성을 true로 설정할 수 있다.
    -   기본 구분 기호는 쉼표(,)이지만 구분 기호 특성을 설정하여 다른 문자를 사용할 수 있다.
    -   #으로 시작되는 주석은 모두 무시된다.
    -   @CsvSource에서 사용되는 기본 구문과는 달리 @CsvFileSource에서는 기본적으로 큰따옴표(")를 따옴표 문자로 사용하지만 이는 quoteCharacter 특성을 통해 변경할 수 있다.
    -   따옴표로 묶은 문자열 내를 제외하고 CSV 열의 선행 및 후행 공백은 기본적으로 trim된다. 이 동작은 ignoreLeadingAndTrailingWhitespace 특성을 true로 설정하여 변경할 수 있다.
7.  ArgumentSource
    -   @ArgumentsSource를 사용하여 재사용 가능한 사용자 지정 ArgumentsProvider를 지정할 수 있다. ArgumentsProvider 구현을 최상위 클래스 또는 정적 중첩 클래스로 선언해야 한다.

4\. 인자 변환

1.  **Widening Conversion** : 예를 들어 @ValueSource(ints = { 1, 2, 3 })로 주석이 달린 매개 변수화된 테스트는 형식 int의 인수뿐만 아니라 형식 long, float 또는 double의 인수도 받아들이도록 선언할 수 있다.
2.  **Implicit Conversion** : 10진수, 16진수 및 8진수 문자열 리터럴은 byte, short, int, long 및 상자형의 대응 문자로 변환된다.
3.  **Explicit Conversion** : @ConvertWith 주석을 사용하여 특정 매개 변수에 사용할 ArgumentConverter를 명시적으로 지정할 수 있다. ArgumentConverter 구현은 최상위 클래스 또는 정적 중첩 클래스로 선언되어야 한다.

5\. 인자 집합단일 인자를 그룹화해준다.

```java
@ParameterizedTest
@CsvSource({
    "Jane, Doe, F, 1990-05-20",
    "John, Doe, M, 1990-10-22"
})
void testWithArgumentsAccessor(ArgumentsAccessor arguments) {
    Person person = new Person(arguments.getString(0),
                               arguments.getString(1),
                               arguments.get(2, Gender.class),
                               arguments.get(3, LocalDate.class));

    if (person.getFirstName().equals("Jane")) {
        assertEquals(Gender.F, person.getGender());
    }
    else {
        assertEquals(Gender.M, person.getGender());
    }
    assertEquals("Doe", person.getLastName());
    assertEquals(1990, person.getDateOfBirth().getYear());
}
```

@AggergateWith()을 이용하여 custom aggregator를 이용할 수 있다.

```java
@ParameterizedTest
@CsvSource({
    "Jane, Doe, F, 1990-05-20",
    "John, Doe, M, 1990-10-22"
})
void testWithArgumentsAggregator(@AggregateWith(PersonAggregator.class) Person person) {
    // perform assertions against person
}

public class PersonAggregator implements ArgumentsAggregator {
    @Override
    public Person aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        return new Person(arguments.getString(0),
                          arguments.getString(1),
                          arguments.get(2, Gender.class),
                          arguments.get(3, LocalDate.class));
    }
}
```

이 상황이 반복될 경우, @CsvToMYCLASS를 이용하면 된다.

```java
@ParameterizedTest
@CsvSource({
    "Jane, Doe, F, 1990-05-20",
    "John, Doe, M, 1990-10-22"
})
void testWithCustomAggregatorAnnotation(@CsvToPerson Person person) {
    // perform assertions against person
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(PersonAggregator.class)
public @interface CsvToPerson {
}
```

### 2.18 Dynamic Tests

-   @TestFactory는 테스트가 아닌 테스트를 위한 팩토리이다.
-    단일 DynamicNode 또는 Stream, Collection, Iterable, Iterator 또는 DynamicNode 인스턴스 배열을 반환해야한다.

> ⚠️ 동적 테스트의 실행 수명 주기는 표준 @Test 케이스의 경우와 다르게 수명 주기 콜백이 없다. 즉, @BeforeEach 및 @AfterEach 메서드와 해당 확장 콜백은 각 동적 테스트에 대해 실행되는 것이 아니라 @TestFactory 메서드에 대해 실행된다. 즉, 동적 테스트에 대한 람다 표현식 내의 테스트 인스턴스에서 필드에 액세스하는 경우 동일한 @TestFactory 메서드에 의해 생성된 개별 동적 테스트가 실행되는 사이에 해당 필드는 콜백 메서드나 확장에 의해 재설정되지 않는다. JUnit Jupiter 5.10.0부터 동적 테스트는 항상 팩토리 메서드로 생성해야 하지만, 이후 릴리스에서 등록 기능으로 이 문제가 보완될 수 있다.

### 2.20 Pararrel 실행

1\. SAME\_THREAD

부모가 사용하는 동일한 스레드에서 강제 실행한다. 예를 들어 테스트 메서드에 사용할 경우 테스트 메서드는 포함하는 테스트 클래스의 임의의 @BeforeAll 또는 @AfterAll 메서드와 동일한 스레드에서 실행됩니다.

2\. CONCURRENT

리소스 잠금이 동일한 스레드에서 강제로 실행되지 않는 한 동시에 실행한다.  
기본적으로 테스트 트리의 노드는 SAME\_THREAD 실행 모드를 사용한다. junit.jupiter.execution.parallel.mode.default 구성 매개 변수를 설정하여 기본값을 변경하거나 또는 @Execution 주석을 사용하여 주석이 달린 요소와 개별 테스트 클래스에 대해 병렬 실행을 활성화할 수 있는 하위 요소(있는 경우)에 대한 실행 모드를 하나씩 변경할 수 있다.

[##_Image|kage@cvXy2b/btszlulJwUh/z2UAwWlaeaJRxTBsUC41l0/img.png|CDM|1.3|{"originWidth":1868,"originHeight":1152,"style":"alignCenter"}_##]

## 3\. Migrating from JUnit 4

### 3.2 Migration Tips

-   @Before and @After \-> @BeforeEach and @AfterEach
-   @BeforeClass and @AfterClass -> @BeforeAll and @AfterAll
-   @Ignore \-> @Disabled or built-in execution conditions
-   @Category \-> @Tag instead.
-   @RunWith \-> @ExtendWith.
-   @Rule and @ClassRule \-> @ExtendWith and @RegisterExtension.
-   @Test(expected = …​) and the ExpectedException rule -> Assertions.assertThrows(…​)

### 3.5 Failure Message Arguments

-   Assertions
    -   assertTrue
    -   assertFalse
    -   assertNull
    -   assertNotNull
    -   assertEquals
    -   assertNotEquals
    -   assertArrayEquals
    -   assertSame
    -   assertNotSame
    -   assertThrows
-   Assumptions
    -   assumeTrue
    -   assumeFalse

## 4\. Running Tests

### 4.1 IDE Supports

1\. Intellij IDEA

Gradle :

```java
testImplementation(platform("org.junit:junit-bom:5.10.0"))
testRuntimeOnly("org.junit.platform:junit-platform-launcher") {
  because("Only needed to run tests in a version of IntelliJ IDEA that bundles older versions")
}
testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
```

Maven :

```java
<!-- ... -->
<dependencies>
    <!-- Only needed to run tests in a version of IntelliJ IDEA that bundles older versions -->
    <dependency>
        <groupId>org.junit.platform</groupId>
        <artifactId>junit-platform-launcher</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.vintage</groupId>
        <artifactId>junit-vintage-engine</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.junit</groupId>
            <artifactId>junit-bom</artifactId>
            <version>5.10.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### 4.2 Build Supports

1\. Gradle

-   Gradle은 Native Image를 지원한다.

```java
test {
    useJUnitPlatform()
}
```

-   tags, tag expression을 지원한다.

```java
test {
    useJUnitPlatform {
        includeTags("fast", "smoke & feature-a")
        // excludeTags("slow", "ci")
        includeEngines("junit-jupiter")
        // excludeEngines("junit-vintage")
    }
}
```

-   Spring을 사용하는 경우 BOM을 이용하는 것이 좋다.
-   BOM을 사용하면 org.junit.platform, org.junit.jupiter 및 org.junit.vintage 그룹 ID를 가진 모든 아티팩트에 종속성을 선언할 때 버전을 생략할 수 있다.

```java
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
}
```

-   현재 표준 Gradle 테스트 작업에서는 Junit Platform 구성 매개 변수를 설정하여 테스트 검색 및 실행에 영향을 주는 전용 DSL을 제공하지 않지만, 시스템 속성(아래에 표시됨)이나 junit-platform.properties 파일을 통해 빌드 스크립트 내에 구성 매개 변수를 제공할 수 있다.

```java
test {
    // ...
    systemProperty("junit.jupiter.conditions.deactivate", "*")
    systemProperty("junit.jupiter.extensions.autodetection.enabled", true)
    systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
    // ...
}
```

-   테스트를 하기 위해선, TestEngine이 클래스 경로 내에 있어야 한다.
-   JUnit Jupiter의 테스트를 지원하기 위해, testImplementation의 의존성이 추가된다.

```java
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0") // version can be omitted when using the BOM
}
```

-   JUnit 4에 대한 testImplementation 종속성과 JUnit Vintage TestEngine 구현에 대한 testRuntimeOnly 종속성을 구성하여 JUNit 4 기반 테스트를 실행할 수 있습니다.

```java
dependencies {
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.10.0") // version can be omitted when using the BOM
}
```

-   LogManager의 Log4j나 LogBack을 이용하기 위해 의존성을 추가한다. (옵션)

```java
test {
    systemProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager")
}
```

2\. Maven

-   BOM을 이용하는 것이 좋다.

```java
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.junit</groupId>
            <artifactId>junit-bom</artifactId>
            <version>5.10.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

-   JUnit Jupiter API와 JUnit Jupiter TestEngine의 의존성을 추가한다.

```java
<!-- ... -->
<dependencies>
    <!-- ... -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version> <!-- can be omitted when using the BOM -->
        <scope>test</scope>
    </dependency>
    <!-- ... -->
</dependencies>
<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
        <plugin>
            <artifactId>maven-failsafe-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
    </plugins>
</build>
<!-- ... -->
```

-   Junit 4에 대한 테스트 범위 종속성과 Junit Vintage Test Engine 구현을 다음과 유사하게 구성하면 Maven Surefire 및 Maven Failsafe는 Junit 4 기반 테스트를 목성 테스트와 함께 실행할 수 있다.

```java
<!-- ... -->
<dependencies>
    <!-- ... -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.vintage</groupId>
        <artifactId>junit-vintage-engine</artifactId>
        <version>5.10.0</version> <!-- can be omitted when using the BOM -->
        <scope>test</scope>
    </dependency>
    <!-- ... -->
</dependencies>
<!-- ... -->
<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
        <plugin>
            <artifactId>maven-failsafe-plugin</artifactId>
            <version>3.1.2</version>
        </plugin>
    </plugins>
</build>
<!-- ... -->
```

```java
<!-- ... -->
<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
            <configuration>
                <excludes>
                    <exclude/>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>
<!-- ... -->
```

-   tag와 tag extension을 추가한다.

```java
<!-- ... -->
<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
            <configuration>
                <groups>acceptance | !feature-a</groups>
                <excludedGroups>integration, regression</excludedGroups>
            </configuration>
        </plugin>
    </plugins>
</build>
<!-- ... -->
```

-   junit-platform.properties 파일을 통해 빌드 스크립트 내에 구성 매개 변수를 제공할 수 있다.

```java
<!-- ... -->
<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.1.2</version>
            <configuration>
                <properties>
                    <configurationParameters>
                        junit.jupiter.conditions.deactivate = *
                        junit.jupiter.extensions.autodetection.enabled = true
                        junit.jupiter.testinstance.lifecycle.default = per_class
                    </configurationParameters>
                </properties>
            </configuration>
        </plugin>
    </plugins>
</build>
<!-- ... -->
```

4\. Spring

Gradle :

```java
ext['junit-jupiter.version'] = '5.10.0'
```

Maven :

```java
<properties>
    <junit-jupiter.version>5.10.0</junit-jupiter.version>
</properties>
```