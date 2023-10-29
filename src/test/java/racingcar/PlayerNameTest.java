package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {

    @Test
    void 플레이어_이름이_다섯자를_초과하면_예외를_발생한다() {
        assertThatThrownBy(() -> PlayerName.from("iamSix")).
                isInstanceOf(IllegalArgumentException.class);
    }

    //    @ParameterizedTest
    @EmptySource
    void 플레이어_이름이_비어있으면_예외를_발생한다(String empty) {
        assertThatThrownBy(() -> PlayerName.from(empty)).
                isInstanceOf(IllegalArgumentException.class);
    }

    //    @Test
    void 플레이어_이름이_다섯자를_이하면_예외를_발생시키지_않는다() {
        assertDoesNotThrow(() -> PlayerName.from("fives"));
    }

    //    @Test
    void 콤마로_구분된_플레이어_이름이_들어오면_리스트로_반환한다() {
//        assertThat(PlayerName.convertNames("rose,lisa")).containsExactly("rose", "lisa");
    }

    //    @ParameterizedTest
    @ValueSource(strings = {"roseLisa", "rose,,lisa", ",rose,lisa", "rose,lisa,", "rose,"})
    void 플레이어_이름이_콤마로_구분되지_않으면_예외를_발생한다(String names) {
        assertThatThrownBy(() -> PlayerName.from(names)).
                isInstanceOf(IllegalArgumentException.class);
    }

    //    @ParameterizedTest
    @ValueSource(strings = {"rose,lisa", "rose,lisa,jisu,jenny"})
    void 플레이어_이름이_콤마로_구분되어_들어오면_예외를_발생시키지_않는다(String names) {
        assertDoesNotThrow(() -> PlayerName.from(names));
    }
}
