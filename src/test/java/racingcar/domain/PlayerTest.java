package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class PlayerTest {

    Player player = new Player();

    @ParameterizedTest
    @ValueSource(strings = {"tom,jenny,rosa"})
    void inputCarNames_성공(String inputNames){
        System.setIn(new ByteArrayInputStream(inputNames.getBytes()));
        Player player = new Player();

        int length = inputNames.split(",").length;
        List<String> strings = player.inputCarNames();

        assertThat(strings.size()).isEqualTo(length);
        assertThat(strings.contains(",")).isFalse();

    }

    @ParameterizedTest
    @ValueSource(strings = {"tomJenny,rosa"})
    void inputCarNames_5자초과이름_실패(String inputNames){
        System.setIn(new ByteArrayInputStream(inputNames.getBytes()));
        Player player = new Player();

        assertThatThrownBy(player::inputCarNames)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryCnt_실패() {
        int tryCnt = -1;
        System.setIn(new ByteArrayInputStream(String.valueOf(tryCnt).getBytes()));
        assertThatThrownBy(player::inputTryCnt).isInstanceOf(IllegalArgumentException.class);
    }

}