package racingcar.util;


import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.function.Executable;

public class CustomAssertions {
    private static final Duration SIMPLE_TEST_TIMEOUT = Duration.ofSeconds(1L);

    private CustomAssertions() {

    }

    public static void assertSimpleTest(final Executable executable) {
        assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, executable);
    }
}
