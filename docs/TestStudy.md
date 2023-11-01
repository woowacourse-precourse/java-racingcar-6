# Test 공부

**Goal**

: Junit과 AssertJ를 사용하는 방법을 어느 정도 익힌 상태이므로 이번 캠프에서 제공한 Test 라이브러리를 분석하고 공부한 내용을 정리하고자 한다.

## 사용된 라이브러리

ApplicationTest에서 사용된 테스트 라이브러리는 다음과 같다. 
- camp.nextstep.edu.missionutils.test.Assertions
- camp.nextstep.edu.missionutils.test.NsTest
- org.assertj.core.api.Assertions

org.assertj.core.api.Assertions는 AssertJ 라이브러리로 이미 사용해 본 경험이 있다. 
camp에서 제공한 테스트 라이브러리 코드를 분석하면서 테스트 라이브러리가 어떻게 동작하는지 이해할 수 있었다. 


## NsTest

abstract class로 ApplicationTest가 상속한다.

- protected abstract void runMain();

: 테스트할 메인 클래스를 실행하는 메소드이다.


: NsTest를 상속하는 ApplicationTest는 다음과 같이 Application.main() 메서드를 
실행해 테스트를 진행한다. 

    ```
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    ```
  
- 출력 스트림 캡쳐링

: 테스트할 메인 클래스를 실행하면서 콘솔에 출력되는 내용을 캡쳐링 하여 테스트 하기 위함이다. 
: org.junit.jupiter.api의 BeforeEach와 AfterEach를 사용해 스트림을 변경하고, 복구한다.
: 테스트를 진행할 땐 BypteArrayOutputStream을 사용하고, 테스트가 끝나면 System.out으로 콘솔에 결과를 출력한다.

    ```
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }
    ```
  

- protected final void run(final String... args)
: argument를 받아 input 스트림을 생성한 후 테스트할 클래스를 실행한다.

    ```
    protected final void run(final String... args) {
        try {
            command(args); // input 스트림 생성
            runMain(); 
        } finally {
            Console.close(); // Singleton pattern으로 구현된 scanner 객체 release
        }
    }
    ```
  
- private void command(final String... args)
: argument를 개행문자로 join해 input stream을 생성해 세팅한다. (사용자의 입력이 개행문자로 구분된다는 가정하에)

    ```
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
    ```

- protected final String output()
: ByteArrayOutputStream에 캡쳐된 내용을 String으로 변환한다. 
: expected output과 actual output을 비교할 때 사람이 이해하기 쉬운 String 형태로 코드를 짤 수 있도록 하기 위함이다. 

    ```
    protected final String output() {
        return captor.toString().trim();
    }
    ```
  
- protected final void runException(final String... args)
: NoSuchElementException을 무시하고 그 흐름을 계속 진행하기 위한 메소드이다. 
: AssertJ의 assertThatThrownBy를 사용해 발생하는 Exception을 검증할 때 사용한다. 

    ```
    protected final void runException(final String... args) {
        try {
            run(args);
        } catch (final NoSuchElementException ignore) {
        }
    }
    ```
  

## Assertions

org.assertj.core.api.Assertions에서 제공하는 것 이외의 커스텀 메서드를 제공한다. 

- assertSimpleTest()
: 실행 가능한 코드 블럭이 일정 시간을 초과할 경우 테스트를 중단한다. 
  
