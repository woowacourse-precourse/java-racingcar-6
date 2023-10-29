package racingcar.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameLengthException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Nested
    class CarNameLengthTest {
        @Test
        void 자동차_이름_5글자_이상일_경우_예외() {
            // given
            String input = "jeongin";

            // when & then
            assertThatThrownBy(() -> new Name(input))
                    .isInstanceOf(CarNameLengthException.class)
                    .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
        }

        @Test
        void 자동차_이름_빈문자일_경우_예외() {
            // given
            String input = "";

            // when & then
            assertThatThrownBy(() -> new Name(input))
                    .isInstanceOf(CarNameLengthException.class)
                    .hasMessageContaining("빈 자동차 이름은 입력할 수 없습니다.");
        }
    }
}