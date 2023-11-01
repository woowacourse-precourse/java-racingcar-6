package manager;

import custom_object.Car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;


public class GameManagerTest {
    ByteArrayOutputStream captor = new ByteArrayOutputStream();
    PrintStream standardOut = System.out;

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @MethodSource("progressMatchTestArguments")
    @DisplayName("progressMatchTest")
    public void progressMatchTest(int numberOfMatch, int[] answerArray) {
        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("test1"), new Car("test2")));
        GameManager gameManager = new GameManager(carList);
        int[] result = new int[2];

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < numberOfMatch; i++) {
                        gameManager.progressMatch();
                    }

                    for (int i = 0; i < result.length; i++) {
                        result[i] = carList.get(i).getPosition();
                    }
                    assertThat(result).isEqualTo(answerArray);
                },
                4, 3, 3, 3, 4, 4
        );
    }

    public static Stream<Arguments> progressMatchTestArguments() {
        return Stream.of(
                Arguments.of(1, new int[]{1, 0}),
                Arguments.of(2, new int[]{1, 0}),
                Arguments.of(3, new int[]{2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("outputCurrentPositionTestArguments")
    @DisplayName("outputCurrentPositionTest")
    public void outputCurrentPositionTest(int numberOfMatch, String answer) {
        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("test1"), new Car("test2")));
        GameManager gameManager = new GameManager(carList);

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < numberOfMatch; i++) {
                        gameManager.progressMatch();
                    }

                    gameManager.outputCurrentPosition();

                    assertThat(captor.toString().trim().replaceAll("(\r\n|\r|\n|\n\r)", ",")).isEqualTo(answer);
                },
                4, 3, 3, 3, 4, 4
        );
    }

    public static Stream<Arguments> outputCurrentPositionTestArguments() {
        return Stream.of(
                Arguments.of(1, "test1 : -,test2 :"),
                Arguments.of(2, "test1 : -,test2 :"),
                Arguments.of(3, "test1 : --,test2 : -")
        );
    }

    @ParameterizedTest
    @MethodSource("outputWinnerTestArguments")
    @DisplayName("outputWinnerTest")
    public void outputWinnerTest(int numberOfMatch, String answer) {
        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("test1"), new Car("test2")));
        GameManager gameManager = new GameManager(carList);

        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < numberOfMatch; i++) {
                        gameManager.progressMatch();
                    }

                    gameManager.outputWinner();

                    assertThat(captor.toString().trim()).isEqualTo(answer);
                },
                4, 3, 3, 3, 4, 4
        );
    }

    public static Stream<Arguments> outputWinnerTestArguments() {
        return Stream.of(
                Arguments.of(1, "최종 우승자 : test1"),
                Arguments.of(2, "최종 우승자 : test1"),
                Arguments.of(3, "최종 우승자 : test1")
        );
    }
}
