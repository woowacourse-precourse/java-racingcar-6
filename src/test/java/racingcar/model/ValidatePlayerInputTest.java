package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class ValidatePlayerInputTest {

    @DisplayName("레이싱 자동차 이름 입력에 space가 포함되어있는 테스트")
    @Test
    void containSpaceInPlayerInputTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "pobi wonbi";
        //then
        assertThatThrownBy(() -> validatePlayerInput.validateContainSpace(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 구분은 ','로 하셔야합니다");
    }

    @DisplayName("레이싱 자동차 이름이 들어오지 않은 경우에 대한 테스트")
    @Test
    void notContainCarName() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "pobi,suhwp,,";
        validatePlayerInput.convertStringToArray(playerInput);
        //then
        assertThatThrownBy(validatePlayerInput::validateNotContainCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름이 없습니다");
    }

    @DisplayName("레이싱 자동차 이름이 5 초과할 경우에 대한 테스트")
    @Test
    void carNameOverLengthTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "pobi,suark,watermelon";
        validatePlayerInput.convertStringToArray(playerInput);
        //then
        assertThatThrownBy(validatePlayerInput::validateCarNameLength)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 길이는 5이하 입니다");
    }

    @DisplayName("레이싱 자동차 이름이 중복될 경우에 대한 테스트")
    @Test
    void carNameDuplicatedTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "pobi,suark,pobi";
        validatePlayerInput.convertStringToArray(playerInput);
        //then
        assertThatThrownBy(validatePlayerInput::validateDuplicateCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 있습니다");
    }

    @DisplayName("레이싱 자동차 이름이 한글이 경우에 대한 테스트")
    @Test
    void containKoreanCarName() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "수환,abc,qwer";
        validatePlayerInput.convertStringToArray(playerInput);
        //then
        assertThatThrownBy(validatePlayerInput::validateAlphaCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름은 영어만 허용됩니다");
    }

    @DisplayName("레이싱 자동차 이름에 숫자가 포함된 경우에 대한 테스트")
    @Test
    void containDigitCarName() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "pobi,pobi2,qwer";
        validatePlayerInput.convertStringToArray(playerInput);
        //then
        assertThatThrownBy(validatePlayerInput::validateAlphaCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름은 영어만 허용됩니다");
    }

    @DisplayName("레이싱 자동차 이름에 특수 기호가 포한된 경우에 대한 테스트")
    @Test
    void containSpecialSignInCarName() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "pobi,pobi@,qwer";
        validatePlayerInput.convertStringToArray(playerInput);
        //then
        assertThatThrownBy(validatePlayerInput::validateAlphaCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이싱 자동차 이름은 영어만 허용됩니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 space가 포함될 경우 대한 테스트")
    @Test
    void containSpaceInTryCountTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String tryInput = "2 1";
        //then
        assertThatThrownBy(() -> validatePlayerInput.validateDigitRaceCount(tryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 ',''가 포함될 경우 대한 테스트")
    @Test
    void containCommaInTryCountTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String tryInput = "2,1";
        //then
        assertThatThrownBy(() -> validatePlayerInput.validateDigitRaceCount(tryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 한글,영어가 포함될 경우 대한 테스트")
    @Test
    void containKoreanOrEnglishInTryCountTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String containKorean = "2ㅁ";
        String containEnglish = "4d";
        //then
        assertThatThrownBy(() -> validatePlayerInput.validateDigitRaceCount(containKorean))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
        assertThatThrownBy(() -> validatePlayerInput.validateDigitRaceCount(containEnglish))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 특수문자가 포함될 경우 대한 테스트")
    @Test
    void containSpecialSignInTryCountTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String containAt = "2@";
        String containSemiColon = "4;";
        //then
        assertThatThrownBy(() -> validatePlayerInput.validateDigitRaceCount(containAt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
        assertThatThrownBy(() -> validatePlayerInput.validateDigitRaceCount(containSemiColon))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("유효성 검사가 끝난 자동차 이름을 list로 변환하는 테스트")
    @Test
    void convertCarNameToListTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String carNames = "pobi,suhwp,jnam,namzi";
        validatePlayerInput.convertStringToArray(carNames);
        List<String> carNamesList = Arrays.asList("pobi", "suhwp", "jnam", "namzi");
        //then
        List<String> convertedValues = validatePlayerInput.convertStringToListCarNames();
        assertThat(convertedValues).isEqualTo(carNamesList);
    }
}