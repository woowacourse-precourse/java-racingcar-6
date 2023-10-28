package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarDtos;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {
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
    void printInputCarNamesMessage() {
        OutputView outputView = new OutputView();
        outputView.printInputCarNamesMessage();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outContent.toString());
    }

    @Test
    void printInputGameTryCountMessage() {
        OutputView outputView = new OutputView();
        outputView.printInputGameTryCountMessage();
        assertEquals("시도할 회수는 몇회인가요?\n", outContent.toString());
    }

    @Test
    void printCarPositions() {
        OutputView outputView = new OutputView();
        List<CarDto> carDtos = Arrays.asList(new CarDto("car1", 3), new CarDto("car2", 5));
        CarDtos carDtosWrapper = new CarDtos(carDtos);

        outputView.printCarPositions(carDtosWrapper);

        String expectedOutput = "실행 결과\n" +
                "car1 : ---\n" +
                "car2 : -----\n" +
                "\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void printWinners() {
        OutputView outputView = new OutputView();
        List<String> winnerNames = Arrays.asList("car1", "car2");

        outputView.printWinners(winnerNames);

        String expectedOutput = "최종 우승자 : car1, car2\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
