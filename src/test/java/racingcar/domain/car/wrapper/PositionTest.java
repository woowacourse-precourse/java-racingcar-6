package racingcar.domain.car.wrapper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PositionTest {

    @Test
    void increase_및_toString_메소드_정상_작동() {
        Position position = new Position();
        position.increase();
        position.increase();
        assertEquals(position.toString(), "--");
    }

    @Test
    void compareTo_메소드_정상_작동() {
        Position p1 = new Position();
        Position p2 = new Position();
        assertThat(p1.compareTo(p2)).isEqualTo(0);

        p1.increase();
        assertThat(p1.compareTo(p2)).isEqualTo(1);
        assertThat(p2.compareTo(p1)).isEqualTo(-1);
    }

    @Test
    void equals_메소드_정상_작동() {
        Position p1 = new Position();
        Position p2 = new Position();
        assertEquals(p1, p2);

        p1.increase();
        assertNotEquals(p1, p2);
    }
}
