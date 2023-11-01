package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 자동차_이름_길이_예외_처리() {
        String inputName = "pobiab";
        assertThatThrownBy(() -> {
            Validator.InputRaceCount(inputName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}