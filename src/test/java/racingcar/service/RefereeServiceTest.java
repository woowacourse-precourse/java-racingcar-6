package racingcar.service;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.position.Position;
import racingcar.domain.power.DefaultPowerGenerator;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

@DisplayName("심판 테스트")
class RefereeServiceTest {

    @DisplayName("단일 우승자를 올바르게 가려낸다")
    @Test
    void testSelectWinnersWithSingleWinner() {
        Car car1 = new Car(new CarName("car1"), new Position(3), new DefaultPowerGenerator());
        Car car2 = new Car(new CarName("car2"), new Position(5), new DefaultPowerGenerator());
        Car car3 = new Car(new CarName("car3"), new Position(2), new DefaultPowerGenerator());

        CarStatusDto dto1 = CarStatusDto.createFrom(car1);
        CarStatusDto dto2 = CarStatusDto.createFrom(car2);
        CarStatusDto dto3 = CarStatusDto.createFrom(car3);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        RoundResultDto round1 = RoundResultDto.createFrom(cars);

        List<RoundResultDto> roundHistories = Arrays.asList(round1);
        List<CarStatusDto> raceEndStatusSnapShot = Arrays.asList(dto1, dto2, dto3);

        RefereeService refereeService = new RefereeService();
        GameResultDto result = refereeService.publishGameResult(roundHistories, raceEndStatusSnapShot);

        Assertions.assertThat(result.getWinners().size()).isEqualTo(1);
    }

    @DisplayName("복수 우승자를 올바르게 가려낸다")
    @Test
    void testSelectWinnersWithMultipleWinner() {
        Car car1 = new Car(new CarName("car1"), new Position(3), new DefaultPowerGenerator());
        Car car2 = new Car(new CarName("car2"), new Position(3), new DefaultPowerGenerator());
        Car car3 = new Car(new CarName("car3"), new Position(2), new DefaultPowerGenerator());

        CarStatusDto dto1 = CarStatusDto.createFrom(car1);
        CarStatusDto dto2 = CarStatusDto.createFrom(car2);
        CarStatusDto dto3 = CarStatusDto.createFrom(car3);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        RoundResultDto round1 = RoundResultDto.createFrom(cars);

        List<RoundResultDto> roundHistories = Arrays.asList(round1);
        List<CarStatusDto> raceEndStatusSnapshot = Arrays.asList(dto1, dto2, dto3);

        RefereeService refereeService = new RefereeService();
        GameResultDto result = refereeService.publishGameResult(roundHistories, raceEndStatusSnapshot);

        Assertions.assertThat(result.getWinners().size()).isEqualTo(2);
    }
}