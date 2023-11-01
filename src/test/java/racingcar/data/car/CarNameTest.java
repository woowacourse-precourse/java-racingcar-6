package racingcar.data.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    @DisplayName("자동차 이름 1보다 짧은 경우 테스트")
    @Test
    void validateCarName_shorterThan1_IAE() {
        // given
        String name = "";
        int limit = 5;

        // when, then
        assertThatThrownBy(() -> CarName.validateCarName(name, limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CarName cannot be empty.");
    }

    @DisplayName("자동차 이름 0보다 긴 경우 테스트")
    @Test
    void validateCarName_longerThan0_OK() {
        // given
        String name = "jun";
        int limit = 5;

        // when, then
        assertThatCode(() -> CarName.validateCarName(name, limit))
                .doesNotThrowAnyException();
    }
    @DisplayName("자동차 이름 3자 제한 초과 테스트")
    @Test
    void validateCarName_LongerThan5_IAE() {
        // given
        String name = "aaaaaa";
        int limit = 5;

        // when, then
        assertThatThrownBy(() -> CarName.validateCarName(name, limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CarName should be no longer than 5.");
    }

    @DisplayName("자동차 이름 5자 제한 초과 테스트")
    @Test
    void validateCarName_LongerThan3_IAE() {
        // given
        String name = "aaaaaa";
        int limit = 3;

        // when, then
        assertThatThrownBy(() -> CarName.validateCarName(name, limit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CarName should be no longer than 3.");
    }

    @DisplayName("자동차 이름 5자 제한 이하 테스트")
    @Test
    void validateCarName_NotLongerThan5_OK() {
        // given
        String name = "a";
        int limit = 5;

        // when, then
        assertThatCode(() -> CarName.validateCarName(name, limit))
                .doesNotThrowAnyException();
    }
}
