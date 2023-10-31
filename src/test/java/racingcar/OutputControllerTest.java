package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.*;
import racingcar.controller.CarRacingController;
import racingcar.controller.RacingCarGenerateController;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.RacingCarView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class OutputControllerTest {
    CarRacingController racingController = new CarRacingController();
    private CarRepository carRepository = CarRepository.getInstance();

    RacingCarView view = new RacingCarView();

    private final ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 개별_경기_출력() {
        String result = "jisu : -----\r\n" +
                "micky : --------------------\r\n" +
                "mocky : -------------------";
        ArrayList<Car> input = new ArrayList<Car>();
        input.add(new Car("jisu", 5));
        input.add(new Car("micky", 20));
        input.add(new Car("mocky", 19));
        carRepository.setRacingCars(input);
        racingController.printRacingResult();

        assertThat(output.toString().trim()).isEqualTo(result);
    }

    @Test
    void 최종우승자_출력() {
        String[] input = {"micky"};
        String result = "최종 우승자 : micky";
        view.printWinner(input);

        assertThat(output.toString().trim()).isEqualTo(result);
    }
}
