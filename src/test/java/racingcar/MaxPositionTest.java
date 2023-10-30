package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Position;


public class MaxPositionTest extends NsTest {
    @Test
    void 최대_거리_테스트() {
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
