package racingcar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {
    @Test
    public void 자동차_이름들을_입력받는_기능() {
        String input = "red,green,blue";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.setRacingCarsByConsole();
        List<RacingCar> cars = racingCarGame.getCars();

        Assertions.assertThat(cars.size()).isEqualTo(3);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("red");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("green");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("blue");
    }
}