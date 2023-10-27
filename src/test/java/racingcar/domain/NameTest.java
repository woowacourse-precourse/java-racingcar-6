package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    public void 자동차_이름_생성_테스트() {
        // given
        Name name = new Name("12345");

        // when, then
        assertThat(name).isEqualTo(new Name("12345"));
    }

    @Test
    public void 자동차_비어있는_이름_생성_실패_테스트() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름_5글자_초과_생성_실패_테스트() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
