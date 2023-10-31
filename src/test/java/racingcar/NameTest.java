package racingcar;

import static racingcar.utils.ErrorMessages.CAR_NAME_BLANK;
import static racingcar.utils.ErrorMessages.CAR_NAME_CONTAIN_BLANK;
import static racingcar.utils.ErrorMessages.CAR_NAME_EMPTY;
import static racingcar.utils.ErrorMessages.OUT_OF_LENGTH_CAR_NAME;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Name;

@DisplayName("Name 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class NameTest {

    @Test
    void 생성자는_길이가_5보다_큰_이름이_주어지면_예외를_던진다() {
        String name = "나는이하늘이야";

        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_LENGTH_CAR_NAME);
    }

    @Test
    void 생성자는_값이_없는_이름이_주어지면_예외를_던진다() {
        String name = "";

        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_EMPTY);
    }

    @Test
    void 생성자는_공백으로_이루어진_이름이_주어지면_예외를_던진다() {
        String name = "   ";

        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {" 이하늘", "이 하늘"})
    void 생성자는_공백이_포함된_이름이_주어지면_예외를_던진다(String name) {
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_CONTAIN_BLANK);
    }
}
