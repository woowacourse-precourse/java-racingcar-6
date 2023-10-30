package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player player = new Player();

    @Test
    @DisplayName("예외) 자동차 이름을 하나만 입력했을 때")
    void 이름_하나_입력_예외() {
        String input = "subin";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> player.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 하나만 입력되었습니다.");
    }

    @Test
    @DisplayName("예외) 입력에 공백이 있을 때")
    void 입력_공백_예외() {
        String input = "subin, jinju";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> player.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 공백이 존재합니다.");
    }

    @Test
    @DisplayName("예외) 이름이 5자를 초과했을 때")
    void 이름_글자수_초과_예외() {
        String input = "subin,gabojaro";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> player.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 5자를 초과하였습니다.");
    }

    @Test
    @DisplayName("예외) 중복된 이름이 존재할 때")
    void 중복된_이름_예외() {
        String input = "subin,hehe,hehe";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> player.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    @DisplayName("입력된 자동차 이름 확인")
    void 자동차_이름_확인() {
        String input = "subin,jinju";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<String> carNames = player.inputCarNames();

        List<String> name = new ArrayList<>();
        name.add("subin");
        name.add("jinju");

        assertThat(name).isEqualTo(carNames);
    }

}