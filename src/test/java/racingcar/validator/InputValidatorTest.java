package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    void 올바른_참가자_목록() {
        List<String> carList = Arrays.asList("자동차1", "자동차2", "자동차3", "자동차4", "자동차5");
        assertThatCode(() -> InputValidator.validateCarList(carList)).doesNotThrowAnyException();
    }

    @Test
    void 참가자의_이름은_5글자_이내() {
        List<String> carList = Arrays.asList("자동차1", "자동차2", "자동차자동차3", "자동차4", "자동차5");
        Throwable thrown = catchThrowable(() -> InputValidator.validateCarList(carList));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참가자_수는_2명_이상() {
        List<String> carList = Arrays.asList("자동차1");
        Throwable thrown = catchThrowable(() -> InputValidator.validateCarList(carList));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}