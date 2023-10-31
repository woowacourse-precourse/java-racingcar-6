package racingcar.view;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.CarName;
import racingcar.domain.CarNames;
import racingcar.domain.MoveCount;

public class InputViewTest {

    @ParameterizedTest
    @MethodSource
    void 자동차_이름_입력이_정상인지_검증(String input) {
        //given
        //when
        Throwable normal = catchThrowable(() -> {
            CarNames.fromInput(input);
        });
        //then
        assertThat(normal).doesNotThrowAnyException();
    }

    private static Stream<Arguments> 자동차_이름_입력이_정상인지_검증() {
        return Stream.of(
                Arguments.of("name1,name2,name3"),
                Arguments.of("1,2,3"),
                Arguments.of("김,이,박"),
                Arguments.of("a,b,c"),
                Arguments.of("1김a,2이b,3박c")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 중복된_자동차_이름_입력일때_예외처리(String input) {
        //given
        //when
        Throwable duplicatedResult = catchThrowable(() -> {
            CarNames.fromInput(input);
        });
        //then
        assertThat(duplicatedResult).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 중복된_자동차_이름_입력일때_예외처리() {
        return Stream.of(
                Arguments.of("name1,name1,name3"),
                Arguments.of("1,2,2"),
                Arguments.of("김,이,김"),
                Arguments.of("a,c,c"),
                Arguments.of("3박c,2이b,3박c")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 입력된_자동차_이름이_주어진_길이를_넘길때_예외처리(String sizeOverInput) {
        //given
        //when
        Throwable sizeOver = catchThrowable(() -> new CarName(sizeOverInput));
        //then
        assertThat(sizeOver).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 입력된_자동차_이름이_주어진_길이를_넘길때_예외처리() {
        return Stream.of(
                Arguments.of("sizeOver"),
                Arguments.of("sizeOverName"),
                Arguments.of("sizeOverNameSizeOverName"),
                Arguments.of("length"));
    }

    @ParameterizedTest
    @MethodSource
    void 입력된_자동차_이름이_특수문자를_포함할때_예외처리(String normalName) {
        //given
        //when
        Throwable specialCharacters = catchThrowable(() -> new CarName(normalName));

        //then
        assertThat(specialCharacters).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 입력된_자동차_이름이_특수문자를_포함할때_예외처리() {
        return Stream.of(
                Arguments.of("."),
                Arguments.of(";"),
                Arguments.of(" "),
                Arguments.of("")
        );
    }


    @ParameterizedTest
    @MethodSource
    void 입력된_이동횟수가_정상인지_검증(String input) {
        //given
        //when
        Throwable normal = catchThrowable(() -> MoveCount.fromInput(input));
        //then
        assertThat(normal).doesNotThrowAnyException();
    }

    private static Stream<Arguments> 입력된_이동횟수가_정상인지_검증() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("10"),
                Arguments.of("100"),
                Arguments.of("1000")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 입력된_이동횟수가_범위를_벗어난_값일때_예외처리(String input) {
        //given
        //when
        Throwable sizeOverResult = catchThrowable(() -> MoveCount.fromInput(input));
        //then
        assertThat(sizeOverResult).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 입력된_이동횟수가_범위를_벗어난_값일때_예외처리() {
        return Stream.of(
                Arguments.of("10001"),
                Arguments.of("100000"),
                Arguments.of("1000000"),
                Arguments.of("10000000")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 입력된_이동횟수가_특수문자일때_예외처리(String input) {
        //given
        //when
        Throwable specialCharacters = catchThrowable(() -> MoveCount.fromInput(input));
        //then
        assertThat(specialCharacters).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 입력된_이동횟수가_특수문자일때_예외처리() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of(" "),
                Arguments.of(","),
                Arguments.of("")
        );
    }

}
