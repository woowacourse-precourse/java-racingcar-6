package racingcar.domain.position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("위치 테스트")
class PositionTest {

    @DisplayName("위치 객체끼리 비교할 수 있다")
    @Test
    void testComparePosition() {
        Position position1 = new Position(5);
        Position position2 = new Position(3);

        assertTrue(position1.compareTo(position2) > 0);
        assertTrue(position2.compareTo(position1) < 0);
        assertEquals(0, position1.compareTo(new Position(5)));
    }


    @DisplayName("위치 객체는 동등성을 비교할 수 있다")
    @Test
    void testEquals() {
        Position position1 = new Position(5);
        Position position2 = new Position(5);
        Position position3 = new Position(3);

        assertTrue(position1.equals(position2));
        assertFalse(position1.equals(position3));
        assertFalse(position1.equals(null));
        assertFalse(position1.equals("Not a Position"));
    }
}