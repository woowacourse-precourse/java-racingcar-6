package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class PlayerTest {


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

    @Test
    void inputTryCnt() {
    }

}