package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputControllerTest {

    @Test
    void setCar_자동차를_생성하며_이름을_부여() {
        InputController inputController = new InputController();
        String input = "pobi,woni,jun";

        List<String> carList = inputController.setCar(input);

        assertThat(carList).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }
}