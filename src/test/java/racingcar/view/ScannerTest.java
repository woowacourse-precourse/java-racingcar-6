package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static racingcar.configurations.ErrorMessages.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ScannerTest {
    String carNames = "pobi,woni,jun";
    String car1 = "pobi";
    String car2 = "woni";
    String car3 = "jun";
    String numberOfRounds = "5";
    String invalidCarName = "verylong";
    String invalidNumberOfRounds1 = "a";
    String invalidNumberOfRounds2 = "0";
    private Scanner scanner;
    private InputStream originalSystemIn;

    ByteArrayInputStream inputStream;

    void beforEach() {
        scanner = Scanner.getInstance();
        originalSystemIn = System.in;
    }

    void setInputStream(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    void afterEach() {
        Console.close();
        System.setIn(originalSystemIn);
    }

    @Test
    public void testInputCarNames() {
        beforEach();
        setInputStream(carNames);

        List<String> carNames = scanner.inputCarNames();
        assertEquals(3, carNames.size());
        assertEquals(car1, carNames.get(0));
        assertEquals(car2, carNames.get(1));
        assertEquals(car3, carNames.get(2));

        afterEach();
    }

    @Test
    public void testInputNumberOfRounds() {
        beforEach();
        setInputStream(numberOfRounds);

        assertEquals(Integer.parseInt(numberOfRounds), scanner.inputNumberOfRounds());

        afterEach();
    }

    @Test
    public void testValidateCarName_invalidLengthOfCarName() {
        beforEach();
        setInputStream(invalidCarName);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> scanner.inputCarNames());
        assertThat(exception.getMessage()).isEqualTo(INVALID_CAR_NAME_LENGTH_MESSAGE.get());

        afterEach();
    }

    @Test
    public void testValidateInputNumber_InvalidNumberOfRound_noInteger() {
        beforEach();
        setInputStream(invalidNumberOfRounds1);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> scanner.inputNumberOfRounds());
        assertThat(exception.getMessage()).isEqualTo(INVALID_NUMBER_OF_ROUNDS_INPUT_MESSAGE.get());

        afterEach();
    }
    @Test
    public void testValidateInputNumber_InvalidNumberOfRound_noNaturalNumber() {
        beforEach();
        setInputStream(invalidNumberOfRounds2);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> scanner.inputNumberOfRounds());
        assertThat(exception.getMessage()).isEqualTo(INVALID_NUMBER_OF_ROUNDS_MESSAGE.get());

        afterEach();
    }
}

