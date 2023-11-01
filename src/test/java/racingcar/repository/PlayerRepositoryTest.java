package racingcar.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerRepositoryTest {

    @Test
    void save() {
        Player player = new Player("james", 0);
        PlayerRepository repository = new PlayerRepository();
        Player savePlayer = repository.save(player);
        assertThat(savePlayer.getPlayerName()).isEqualTo(player.getPlayerName());
    }

    @Test
    void getPlayers() {
        Player player1 = new Player("james", 0);
        Player player2 = new Player("jun", 0);
        PlayerRepository repository = new PlayerRepository();
        repository.save(player1);
        repository.save(player2);
        Map<String, Integer> findAllPlayers = repository.getPlayers();
        assertThat(findAllPlayers.size()).isEqualTo(2);
    }
}