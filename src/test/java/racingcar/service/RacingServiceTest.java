package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.dto.request.CarNamesDto;
import racingcar.dto.response.WinnersDto;

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

    @ParameterizedTest
    @MethodSource("전진횟수와_우승자_설정")
    void 우승자_결정하기(List<String> carNames, List<Integer> forwardCounts, String winner) {
        // given
        List<Car> savedCars = 경주차_저장하기(carNames);
        for(int i = 0; i < savedCars.size(); i++) {
            특정_횟수만큼_전진하기(savedCars.get(i), forwardCounts.get(i));
        }

        // when
        WinnersDto winnersDto = racingService.findWinners();

        // then
        assertThat(winnersDto.getNames()).contains(winner);
    }

    static Stream<Arguments> 전진횟수와_우승자_설정() {
        return Stream.of(
            Arguments.arguments(List.of("jong", "meoru"), List.of(5, 4), "jong"),
            Arguments.arguments(List.of("gari"), List.of(1), "gari"),
            Arguments.arguments(List.of("gari", "meoru", "zzol"), List.of(1, 2, 3), "zzol")
        );
    }

    private List<Car> 경주차_저장하기(List<String> carNames) {
        List<Car> savedCars = new ArrayList<>();
        for(String name: carNames) {
            savedCars.add(carRepository.save(name));
        }
        return savedCars;
    }

    private void 특정_횟수만큼_전진하기(Car car, Integer count) {
        for(int i = 0; i < count; i++) {
            car.updateForwardCount();
        }
        carRepository.update(car);
    }
}