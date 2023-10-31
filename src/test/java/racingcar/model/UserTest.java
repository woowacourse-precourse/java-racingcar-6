package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    User user;

    @DisplayName("시도 횟수의 입력값이 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void moveSizeFail() {
        assertThatThrownBy(() -> new User("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }
    @DisplayName("시도 횟수의 입력값이 숫자라면 성공한다.")
    @Test
    void moveSizeSuccess() {
        user = new User("5");
        assertThat(user.getMoveSize()).isEqualTo(5);
    }
    @DisplayName("시도 횟수가 0이라면 예외를 발생시킨다.")
    @Test
    void moveSizeIsZero() {
        assertThatThrownBy(() -> new User("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }
}