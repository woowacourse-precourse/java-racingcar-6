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
    void existsDuplicateName_메서드로_중복된_차_여부_검증() {
        List<String> carNames = Arrays.asList("a", "a", "c");
        boolean result = true;
        assertThat(validator.existsDuplicateName(carNames)).isEqualTo(result);
    }

    @Test
    void isBiggerThanMaxCarLength_메서드로_자동차_길이_검증() {
        List<List<String>> carsNames = Arrays.asList(
                Arrays.asList("a", "a", "c"),
                Arrays.asList("abcdef", "g", "hij")
        );
        List<Boolean> result = Arrays.asList(false, true);

        int index = 0;
        for (List<String> carNames : carsNames) {
            assertThat(validator.isBiggerThanMaxCarLength(carNames))
                    .isEqualTo(result.get(index));
            index++;
        }
    }

    @Test
    void isSmallerThanMinCarNumber_메서드로_자동차_개수_검증() {
        List<String> carNames = Arrays.asList("a");
        boolean result = true;
        assertThat(validator.isSmallerThanMinCarNumber(carNames)).isEqualTo(result);
    }

    @Test
    void validateCarNames_메서드_사용시_예외_발생() {
        List<List<String>> input = Arrays.asList(
                Arrays.asList("pobi", "pobi", "jun"),
                Arrays.asList("p", "", "bi"),
                Arrays.asList("abcdefg", "ab"),
                Arrays.asList("abc"));

        for (List<String> cars : input) {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> validator.validateCarNames(cars));
        }
    }

    @Test
    void isNotNumber_메서드로_시도_횟수_숫자_여부_검증() {
        List<String> rounds = Arrays.asList(" ", ".", "!!");
        List<Boolean> result = Arrays.asList(true, true, true);

        int index = 0;
        for (String round : rounds) {
            assertThat(validator.isNotNumber(round))
                    .isEqualTo(result.get(index));
            index++;
        }
    }

    @Test
    void isSmallerThanMinRoundNumber_메서드로_시도_횟수_범위_검증() {
        List<String> rounds = Arrays.asList("1", "0", "55");
        List<Boolean> result = Arrays.asList(false, true, false);

        int index = 0;
        for (String round : rounds) {
            assertThat(validator.isSmallerThanMinRoundNumber(round))
                    .isEqualTo(result.get(index));
            index++;
        }
    }

    @Test
    void validateRounds_메서드_사용시_1이상의_숫자가_아닌_경우_예외_처리() {
        List<String> input = Arrays.asList("10.11", "-10", "f", "0", " ", "");

        for (String rounds : input) {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> validator.validateRounds(rounds));
        }
    }

}
