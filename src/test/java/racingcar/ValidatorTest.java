package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Validator;

public class ValidatorTest {

    final Validator validator = new Validator();

    @Test
    void separateAndRemoveSpace_메서드로_자동차_이름_구분() {
        String input = "a, b, c";
        List<String> result = Arrays.asList("a", "b", "c");
        assertThat(validator.separateAndRemoveSpace(input)).isEqualTo(result);
    }

    @Test
    void existsDuplicateName_메서드로_중복된_차_여부_검증() {
        List<String> carNames = Arrays.asList("a", "a", "c");
        boolean result = true;
        assertThat(validator.existsDuplicateName(carNames)).isEqualTo(result);
    }

    @Test
    void ensureLengthInRange_메서드로_자동차_길이_검증() {
        List<List<String>> carsNames = Arrays.asList(
            Arrays.asList("a", "a", "c"),
            Arrays.asList("abcdef", "g", "hij")
        );
        List<Boolean> result = Arrays.asList(true, false);

        int index = 0;
        for (List<String> carNames : carsNames) {
            assertThat(validator.ensureLengthInRange(carNames)).isEqualTo(result.get(index));
            index++;
        }
    }

    @Test
    void ensureNumberOfCars_메서드로_자동차_개수_검증() {
        List<String> carNames = Arrays.asList("a");
        boolean result = false;
        assertThat(validator.ensureNumberOfCars(carNames)).isEqualTo(result);
    }

    @Test
    void validateCarNamesInput_메서드_사용시_예외_발생() {
        List<String> input = Arrays.asList("pobi,pobi,jun", "p, , bi", " ", "\n");

        for (String carNames : input) {
            assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validateCarNamesInput(carNames));
        }
    }

    @Test
    void ensureRange_메서드로_시도_횟수_검증() {
        List<Integer> attempts = Arrays.asList(1, 0, 55);
        List<Boolean> result = Arrays.asList(true, false, true);

        int index = 0;
        for (Integer attempt : attempts) {
            assertThat(validator.ensureRange(attempt)).isEqualTo(result.get(index));
            index++;
        }
    }

    @Test
    void validateCarNamesInput_메서드_사용시_1이상의_숫자가_아닌_경우_예외_처리() {
        List<String> input = Arrays.asList("10.11", "-10", "f", "0", " ", "");

        for (String attempt : input) {
            assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validateCarNamesInput(attempt));
        }
    }

}
