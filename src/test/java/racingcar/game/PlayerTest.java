package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void playerNamePrint() {
        Player player = new Player("worm");
        Assertions.assertThat(player.getName()).isEqualTo("worm");
    }

    @Test
    void playerDistancePrint() {
        Player player = new Player("worm");
        Assertions.assertThat(player.getDistance()).isEqualTo(0);
    }

    @Test
    void increaseDistance() {
        Player player = new Player("worm");
        int distance = 3;
        for (int i = 0; i < distance; i++) {
            player.forward();
        }
        Assertions.assertThat(player.getDistance()).isEqualTo(distance);
    }
}
