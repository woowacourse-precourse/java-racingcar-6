package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.service.GameService;

public class GamePlayerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @ParameterizedTest
    @MethodSource
    public void 가장_높은_점수를_구한다(List<Integer> moveCondition, int expectedResult) {
        //given
        GameService gameService = new GameService();
        CarNames carNames = CarNames.fromInput("name1,name2,name3");
        GamePlayer gamePlayer = gameService.createGamePlayer(carNames);
        //when
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 2; i++) {
                        gameService.moveCars(gamePlayer);
                    }
                },
                moveCondition.get(0), moveCondition.get(1), moveCondition.get(2),
                moveCondition.get(3), moveCondition.get(4), moveCondition.get(5)
        );
        //then
        assertThat(gamePlayer.getMaxMoveDistance()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> 가장_높은_점수를_구한다() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(
                                Arrays.asList(MOVING_FORWARD, STOP, STOP, STOP, STOP, STOP)),
                        1),
                Arguments.of(
                        new ArrayList<>(
                                Arrays.asList(MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP)),
                        2),
                Arguments.of(
                        new ArrayList<>(
                                Arrays.asList(STOP, STOP, STOP, STOP, STOP, STOP)),
                        0)
        );
    }
}
