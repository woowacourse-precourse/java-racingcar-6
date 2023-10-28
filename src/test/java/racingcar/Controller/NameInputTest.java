package racingcar.Controller;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NameInputTest {
    RacingGameController rc = new RacingGameController();
    Verification verify = new Verification();

    @Test
    void 이름_쉼표_구분() {
        //given
        String input = "abc,def,ghi";
        //when
        String[] result = rc.splitInput(input);
        //then
        assertThat(result).containsExactly("abc", "def", "ghi");
    }

    @Test
    void 이름_예외처리_5자초과() {
        List<String> input = new ArrayList<>();
        input.add("abcdef");

        assertThatThrownBy(() -> verify.verifyCarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_예외처리_공백() {
        List<String> input = new ArrayList<>();
        input.add("   "); // 공백 3개

        assertThatThrownBy(() -> verify.verifyCarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_예외처리_문자_공백_섞여있는_경우() {
        List<String> input = new ArrayList<>();
        input.add("abc  "); // abc + 공백 2개

        assertThatThrownBy(() -> verify.verifyCarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}