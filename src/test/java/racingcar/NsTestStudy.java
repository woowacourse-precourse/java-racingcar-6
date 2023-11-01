package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public abstract class NsTestStudy {
    private PrintStream standardOut;
    private OutputStream captor;

    private static final Duration SIMPLE_TEST_TIMEOUT = Duration.ofSeconds(1L);
    private static final Duration TIMEOUT = Duration.ofSeconds(10L);

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

    public static void assertRandomNumberInRangeTest(
            final Executable executable,
            final Integer value, // value, values : 4, 3, 4, 3
            final Integer... values
    ) {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()), // static method
                executable,
                value,
                values
        );
    }

    private static void assertRandomTest(
            final MockedStatic.Verification verification,
            final Executable executable,
            final Integer value,
            final Integer... values
    ) {
        assertTimeoutPreemptively(TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) { // static 메소드 mocking
                mock.when(verification) // pickNumberInRange
                        .thenReturn(value, Arrays.stream(values) // 실행 값들 4, 3, 4 ,3
                                .toArray());
                executable.execute(); // 실행
            }
        });
    }

    public static void assertSimpleTest(final Executable executable) {
        assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, executable);
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final void run(final String... args) {
        try {
            command(args);
            runMain();
        } finally {
            Console.close();
        }
    }

    protected final void runException(final String... args) {
        try {
            run(args);
        } catch (final NoSuchElementException ignore) {
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected abstract void runMain();
}


