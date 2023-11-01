package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingRefereeTest {

    @Test
    void normal_test() {
        Players players = new Players(List.of("test1", "test2", "test3"));
        assertDoesNotThrow(() -> new RacingReferee(players, new RandomDice()));
    }

    @Test
    void move_random_test() {

        Players players = new Players(List.of("test1", "test2", "test3"));

        RacingReferee racingReferee = new RacingReferee(players, new RandomDice());

        assertRandomNumberInRangeTest(() -> {
                    assertThat(racingReferee.playerMove().get(players.getPlayers().get(0))).isEqualTo(1);
                },
                4, 1, 1);
    }

    @Test
    void move_test() {

        Players players = new Players(List.of("test1", "test2", "test3"));

        Dice dice = new Dice() {
            @Override
            public int roll() {
                return 5;
            }
        };

        RacingReferee racingReferee = new RacingReferee(players, dice);

        assertThat(racingReferee.playerMove().get(players.getPlayers().get(0))).isEqualTo(1);

    }
}