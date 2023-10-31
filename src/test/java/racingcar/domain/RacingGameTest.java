package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void play_게임이_정상적으로_진행되는지_테스트() {
        RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.generate(anyInt(), anyInt())).thenReturn(5); // 항상 이동

        RacingGame racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"), 3,
                mockGenerator);
        racingGame.play();

        String expectedOutput = "car1 : -\ncar2 : -\ncar3 : -\n\n" +
                "car1 : --\ncar2 : --\ncar3 : --\n\n" +
                "car1 : ---\ncar2 : ---\ncar3 : ---\n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void getWinners_우승자가_올바르게_결정되는지_테스트() {
        RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        RacingGame racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"), 3,
                mockGenerator);

        when(mockGenerator.generate(anyInt(), anyInt())).thenReturn(5, 3, 5); // 1라운드: car1, car3 이동
        racingGame.play();

        when(mockGenerator.generate(anyInt(), anyInt())).thenReturn(3, 5, 5); // 2라운드: car2, car3 이동
        racingGame.play();

        when(mockGenerator.generate(anyInt(), anyInt())).thenReturn(5, 3, 3); // 3라운드: car1 이동
        racingGame.play();

        List<String> winners = racingGame.getWinners();
        assertEquals(Arrays.asList("car1", "car3"), winners);
    }
}
