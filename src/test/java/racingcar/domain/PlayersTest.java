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

    @DisplayName("우승자 확인")
    @Test
    void findWinner() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Players players = new Players(names);
        players.getCars().get(0).move(5);
        players.getCars().get(1).move(7);

        List<String> winnersName = players.findWinner();

        assertThat(winnersName.contains("pobi")).isTrue();
        assertThat(winnersName.contains("woni")).isTrue();
        assertThat(winnersName.size()).isEqualTo(2);
    }
}