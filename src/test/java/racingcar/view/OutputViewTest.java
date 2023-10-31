package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class OutputViewTest {

    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int MOVING_FORWARD = 4;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    OutputView outputView = new OutputView();

    private static Stream<Arguments> provideStringsForPrintResult() {

        return Stream.of(
                Arguments.of("car1", 0, "car1 : " + LINE_SEPARATOR + LINE_SEPARATOR),
                Arguments.of("car2", 3, "car2 : ---" + LINE_SEPARATOR + LINE_SEPARATOR),
                Arguments.of("car3", 10, "car3 : ----------" + LINE_SEPARATOR + LINE_SEPARATOR)
        );
    }

    private static Stream<Arguments> provideStringsForPrintResultTestByLength() {
        String fixed = "car : ";
        int fixedLength = fixed.length() + LINE_SEPARATOR.length() * 2;
        return Stream.of(
                Arguments.of("car", 0, fixedLength),
                Arguments.of("car", 3, fixedLength + 3),
                Arguments.of("car", 10, fixedLength + 10),
                Arguments.of("car", 1000, fixedLength + 1000),
                Arguments.of("car", 100000000, fixedLength + 100000000)
//                , Arguments.of("car", Integer.MAX_VALUE, fixedLength + Integer.MAX_VALUE) //메모리 초과 발생
        );
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("결과문 출력_순수 비교")
    @ParameterizedTest
    @MethodSource("provideStringsForPrintResult")
    void printResult(String name, int nProgress, String result) {
        Car car = new Car(name);
        for (int i = 0; i < nProgress; i++) {
            car.move(MOVING_FORWARD);
        }

        List<Car> list = List.of(car);
        outputView.printResult(list);

        Assertions.assertThat(output.toString()).isEqualTo(result);

    }

    @DisplayName("결과문 출력_문자열 길이로 테스트")
    @ParameterizedTest
    @MethodSource("provideStringsForPrintResultTestByLength")
    void printResultTestByLength(String name, int nProgress, int length) {
        Car car = new Car(name);
        for (int i = 0; i < nProgress; i++) {
            car.move(MOVING_FORWARD);
        }

        List<Car> list = List.of(car);
        outputView.printResult(list);

        Assertions.assertThat(output.toString().length()).isEqualTo(length);

    }

    @DisplayName("우승자가 한명인 경우 테스트")
    @Test
    void printWinner() {
        List<String> winners = List.of("pobi");

        outputView.printWinner(winners);

        Assertions.assertThat(output.toString()).isEqualTo(WINNER_MESSAGE + "pobi" + LINE_SEPARATOR);

    }

    @DisplayName("우승자가 여러명인 경우 테스트")
    @Test
    void printJointWinner() {
        List<String> winners = List.of("pobi", "woni", "jun");

        outputView.printWinner(winners);

        Assertions.assertThat(output.toString()).isEqualTo(WINNER_MESSAGE + "pobi, woni, jun" + LINE_SEPARATOR);

    }

}

