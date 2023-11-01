package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.RacingGameView.FORMAT_PRINT_ROUND;

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

    @ParameterizedTest
    @ValueSource(strings = {"a,ab,abc,abcd,abcde", "1,12,안녕,abc"})
    @DisplayName("입력받은 자동차의 이름이 정상적인 값만 들어오는 경우를 테스트.")
    void testValidateCarNames(String value) {
        //given
        RacingGameView racingGameView = new RacingGameView();
        //then
        assertDoesNotThrow(() -> racingGameView.validateCarNames(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "a,ab,abc,abcd,abcde,abcdef"})
    @DisplayName("입력받은 자동차의 이름 중 5글자를 초과하는 이름이 있으면 에러를 발생시킨다.")
    void testValidateCarNamesOver(String value) {
        //given
        RacingGameView racingGameView = new RacingGameView();
        //then
        assertThrows(IllegalArgumentException.class, () -> racingGameView.validateCarNames(value));
    }

    @Test
    @DisplayName("라운드 입력시 유효한 숫자면 예외가 발생하지 않는다")
    void testValidPositiveNumber() {
        String validInput = "42";
        RacingGameView racingGameView = new RacingGameView();

        assertDoesNotThrow(() -> racingGameView.validatePositiveNumber(validInput));
    }

    @Test
    @DisplayName("라운드 입력시 0 이하의 숫자 입력이 발생하면 예외")
    void testZeroOrNegativeInput() {
        String invalidInput = "0";
        RacingGameView racingGameView = new RacingGameView();

        assertThrows(IllegalArgumentException.class, () -> racingGameView.validatePositiveNumber(invalidInput));
    }

    @Test
    @DisplayName("라운드 입력시 숫자가 아닌 입력이 발생하면 예외")
    void testNonNumericInput() {
        String invalidInput = "abc";
        RacingGameView racingGameView = new RacingGameView();

        assertThrows(IllegalArgumentException.class, () -> racingGameView.validatePositiveNumber(invalidInput));
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
}