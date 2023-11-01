package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.service.GameService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {
    private final GameService gameService = new GameService();

    @Test
    void gameService_입력된_값을_쉼표_기준으로_나눈다() {
        List<String> result = gameService.parseCarName("one,two,three");

        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo("one");
    }
}
