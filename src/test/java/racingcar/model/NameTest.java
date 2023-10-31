package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static racingcar.model.CarName.*;
import static racingcar.model.Cars.*;

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
    @Test
    void 입력_중복_테스트() {
        ArrayList<String> carNames = new ArrayList<>();
        String input = "as,ds,ds";
        String[] names = input.split(",");
        carNames.addAll(Arrays.asList(names));
        assertThatThrownBy(() -> validateDuplicated(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_NAME_DUQLICATED_EXCEPTION);
    }


}





