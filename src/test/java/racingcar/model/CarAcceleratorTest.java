package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CarAcceleratorTest {

    @Test
    public void shouldAccelerate_() {
        CarAccelerator carAccelerator = new CarAccelerator();
        carAccelerator.setFakeRandoms();

        assertEquals(false, carAccelerator.shouldAccelerate());
        carAccelerator.rollback();
    }
}