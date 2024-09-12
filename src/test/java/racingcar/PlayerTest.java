package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"test1", "test1test2", "test1,test2"})
    void 자동차의_이름을_콤마로_구분(String s) {
        Player.makeCarList(s);
        List<String> testList = new ArrayList<>(Arrays.asList(s.split(",")));

        Assertions.assertThat(Player.getCarList())
                .isEqualTo(testList);
    }

    @Test
    void 이름이_5자가_넘을_시_입력시_예외_발생() {
        String input = "5자가넘는이름,longName";
        List<String> list = new ArrayList<>(Arrays.asList(input.split(",")));

        assertThatThrownBy(() -> Player.validateInput(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}