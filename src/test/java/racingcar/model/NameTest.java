package racingcar.model;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static racingcar.model.CarName.*;


public class NameTest {

    @Test
    void 길이_테스트() {
        assertThatThrownBy(() -> new CarName("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NAME_LENGTH_EXCEPTION);
    }

    @Test
    void 입력_공백_테스트() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NAME_EMPTY_EXCEPTION);
    }


}





