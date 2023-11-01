package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingcarControllerTest {
    private RacingcarController racingcarController;
    @BeforeEach
    void beforeEach() {
        racingcarController = new RacingcarController();
    }

    @Test
    void 자동차이름_입력값_구분() {
        String inputCarsName = "abc,def,gh";
        String[] result = racingcarController.splitCarsName(inputCarsName);
        assertThat(result).contains("abc", "def", "gh");
    }

    @Test
    void 자동차_리스트_저장() {
        String[] carsName = {"kim", "yeon", "su"};
        racingcarController.addCars(carsName);
        List<Car> carsList = racingcarController.cars.cars;
        assertThat(carsList.size()).isEqualTo(carsName.length);
    }

    @Test
    void 랜덤값에_따라_자동차_number_1_증가() {
        Car car = new Car("test", 0);

        racingcarController.cars.addCarList(car);
        racingcarController.getRandom();

        assertThat(car.getNumber()).isBetween(0, 1);
    }
}