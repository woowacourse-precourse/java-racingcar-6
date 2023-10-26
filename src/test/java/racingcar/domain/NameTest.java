package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    private static final String VALID_NAME = "pobi";

    @Test
    void 정상_이름_생성() {
        //when
        Name validName = new Name(VALID_NAME);

        //then
        assertThat(validName.value()).isEqualTo(VALID_NAME);
    }

    @Test
    void 공백_이름_예외() {
        //given
        String blankName = " ";

        //when & then
        assertThatThrownBy(() -> new Name(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 입력 불가능 합니다.");
    }

    @Test
    void 이름_길이_예외() {
        //given
        String longName = "abcdef";

        //when & then
        assertThatThrownBy(() -> new Name(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 이름만 가능합니다.");
    }

    @Test
    void 숫자_이름_예외() {
        //given
        String numberName = "123";

        //when & then
        assertThatThrownBy(() -> new Name(numberName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 입력 불가능 합니다.");
    }
}
