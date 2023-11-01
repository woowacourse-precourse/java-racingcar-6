package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void inputCarsTest() {
        String input = "car1,car2,car3";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        List<String> carNameList = user.inputCars();
        Assertions.assertThat(carNameList.size()).isEqualTo(3);
    }

    @Test
    void inputAttemptTest() {
        String input = "5";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        int attempt = user.inputAttempt();
        Assertions.assertThat(attempt).isEqualTo(5);
    }

    @Test
    void wrongInputAttemptTest() {
        String input = "input";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        Assertions.assertThatThrownBy(() -> user.inputAttempt())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
