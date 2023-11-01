package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 이름의_수가_2_미만일_경우_예외가_발생한다() {
        List<String> names = List.of("a");

        assertThatThrownBy(() -> validator.validateSize(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름의_수가_100_초과일_경우_예외가_발생한다() {
        List<String> names = Collections.nCopies(101, "a");

        assertThatThrownBy(() -> validator.validateSize(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_0자일_경우_예외가_발생한다() {
        List<String> names = List.of("");

        assertThatThrownBy(() -> validator.validateNamePattern(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자_초과일_경우_예외가_발생한다() {
        List<String> names = List.of("abcdef");

        assertThatThrownBy(() -> validator.validateNamePattern(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_알파벳으로_이루어져_있지_않을_경우_예외가_발생한다() {
        List<String> names = List.of("헬로hello");

        assertThatThrownBy(() -> validator.validateNamePattern(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_중복될_경우_예외가_발생한다() {
        List<String> names = List.of("a", "a");

        assertThatThrownBy(() -> validator.validateDuplicate(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_0일_경우_예외가_발생한다() {
        int raceCount = 0;

        assertThatThrownBy(() -> validator.validateRaceCountRange(raceCount))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_100_초과일_경우_예외가_발생한다() {
        int raceCount = 101;

        assertThatThrownBy(() -> validator.validateRaceCountRange(raceCount))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
