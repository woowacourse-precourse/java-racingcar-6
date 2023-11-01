package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RacingGameTest {
    private RacingGame racingGame;
    private List<Car> cars;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        Car car1 = mock(Car.class);
        when(car1.getName()).thenReturn("Car1");
        Car car2 = mock(Car.class);
        when(car2.getName()).thenReturn("Car2");
        cars = Arrays.asList(car1, car2);
        racingGame = new RacingGame(cars, 3);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void should_PlayGame_CorrectNumberOfTimes() {
        racingGame.playGame();
        verify(cars.get(0), times(3)).attemptToMove(anyInt());
        verify(cars.get(1), times(3)).attemptToMove(anyInt());
    }

    @Test
    void should_AnnounceCorrectWinner() {
        when(cars.get(0).getPosition()).thenReturn(2);
        when(cars.get(1).getPosition()).thenReturn(3);
        racingGame.announceWinners();
        assertThat(outContent.toString()).contains("최종 우승자 : Car2");
    }
}
