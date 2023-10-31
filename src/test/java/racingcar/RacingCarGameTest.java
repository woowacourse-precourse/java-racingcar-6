package racingcar;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameTest {

    private RacingCarGame game;

    @BeforeEach
    public void setUp() {
        game = new RacingCarGame();
    }

    @Test
    void setRacingCarNames_자동차_이름을_부여할_수_있고_쉼표를_기준으로_구분한다() {
        String testInput = "car1,car2,car3";
        game.setRacingCarNames(testInput);
        assertEquals(3, game.racingCars.size());
    }

    @Test
    void setTryIteration_사용자는_몇_번의_이동을_할_것인지를_입력할_수_있어야_한다() {
        game.setTryIteration("5");
        assertEquals(5, game.tryIteration);
    }
}