package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.GameInput;

class GameTest {

    ByteArrayOutputStream out;

    private static final int MOVING_FORWARD = 9;
    private static final int STOP = 0;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("play: 게임 진행에 성공한다 - 우승자 한명")
    void play_한명_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    Game game = new Game(new GameInput(List.of("a", "b"), 3L));
                    game.play();
                    assertThat(out.toString()).contains("a : ---", "b : ", "최종 우승자 : a");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("play: 게임 진행에 성공한다 - 우승자 여러명")
    void play_복수_우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    Game game = new Game(new GameInput(List.of("a", "b"), 3L));
                    game.play();
                    assertThat(out.toString()).contains("a : --", "b : --", "최종 우승자 : a, b");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}