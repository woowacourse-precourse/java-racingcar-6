package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidationTest {
    @Test
    void 숫자가0이하이면에러발생(){
        Validation validation = new Validation();
        assertThatThrownBy(()->validation.validTryCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}