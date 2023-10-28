package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    String[] array = { "i", "my", "me" };
    Game game = new Game(Arrays.asList(array), 3);

    @Test
    void 주어진_횟수_동안_n대의_자동차는_전진_또는_멈춤() {
        assertRandomNumberInRangeTest(
                () -> {
                    game.step();
                    Assertions.assertThat(
                            "i : \nmy : \nme : ").isEqualTo(game.getRaceInfo());
                    game.step();
                    Assertions.assertThat(
                            "i : -\nmy : -\nme : -").isEqualTo(game.getRaceInfo());
                    game.step();
                    Assertions.assertThat(
                            "i : -\nmy : -\nme : --").isEqualTo(game.getRaceInfo());
                },
                1, 2, 3,
                4, 5, 6,
                1, 2, 4);
    }

    @Test
    void 자동차_경주_게임을_완료한_후_누가_우승했는지를_알려줌() {
        assertRandomNumberInRangeTest(
                () -> {
                    while (!game.isDone()) {
                        game.step();
                    }
                    assertThat(game.getWinnersList()).contains("me");
                },
                1, 2, 3,
                4, 5, 6,
                1, 2, 4);
    }

    @Test
    void 우승자는_한_명_이상일_수_있음() {
        assertRandomNumberInRangeTest(
                () -> {
                    while (!game.isDone()) {
                        game.step();
                    }
                    assertThat(game.getWinnersList()).contains("me", "my");
                },
                1, 2, 3,
                4, 5, 6,
                1, 4, 4);
    }
}
