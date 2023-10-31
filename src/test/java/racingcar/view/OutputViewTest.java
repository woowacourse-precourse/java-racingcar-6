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
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    OutputView outputView = new OutputView();

    private static Stream<Arguments> provideStringsForPrintResult() {

        String lineSeparator = System.lineSeparator();
        return Stream.of(
                Arguments.of("car1", 0, "car1 : " + lineSeparator + lineSeparator),
                Arguments.of("car2", 3, "car2 : ---" + lineSeparator + lineSeparator),
                Arguments.of("car3", 10, "car3 : ----------" + lineSeparator + lineSeparator)
        );
    }

    private static Stream<Arguments> provideStringsForPrintResultTestByLength() {
        int fixedLength = 6;
        int separatorLength = System.lineSeparator().length();
        return Stream.of(
                Arguments.of("car", 0, 0 + fixedLength + separatorLength + separatorLength),
                Arguments.of("car", 3, 3 + fixedLength + separatorLength + separatorLength),
                Arguments.of("car", 10, 10 + fixedLength + separatorLength + separatorLength),
                Arguments.of("car", 1000, 1000 + fixedLength + separatorLength + separatorLength),
                Arguments.of("car", 100000000, 100000000 + fixedLength + separatorLength + separatorLength)
//                , Arguments.of("car", Integer.MAX_VALUE, Integer.MAX_VALUE + fixedLength + separatorLength) //오류 발생
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
            car.move(4);
        }

        List<Car> list = List.of(car);
        outputView.printResult(list);

        Assertions.assertThat(output.toString()).isEqualTo(result);

    }

    @DisplayName("결과문 출력_문자열 길이로 테스트")
    @ParameterizedTest
    @MethodSource("provideStringsForPrintResultTestByLength")
    void printResultTestByLength(String name, int nProgress, int result) {
        Car car = new Car(name);
        for (int i = 0; i < nProgress; i++) {
            car.move(4);
        }

        List<Car> list = List.of(car);
        outputView.printResult(list);

        Assertions.assertThat(output.toString().length()).isEqualTo(result);


    }

    @DisplayName("우승자가 한명인 경우 테스트")
    @Test
    void printWinner() {
        String lineSeparator = System.lineSeparator();
        List<String> winners = List.of("pobi");

        outputView.printWinner(winners);

        Assertions.assertThat(output.toString()).isEqualTo(WINNER_MESSAGE + "pobi" + lineSeparator);


    }

    @DisplayName("우승자가 여러명인 경우 테스트")
    @Test
    void printJointWinner() {
        String lineSeparator = System.lineSeparator();
        List<String> winners = List.of("pobi", "woni", "jun");

        outputView.printWinner(winners);

        Assertions.assertThat(output.toString()).isEqualTo(WINNER_MESSAGE + "pobi, woni, jun" + lineSeparator);


    }

}

