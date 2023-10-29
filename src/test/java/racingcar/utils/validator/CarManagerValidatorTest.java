package racingcar.utils.validator;

import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Nested
@DisplayName("[Car Manager Validator]")
class CarManagerValidatorTest {

    private List<String> makeStringCarToList(final String cars) {
        return Arrays.stream(cars.split(",", -1))
                .map(String::strip)
                .toList();
    }

    @ParameterizedTest
    @MethodSource("validCarName")
    @DisplayName("자동차들 이름 검증 - 올바른 이름 입력")
    public void isValidCarNames(final String cars) {
        Assertions.assertDoesNotThrow(() -> new CarManagerValidator().validate(this.makeStringCarToList(cars)));
    }

    static Stream<Arguments> validCarName() {
        return Stream.of(
                arguments("abc, cds, aaa"),
                arguments("abc, cds, a.aa"),
                arguments("abc,cds,aaa"),
                arguments("abc,cds,aa a"),
                arguments("abc , cds , aaa"),
                arguments("abc , cds ,        aaa")
        );
    }

    @ParameterizedTest
    @MethodSource("emptyCarName")
    @DisplayName("자동차들 이름 검증 - 자동차 이름 입력 시 비어있는 값 입력")
    public void enterEmptyCarName(final String cars) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CarManagerValidator().validate(this.makeStringCarToList(cars)));
    }

    static Stream<Arguments> emptyCarName() {
        return Stream.of(
                arguments(", ,"),
                arguments(""),
                arguments("       "),
                arguments(", cds, aaa"),
                arguments(",cds,aaa"),
                arguments(" , cds , aaa"),
                arguments("abc, , aaa"),
                arguments("abc,,aaa"),
                arguments("abc ,  , aaa"),
                arguments("abc, cds, "),
                arguments("abc,cds,"),
                arguments("abc,cds,      "),
                arguments("abc , cds , ")
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateCarName")
    @DisplayName("자동차들 이름 검증 - 중복된 차량 이름 입력")
    public void enterDuplicateCarName(final String cars) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CarManagerValidator().validate(this.makeStringCarToList(cars)));
    }

    static Stream<Arguments> duplicateCarName() {
        return Stream.of(
                arguments("abc,abc"),
                arguments("abc, abc"),
                arguments("abc   , abc, ddd")
        );
    }

}