package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputTest {

    @AfterEach
    void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field field = Console.class.getDeclaredField("scanner");
        field.setAccessible(true);
        field.set(Scanner.class, null);
    }

    @Test
    void consoleLine() {
        String message = "테스트 문구입니다.";

        String input = enterInput(message);
        customSetIn(input);
        String userInput = Input.consoleLine();

        Assertions.assertThat(userInput).isEqualTo(message);
    }

    @Test
    void consoleNumber테스트() {
        String testNumberString = "420";
        int testNumber = Integer.parseInt(testNumberString);

        String input = enterInput(testNumberString);
        customSetIn(input);
        int userInput = Input.consoleNumber();

        Assertions.assertThat(userInput).isEqualTo(testNumber);
    }

    @Test
    void 기본consoleNumbers테스트() {
        String testNumberString = "429";
        List<Integer> testNumbers = List.of(4, 2, 9);

        String input = enterInput(testNumberString);
        customSetIn(input);
        List<Integer> numbers = Input.consoleNumbers();

        Assertions.assertThat(numbers).isEqualTo(testNumbers);
    }

    @Test
    void 구분자가_들어간_consoleNumbers테스트() {
        String testNumberString = "4,2,9";
        List<Integer> testNumbers = List.of(4, 2, 9);

        String input = enterInput(testNumberString);
        customSetIn(input);
        List<Integer> numbers = Input.consoleNumbers(",");

        Assertions.assertThat(numbers).isEqualTo(testNumbers);
    }

    @Test
    void 기본_consoleStrings_테스트() {
        String testString = "안녕하세요 세상아";
        String[] expectedStrings = {"안", "녕", "하", "세", "요", " ", "세", "상", "아"};

        String input = enterInput(testString);
        customSetIn(input);
        List<String> actualStringList = Input.consoleStrings();

        Assertions.assertThat(actualStringList).containsExactly(expectedStrings);

    }

    @Test
    void 구분자가주어지는_consoleStrings_테스트() {
        String testString = "안녕하세요,세상아";
        String[] expectedStrings = {"안녕하세요", "세상아"};

        String input = enterInput(testString);
        customSetIn(input);
        List<String> actualStringList = Input.consoleStrings(",");

        Assertions.assertThat(actualStringList).containsExactly(expectedStrings);

    }

    private static String enterInput(String testString) {
        return testString + "\n";
    }

    private static void customSetIn(String input) {
        InputStream customInput =
                new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
    }

}