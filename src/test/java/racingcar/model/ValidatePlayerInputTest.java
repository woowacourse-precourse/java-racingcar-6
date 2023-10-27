package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("레이싱 자동차 이름이 5 초과할 경우에 대한 테스트")
    @Test
    void carNameOverLengthTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String playerInput = "pobi,suark,watermelon";
        //then
        assertThatThrownBy(() -> validatePlayerInput.validateCarNameLength(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 길이는 5이하 입니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 space가 포함될 경우 대한 테스트")
    @Test
    void containSpaceInTryCountTest() {
        //when
        ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
        //given
        String tryInput = "2 1";
        //then
        assertThatThrownBy(() -> validatePlayerInput.validatePlayerTryCountInput(tryInput))
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
        assertThatThrownBy(() -> validatePlayerInput.validatePlayerTryCountInput(tryInput))
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
        assertThatThrownBy(() -> validatePlayerInput.validatePlayerTryCountInput(containKorean))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
        assertThatThrownBy(() -> validatePlayerInput.validatePlayerTryCountInput(containEnglish))
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
        assertThatThrownBy(() -> validatePlayerInput.validatePlayerTryCountInput(containAt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
        assertThatThrownBy(() -> validatePlayerInput.validatePlayerTryCountInput(containSemiColon))
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
        List<String> carNamesList = Arrays.asList("pobi", "suhwp", "jnam", "namzi");
        //then
        List<String> convertedValues = validatePlayerInput.convertStringToListCarNames(carNames);
        assertThat(convertedValues).isEqualTo(carNamesList);
    }
}