package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private final Car testCar = Model.generateCar("ukeun");

    @Test
    @DisplayName("move 메서드 테스트")
    void move() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar.moveOrStop();
                    }
                    assertEquals(2, testCar.getMoved());
                },
                3, 4, 5
        );
    }

    @Test
    @DisplayName("toString 메서드 테스트")
    void testToString() {
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        testCar.moveOrStop();
                    }
                    assertEquals("ukeun : ---", testCar.toString());
                },
                4, 4, 4
        );
    }
}