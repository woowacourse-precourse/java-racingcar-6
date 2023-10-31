package racingcar.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Test
    void 이름에_대한_예외처리_길이() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("pobi,woonii,jun");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외처리_공백() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외처리_이름_하나() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 이름에_대한_예외처리_중복() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("pobi,pobi,wooni");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 회수에_대한_예외처리_음수() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("-2");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 회수에_대한_예외처리_제로() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 회수에_대한_예외처리_문자() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("l");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 회수에_대한_예외처리_공백() {
        Name name = new Name();
        assertThatThrownBy(() -> {
            name.carName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
