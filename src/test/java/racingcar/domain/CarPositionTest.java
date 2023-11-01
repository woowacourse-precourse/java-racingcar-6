package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarPositionTest {

    @Test
    void testLineCreation() {
        CarPosition position = new CarPosition(3);
        String line = position.createLine();

        assertThat(line).isEqualTo("---");
    }

}
