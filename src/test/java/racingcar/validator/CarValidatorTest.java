package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarValidatorTest {
    private CarValidator carValidator;

    @BeforeEach
    void setUp() {
        carValidator = new CarValidator();
    }

    @Test
    void 자동차_이름_길이_제한() {
        List<String> carList = new ArrayList<>(Arrays.asList("apple", "melon", "watermelon"));

        assertThatThrownBy(() -> carValidator.validateCarNameLength(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름_중복() {
        List<String> carList = new ArrayList<>(Arrays.asList("apple", "melon", "grape", "melon"));

        assertThatThrownBy(() -> carValidator.validateCarNameDuplication(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 겹치지 않아야 합니다.");
    }

    @Test
    void 자동차_개수가_한개_이하() {
        List<String> carList = new ArrayList<>(Arrays.asList("car"));

        assertThatThrownBy(() -> carValidator.validateCarCount(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 두 대의 자동차가 있어야 게임이 가능합니다.");
    }
}
