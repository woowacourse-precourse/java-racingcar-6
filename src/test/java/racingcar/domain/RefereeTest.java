package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    private RandomNumberGenerator mockGenerator;
    private Referee referee;
    private RacingCar car1, car2, car3;
    private List<RacingCar> cars;

    @BeforeEach
    void setUp() {
        mockGenerator = mock(RandomNumberGenerator.class);
        referee = new Referee(mockGenerator);
        car1 = new RacingCar("car1");
        car2 = new RacingCar("car2");
        car3 = new RacingCar("car3");
        cars = Arrays.asList(car1, car2, car3);
    }

    @Test
    void playRound_각_자동차를_랜덤한_수치에_따라_이동() {
        when(mockGenerator.generate(0, 9)).thenReturn(STOP, MOVE, MOVE);

        referee.playRound(cars);

        assertEquals(0, car1.getDistance());
        assertEquals(1, car2.getDistance());
        assertEquals(1, car3.getDistance());
    }

    @Test
    void getWinners_가장_멀리_이동한_자동차를_승자로_결정() {
        car1.move();
        car1.move();
        car2.move();
        car3.move();
        car3.move();
        car3.move();

        List<RacingCar> winners = referee.getWinners(cars);

        assertEquals(1, winners.size());
        assertTrue(winners.contains(car3));
    }

    @Test
    void getWinners_승자가_여럿인_경우() {
        car1.move();
        car2.move();
        car2.move();
        car3.move();
        car3.move();

        List<RacingCar> winners = referee.getWinners(cars);

        assertEquals(2, winners.size());
        assertTrue(winners.contains(car2));
        assertTrue(winners.contains(car3));
    }
}
