package racingcarv2.view;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputViewTest extends IOTest {
    private void inputGeneratedString(String userInput) {
        setInGeneratedInputStream(generateInputStream(userInput));
        InputView.inputCarNames();
    }

    private static Stream<Arguments> generateEmptyString() {
        return Stream.of(
                Arguments.of("  ,   , "),
                Arguments.of("  ")
        );
    }

    @ParameterizedTest
    @MethodSource("generateEmptyString")
    void 아무것도_입력하지_않은_경우_예외_발생(String nothing) {
        Assertions.assertThatThrownBy(
                        () -> {
                            inputGeneratedString(nothing);
                        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("아무것도");
    }



    private static Stream<Arguments> generateWrongString() {
        return Stream.of(
                Arguments.of("honi1, liㅎ, ku@"),
                Arguments.of("holi, linm!, liu"),
                Arguments.of("한국,한국,한국어")
        );
    }

    @ParameterizedTest
    @MethodSource("generateWrongString")
    void 영문자_이름이_아닌_경우_예외_발생(String wrongInput) {
        Assertions.assertThatThrownBy(
                        () -> {
                            inputGeneratedString(wrongInput);
                        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("형식에");
    }

    private static Stream<Arguments> generateEnglishPattern() {
        return Stream.of(
                Arguments.of("os,genius,samsung"),
                Arguments.of("kor,kor,kor"),
                Arguments.of("hobi, sameslif, abcdefghi"),
                Arguments.of("hobi, woni, juni")
        );
    }

    @ParameterizedTest
    @MethodSource("generateEnglishPattern")
    void 영문자_조건만_만족하면_성공(String englishName) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(
                () -> {
                    inputGeneratedString(englishName);
                }
        );
    }

    private void inputGeneratedNumber(String inputNumber) {
        setInGeneratedInputStream(generateInputStream(inputNumber));
        InputView.inputRoundTotal();
    }

    private static Stream<Arguments> generateUnvalidNumber() {
        return Stream.of(
                Arguments.of("abc-"),
                Arguments.of("012")
        );
    }

    @ParameterizedTest
    @MethodSource("generateUnvalidNumber")
    void 수가_아닌_경우_예외_발생(String wrongNumber) {
        Assertions.assertThatThrownBy(
                () -> {
                    inputGeneratedNumber(wrongNumber);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateValidNumber() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("12")
        );
    }

    @ParameterizedTest
    @MethodSource("generateValidNumber")
    void Zero로_시작하지_않는_수를_입력하면_성공(String validNumber) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(
                () -> {
                    inputGeneratedNumber(validNumber);
                }
        );
    }
}
