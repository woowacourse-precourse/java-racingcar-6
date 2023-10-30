package racingcar.output;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.game.Car;
import racingcar.game.Racing;

public class OutputManagerTest {
    ByteArrayOutputStream outputStream;
    String carNames;
    Racing racing;
    List<Car> racingCars;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        carNames = "pobi,woni,jun";
        racing = new Racing(carNames);
        racingCars = racing.getRacingCars();
    }

    @Test
    void printRacingStatus_레이싱_상황을_제대로_출력하는지() {
        racingCars.get(0).moveForward();
        racingCars.get(0).moveForward();
        racingCars.get(1).moveForward();
        racingCars.get(2).moveForward();
        OutputManager.printRacingStatus(racing);
        String expectedOutput = "pobi : --\n" + "woni : -\n" + "jun : -\n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void printRacingResult_우승자가_한_명인_경우_레이싱_결과를_제대로_출력하는지() {
        racingCars.get(0).moveForward();
        racingCars.get(0).moveForward();
        racingCars.get(1).moveForward();
        racingCars.get(2).moveForward();
        racing.determineWinningCars();
        OutputManager.printRacingResult(racing);
        String expectedOutput = "최종 우승자 : pobi\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void printRacingResult_우승자가_여러_명인_경우_레이싱_결과를_제대로_출력하는지() {
        racingCars.get(0).moveForward();
        racingCars.get(0).moveForward();
        racingCars.get(1).moveForward();
        racingCars.get(2).moveForward();
        racingCars.get(2).moveForward();
        racing.determineWinningCars();
        OutputManager.printRacingResult(racing);
        String expectedOutput = "최종 우승자 : pobi, jun\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}