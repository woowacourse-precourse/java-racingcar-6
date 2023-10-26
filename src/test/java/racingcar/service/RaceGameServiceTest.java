package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.CarsDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceGameServiceTest {

    private final RaceGameService raceGameService = new RaceGameService();

    @DisplayName("한 라운드 실행 테스트")
    @Test
    void roundStartTest() {
        // given
        String[] names = {"철수", "짱구", "맹구"};
        Car[] cars = new Car[names.length];
        for (int i=0; i< names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        CarsDto carsDto = new CarsDto(cars);

        // when
        raceGameService.roundStart(carsDto);
        Car[] cars1 = carsDto.cars();

        // then
        for (int i=0; i<cars1.length; i++) {
            Car car = cars1[i];
            assertThat(car.ownerOfCar()).isEqualTo(names[i]);
            assertThat(car.getLocation()).isGreaterThanOrEqualTo(0);
        }
    }
}
