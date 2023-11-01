package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class RacingGameControllerTest {
    private final RacingGameController racingGameController = new RacingGameController();
    @Test
    void getCarString() throws IOException {
        String input = "pobi,wani";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] carString = racingGameController.getCarString();
        in.reset();
        in.close();
        assertThat(String.join(",", carString)).isEqualTo(input);

    }

    @Test
    void checkTryNumber() {
        assertThatThrownBy(()->racingGameController.checkTryNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}