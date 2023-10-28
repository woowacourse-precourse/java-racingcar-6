package racingcar.model;

import org.assertj.core.api.Assertions;
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
        Assertions.assertThatThrownBy(() -> {
            Name.of(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}