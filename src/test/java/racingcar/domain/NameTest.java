package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingCarGameUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름 타입 검증 성공 케이스")
    void 이름_타입_검증_성공() {
        assertThat(RacingCarGameUtil.validNameType("현대")).isTrue();
    }

    @Test
    @DisplayName("이름 타입 검증 실패 케이스")
    void 이름_타입_검증_실패() {
        assertThatThrownBy(() -> RacingCarGameUtil.validNameType(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 값 입니다.");
    }

    @Test
    @DisplayName("이름 길이 검증 성공 케이스")
    void 이름_길이_검증_성공() {
        assertThat(RacingCarGameUtil.validNameLength("현대")).isTrue();
    }

    @Test
    @DisplayName("이름 길이 검증 실패 케이스")
    void 이름_길이_검증_실패() {
        assertThatThrownBy(() -> RacingCarGameUtil.validNameLength("현대같은기아"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 값 입니다.");
    }
}