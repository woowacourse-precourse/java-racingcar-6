package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarGame;
import racingcar.model.Car;

public class WinnerTest {

    @Test
    void 우승자_한명_인덱스_찾기_테스트() {
        List<Integer> winnerMove = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = RacingCarGame.indexOfWinners(winnerMove);

        assertEquals(1, result.size());
        assertTrue(result.contains(4));
    }

    @Test
    void 우승자_여러명_인덱스_찾기_테스트() {
        List<Integer> winnerMove = Arrays.asList(1, 2, 3, 5, 5);
        List<Integer> result = RacingCarGame.indexOfWinners(winnerMove);

        assertEquals(2, result.size());
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertThat(result).containsExactly(3,4);

    }

    @Test
    void 우승자_한명_이름_찾기_테스트() {
        List<Integer> indices = Arrays.asList(2);
        Car cars = new Car(Arrays.asList("A", "B", "C"));
        String result = RacingCarGame.nameOfWinners(indices);

        assertEquals("C", result);
    }

    @Test
    void 우승자_여러명_이름_찾기_테스트() {
        List<Integer> indices = Arrays.asList(1, 2);
        Car cars = new Car(Arrays.asList("A", "B", "C"));
        String result = RacingCarGame.nameOfWinners(indices);

        assertEquals("B, C", result);
    }
}
