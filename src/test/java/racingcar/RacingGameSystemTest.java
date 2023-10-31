package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.TestConstantsProvider.provideValidSystemTestConstants;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
public class RacingGameSystemTest extends NsTest {

    @ParameterizedTest(name = "자동차 {0}대가 참가하고 {1}번 이동하여 우승은 {2}이다.")
    @DisplayName("성공 테스트")
    @MethodSource("provideValidSystemTestParameter")
    void successTest(final String carName,
                     final String playNumber,
                     final List<String> expectedOutputString,
                     final int firstRandomNumber,
                     final Integer... subsequentRandomNumbers) {

        assertRandomNumberInRangeTest(
                () -> {
                    run(carName, playNumber);
                    assertThat(output()).contains(expectedOutputString);
                }, firstRandomNumber, subsequentRandomNumbers
        );
    }

    private Stream<Arguments> provideValidSystemTestParameter() {
        return provideValidSystemTestConstants();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
