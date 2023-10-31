package study;

import org.junit.jupiter.api.Test;
import racingcar.game.Game;
import racingcar.game.GameCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCarTest {

    @Test
    void 차_이동_테스트() {
        //given
        GameCar gameCar = new GameCar("choi");
        //when
        gameCar.move();
        //then
        assertThat(gameCar.getPosition()).isEqualTo(1);
    }
}
