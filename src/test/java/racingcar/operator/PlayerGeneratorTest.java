package racingcar.operator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;

class PlayerGeneratorTest {
    @Test
    void generatePlayerList() {
        //given
        List<String> mockPlayer = List.of("배달이", "동준이");
        //when
        List<Player> mockPlayerList = PlayerGenerator.generatePlayerList(mockPlayer);
        //then
        Assertions.assertThat(mockPlayerList.get(0).getName()).isEqualTo("배달이");
        Assertions.assertThat(mockPlayerList.get(1).getName()).isEqualTo("동준이");
    }
}