package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MainTest {
    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testRacing() {

        CarNames carNames = Mockito.mock(CarNames.class);
        Moving moving = Mockito.mock(Moving.class);
        Generator generator = Mockito.mock(Generator.class);

        List<String> carList = new ArrayList<>();
        carList.add("Car1");
        carList.add("Car2");

        when(carNames.inputCarNames()).thenReturn(carList);
        when(moving.inputMovingNumber()).thenReturn(5);
        when(generator.numberGenerator()).thenReturn(4);

        main.carNames = carNames;
        main.moving = moving;
        main.generator = generator;

        List<Integer> winCount = new ArrayList<>(Collections.nCopies(carList.size(), 0));

        main.racing(carList.size(), winCount, carList, 5);

        assertEquals(5, winCount.get(0).intValue());
        assertEquals(5, winCount.get(1).intValue());
    }

    @Test
    void testJudgeWinner() {
        List<Integer> winCount = new ArrayList<>();
        winCount.add(3);
        winCount.add(5);
        winCount.add(5);

        main = new Main();
        List<Integer> winners = main.judgeWinner(winCount.size(), winCount);

        assertEquals(2, winners.size());
        assertEquals(1, winners.get(0));
        assertEquals(2, winners.get(1));
    }
}