package racingcar;


import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CallNsTestMethod {

    public static void myCommand(final String... args) { // Console.readln 함수의 입력값을 매개변수로 받음
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    private static <T> void assertRandomTest( // 랜덤값이 아닌, 처음에는 value로 들어온 값을 리턴, 그 이후에는 values의 배열을 리턴
            final MockedStatic.Verification verification,
            final Executable executable,
            final T value,
            final T... values
    ) {
        assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            // 실제로 매개변수 verification 메소드가 실행되지 않고 무조건 첫번째는 value, 나머지는 values 배열 값을 리턴함.
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                executable.execute();
            }
        });
    }

    public static void assertRandomNumberInRangeTest(
            final Executable executable, // 실행할 함수
            final Integer value, // 해당 함수의 첫번째 리턴값
            final Integer... values // 나머지 리턴값
    ) {
        assertRandomTest(
                // executable 함수가 실행되던 도중 Randoms.pickNumberInRange 함수가 실행되면 무조건 value 또는 value를 리턴함
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()), 
                executable,
                value,
                values
        );
    }
}
