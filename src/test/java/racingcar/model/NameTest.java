package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

public class NameTest {

    @Test
    void 이름_입력_성공_테스트() {
        String nameValue = "name";
        Name name = new Name(nameValue);
        assertThat(name.value()).isEqualTo(nameValue);
    }

    @Test
    void 길이_제한_못_미치는_이름_실패_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LENGTH_CONDITION));
    }

    @Test
    void 길이_제한_넘는_이름_실패_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Name("namename"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LENGTH_CONDITION));
    }

    @Test
    void 공배_있는_이름_실패_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Name("na me"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_WHITE_SPACE_CONDITION));
    }
}