package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputTest {

    Input input = new Input();

    @Test
    void 이름_입력() {
        // given
        String readline = "aaa,bbb,ccc,ddd";

        // when
        List<String> nameList = input.getNames(readline);

        // then
        assertThat(nameList).containsExactly("aaa", "bbb", "ccc", "ddd");
    }

    @Test
    void 이름_입력_예외_5자_초과() {
        // given
        String readline = "aaa,bbbbbb";

        // when, then
        assertThatThrownBy(() -> input.getNames(readline))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하로 이름을 작성해 주세요.");
    }


    @Test
    void 이름_입력_예외_중복() {
        // given
        String readline = "aaa,bbb,aaa";

        // when, then
        assertThatThrownBy(() -> input.getNames(readline))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("겹치지 않은 이름을 입력해 주세요.");
    }

    @Test
    void 시도할_횟수_입력() {
        // given
        String readline = "4";

        // when
        int moveCount = input.getMoveCount(readline);

        // then
        assertThat(moveCount).isEqualTo(4);
    }

    @Test
    void 시도할_횟수에_문자_입력_예외() {
        // given
        String readline = "1q";

        // when, then
        assertThatThrownBy(() -> input.getMoveCount(readline))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해 주세요.");
    }
}