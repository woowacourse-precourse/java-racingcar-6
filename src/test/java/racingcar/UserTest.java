package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.User;
import racingcar.validator.UserValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("사용자가 자동차이름을 6글자 이상으로 입력할 때 예외 발생")
    void 이름_6글자_예외() {
        UserValidator validator = new UserValidator();
        assertThatThrownBy(() -> validator.CheckCarNameLength("siwonnn"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 자동차이름을 1글자 이하(공백)로 입력할 때 예외 발생")
    void 이름_공백_예외() {
        UserValidator validator = new UserValidator();
        assertThatThrownBy(() -> validator.CheckCarNameLength(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 중복의 자동차 이름을 입력할 때 예외 발생")
    void 이름_중복_예외() {
        UserValidator validator = new UserValidator();
        assertThatThrownBy(() -> validator.CheckCarNameDuplication(List.of("siwon", "siwon")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 횟수가 저장되는지 확인")
    void 게임_횟수_저장() {
        User user = new User();
        user.setGameNumber(3);
        assertThat(user.gameNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자가 시도 횟수를 공백으로 입력할 때 예외 발생")
    void 횟수_공백_예외() {
        UserValidator validator = new UserValidator();
        assertThatThrownBy(() -> validator.CheckGameNumberNull(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 시도 횟수에 숫자만 입력하지 않았을 때 예외 발생")
    void 횟수_숫자_아닐때_예외() {
        UserValidator validator = new UserValidator();
        assertThatThrownBy(() -> validator.CheckGameNumberIsNumber("1a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
