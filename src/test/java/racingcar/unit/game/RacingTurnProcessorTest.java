package racingcar.unit.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.RacerMovingNumber;
import racingcar.domain.RacerRegistry;
import racingcar.domain.racer.RacingCar;
import racingcar.game.RacingTurnProcessor;
import racingcar.game.vo.RacerPosition;
import racingcar.mock.MockRandom;

class RacingTurnProcessorTest extends RacerMovingNumber {

    private static RacerRegistry<RacingCar> getRacingCarRegistry(String... names) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String name : names) {
            racingCarList.add(RacingCar.from(name));
        }
        RacerRegistry<RacingCar> racerRegistry = new RacerRegistry<>();
        racerRegistry.addAll(racingCarList);
        return racerRegistry;
    }

    @DisplayName("자동차 경주 게임의 한 턴을 진행한다.")
    @Test
    void progressTurn() {
        //given
        MockRandom mockRandom = new MockRandom();
        RacingTurnProcessor<RacingCar> racingTurnProcessor = new RacingTurnProcessor<>(mockRandom,
                getRacingCarRegistry("a", "b", "c"));
        mockRandom.setRandomNumber(
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP
        );
        //when
        racingTurnProcessor.progressTurn();
        //then
        String position = racingTurnProcessor.toString().replaceAll("[^0-9]", "");
        assertThat(position).isEqualTo("101");
    }

    @DisplayName("자동차 경주 게임의 자동차들별 현재 위치를 반환한다.")
    @Test
    void getTurnResult() {
        //given
        MockRandom mockRandom = new MockRandom();
        RacingTurnProcessor<RacingCar> racingTurnProcessor = new RacingTurnProcessor<>(mockRandom,
                getRacingCarRegistry("a", "b", "c"));
        //when
        List<RacerPosition> turnResult = racingTurnProcessor.getRacerPositions();
        //then
        assertThat(turnResult).hasSize(3)
                .extracting("name", "position")
                .containsExactly(
                        Tuple.tuple("a", 0),
                        Tuple.tuple("b", 0),
                        Tuple.tuple("c", 0)
                );
    }

    @DisplayName("자동차 경주 게임의 우승자를 반환한다.")
    @Test
    void getWinners() {
        //given
        MockRandom mockRandom = new MockRandom();
        RacingTurnProcessor<RacingCar> racingTurnProcessor = new RacingTurnProcessor<>(mockRandom,
                getRacingCarRegistry("a", "b", "c"));
        mockRandom.setRandomNumber(MOVING_FORWARD, STOP, MOVING_FORWARD);
        //when
        racingTurnProcessor.progressTurn();
        List<String> winners = racingTurnProcessor.getWinners();
        //then
        assertThat(winners).hasSize(2)
                .containsExactly("a", "c");
    }
}