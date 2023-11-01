package racingcar.utils;


import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ValidationTest {
    Validation validation = new Validation();

    private void carNameListExceptionTest(List<String> List) {
        List<String> racers = List;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validation.carNameValidator(racers));
    }

    @Test
    void 예외_입력값_null() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validation.nullStringInput(null));
    }

   // carName validation
    @Test
    void 예외_carName_글자수_6자_이상() {
        carNameListExceptionTest(Arrays.asList("pobi", "javaji"));
    }

    @Test
    void 예외_carName_자동차_1대만_입력() {
        carNameListExceptionTest(Arrays.asList("pobi"));
    }

    @Test
    void 예외_자동차이름이_null1() {
        carNameListExceptionTest(Arrays.asList("pobi", ""));
    }
    @Test
    void 예외_자동차이름이_null2() {
        carNameListExceptionTest(Arrays.asList("pobi", ""));
    }

    @Test
    void 예외_중복된_이름() {
        carNameListExceptionTest(Arrays.asList("pobi", "pobi"));
    }

    @Test
    void 예외_입력값_없음() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validation.nullStringInput(""));
    }


    // 시도 횟수(attemptCount) validation
    @Test
    void 예외_attemptCount_입력값_숫자아닐때1() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validation.isNumberValidation("안녕"));
    }

    @Test
    void 예외_attemptCount_숫자아닐때2() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> validation.isNumberValidation("??"));
    }

}