package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumbers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static racingcar.testutil.TestConstant.*;

class RacingcarGameServiceTest {

    private RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();

    @DisplayName("경주에 참가할 자동차들을 생성한다.")
    @Test
    void generateCarsToRace() {
        // given
        RacingcarGameService racingcarGameService = new RacingcarGameServiceImpl();
        String inputMessage = CAR_NAME1 + "," + CAR_NAME2 + "," + CAR_NAME3;

        // when
        Cars cars = racingcarGameService.generateCarsToRace(inputMessage);

        // then
        assertThat(cars.getCars()).hasSize(3)
                .extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple(CAR_NAME1, 0),
                        tuple(CAR_NAME2, 0),
                        tuple(CAR_NAME3, 0)
                );
    }

    @DisplayName("각 라운드마다 임의의 숫자 값을 토대로 자동차를 전진하거나 전진하지 않는다.")
    @Test
    void playOneRound() {
        // given
        Car car1 = Car.of(CAR_NAME1);
        Car car2 = Car.of(CAR_NAME2);
        Car car3 = Car.of(CAR_NAME3);
        Car car4 = Car.of(CAR_NAME4);

        Cars cars = new Cars();
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);

        RandomNumbers randomNumbers
                = new RandomNumbers(List.of(RANDOM_NUMBER1, RANDOM_NUMBER2, RANDOM_NUMBER3, RANDOM_NUMBER4));

        // when
        racingcarGameService.playOneRound(cars, randomNumbers);

        // then
        assertThat(cars.getCars()).hasSize(4)
                .extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple(CAR_NAME1, 0),
                        tuple(CAR_NAME2, 0),
                        tuple(CAR_NAME3, 1),
                        tuple(CAR_NAME4, 1)
                );
    }

}