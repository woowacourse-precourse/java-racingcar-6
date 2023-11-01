package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Constants;
import racingcar.util.InputValidation;

public class InputTest {

    private final InputValidation inputValidation = new InputValidation();
    private final String blank = " ";

    @ParameterizedTest
    @ValueSource(strings = { blank+",가희,깨위" ,"가희,"+blank+",휘", "가희,휘,"+blank })
    void 공백_자동차_입력_오류_테스트(String string) {
        assertThatThrownBy(() -> inputValidation.checkNameInputValid(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.HAS_BLANK_IN_NAME.constant);
    }

    @ParameterizedTest
    @ValueSource(strings = { "가희,가희", "깨위,깨위", "휘,휘" })
    void 같은_이름을_가진_자동차_오류_테스트(String string) {
        assertThatThrownBy(() -> inputValidation.checkNameInputValid(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.HAS_DUPLICATE_NAME.constant);
    }

    @ParameterizedTest
    @ValueSource(strings = { "가희", "개휘", "깨위" })
    void 자동차_1개이하_입력_오류_테스트(String string) {
        assertThatThrownBy(() -> inputValidation.checkNameInputValid(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.NOT_MATCH_MINIMUM_CAR_SIZE.constant);
    }
}
