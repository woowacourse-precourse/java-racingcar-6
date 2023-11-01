package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceHistoryTest {
    private static final String JACK = "jack";
    private static final String CRONG = "crong";
    private static final int POSITION_5 = 5;
    private static final int POSITION_4 = 4;
    private static final Car CAR_JACK_5_POSITION = createCar(JACK, POSITION_5);
    private static final Car CAR_JACK_4_POSITION = createCar(JACK, POSITION_4);
    private static final Car CAR_CRONG_4_POSITION = createCar(CRONG, POSITION_4);

    @Test
    void 경기_스테이지_기록이_비어있으면_경기_기록을_생성할_수_없다() {
        assertThatThrownBy(() -> RaceHistory.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경기_기록은_최소한_한개의_스테이지_기록이_있어야_한다() {
        RaceStage raceStage = createRaceStage(CAR_JACK_5_POSITION);

        assertDoesNotThrow(
                () -> RaceHistory.from(List.of(raceStage))
        );
    }

    @Test
    void 전체_경기_기록에서_마지막_경기_기록으로_우승자를_찾는다() {
        RaceStage firstStage = createRaceStage(CAR_JACK_4_POSITION, CAR_CRONG_4_POSITION);
        RaceStage secondStage = createRaceStage(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);
        RaceHistory raceHistory = createRaceHistory(firstStage, secondStage);
        Winners expectedWinners = createWinners(CAR_JACK_5_POSITION);

        Winners actualWinners = raceHistory.findFinalStageWinners();

        assertThat(actualWinners).usingRecursiveComparison()
                .isEqualTo(expectedWinners);
    }

    @Test
    void 외부로부터_받은_경기_스테이지_목록이_변경되어도_내부_목록은_변경되지_않는다() {
        RaceStage finalStage = createRaceStage(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);
        List<RaceStage> modifiableRaceStages = new ArrayList<>(List.of(finalStage));
        RaceHistory protectedRaceHistory = createRaceHistory(modifiableRaceStages);
        RaceHistory expectedRaceHistory = createRaceHistory(finalStage);

        modifiableRaceStages.clear();

        assertThat(protectedRaceHistory).usingRecursiveComparison()
                .isEqualTo(expectedRaceHistory);
    }

    @Test
    void 외부로_반환된_경기_스테이지_목록이_변경되어도_내부_목록은_변경되지_않는다() {
        RaceStage finalRaceStage = createRaceStage(CAR_JACK_5_POSITION, CAR_CRONG_4_POSITION);
        RaceHistory protectedRaceHistory = createRaceHistory(finalRaceStage);
        List<RaceStage> modifiableRaceStages = protectedRaceHistory.getRaceStages();
        RaceHistory expectedRaceHistory = createRaceHistory(finalRaceStage);

        modifiableRaceStages.clear();

        assertThat(protectedRaceHistory).usingRecursiveComparison()
                .isEqualTo(expectedRaceHistory);
    }

    private static Car createCar(String name, int position) {
        return new Car(CarName.from(name), new CarPosition(position));
    }

    private Winners createWinners(Car... cars) {
        return Winners.from(List.of(cars));
    }

    private RaceStage createRaceStage(Car... cars) {
        CarGroup carGroup = new CarGroup(List.of(cars));
        return RaceStage.from(carGroup);
    }

    private RaceHistory createRaceHistory(RaceStage... raceStages) {
        return RaceHistory.from(List.of(raceStages));
    }

    private static RaceHistory createRaceHistory(List<RaceStage> raceStages) {
        return RaceHistory.from(raceStages);
    }

}
