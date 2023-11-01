package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceCarsTest {
    private RaceCars raceCars;
    private RaceCar car1;
    private RaceCar car2;
    private RaceCar car3;

    @BeforeEach
    public void setUp() {
        car1 = mock(RaceCar.class);
        car2 = mock(RaceCar.class);
        car3 = mock(RaceCar.class);
        when(car1.getPosition()).thenReturn(new Position(1));
        when(car2.getPosition()).thenReturn(new Position(2));
        when(car3.getPosition()).thenReturn(new Position(0));

        raceCars = new RaceCars(Arrays.asList(car1, car2, car3));
    }

    @Test
    public void getWinners_ReturnsCorrectWinners() {
        List<RaceCar> winners = raceCars.getWinners();

        assertEquals(1, winners.size());
        assertEquals(car2, winners.get(0));
    }
}
