package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameValidatorTest {
    @DisplayName("이름의 적합성을 판단하는 기능")
    @ParameterizedTest
    @ValueSource(strings={"eleven","abcdef","qwerdf","111234","1q2w3e4r","","  "})
    void validateName_이름의_적합성_판단(String name){
        NameValidator validator=NameValidator.INSTANCE;

        assertThatThrownBy(()->validator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
