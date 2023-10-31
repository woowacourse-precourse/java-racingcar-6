package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import static org.assertj.core.api.Assertions.assertThat;
class IOConsoleTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }
    @Test
    void 자동차_이름_리스트로_만들기() {
        ByteArrayInputStream in = new ByteArrayInputStream("Car1,Car2,Car3".getBytes());
        System.setIn(in);

        List<String> carNames = IOConsole.readCarNames();
        assertEquals(List.of("Car1", "Car2", "Car3"), carNames);
    }

    @Test
    void 시도_횟수_입력_테스트() {
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        System.setIn(in);

        int trial = IOConsole.readTrial();

        assertEquals(5, trial);
    }

    @Test
    void 점수_입력_테스트() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<Car> cars = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        cars.get(0).increaseScore();
        cars.get(0).increaseScore();
        cars.get(2).increaseScore();

        IOConsole.printScores(cars);

        String expectedOutput = "Car1 : --\nCar2 : \nCar3 : -\n";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void 우승자_출력_테스트() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> winners = List.of("Car1", "Car2", "Car3");

        IOConsole.printWinner(winners);

        String expectedOutput = "Car1,Car2,Car3";
        assertThat(out.toString()).contains("Car1,Car2,Car3");
    }
}
