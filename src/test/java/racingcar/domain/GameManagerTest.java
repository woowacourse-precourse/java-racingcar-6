package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameManagerTest {
    private static final List<String> EMPTY_STRING_LIST = List.of("", " ", "   ", "    ");

    @Test
    void validateRacingcarName_메서드로_Racingcar_Name_검증() {
        // given
        String racingcarName = "abcde";
        // when
        // then
        assertThat(GameManager.validateRacingcarName(racingcarName)).isTrue();
    }


    @Test
    void validateRacingcarName_메서드_사용시_Racingcar_Name이_공백이거나_null이면_예외_발생() {
        // given
        // EMPTY_STRING_LIST
        // when
        // then
        assertThatThrownBy(() -> {
            for (String racingcarName : EMPTY_STRING_LIST) {
                GameManager.validateRacingcarName(racingcarName);
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("racingcar 이름이 null이거나 비어있습니다.");
    }

    @Test
    void validateRacingcarName_메서드_사용시_Racingcar_Name이_5자_초과하면_예외_발생() {
        // given
        String racingcarName = "abcdef";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateRacingcarName(racingcarName)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("racingcar 이름이 5자를 초과합니다.");
    }

    @Test
    void validateUserInput_메서드로_User_Input_검증() {
        // given
        String userInput = "pobi,woni,crong,honux";
        // when
        // then
        assertThat(GameManager.validateUserInput(userInput)).isTrue();
    }

    @Test
    void validateUserInput_메서드_사용시_User_Input이_공백이거나_null이면_예외_발생() {
        // given
        // EMPTY_STRING_LIST
        // when
        // then
        assertThatThrownBy(() -> {
            for (String userInput : EMPTY_STRING_LIST) {
                GameManager.validateUserInput(userInput);
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유저 입력값이 null이거나 비어있습니다.");
    }

    @Test
    void validateUserInput_메서드_사용시_User_Input이_중복된_Racingcar_Name이_있으면_예외_발생() {
        // given
        String userInput = "pobi,woni,crong,pobi";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateUserInput(userInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("중복된 racingcar 이름이 있습니다.");
    }

    @Test
    void validateUserInput_메서드_사용시_User_Input에_5자_초과하는_Racingcar_Name이_있으면_예외_발생() {
        // given
        String userInput = "pobi,woni,crong,honux,abcdef";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateUserInput(userInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("racingcar 이름이 5자를 초과합니다.");
    }


}