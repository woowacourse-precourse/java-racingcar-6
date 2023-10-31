package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.Cars.INPUT_NAME_DUQLICATED_EXCEPTION;
import static racingcar.model.Cars.validateDuplicated;

public class CarsTest {
    @Test
    void 입력_중복_테스트() {
        String input = "as,ds,ds";
        String[] names = input.split(",");
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(names));
        assertThatThrownBy(() -> validateDuplicated(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NAME_DUQLICATED_EXCEPTION);
    }
}
