package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingcarControllerTest {
    private RacingcarGame racingcarController;

    @BeforeEach
    void beforeEach() {
        racingcarController = new RacingcarGame();
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
        List<Car> carsList = racingcarController.cars.carsList;
        assertThat(carsList.size()).isEqualTo(carsName.length);
    }

    @Test
    void 랜덤값에_따라_자동차_number_1_증가() {
        Car car = new Car("test", 0);

        racingcarController.cars.addCarList(car);
        racingcarController.printResult();

        assertThat(car.getNumber()).isBetween(0, 1);
    }

    @Test
    void 우승자_한명() {
        Car winner = new Car("winnerTest", 3);
        racingcarController.cars.addCarList(winner);

        Car car = new Car("car", 1);
        racingcarController.cars.addCarList(car);

        List<String> winnerList = racingcarController.getWinner();
        assertThat(winnerList).containsExactly("winnerTest");
    }

    @Test
    void 우승자_여러명() {
        Car winner1 = new Car("winnerTest1", 3);
        racingcarController.cars.addCarList(winner1);

        Car winner2 = new Car("winnerTest2", 3);
        racingcarController.cars.addCarList(winner2);

        Car car = new Car("car", 1);
        racingcarController.cars.addCarList(car);

        List<String> winnerList = racingcarController.getWinner();
        assertThat(winnerList).contains("winnerTest1", "winnerTest2");
    }
}