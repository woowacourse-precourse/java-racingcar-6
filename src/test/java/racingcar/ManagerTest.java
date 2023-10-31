package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Manager;
import racingcar.domain.Player;

public class ManagerTest {
    private Manager manager;

    @BeforeEach
    void setUp() {
        manager = new Manager();
    }

    List<Player> playerList = List.of(
            new Player("aaa", 1),
            new Player("bbb", 0),
            new Player("ccc", 1)
    );

    @Test
    void 참가자_목록에서_우승자_추출() {
        List<String> testResult = manager.getWinners(playerList);

        assertThat(testResult).hasSize(2);
        assertThat(testResult).contains("aaa", "ccc");
    }
}
