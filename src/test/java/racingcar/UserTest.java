package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.User;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    @DisplayName("사용자가 자동차이름을 6글자 이상으로 입력할 때 예외 발생")
    void 이름_6글자_예외() {
        CarNameValidator validator = new CarNameValidator();
        assertThatThrownBy(() -> validator.CheckCarNameLength("siwonnn"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 자동차이름을 1글자 이하(공백)로 입력할 때 예외 발생")
    void 이름_공백_예외() {
        CarNameValidator validator = new CarNameValidator();
        assertThatThrownBy(() -> validator.CheckCarNameLength(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 중복의 자동차 이름을 입력할 때 예외 발생")
    void 이름_중복_예외() {
        CarNameValidator validator = new CarNameValidator();
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
}
