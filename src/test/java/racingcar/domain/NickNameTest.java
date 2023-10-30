package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NickNameTest {
    @Test
    void 이름에_공백이_주어짐() {
        assertThatThrownBy(() -> new NickName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름에_빈칸이_주어짐() {
        assertThatThrownBy(() -> new NickName(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_여섯글자_이상_주어짐() {
        assertThatThrownBy(() -> new NickName("imnotcar"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
