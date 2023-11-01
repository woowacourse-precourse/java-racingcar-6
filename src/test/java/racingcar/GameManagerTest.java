package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class GameManagerTest {

    @Test
    void enterCars() {
        String input = "car1,car2,car3";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        List<String> carNames = GameManager.enterCars();

        Assertions.assertThat(carNames.size()).isEqualTo(3);
        Console.close();
    }

    @Test
    void generateCars() {
        List<String> carNames = Arrays.stream(new String[]{"car1", "car2", "car3"}).toList();

        List<Car> cars = GameManager.generateCars(carNames);

        Assertions.assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void enterAttempt() {
        String input = "5";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        int attempt = GameManager.enterAttempt();

        Assertions.assertThat(attempt).isEqualTo(5);
        Console.close();
    }
}
