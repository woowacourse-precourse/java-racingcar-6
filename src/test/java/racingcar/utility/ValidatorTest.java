package racingcar.utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 입력값이_공백인_경우_true_반환() {

        boolean stringNull = Validator.isBlank(null);
        boolean blank = Validator.isBlank(" ");
        boolean empty = Validator.isBlank("");

        assertThat(stringNull).isTrue();
        assertThat(blank).isTrue();
        assertThat(empty).isTrue();

    }

}