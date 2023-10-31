package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {
    @Test
    void 랜덤_숫자가_4이상일_경우_자동차_위치_전진(){
        Position position = new Position();
        assertThat(position.move(4)).isEqualTo(new Position(1));
    }

    @Test
    void 랜덤_숫자가_4미만일_경우_자동차_위치_정지(){
        Position position = new Position();
        assertThat(position.move(3)).isEqualTo(new Position(0));
    }

    @Test
    void 자동차_위치_같은지_비교한다(){
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    void 전달받은_위치보다_자동차_위치가_더_높으면_1을_반환한다(){
        assertThat(new Position(4).compareTo(new Position(3))).isEqualTo(1);
    }
}