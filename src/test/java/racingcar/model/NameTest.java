package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class NameTest {

    @Test
    public void Name_생성_시_이름이_다섯_글자가_넘으면_예외를_발생시킨다() throws Exception {
        // given
        String name = "moreThan5";

        // when
        //then
        assertThatThrownBy(() -> {
            Name.of(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이름이_다섯_글자가_이하면_Name_을_생성할_수_있다() throws Exception {
        // given
        String name = "55555";

        // when
        //then
        assertThatCode(() -> {
            Name.of(name);
        }).doesNotThrowAnyException();
    }

}