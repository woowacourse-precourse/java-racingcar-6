package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.util.GameConstants.COUNT_OF_CAR;
import static racingcar.util.GameConstants.MAXIMUM_CAR_NAME_LENGTH;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.validator.carName.CarNameValidatorImpl;

public class CarNameInputTest {

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
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then
        assertThatNoException().isThrownBy(() -> carNameValidator.validateCount(input));
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
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> carNameValidator.validateCount(input));
    }

    @Test
    @DisplayName("공백을 입력받을 경우 예외를 반환한다.")
    public void 공백을_입력받을_경우_예외를_반환한다() {
        // given
        List<String> strings = new ArrayList<>();
        strings.add("");
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> carNameValidator.validateCount(input));
    }

    @Test
    @DisplayName("이름의 길이가 최소 길이 이상일 경우 테스트를 통과한다.")
    public void 이름이_길이가_최소_길이_이상일_경우_테스트를_통과한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CAR; i++) {
            char name = (char) ('a' + i);
            strings.add(Character.toString(name));
        }
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then
        assertThatNoException().isThrownBy(() -> carNameValidator.validateLength(input));
    }

    @Test
    @DisplayName("이름의 길이가 최소 길이 미만인 경우 예외를 반환한다.")
    public void 이름이_길이가_최소_길이_미만인_경우_예외를_반환한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CAR - 1; i++) {
            char name = (char) ('a' + i);
            strings.add(Character.toString(name));
        }
        strings.add("");
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> carNameValidator.validateLength(input));
    }

    @Test
    @DisplayName("이름의 길이가 최대 길이 초과인 경우 예외를 반환한다.")
    public void 이름이_길이가_최대_길이_초과인_경우_예외를_반환한다() {
        // given
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CAR - 1; i++) {
            char name = (char) ('a' + i);
            strings.add(Character.toString(name));
        }
        String overString = "";
        for (int i = 0; i < MAXIMUM_CAR_NAME_LENGTH + 1; i++) {
            overString += "a";
        }
        strings.add(overString);
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then=
        assertThatIllegalArgumentException().isThrownBy(() -> carNameValidator.validateLength(input));
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
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then
        assertThatNoException().isThrownBy(() -> carNameValidator.validateDuplicate(input));
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
        final String[] input = strings.toArray(new String[strings.size()]);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> carNameValidator.validateDuplicate(input));
    }
}
