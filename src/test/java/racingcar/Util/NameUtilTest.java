package racingcar.Util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameUtilTest {
    @Test
    @DisplayName("이름 길이 검증 테스트")
    void 이름_길이_검증_테스트() {
        assertThatThrownBy(() -> NameUtil.validateNameLength("이름길이초과"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 길이가 초과되었습니다.");
    }

    @Test
    @DisplayName("이름 분리 테스트")
    void 이름_분리_테스트() {
        String name = "pobi,woni";
        assertThat(NameUtil.splitName(name)).contains("pobi", "woni");
    }

    @Test
    @DisplayName("이름 분리 실패 테스트")
    void 이름_분리_실패_테스트() {
        String name = "pobi,woni";
        assertThat(NameUtil.splitName(name)).doesNotContain("ppobi", "wwoni");
    }
}