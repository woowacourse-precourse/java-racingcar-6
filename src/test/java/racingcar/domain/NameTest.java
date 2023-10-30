package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {
    @Test
    void 이름이_5자_초과인_경우_예외_발생() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_0자_이하인_경우_예외_발생() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_같은지_비교한다(){
        assertThat(new Name("abc")).isEqualTo(new Name("abc"));
    }

    @Test
    void 이름_다르면_false를_반환한다(){
        assertThat(new Name("abc")).isNotEqualTo(new Name("abcd"));
    }

    @Test
    void 이름_객체를_문자열로_반환한다(){
        assertThat(new Name("abc").toString()).isEqualTo("abc");
    }
}