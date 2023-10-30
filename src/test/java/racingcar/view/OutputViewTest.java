package racingcar.view;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private static final ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();

    @BeforeAll
    static void setUpPrint() {
        System.setOut(new PrintStream(outputBuffer));
    }

    @AfterAll
    static void rollBackPrint() {
        System.setOut(System.out);
    }

    @BeforeEach
    void resetPrint() {
        outputBuffer.reset();
    }

    @Test
    void printOneRoundResult() {
        CarRepository carRepository = new CarRepository(List.of("test1", "test2", "test3"));
        List<Car> cars = carRepository.getCars();

        cars.get(0).moveForward();
        cars.get(2).moveForward();

        outputView.printOneRoundResult(carRepository);
        String result = outputBuffer.toString();

        String expected = "test1 : - \ntest2 :  \ntest3 : - \n\n";
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void getResult() {
        CarRepository carRepository = new CarRepository(List.of("test1", "test2", "test3"));
        List<Car> cars = carRepository.getCars();

        cars.get(0).moveForward();
        cars.get(0).moveForward();

        outputView.printGameResult(carRepository.getMaxCars());
        String result = outputBuffer.toString();

        String expected = "최종 우승자 : test1\n";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getResult2() {
        CarRepository carRepository = new CarRepository(List.of("test1", "test2", "test3"));

        outputView.printGameResult(carRepository.getMaxCars());
        String result = outputBuffer.toString();

        String expected = "최종 우승자 : test1, test2, test3\n";
        assertThat(result).isEqualTo(expected);
    }
}