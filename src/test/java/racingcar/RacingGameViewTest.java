package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.RacingGameView.FORMAT_PRINT_ROUND;
import static racingcar.RacingGameView.FORMAT_PRINT_WINNERS;

class RacingGameViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("경주 라운드 결과 출력을 테스트한다.")
    void testPrintRoundResult() {
        //given
        RacingGameView racingGameView = new RacingGameView();
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("페라리"));
        cars.add(new RacingCar("벤츠"));

        //when
        for (int i = 0; i < 10; i++) {
            cars.forEach(RacingCar::move);
        }
        String s1 = String.format(FORMAT_PRINT_ROUND, cars.get(0).getName(), cars.get(0).getMovement());
        String s2 = String.format(FORMAT_PRINT_ROUND, cars.get(1).getName(), cars.get(1).getMovement());
        String result = s1 + s2 + "\n";
        racingGameView.printRoundResult(cars);
        String actualOutput = outContent.toString().replaceAll("\r", "");

        //then
        assertEquals(result, actualOutput);
    }

    @Test
    @DisplayName("우승자 결과 출력을 테스트한다")
    void testPrintWinnerResult() {
        //given
        RacingGameView racingGameView = new RacingGameView();
        List<RacingCar> winners = new ArrayList<>();
        winners.add(new RacingCar("페라리"));
        winners.add(new RacingCar("벤츠"));

        //when
        String result = String.format(
                FORMAT_PRINT_WINNERS,
                winners.get(0).getName() + ", " + winners.get(1).getName()
        );
        racingGameView.printWinners(winners);
        String actualOutput = outContent.toString();

        //then
        assertEquals(result, actualOutput);
    }
}