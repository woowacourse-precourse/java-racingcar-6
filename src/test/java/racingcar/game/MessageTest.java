package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    void distanceMessageTest(){
        Player player = new Player("worm");

        int distance = 4;

        for(int i = 0 ; i < distance; i++){
            player.forward();
        }

        Assertions.assertThat(new Message().distanceOfPlayer(player)).isEqualTo("worm : ----");
    }
}
