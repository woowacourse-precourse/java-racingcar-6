package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("[도메인] Lap 테스트 ")
class LapTest {

    @Nested
    @DisplayName("생성할 떄")
    class CreateTest {

        @ParameterizedTest
        @ValueSource(ints = {-1, -2})
        public void _0보다_작게_만들_수_없습니다(int count) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Lap(count));
        }

    }


    @Nested
    @DisplayName("동작할 떄")
    class ActionTest {

        @Test
        void _한칸_전진이_가능합니다() {
            final var lap = new Lap(0).nextLap();
            Assertions.assertThat(lap).isEqualTo(new Lap(1));
        }

    }


}