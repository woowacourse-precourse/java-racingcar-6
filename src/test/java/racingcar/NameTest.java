package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    private static final String GIVEN_SUCCESS_NAME = "mooso";
    private static final String GIVEN_FAIL_NAME = "moosong";

    @Test
    void 이름_생성_시_5자_검사_실패() {
        assertThatThrownBy(() -> Name.createName(GIVEN_FAIL_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5");
    }

    @Test
    void 이름_생성_시_5자_검사_성공() {
        Name givenName = Name.createName(GIVEN_SUCCESS_NAME);
        assertThat(givenName.getName()).isEqualTo(GIVEN_SUCCESS_NAME);
    }
}
