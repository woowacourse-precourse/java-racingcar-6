package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceHistoryTest {

    @Test
    void 경기_기록은_비어있을_수_없다() {
        assertThatThrownBy(() -> RaceHistory.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경기_기록은_최소한_한라운드의_경기_기록이_있어야_한다() {
        Car jackCar = createCarWith("jack", 5);
        CarGroup finalStage = new CarGroup(List.of(jackCar));

        assertDoesNotThrow(
                () -> RaceHistory.from(List.of(finalStage))
        );
    }

    @Test
    void 전체_경기_기록에서_마지막_경기_기록으로_우승자를_찾는다() {
        Car jackCar = createCarWith("jack", 5);
        Car johnCar = createCarWith("john", 4);
        CarGroup finalStage = new CarGroup(List.of(jackCar, johnCar));
        RaceHistory raceHistory = RaceHistory.from(List.of(finalStage));
        CarWinners expectedCarWinners = CarWinners.from(List.of(jackCar));

        CarWinners actualCarWinners = raceHistory.findFinalStageWinners();

        assertThat(actualCarWinners).usingRecursiveComparison()
                .isEqualTo(expectedCarWinners);
    }

    private Car createCarWith(String name, int position) {
        return new Car(CarName.from(name), new CarPosition(position));
    }
}
