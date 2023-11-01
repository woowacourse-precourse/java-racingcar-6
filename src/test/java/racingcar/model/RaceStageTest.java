package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceStageTest {
    private static final String JACK = "jack";
    private static final String CRONG = "crong";
    private static final int POSITION_5 = 5;
    private static final int POSITION_4 = 4;
    private static final Car CAR_JACK_5_POSITION = createCar(JACK, POSITION_5);
    private static final Car CAR_JACK_4_POSITION = createCar(JACK, POSITION_4);
    private static final Car CAR_JACK_0_POSITION = createCar(JACK, 0);
    private static final Car CAR_CRONG_4_POSITION = createCar(CRONG, POSITION_4);
    private static final Car CAR_CRONG_0_POSITION = createCar(CRONG, 0);

    @Test
    void 자동차_그룹으로_레이스_스테이지_기록을_생성할_수_있다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_4_POSITION, CAR_CRONG_4_POSITION);

        assertDoesNotThrow(
                () -> RaceStage.from(carGroup)
        );
    }

    @Test
    void 가장_멀리_이동한_자동차가_최종_우승자가_된다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);
        RaceStage raceStage = createRaceStage(carGroup);
        Winners expectedWinners = createWinners(CAR_JACK_5_POSITION);

        Winners actualWinners = raceStage.findWinners();

        assertThat(actualWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 최종_위치값이_서로_같다면_공동_우승자이다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_4_POSITION, CAR_CRONG_4_POSITION);
        RaceStage raceStage = createRaceStage(carGroup);
        Winners expectedWinners = createWinners(CAR_JACK_4_POSITION, CAR_CRONG_4_POSITION);

        Winners actualWinners = raceStage.findWinners();

        assertThat(actualWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 여러번_시도에도_자동차_모두_움직이지_않는_경우_모든_자동차가_우승자이다() {
        CarGroup carGroup = createCarGroup(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);
        RaceStage raceStage = createRaceStage(carGroup);
        Winners expectedWinners = createWinners(CAR_JACK_0_POSITION, CAR_CRONG_0_POSITION);

        Winners actualWinners = raceStage.findWinners();

        assertThat(actualWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    private static Car createCar(String name, int position) {
        CarName carName = CarName.from(name);
        CarPosition carPosition = new CarPosition(position);
        return new Car(carName, carPosition);
    }

    private static CarGroup createCarGroup(Car... cars) {
        return new CarGroup(List.of(cars));
    }

    private Winners createWinners(Car... cars) {
        return Winners.from(List.of(cars));
    }

    private RaceStage createRaceStage(CarGroup carGroup) {
        return RaceStage.from(carGroup);
    }
}
