package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ValidatorTest {

    @Test
    void 자동차_이름_정상입력() {
        Validator validator = new Validator();
        List<String> cars = Arrays.asList("아우디", "벤츠2", "Audi");

        assertThatCode(() -> validator.validatorForCar(cars))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수_정상입력() {
        Validator validator = new Validator();
        int count = 5;

        assertThatCode(() -> validator.validatorForAttemptCount(count))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차_이름_5문자이상_예외_처리() {
        Validator validator = new Validator();
        List<String> cars = Arrays.asList("롤스로이스팬텀", "현대2", "벤츠");

        assertThatThrownBy(() -> validator.validatorForCar(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_공백_예외_처리() {
        Validator validator = new Validator();
        List<String> cars = Arrays.asList("현대", "", "기아");

        assertThatThrownBy(() -> validator.validatorForCar(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_중복입력_예외_처리() {
        Validator validator = new Validator();
        List<String> cars = Arrays.asList("현대", "현대", "기아");

        assertThatThrownBy(() -> validator.validatorForCar(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_1보다_작은수_예외_처리() {
        Validator validator = new Validator();
        int count = -3;

        assertThatThrownBy(() -> validator.validatorForAttemptCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

}