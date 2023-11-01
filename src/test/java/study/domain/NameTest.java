package study.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.BadInputException;

public class NameTest {
    @Test
    void 이름_5자_초과_예외처리() {
        String name = "gahyeon";

        assertThatThrownBy(() -> {
            BadInputException.checkNameLength(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_공백_포함_예외처리() {
        String name = "ga hyeon";

        assertThatThrownBy(() -> {
            BadInputException.isSpace(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참여자_2명_미만_예외처리() {
        String[] participants = new String[]{"ghlee"};

        assertThatThrownBy(() -> {
            BadInputException.checkMinimumParticipants(participants);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름_중복_예외처리() {
        String[] names = new String[]{"ghlee", "ghlee"};

        assertThatThrownBy(() -> {
            BadInputException.isNameDuplicate(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
