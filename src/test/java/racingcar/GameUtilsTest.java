package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameUtilsTest {

    @Test
    void numToHyphen_메서드_사용시_숫자값을_하이픈_개수로_변환() {
        int input = 5;
        String result = GameUtils.numToHyphen(input);

        assertThat(result).isEqualTo("-----");

    }
}