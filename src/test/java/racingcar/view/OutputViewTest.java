package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarDto;

class OutputViewTest {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String ROUND_REG_EX = " : ";
    private static final String POSITION_EXPRESSION = "-";
    private static final String WINNER_EXPRESSION = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 실행_결과_메시지를_출력() {
        OutputView.printResultMessage();

        Assertions.assertThat(outputStream.toString())
                .hasToString(EXECUTION_RESULT + System.lineSeparator());
    }

    @Test
    void 라운드_별_메시지를_출력() {
        List<CarDto> cars = Arrays.asList(new CarDto("base", 5), new CarDto("jerry", 3));
        String roundResultMessage = cars.stream()
                .map(car -> car.name() + ROUND_REG_EX + POSITION_EXPRESSION.repeat(car.position())
                        + System.lineSeparator())
                .collect(Collectors.joining());
        roundResultMessage += System.lineSeparator();
        OutputView.printRoundResult(cars);

        Assertions.assertThat(outputStream.toString()).hasToString(roundResultMessage);
    }

    @Test
    void 우승자_한명일_때_출력() {
        List<String> winners = List.of("base");
        String winnerMessage = WINNER_EXPRESSION + String.join(WINNER_DELIMITER, winners);
        OutputView.printResult(winners);

        Assertions.assertThat(outputStream.toString()).hasToString(winnerMessage);
    }

    @Test
    void 우승자가_여러명일_때_출력() {
        List<String> winners = List.of("base", "jerry", "tom");
        String winnerMessage = WINNER_EXPRESSION + String.join(WINNER_DELIMITER, winners);
        OutputView.printResult(winners);

        Assertions.assertThat(outputStream.toString()).hasToString(winnerMessage);
    }
}