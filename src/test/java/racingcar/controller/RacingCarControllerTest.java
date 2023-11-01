package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.RacingCarService;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarControllerTest {
    RacingCarController controller = new RacingCarController();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void setGamePlayer() {
        // given
        systemIn("abcdef");
        //then
        assertThatThrownBy(() -> controller.setGamePlayer())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setGameCount() {
        systemIn("0");
        assertThatThrownBy(() -> controller.setGameCount())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();

        systemIn("-1");
        assertThatThrownBy(() -> controller.setGameCount())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();

        systemIn("1a");
        assertThatThrownBy(() -> controller.setGameCount())
                .isInstanceOf(IllegalArgumentException.class);

        Console.close();

        systemIn("a1");
        assertThatThrownBy(() -> controller.setGameCount())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();

        systemIn("1");
        int num = controller.setGameCount();
        assertThat(num).isSameAs(1);
    }

    @Test
    void executeResult() {
        //given
        RacingCarService service = new RacingCarService();
        Cars cars = new Cars();
        cars.setCarsData(List.of("1", "2"));

        Cars excuteCars = controller.executeResult();
        boolean value = excuteCars.getCarsData().values()
                .stream().anyMatch(a -> a >= 0 && a <= 2);

        assertThat(value).isTrue();
    }

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}