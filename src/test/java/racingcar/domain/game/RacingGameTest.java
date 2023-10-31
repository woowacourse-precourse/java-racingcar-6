package racingcar.domain.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.stubgenerator.SequentialNumberGeneratorStub;

class RacingGameTest {

    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    void init() {
        List<String> carNames = List.of("test", "test2","test3");
        cars = Cars.createCars(carNames, new SequentialNumberGeneratorStub(List.of(4,4,3)));
        racingGame = RacingGame.createRacingGame(cars,5);
    }


    @DisplayName("progressCount만큼 진행하면 게임의 현재 진행횟수와 같아야합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1,3,5})
    void 게임_진행횟수_테스트(int progressCount) {
        // when
        for (int i = 0; i < progressCount; i++) {
            racingGame.progress();
        }

        // then
        Assertions.assertThat(progressCount).isEqualTo(racingGame.getCurrentProgressCount());
    }

    @Test
    @DisplayName("차 진행 여부 테스트")
    void 차_진행여부_테스트(){
        // when
        racingGame.progress();
        List<Car> findCars = cars.getCars();
        List<Integer> positions = findCars.stream()
                .map(Car::getPosition)
                .toList();

        // then
        Assertions.assertThat(positions).isEqualTo(List.of(1,1,0));

    }



}