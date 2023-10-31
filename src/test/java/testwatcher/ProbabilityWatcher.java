package testwatcher;

import java.io.PrintStream;
import java.lang.StackWalker.StackFrame;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.ParameterizedTest;

public class ProbabilityWatcher implements TestWatcher {
    static Map<String, TestResult> resultMap = new HashMap<>();

    public static void registerResult(TestInfo testInfo, String result, boolean warn) {
        String key = getRegisterKey(testInfo);
        resultMap.put(key, new TestResult(result, warn));
    }

    static String getRegisterKey(TestInfo testInfo) {
        Class<?> testClass = testInfo.getTestClass().orElseThrow(NullPointerException::new);
        Method testMethod = testInfo.getTestMethod().orElseThrow(NullPointerException::new);

        return testClass.getName() + "." + testMethod.getName();
    }

    /**
     * 적절한 key를 생성하기 위해 Stack Trace를 사용합니다.<br/>
     * JUnit5의 @Test, @ParameterizedTest, @RepeatedTest 범위 내에서 호출하는 것을 권장합니다.
     *
     * @param result 현재는 String 출력만 수행하지만, 차후 특정한 형식을 요구할 수 있습니다.
     * @deprecated CallStack 대신 testInfo를 사용하도록 변경되었습니다.
     */
    @Deprecated
    public static void registerResult(String result, boolean warn) {
        String key = getRegisterKey(2);
        resultMap.put(key, new TestResult(result, warn));
    }

    /**
     * Stack Trace를 이용하여 적절한 key를 생성합니다.
     *
     * @param skipDepth 초기에 스킵할 콜스택 깊이
     * @return <현재 TestClass의 fullName>.<현재 Test메소드 이름> 형식의 문자열
     * @deprecated CallStack 대신 testInfo를 사용하도록 변경되었습니다.
     */
    @Deprecated
    static String getRegisterKey(int skipDepth) {
        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        StackFrame stackFrame = stackWalker.walk(stream -> stream
                .skip(skipDepth)
                .filter(ProbabilityWatcher::isTestMethod)
                .findFirst()
                .orElse(null));

        return stackFrame.getClassName() + "." + stackFrame.getMethodName();
    }

    private static boolean isTestMethod(StackFrame frame) {
        String methodName = frame.getMethodName();
        Class<?> testClass = frame.getDeclaringClass();

        try {
            Method testMethod = testClass.getDeclaredMethod(frame.getMethodName(),
                    frame.getMethodType().parameterArray());

            // 다른 JUnit Test 어노테이션이 존재한다면 추가할 수 있습니다.
            return testMethod.isAnnotationPresent(Test.class)
                    || testMethod.isAnnotationPresent(ParameterizedTest.class)
                    || testMethod.isAnnotationPresent(RepeatedTest.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("테스트 클래스에서 테스트 메서드를 찾을 수 없습니다.");
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testClassName = context.getTestClass()
                .orElseThrow(() -> new RuntimeException("테스트 클래스를 찾을 수 없습니다."))
                .getName();
        String testMethodName = context.getTestMethod()
                .orElseThrow(() -> new RuntimeException("테스트 메소드를 찾을 수 없습니다."))
                .getName();
        String key = testClassName + "." + testMethodName;
        TestResult testResult = resultMap.get(key);

        // 물론 실제로는 로거를 사용하는 것이 바람직할 것...
        PrintStream outputStream = System.out;
        if (testResult.warn()) {
            outputStream = System.err;
        }

        outputStream.println("---------------------------------------");
        outputStream.println("> 확률 테스트명: " + context.getDisplayName());
        outputStream.println();
        outputStream.println("> 테스트 결과: ");
        outputStream.println();
        outputStream.println(testResult.report());
        outputStream.println("---------------------------------------");
    }

    private record TestResult(String report, boolean warn) {
    }
}
