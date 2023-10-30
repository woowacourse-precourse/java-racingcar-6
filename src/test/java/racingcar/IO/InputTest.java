package racingcar.IO;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

class InputTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 자동차_이름_입력받기() {
        // given
        System.setIn(createInput("test1, test2, test3"));

        // when
        List<Car> cars = Input.getCars();

        // then
        Assertions.assertEquals(3, cars.size());
        Assertions.assertEquals("test3", cars.get(2).getName());
    }

    @Test
    void 이동_횟수_입력받기() {
        // given
        System.setIn(createInput("3"));

        // when
        int attempts = Input.getAttempts();

        // then
        Assertions.assertEquals(3, attempts);
    }
}