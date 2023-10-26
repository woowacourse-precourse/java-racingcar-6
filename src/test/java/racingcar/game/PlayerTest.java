package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("Player 이름 출력 테스트")
    void playerNamePrint(){
        Player player = new Player("worm");
        Assertions.assertThat(player.getName()).isEqualTo("worm");
    }

    @Test
    @DisplayName("Player 거리 출력 테스트")
    void playerDistancePrint(){
        Player player = new Player("worm");
        Assertions.assertThat(player.getDistance()).isEqualTo(0);
    }
}
