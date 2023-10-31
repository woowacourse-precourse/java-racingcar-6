package racingcar.unit.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.game.RacingTurnProcessor;
import racingcar.game.vo.RacerPosition;
import racingcar.race.RacerRegistry;
import racingcar.race.RacingCar;
import racingcar.util.Random;

class RacingTurnProcessorTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static MockedStatic<Random> random;

    @BeforeAll
    static void beforeAll() {
        random = mockStatic(Random.class);
    }

    @AfterAll
    static void afterAll() {
        random.close();
    }

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
        RacingTurnProcessor<RacingCar> racingTurnProcessor = new RacingTurnProcessor<>(
                getRacingCarRegistry("a", "b", "c"));
        given(Random.getRandomNumberInRange(anyInt(), anyInt())).willReturn(
                MOVING_FORWARD, STOP, MOVING_FORWARD);
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
        RacingTurnProcessor<RacingCar> racingTurnProcessor = new RacingTurnProcessor<>(
                getRacingCarRegistry("a", "b", "c"));
        //when
        List<RacerPosition> turnResult = racingTurnProcessor.getTurnResult();
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
        RacingTurnProcessor<RacingCar> racingTurnProcessor = new RacingTurnProcessor<>(
                getRacingCarRegistry("a", "b", "c"));
        given(Random.getRandomNumberInRange(anyInt(), anyInt())).willReturn(
                MOVING_FORWARD, STOP, MOVING_FORWARD);
        given(Random.getRandomNumberInRange(anyInt(), anyInt())).willReturn(
                MOVING_FORWARD, STOP, MOVING_FORWARD);
        //when
        racingTurnProcessor.progressTurn();
        racingTurnProcessor.progressTurn();
        List<String> winners = racingTurnProcessor.getWinners();

        //then
        assertThat(winners).hasSize(2)
                .containsExactly("a", "c");
    }
}