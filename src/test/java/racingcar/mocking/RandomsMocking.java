package racingcar.mocking;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import org.mockito.Mockito;
import org.mockito.MockedStatic;
import org.mockito.ArgumentMatchers;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.configs.Config;


public class RandomsMocking {
    private static MockedStatic.Verification verificationPickNumberInRange =
            () -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt());

    public static void fixPickNumberInRangeUnderThreshold(Executable executable){

        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
                mock.when(verificationPickNumberInRange)
                        .thenReturn(Config.FORWARD_THRESHOLD -1);
                executable.execute();
            }
        });
    }
    public static void fixPickNumberInRangeOverThreshold(Executable executable){

        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
                mock.when(verificationPickNumberInRange)
                        .thenReturn(Config.FORWARD_THRESHOLD + 1);
                executable.execute();
            }
        });
    }
}
