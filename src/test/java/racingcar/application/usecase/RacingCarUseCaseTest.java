package racingcar.application.usecase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.domain.car.Car;
import racingcar.domain.race.RaceChecker;
import racingcar.domain.race.RaceResult;
import racingcar.port.output.RacingCarOutputPort;
import racingcar.application.service.CarService;
import racingcar.application.service.RacingCarGameService;
import racingcar.view.RacingCarView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarUseCaseTest {
    @Test
    @DisplayName("play를 실행하면 자동차 경주 결과를 반환한다.")
    void play() {
        // given
        RacingCarOutputPort racingCarOutputPort = new RacingCarOutputPort() {
            public List<String> getCarNames() {
                return List.of("pobi", "crong", "honux");
            }

            public int getTryCount() {
                return 5;
            }
        };

        CarService carService = Mockito.mock(CarService.class);
        Car car1 = new Car("pobi", () -> true);
        Car car2 = new Car("crong", () -> true);
        Car car3 = new Car("honux", () -> false);

        Mockito.when(carService.createCars(List.of("pobi", "crong", "honux")))
                .thenReturn(List.of(car1, car2, car3));


        RacingCarUseCase racingCarUseCase = new RacingCarUseCase(
                carService,
                new RacingCarGameService(new RaceChecker()),
                new RacingCarView(),
                racingCarOutputPort
        );

        // when
        RaceResult result = racingCarUseCase.play();

        // then
        assertThat(result.winners()).contains(car1, car2);
    }
}