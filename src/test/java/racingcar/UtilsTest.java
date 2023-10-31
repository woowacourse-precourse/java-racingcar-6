package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UtilsTest {
    @Test
    void 레인_그리기() {
        String result = Utils.makeLane(2);
        assertThat(result).isEqualTo("--");
    }
}
