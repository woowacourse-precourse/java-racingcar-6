package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceControllerTest {

    private RaceController raceController;

    @BeforeEach
    void setUp() {
        raceController = new RaceController();
    }
    @Test
    void 자동차가_전진했을_경우_기록() {
        Car car_dog = new Car("dog", 0);
        int randomNumber = 7;
        int expectedRecord = 1;

        raceController.addRecord(car_dog, randomNumber);

        assertThat(car_dog.getRecord()).isEqualTo(expectedRecord);
    }

    @Test
    void 자동차가_전진하지_못했을_경우_기록() {
        Car car_dog = new Car("dog", 0);
        int randomNumber = 2;
        int expectedRecord = 0;

        raceController.addRecord(car_dog, randomNumber);
        assertThat(car_dog.getRecord()).isEqualTo(expectedRecord);
    }

    @Test
    void 자동차의_이름과_기록_출력() {
        List<Car> racingCars = Arrays.asList(new Car("dog", 2),
                new Car("cat", 1), new Car("bear", 0));
        String result = raceController.getNameAndRecord(racingCars);
        String expectedResult = "dog : --\ncat : -\nbear : \n";
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 우승자가_1명일_경우_우승자_이름_출력() {
        List<Car> racingCars = Arrays.asList(new Car("dog", 2),
                new Car("cat", 1), new Car("bear", 0));
        String expectedResult = "dog";
        assertThat(raceController.getWinnerName(racingCars)).isEqualTo(expectedResult);
    }

    @Test
    void 우승자가_다수일_경우_우승자_이름_출력() {
        List<Car> racingCars = Arrays.asList(new Car("dog", 2),
                new Car("cat", 2), new Car("bear", 1));
        String expectedResult = "dog, cat";
        assertThat(raceController.getWinnerName(racingCars)).isEqualTo(expectedResult);
    }
}