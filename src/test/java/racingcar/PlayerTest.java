package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player player = new Player();

    @Test
    @DisplayName("예외) 자동차 이름을 하나만 입력했을 때")
    void 이름_하나_입력_예외() {
        assertThatThrownBy(() -> player.validateInputCarNames("subin"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 하나만 입력되었습니다.");

    }

    @Test
    @DisplayName("예외) 입력에 공백이 있을 때")
    void 입력_공백_예외() {
        assertThatThrownBy(() -> player.validateInputCarNames("subin, jinju"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 공백이 존재합니다.");
    }

    @Test
    @DisplayName("예외) 이름이 5자를 초과했을 때")
    void 이름_글자수_초과_예외() {
        assertThatThrownBy(() -> player.validateInputCarNames("subin,gabojago"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 5자를 초과하였습니다.");
    }

    @Test
    @DisplayName("예외) 중복된 이름이 존재할 때")
    void 중복된_이름_예외() {
        assertThatThrownBy(() -> player.validateInputCarNames("subin,hehe,hehe"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    @DisplayName("검증 후 입력된 자동차 이름 저장 확인")
    void 자동차_이름_확인() {
        List<String> names = new ArrayList<>();
        names.add("subin");
        names.add("jinju");

        assertThat(player.validateInputCarNames("subin,jinju")).isEqualTo(names);

    }

    @Test
    @DisplayName("예외) 입력이 없을 때")
    void 입력이_없는_예외() {
        assertThatThrownBy(() -> player.validateInputCounts(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 존재하지 않습니다.");
    }

    @Test
    @DisplayName("예외) 숫자가 아닌 값을 입력했을 때")
    void 숫자가_아닌_문자_예외() {
        assertThatThrownBy(() -> player.validateInputCounts("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("검증 후 입력된 횟수 저장 확인")
    void 횟수_확인() {
        assertThat(player.validateInputCounts("3")).isEqualTo(3);
    }

}