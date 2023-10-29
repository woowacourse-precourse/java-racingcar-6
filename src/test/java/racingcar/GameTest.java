package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }


    @Test
    void createCar_메서드로_주어진_값을_저장() {
        String input = "zei,casa,miro";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game.createCar();
        Assertions.assertThat(game.getCarRepository().toString()).contains("zei", "casa", "miro");
    }

    @Test
    void getRound_메서드로_주어진_값을_저장() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game.createRound();
        Assertions.assertThat(game.getRound()).isEqualTo(1);
    }

    @Test
    void validateName_메서드로_검증_이름이_6자인_경우() {
        Assertions.assertThatThrownBy(() -> game.validateName("zzz_ei")).isInstanceOf(IllegalArgumentException.class);
    }


}