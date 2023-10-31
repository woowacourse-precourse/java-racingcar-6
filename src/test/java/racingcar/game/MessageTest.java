package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    void distanceMessageTest() {
        Player player = new Player("worm");

        int distance = 4;

        for (int i = 0; i < distance; i++) {
            player.forward();
        }

        Assertions.assertThat(new Message().distanceOfPlayer(player)).isEqualTo("worm : ----");
    }

    @Test
    void championMessageTest() {
        List<Player> champions = new ArrayList<>();
        champions.add(new Player("worm"));
        champions.add(new Player("bird"));
        Assertions.assertThat(new Message().champions(champions)).isEqualTo("최종 우승자 : worm, bird");
    }
}
