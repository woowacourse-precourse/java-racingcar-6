package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.exception.RacingCarExceptionType.DUPLICATE_NAME;
import static racingcar.exception.RacingCarExceptionType.EMPTY_NAME;
import static racingcar.exception.RacingCarExceptionType.INVALID_CAR_NAME_FORMAT;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

    @DisplayName("유효한 문자열로 CarNames 객체를 성공적으로 생성한다.")
    @Test
    void createValidCarNames() {
        // given
        List<String> names = Arrays.asList("pobi", "woni", "jun");

        // when
        CarNames carNames = new CarNames(names);

        // then
        assertThat(carNames.getNames()).isEqualTo(names);
    }

    @DisplayName("빈 리스트로 CarNames 객체 생성 시 예외가 발생한다.")
    @Test
    void throwExceptionOnEmptyNameList() {
        // given
        List<String> names = Arrays.asList();

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarNames(names);
        });
        assertThat(exception.getMessage()).isEqualTo(EMPTY_NAME.getMessage());
    }

    @DisplayName("중복된 이름이 포함된 리스트로 CarNames 객체 생성 시 예외가 발생한다.")
    @Test
    void throwExceptionOnDuplicateNames() {
        // given
        List<String> names = Arrays.asList("pobi", "pobi", "jun");

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarNames(names);
        });
        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_NAME.getMessage());
    }

    @DisplayName("잘못된 형식의 이름이 포함된 리스트로 CarNames 객체 생성 시 예외가 발생한다.")
    @Test
    void throwExceptionOnInvalidNameFormat() {
        // given
        List<String> names = Arrays.asList("pobi!", "woni", "jun");

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarNames(names);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_CAR_NAME_FORMAT.getMessage());
    }

}