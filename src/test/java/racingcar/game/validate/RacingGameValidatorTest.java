package racingcar.game.validate;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameValidatorTest {


    @DisplayName("빈 자동차 이름 목록을 작성하면 예외가 발생한다.")
    @Test
    void getEmptyCarNames() {
        List<String> emptyCarNames = Collections.emptyList();

        Assertions.assertThatThrownBy(() -> EmptyCarNamesValidator.validate(emptyCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
