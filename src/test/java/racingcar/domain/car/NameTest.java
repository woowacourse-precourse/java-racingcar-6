package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 게임에서_허용한_길이의_문자열로_이름을_생성할_수_있다() {
        // given
        String input = "abcde";

        // when
        Name name = new Name(input);

        // then
        assertEquals("abcde", name.name());
    }

    @Test
    void 게임에서_허용하지_않은_길이의_문자열로_이름을_생성하면_예외가_발생한다() {
        // given
        String input = "abcdef";

        // when, then
        Assertions.assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 제한 길이를 초과하였습니다.");
    }

    @Test
    void 빈_문자열로_이름을_생성하면_예외가_발생한다() {
        // given
        String input = "";

        // when, then
        Assertions.assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열은 이름이 될 수 없습니다.");
    }

    @Test
    void 공백으로_이름을_생성하면_예외가_발생한다() {
        // given
        String input = " ";

        // when, then
        Assertions.assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열은 이름이 될 수 없습니다.");
    }

    @Test
    void null_문자열로_이름을_생성하면_예외가_발생한다() {
        // given
        String input = null;

        // when, then
        Assertions.assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열은 이름이 될 수 없습니다.");
    }
}