package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.util.GameConstants.CAR_NAME_DELIMITER;
import static racingcar.util.GameConstants.COUNT_OF_CAR;
import static racingcar.util.GameConstants.MAXIMUM_CAR_NAME_LENGTH;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.validator.carName.CarNameValidatorImpl;

public class InputTest {

    static CarNameValidatorImpl carNameValidator;

    @BeforeEach
    void beforeEach() {
        carNameValidator = new CarNameValidatorImpl();
    }

    @Test
    @DisplayName("세 개의 이름을 입력받을 경우 테스트를 통과한다.")
    public void 세_개의_이름을_입력받을_경우_테스트를_통과한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CAR; i++) {
            char name = (char) ('a' + i);
            strings.add(Character.toString(name));
        }
        final String input = String.join(CAR_NAME_DELIMITER, strings);

        // when & then
        assertThatNoException(() -> carNameValidator.validateCount(input));
    }

    @Test
    @DisplayName("네 개의 이름을 입력받을 경우 예외를 반환한다.")
    public void 네_개의_이름을_입력받을_경우_예외를_반환한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= COUNT_OF_CAR; i++) {
            char name = (char) ('a' + i);
            strings.add(Character.toString(name));
        }
        final String input = String.join(CAR_NAME_DELIMITER, strings);

        // when & then
        assertThatIllegalArgumentException(() -> carNameValidator.validateCount(input));
    }

    @Test
    @DisplayName("공백을 입력받을 경우 예외를 반환한다.")
    public void 공백을_입력받을_경우_예외를_반환한다() {
        // given
        // when & then
        assertThatIllegalArgumentException(() -> carNameValidator.validateCount(""));
    }

    @Test
    @DisplayName("형식을 벗어난 경우 예외를 반환한다.")
    public void 형식을_벗어난_경우_예외를_반환한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CAR; i++) {
            char name = (char) ('a' + i);
            strings.add(Character.toString(name));
        }
        final String input = String.join(CAR_NAME_DELIMITER, strings) + CAR_NAME_DELIMITER;

        // when & then
        assertThatIllegalArgumentException(() -> carNameValidator.validateCount(input));
    }

    @Test
    @DisplayName("이름의 길이가 범위 내일 경우 테스트를 통과한다.")
    public void 이름이_길이가_범위_내일_경우_테스트를_통과한다() {
        // given
        // when & then
        assertThatNoException(() -> carNameValidator.validateLength("a"));
    }

    @Test
    @DisplayName("이름의 길이가 0일 경우 예외를 반환한다.")
    public void 이름이_길이가_0일_경우_예외를_반환한다() {
        // given
        // when & then
        assertThatIllegalArgumentException(() -> carNameValidator.validateLength(""));
    }

    @Test
    @DisplayName("이름의 길이가 범위 밖일 경우 예외를 반환한다.")
    public void 이름이_길이가_범위_밖일_경우_예외를_반환한다() {
        // given
        String carName = "";
        for (int i = 0; i <= MAXIMUM_CAR_NAME_LENGTH; i++) {
            carName += "a";
        }
        final String finalCarName = carName;

        // when & then=
        assertThatIllegalArgumentException(() -> carNameValidator.validateLength(finalCarName));
    }

    @Test
    @DisplayName("서로 다른 이름을 가졌을 경우 테스트를 통과한다.")
    public void 서로_다른_이름을_가졌을_경우_테스트를_통과한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CAR; i++) {
            char name = (char) ('a' + i);
            strings.add(Character.toString(name));
        }
        final String input = String.join(CAR_NAME_DELIMITER, strings);

        // when & then
        assertThatNoException(() -> carNameValidator.validateDuplicate(input));
    }

    @Test
    @DisplayName("서로 같은 이름을 가졌을 경우 예외를 반환한다.")
    public void 서로_같은_이름을_가졌을_경우_예외를_반환한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CAR; i++) {
            char name = 'a';
            strings.add(Character.toString(name));
        }
        final String input = String.join(CAR_NAME_DELIMITER, strings);

        // when & then
        assertThatIllegalArgumentException(() -> carNameValidator.validateDuplicate(input));
    }
}
