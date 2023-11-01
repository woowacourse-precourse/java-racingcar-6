package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoveNumberTest {

    @Test
    void MoveNumber를_생성한다() {
        // given
        MoveNumber number = new MoveNumber(1);

        // then
        Assertions.assertThat(number).isEqualTo(new MoveNumber(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,false", "4,true"})
    void 움직일_수_있는지_알_수_있다(int moveNumber, boolean expected) {
        // given
        MoveNumber number = new MoveNumber(moveNumber);

        // when
        boolean actual = number.isMovable();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 입력이_잘못되면_예외가_발생한다(int moveNumber) {
        // when
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () ->
                new MoveNumber(moveNumber));
    }
}
