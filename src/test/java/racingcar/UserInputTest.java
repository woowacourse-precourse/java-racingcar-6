package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.AppConstants;
import racingcar.controller.UserInputHandler;
import racingcar.utils.InputValidationUtil;

import java.util.List;

public class UserInputTest {

    private UserInputHandler userInputHandler;

    @BeforeEach
    void setUp() {
        userInputHandler = new UserInputHandler();
    }

    @ParameterizedTest
    @ValueSource(strings = {"istoLongMessage", "car1,car123,car3", "car3,car5,car666"})
    void 입력_자동차이름_길이제한체크 (String str) {
        //given
        List<String> nameList = List.of(str.split(AppConstants.INPUT_DELIMITER));
        //when
        //then
        Assertions.assertThatThrownBy(() -> InputValidationUtil.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_INVALID_NAME_LENGTH);
    }
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car1", "car1,car1,car1", "car2,car2,car1"})
    void 입력_자동차이름_중복체크 (String str) {
        //given
        List<String> nameList = List.of(str.split(AppConstants.INPUT_DELIMITER));
        //when
        //then
        Assertions.assertThatThrownBy(() -> InputValidationUtil.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_DUPLICATE_NAME_EXISTS);

    }
    @ParameterizedTest
    @ValueSource(strings = {",car2,car1", "car1,,car4"})
    void 입력_자동차이름_공백체크 (String str) {
        //given
        List<String> nameList = List.of(str.split(AppConstants.INPUT_DELIMITER));
        //when
        //then
        Assertions.assertThatThrownBy(() -> InputValidationUtil.validateCarNameList(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_NAME_CANNOT_BE_BLANK);

    }

    @ParameterizedTest
    @ValueSource(strings = {"한글1","abc", "숫자" })
    void 입력_라운드횟수_숫자검증 (String str) {
        Assertions.assertThatThrownBy(() -> InputValidationUtil.validateAndParseRound(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_INVALID_ROUND_NUMBER);

    }
    @Test
    void 입력_라운드횟수_0입력 () {
        Assertions.assertThatThrownBy(() -> InputValidationUtil.validateAndParseRound("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_INVALID_ROUND_LOWER);

    }
    @Test
    void 입력_라운드횟수_빈값체크 () {
        String str = "";
        Assertions.assertThatThrownBy(() -> InputValidationUtil.validateAndParseRound(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AppConstants.ERR_ROUND_CANNOT_BE_BLANK);

    }
}
