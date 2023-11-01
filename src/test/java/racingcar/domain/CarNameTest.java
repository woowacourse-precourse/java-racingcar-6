package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.numbergenerator.RandomNumberGenerator;

class CarNameTest {
    @Test
    void 이름_입력_5글자_테스트() {
        String inputNames = "david";

        assertThatThrownBy(() -> {
            new CarName(inputNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_입력_공백_테스트() {
        String inputNames = "";

        assertThatThrownBy(() -> {
            new CarName(inputNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_입력_성공_테스트() {
        String inputNames = "pobi";

        CarName carName = new CarName(inputNames);

        assertThat(carName.value()).isEqualTo("pobi");
    }
}
