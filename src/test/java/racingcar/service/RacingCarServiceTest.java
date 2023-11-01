package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.repository.DomainRepository;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;

@DisplayName("자동차 경주 서비스의 객체에")
class RacingCarServiceTest {

    private final DomainRepository<RacingCars> racingCarsRepository = new DomainRepository<>();
    private final DomainRepository<TryCount> tryCountRepository = new DomainRepository<>();
    private final RacingCarService racingCarService =
            new RacingCarService(
                    racingCarsRepository, tryCountRepository, new RandomNumberGenerator());

    @Test
    @DisplayName("자동차 저장 요청시 저장소에 저장되는가")
    void saveRacingCars() {
        // given
        final RacingCars racingCars =
                new RacingCars(List.of(new RacingCar("a"), new RacingCar("b")));

        // when
        racingCarService.saveRacingCars(racingCars);

        // then
        final RacingCars savedRacingCars = racingCarsRepository.get();
        assertThat(savedRacingCars).isNotNull();
    }

    @Test
    @DisplayName("시도 횟수 저장 요청시 저장소에 저장되는가")
    void saveTryCount() {
        // given
        final TryCount tryCount = new TryCount(3);

        // when
        racingCarService.saveTryCount(tryCount);

        // then
        final TryCount savedTryCount = tryCountRepository.get();
        assertThat(savedTryCount).isNotNull();
    }

    @Test
    @DisplayName("이동 요청시 이동 이후 null이 아닌 자동차 목록을 반환하는가")
    void move() {
        // given
        final RacingCars racingCars =
                new RacingCars(List.of(new RacingCar("a"), new RacingCar("b")));
        racingCarService.saveRacingCars(racingCars);

        // when
        final RacingCars movedRacingCars = racingCarService.move();

        // then
        assertThat(movedRacingCars).isNotNull();
    }

    @Test
    @DisplayName("시도 횟수 조회 요청시 null이 아닌 값이 조회되는가")
    void findTryCount() {
        // given
        racingCarService.saveTryCount(new TryCount(3));

        // when
        final TryCount tryCount = racingCarService.findTryCount();

        // then
        assertThat(tryCount).isNotNull();
    }

    @Test
    @DisplayName("우승자 확인 요청시 우승자 목록을 반환하는가")
    void checkWinners() {
        // given
        final RacingCars racingCars =
                new RacingCars(List.of(new RacingCar("a"), new RacingCar("b")));
        racingCarService.saveRacingCars(racingCars);

        // when
        final Winners winners = racingCarService.checkWinners();

        // then
        assertThat(winners).isNotNull();
    }
}
