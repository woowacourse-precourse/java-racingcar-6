package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.dto.request.CarNamesDto;

class RacingServiceTest {

    private final CarRepository carRepository = new CarRepository();
    private final RacingService racingService = new RacingService(carRepository);

    @AfterEach
    public void clearRepository() {
        carRepository.deleteAll();
    }

    @Test
    void 경주차_생성하기() {
        // given
        CarNamesDto carNamesDto = new CarNamesDto("jong,gari,meoru");

        // when
        racingService.createCars(carNamesDto);

        // then
        List<Car> carList = carRepository.findAll();
        assertThat(carList).hasSize(3)
            .extracting(Car::getName)
            .containsAll(carNamesDto.getNames());
    }

    @Test
    void 경주하기() {
        // given
        carRepository.save("meoru");
        carRepository.save("gari");

        // when
        racingService.action();

        // then
        List<Car> carList = carRepository.findAll();
        assertThat(carList).hasSize(2)
            .extracting(Car::getForwardCount)
            .allMatch(count -> count >= 0);
    }
}