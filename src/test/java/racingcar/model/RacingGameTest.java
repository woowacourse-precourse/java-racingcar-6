package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 자동차_그룹과_시도횟수를_통해_레이싱_게임을_생성할_수_있다() {
        CarGroup carGroup = CarGroup.from(List.of("jack", "jess", "adam"));
        TryCount tryCount = TryCount.from(5);

        RacingGame racingGame = RacingGame.of(carGroup, tryCount);

        assertNotNull(racingGame);
    }

    @Test
    void 레이싱_게임을_시작하면_레이스_히스토리가_반환된다() {
        CarGroup carGroup = CarGroup.from(List.of("jack", "john"));
        TryCount tryCount = TryCount.from(1);
        RacingGame racingGame = RacingGame.of(carGroup, tryCount);
        MovementCondition alwaysMoveCondition = () -> true;

        RaceHistory actualRaceHistory = racingGame.playWith(alwaysMoveCondition);

        Car jackCar = new Car(CarName.from("jack"), new CarPosition(1));
        Car johnCar = new Car(CarName.from("john"), new CarPosition(1));
        CarGroup movedCarGroup = new CarGroup(List.of(jackCar, johnCar));
        RaceHistory expectedRaceHistory = RaceHistory.from(List.of(movedCarGroup));

        assertThat(actualRaceHistory).usingRecursiveComparison()
                .isEqualTo(expectedRaceHistory);
    }
}
