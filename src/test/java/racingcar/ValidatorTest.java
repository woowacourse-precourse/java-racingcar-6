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
    void 자동차_이름_쉼표로_구분되는지() {
        String input = "a, b, c";
        List<String> result = Arrays.asList("a", "b", "c");
        assertThat(validator.separateAndRemoveSpace(input)).isEqualTo(result);
    }

    @Test
    void 중복된_차가_있는지() {
        List<String> carNames = Arrays.asList("a", "a", "c");
        boolean result = true;
        assertThat(validator.existsDuplicateName(carNames)).isEqualTo(result);
    }

    @Test
    void 자동차_길이_1과_5사이인지() {
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
    void 자동차_개수_2이상인지() {
        List<String> carNames = Arrays.asList("a");
        boolean result = false;
        assertThat(validator.ensureNumberOfCars(carNames)).isEqualTo(result);
    }

    @Test
    void 자동차_예외_처리() {
        List<String> input = Arrays.asList("pobi,pobi,jun", "p, , bi", " ", "\n");

        for (String carNames : input) {
            assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validateCarNamesInput(carNames));
        }
    }

    @Test
    void 시도_횟수_1이상인지() {
        List<Integer> attempts = Arrays.asList(1, 0, 55);
        List<Boolean> result = Arrays.asList(true, false, true);

        int index = 0;
        for (Integer attempt : attempts) {
            assertThat(validator.ensureRange(attempt)).isEqualTo(result.get(index));
            index++;
        }
    }

    @Test
    void 시도_횟수_예외_처리() {
        List<String> input = Arrays.asList("10.11", "-10", "f", "0", " ", "");

        for (String attempt : input) {
            assertThatIllegalArgumentException().isThrownBy(
                () -> validator.validateCarNamesInput(attempt));
        }
    }

}
