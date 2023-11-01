package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {
    @Test
    void setPlayers_사용자_1명_설정할_수_있다() {
        RacingCarGame game = new RacingCarGame();
        game.setPlayers("dadi");
        ArrayList<RacingCar> racingCars = game.getRacingCars();

        assertThat(racingCars).hasSize(1);
        assertThat(racingCars.get(0).getName()).isEqualTo("dadi");
    }
    @Test
    void setPlayers_사용자_여러명_설정할_수_있다() {
        RacingCarGame game = new RacingCarGame();
        game.setPlayers("dadi,dodi");
        ArrayList<RacingCar> racingCars = game.getRacingCars();

        assertThat(racingCars).hasSize(2);
        assertThat(racingCars.get(0).getName()).isEqualTo("dadi");
        assertThat(racingCars.get(1).getName()).isEqualTo("dodi");
    }
}
