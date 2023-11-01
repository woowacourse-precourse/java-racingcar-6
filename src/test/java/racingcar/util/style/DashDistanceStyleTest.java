package racingcar.util.style;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DashDistanceStyleTest {

    @ParameterizedTest
    @CsvSource(value = {"0,''", "1,-", "5,-----"})
    void 하나의_거리를_대쉬로_출력(final int distance, final String expected) {
        final DashDistanceStyle dashDistanceStyle = new DashDistanceStyle();
        final String actual = dashDistanceStyle.getDistanceString(distance);
        assertThat(actual).isEqualTo(expected);
    }
}
