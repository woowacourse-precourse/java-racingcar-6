package racingcar.racer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @Nested
    @DisplayName("이름을 기반으로 경주 자동차 생성 시")
    class nameOf {

        @DisplayName("성공적으로 생성한다.")
        @Test
        void success() {
            //given
            String name = "pobi";

            //when
            RacingCar racingCar = RacingCar.nameOf(name);

            //then
            assertThat(racingCar.getName()).isEqualTo(name);
        }

        @DisplayName("이름의 길이가 0이거나 5 초과라면 예외를 발생시킨다.")
        @ValueSource(strings = {"123456", ""})
        @ParameterizedTest
        void fail_InvalidNameLength(String name) {
            //given
            //when then
            assertThatThrownBy(() -> RacingCar.nameOf(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("알파벳이나 숫자 외 문자가 이름에 있는 경우 예외를 발생시킨다.")
        @ValueSource(strings = {"!dov", "sd d", "dfe\ns"})
        @ParameterizedTest
        void fail_InvalidNameFormat(String name) {
            //given
            //when then
            assertThatThrownBy(() -> RacingCar.nameOf(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}