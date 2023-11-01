package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Cars;
import racingcar.model.RacingResult;

class OutputViewTest {

    private final String inputCarNames = "pobi,ruby,dobbi";
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private OutputView outputView;
    private Cars cars;

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(output));
        outputView = new OutputView();
        cars = new Cars(inputCarNames);
    }

    @AfterEach
    void clean() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("이동 거리를 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "4,3,0/pobi : -ruby : dobbi :",
            "4,4,0/pobi : -ruby : -dobbi :",
            "9,8,7/pobi : -ruby : -dobbi : -"
    }, delimiter = '/')
    void testPrintProcessMessage(String numbers, String expectedMessage) {
        List<Integer> pickNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        cars.updateDistance(pickNumbers);

        outputView.printProcess(cars);
        String outputString = output.toString().replace("\n", "").strip();
        assertThat(outputString).isEqualTo(expectedMessage.strip());
    }

    @DisplayName("승자를 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "4,3,0/최종 우승자 : pobi",
            "4,4,0/최종 우승자 : pobi, ruby",
            "9,8,7/최종 우승자 : pobi, ruby, dobbi"
    }, delimiter = '/')
    void testPrintWinnerMessage(String numbers, String expectedMessage) {
        List<Integer> pickNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        cars.updateDistance(pickNumbers);
        RacingResult racingResult = new RacingResult(cars);

        outputView.printWinner(racingResult);
        String outputString = output.toString().replace("\n", "").strip();
        assertThat(outputString).isEqualTo(expectedMessage.strip());
    }
}