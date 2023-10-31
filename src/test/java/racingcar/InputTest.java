package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.*;
import racingcar.controller.RacingCarGenerateController;
import racingcar.model.Car;
import racingcar.model.CarRepository;

import java.util.ArrayList;

public class InputTest {
    RacingCarGenerateController generateController = new RacingCarGenerateController();
    private CarRepository carRepository = CarRepository.getInstance();

    @Test
    void 이름이_null() {

    }

    @Test
    void 초기_Car_리스트_세팅() {
        String[] names = "jisu,lee".split(",");
        ArrayList<Car> result = new ArrayList<Car>();
        result.add(new Car(names[0]));
        result.add(new Car(names[1]));

        generateController.setCarList(names);
        assertThat(result).usingRecursiveComparison().isEqualTo(carRepository.findCarList());

    }

    @Test
    void 초기_레이싱Count_세팅() {
        String input = "10";
        int result = Integer.parseInt(input);

        assertThat(result).isEqualTo(generateController.setRacingCount(input));
    }

    @Test
    void 예외처리_공백() {
        String input = "\n";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    generateController.checkNull(input);
                }
        );
    }

    @Test
    void 예외처리_이름길이() {
        String[] input = "jisu,lee,jisususu".split(",");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    generateController.checkLength(input);
                }
        );
    }

    @Test
    void 예외처리_모두숫자() {
        String input = "18c";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    generateController.checkDigit(input);
                }
        );
    }
}
