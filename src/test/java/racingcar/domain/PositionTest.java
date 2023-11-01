package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {

    @Test
    void testLineCreation() {
        Position position = new Position(3);
        String line = position.createLine();

        assertThat(line).isEqualTo("---");
    }

}
