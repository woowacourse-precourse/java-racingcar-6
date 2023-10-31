package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @DisplayName("참여자들 객체 생성 - 입력값 정상")
    @Test
    void createPlayersWithCorrectInput() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");

        Players players = new Players(names);

        assertThat(players.getCars().size()).isEqualTo(3);
    }

    @DisplayName("참여자들 객체 생성 - 입력값 오류")
    @Test
    void createPlayersWithWrongInput() {
        List<String> names = Arrays.asList("pobi", "pobi", "jun");

        assertThatThrownBy(() -> new Players(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}