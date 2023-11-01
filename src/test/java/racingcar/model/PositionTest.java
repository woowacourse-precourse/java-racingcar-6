package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("Position(position) 생성 테스트 : Position 생성 시 위치값을 부여할 수 있다.")
    @Test
    void create_생성자에_위치값이_주어짐() {
        Position position = new Position(5);
        assertThat(position).isEqualTo(new Position(5));
    }

    @DisplayName("Position(position) 생성 예외 테스트 : 0보다 작다면 IllegalArgumentException가 발생한다.")
    @Test
    void 예외발생_위치값이_0보다_작은_경우() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 초기위치값은 0보다 작을 수 없습니다.");
    }

    @DisplayName("Position(position) 생성 예외 테스트 : 0이상이라면 성공적으로 Position객체가 생성된다.")
    @Test
    void 예외발생하지않음_위치값이_0_이상인_경우() {
        assertAll(
                () -> assertThatCode(() -> new Position(0))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new Position(1))
                        .doesNotThrowAnyException()
        );
    }

}