package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;
import racingcar.domain.Players;

public class PlayersTest {
    @Test
    void from은_플레이어_리스트를_받아_Players_객체를_반환한다() {
        Players players = Players.from(List.of(Player.from("a"), Player.from("b")));
        assertNotNull(players);
    }

    @Test
    void getWinnerList는_우승자들의_이름을_반환한다() {
        Player win1 = Player.of("win1", true);
        Player win2 = Player.of("win2", true);
        Player fail1 = Player.of("fail1", false);
        Players players = Players.from(List.of(win1, win2, fail1));
        
        assertThat(players.getWinnerList()).containsExactly("win1", "win2");
    }
}
