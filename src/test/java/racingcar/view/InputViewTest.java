package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.ValidateCarName;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @Test
    void 자동자_정상_입력_테스트(){

        // given
        String input = "pobi,crong,honux";

        // when
        List<String> result = ValidateCarName.validateInputValue(input);

        // then
        assertThat(result).containsExactly("pobi", "crong", "honux");

    }

    @Test
    void 자동자_구분자_없는_입력(){

        // given
        String input = "pobi";

        // when
        List<String> result = ValidateCarName.validateInputValue(input);

        // then
        assertThat(result).containsExactly("pobi");

    }

    @Test
    void 다섯_글자_넘는_자동차_입력(){

        // given
        String input = "iamoverfive";

        // when
        Throwable thrown = catchThrowable(() -> ValidateCarName.validateInputValue(input));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

}