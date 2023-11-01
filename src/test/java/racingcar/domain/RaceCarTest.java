package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RaceCarTest {
    @Test
    void createRaceCar_Successfully() {
        RaceCar raceCar = new RaceCar(new Name("Alice"));
        assertEquals("Alice", raceCar.getName().value());
        assertEquals(0, raceCar.getPosition().value());
    }

    @Test
    void canMove_WithThresholdOrAbove_ReturnsTrue() {
        RaceCar raceCar = new RaceCar(new Name("Bob"));
        assertTrue(raceCar.canMove(4));
        assertTrue(raceCar.canMove(5));
    }

    @Test
    void canMove_BelowThreshold_ReturnsFalse() {
        RaceCar raceCar = new RaceCar(new Name("Max"));
        assertFalse(raceCar.canMove(3));
    }

    @Test
    void moveForward_CanMove() {
        RaceCar raceCar = new RaceCar(new Name("David"));
        raceCar = Mockito.spy(raceCar);

        Mockito.doReturn(true).when(raceCar).canMove(Mockito.anyInt());

        raceCar.moveForward();

        assertEquals(1, raceCar.getPosition().value());
    }

    @Test
    void moveForward_CannotMove() {
        RaceCar raceCar = new RaceCar(new Name("Emily"));
        raceCar = Mockito.spy(raceCar);

        Mockito.doReturn(false).when(raceCar).canMove(Mockito.anyInt());

        raceCar.moveForward();

        assertEquals(0, raceCar.getPosition().value());
    }
}