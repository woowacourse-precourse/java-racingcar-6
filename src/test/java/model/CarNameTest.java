package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import racingcar.exception.car_name.NotValidNameLengthException;
import racingcar.model.CarName;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CarNameTest {

    @Test
    void 자동차의_이름의_길이가_게임_조건보다_길면_예외가_발생한다() {
        // given
        String inValidName = "morning";

        // when & then
        assertThatThrownBy(() -> new CarName(inValidName))
                .isInstanceOf(NotValidNameLengthException.class);
    }
}
