package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void from은_이름을_받아서_Player_객체를_생성한다() {
        Player player = Player.from("hyeon");
        assertThat(player).isInstanceOf(Player.class);
    }
}
