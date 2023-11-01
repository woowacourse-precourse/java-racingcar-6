package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PositionTest {

    private static final String POSITION_PATTERN = "-";

    @Test
    void 현재_위치만큼_특정_문자로_나타낼_수_있어야_한다() {
        // given
        int curPosition = 3;
        Position position = new Position(curPosition);

        // when
        String position_pattern = position.expressPosition();

        // then
        String expectedPatterns = POSITION_PATTERN.repeat(curPosition);
        assertEquals(expectedPatterns, position_pattern);
    }
}