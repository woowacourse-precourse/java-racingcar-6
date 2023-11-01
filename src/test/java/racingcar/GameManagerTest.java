package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
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

    @Test
    void play() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        List<Car> cars = Arrays.stream(new Car[]{new Car("car1"), new Car("car2")}).toList();
        int attempt = 1;

        GameManager.play(cars, attempt);

        String car1PositionBar = cars.get(0).getPositionBar();
        String car2PositionBar = cars.get(1).getPositionBar();

        String result = "실행 결과" + System.getProperty("line.separator") +
                "car1 : " + car1PositionBar + System.getProperty("line.separator") +
                "car2 : " + car2PositionBar + System.getProperty("line.separator") +
                System.getProperty("line.separator");

        Assertions.assertThat(os.toString()).isEqualTo(result);
    }

    @Test
    void end() {
        List<Car> cars = Arrays.stream(new Car[]{new Car("car")}).toList();
        int attempt = 1;

        GameManager.play(cars, attempt);

        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));

        GameManager.end(cars);

        String result = "최종 우승자 : car" + System.getProperty("line.separator");
        Assertions.assertThat(os.toString()).isEqualTo(result);
    }
}
