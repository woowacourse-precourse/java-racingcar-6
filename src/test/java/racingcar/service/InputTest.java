package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class InputTest {

    @Test
    void 자동차_이름_구분하여_배열로_만들기() {
        //given
        String notSplitCars = "a,b,c";

        //when
        String[] result = Input.splitCarName(notSplitCars);

        //then
        assertThat(result).contains("a", "c", "b");
        assertThat(result).containsExactly("a", "b", "c");
    }

    @Test
    void assignChallengeNumber() {
    }
}