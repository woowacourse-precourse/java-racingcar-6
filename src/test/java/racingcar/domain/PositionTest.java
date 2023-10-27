package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    public void 포지션_기본_생성_테스트() {
        // given
        Position position = new Position();

        // when, then
        assertThat(position).isEqualTo(new Position(0));
    }
    
    @Test
    public void 포지션_생성자_생성_테스트() {
        // given
        Position position = new Position(7);

        // when, then
        assertThat(position).isEqualTo(new Position(7));
    }

    @Test
    public void 음수_포지션_예외발생_테스트() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 포지션_증가_테스트() {
        // given
        Position position = new Position(7);

        // when
        position.increase();

        // then
        assertThat(position).isEqualTo(new Position(8));
    }
}
