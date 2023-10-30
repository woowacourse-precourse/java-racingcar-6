package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 포지션_생성_시_0_초기화_여부_테스트() {
        Position position = new Position();
        assertThat(position.value()).isEqualTo(0);
    }

    @Test
    void 포지션_증가_테스트() {
        Position position = new Position();
        position.add();

        assertThat(position.value()).isEqualTo(1);
    }

    @Test
    void 포지션_같은_위치_테스트() {
        Position position1 = new Position();
        Position position2 = new Position();

        boolean flag = position1.equals(position2);
        assertThat(flag).isEqualTo(true);
    }
}