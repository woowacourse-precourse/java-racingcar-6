package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void 위치_비교_테스트() {
        Position position1 = new Position(1);
        Position position2 = new Position(2);
        assertTrue(position2.isGreaterThan(position1));
    }

    @Test
    void 이동한_후_위치_비교_테스트() {
        Position position1 = new Position();
        Position position2 = new Position();
        position1.move();
        assertTrue(position1.isGreaterThan(position2));
    }
}
