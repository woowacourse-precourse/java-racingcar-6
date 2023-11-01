package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.vaildator.CarNameValidator;

public class CarNameValidatorTest {

    @DisplayName("이름이 5자 이하인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pooobi", "asdfasdfa"})
    void validateInputNameSize(String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validateInputNameSize(carName));
    }

    @Test
    @DisplayName("이름을 아무것도 입력하지 않았을 때를 검증한다.")
    void validateInputName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validateInputName(""));
    }

    @Test
    @DisplayName("2명 이상 입력하였는지에 대해서 검증한다.")
    void validateMinimumCarNameCount() {
        List<String> carList = new ArrayList<>();
        carList.add("poobi");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validateMinimumCarNameCount(carList));
    }

    @Test
    @DisplayName("중복된 이름 입력에 대해 검증한다.")
    void validateInputNameDuplication() {
        List<String> carList = new ArrayList<>();
        carList.add("pobi");
        carList.add("pobi");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validateInputNameDupication(carList));
    }

}
