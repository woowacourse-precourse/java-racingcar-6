package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidationTest {
    Validation validation;
    @BeforeEach
    void 클래스생성(){
        validation = new Validation();
    }
    @Test
    void 숫자가0이하이면에러발생(){
        Integer number = 0;

        assertThatThrownBy(()->validation.validTryCount(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름이6자이상이면에러발생(){
        Validation validation = new Validation();
        List<String> carNames = new ArrayList<>();
        carNames.add("1234");
        carNames.add("12345");
        carNames.add("123456");

        assertThatThrownBy(()->validation.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}