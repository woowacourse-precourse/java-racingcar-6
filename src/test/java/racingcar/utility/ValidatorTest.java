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

    @Test
    void 전달받은_이름이_5글자_이상인_경우_false_반환() {
        boolean nineLength = Validator.isInNameRange("123456789");
        boolean sixLength = Validator.isInNameRange("123456");

        assertThat(nineLength).isFalse();
        assertThat(sixLength).isFalse();
    }

    @Test
    void 전달받은_이름이_5글자_이하인_경우_true_반환() {
        boolean fiveLength = Validator.isInNameRange("12345");
        boolean oneLength = Validator.isInNameRange("1");
        boolean zeroLength = Validator.isInNameRange("");

        assertThat(fiveLength).isTrue();
        assertThat(oneLength).isTrue();
        assertThat(zeroLength).isTrue();
    }


}