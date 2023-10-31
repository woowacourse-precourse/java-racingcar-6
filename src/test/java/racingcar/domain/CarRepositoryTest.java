package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.repository.CarRepository;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {

    private static final String TEMP_CLIENT_ROUND = "3";

    @Test
    @DisplayName("RacingCars 생성")
    void createRacingCars() {
        // given
        String inputtedCarNames = "pobi,woni,jun";
        CarsDto carsDto = new CarsDto(inputtedCarNames);
        Client client = new Client(TEMP_CLIENT_ROUND);

        // when
        CarRepository carRepository = new CarRepository(carsDto, client);

        // then
        assertThat(carRepository).isExactlyInstanceOf(CarRepository.class);
    }
}