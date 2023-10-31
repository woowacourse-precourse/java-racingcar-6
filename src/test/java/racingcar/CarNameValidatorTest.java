package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.vaildator.carNameValidator;

public class CarNameValidatorTest {

    @DisplayName("이름이 5자 이하인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pooobi", "asdfasdfa"})
    void validateInputNameSize(String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validateInputNameSize(carName));
    }

    @Test
    @DisplayName("이름을 아무것도 입력하지 않았을 때를 검증한다.")
    void validateInputName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validateInputName(""));
    }

    @Test
    @DisplayName("2명 이상 입력하였는지에 대해서 검증한다.")
    void validateMinimumCarNameCount() {
        List<String> carList = new ArrayList<>();
        carList.add("poobi");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carNameValidator.validateMinimumCarNameCount(carList));
    }

}
