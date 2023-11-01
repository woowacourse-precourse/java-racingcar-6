package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.InitDto;
import racingcar.repository.CarRepositoryImpl;
import racingcar.repository.Repository;
import racingcar.service.NumberGenerateService;
import racingcar.service.NumberGenerateServiceImpl;
import racingcar.service.RacingServiceImpl;

import java.util.List;

public class RacingServiceTest {
    private Car carA = new Car("A");
    private Car carB = new Car("B");
    private Car carC = new Car("C");
    InitDto initDto = new InitDto(List.of(carA, carB, carC), 3);
    Repository carRepository = new CarRepositoryImpl();
    NumberGenerateService numberGenerateService = new NumberGenerateServiceImpl();
    RacingServiceImpl racingService = new RacingServiceImpl(initDto, carRepository, numberGenerateService);

    @Test
    void AisWinTest() {
        // when
        carRepository.moveForward(carA, 5);
        carRepository.moveForward(carA, 5);
        carRepository.moveForward(carB, 5);
        List<String> winners = racingService.chooseWinner();

        // then
        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners).contains("A");
    }

    @Test
    void ABisWinTest() {
        // when
        carRepository.moveForward(carA, 5);
        carRepository.moveForward(carA, 5);
        carRepository.moveForward(carB, 5);
        carRepository.moveForward(carB, 5);
        carRepository.moveForward(carC, 5);
        List winners = racingService.chooseWinner();

        // then
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners).contains("A","B");
    }
}
