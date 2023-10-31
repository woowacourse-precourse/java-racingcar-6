package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;


public class PositionTest {
    @Test
    void 최대_위치_테스트() {
        Position maxPosition = new Position();
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(7));
        positions.add(new Position(9));
        positions.add(new Position(8));
        for (int i = 0; i < positions.size(); i++) {
            Position position = positions.get(i);
            if (position.isGreaterThan(maxPosition)) {
                maxPosition = position;
            }
        }
        assertEquals(new Position(9), maxPosition);
    }

    @Test
    void 위치_객체_동등성_테스트() {
        Position position1 = new Position(5);
        Position position2 = new Position(5);
        assertTrue(position1.equals(position2));
    }

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

    @Test
    void 위치를_문자열로_변환하는_테스트() {
        Position position = new Position();
        position.move();
        position.move();
        assertEquals("--", position.format());
    }

}
