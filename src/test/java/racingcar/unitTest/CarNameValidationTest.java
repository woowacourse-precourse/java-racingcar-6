package racingcar.unitTest;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.vo.CarName;
import racingcar.validation.NameValidator;

public class CarNameValidationTest {

    private NameValidator nameValidator;

    @BeforeEach
    void setUp() {
        nameValidator = new NameValidator();
    }

    @Test
    void should_throwException_when_hasNotComma() {
        // given
        String carName = "park;kim";
        // when & then
        assertThatThrownBy(() -> nameValidator.validate(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자는 최대 2명 이상입니다.");
    }

    @Test
    void should_throwException_when_LessThan5() {
        // given
        List<CarName> carNameGroup = new ArrayList<>();
        carNameGroup.add(new CarName("sanghyeok"));
        carNameGroup.add(new CarName("parksanghyeok"));
        // when & then
        assertThatThrownBy(() -> nameValidator.validate(carNameGroup))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이내여야 합니다.");
    }

    @Test
    void should_throwException_when_isBlank() {
        // given
        List<CarName> carNameGroup = new ArrayList<>();
        carNameGroup.add(new CarName(""));
        carNameGroup.add(new CarName(null));
        // when & then
        assertThatThrownBy(() -> nameValidator.validate(carNameGroup))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 빈 값이 들어올 수 없습니다.");
    }
}
