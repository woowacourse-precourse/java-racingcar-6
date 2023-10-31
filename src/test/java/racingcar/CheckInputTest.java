package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.controller.CheckInput.*;

public class CheckInputTest {

    @Test
    void 중복된_이름_입력() {
        List<String> names = new ArrayList<>();
        names.add("poobee");
        names.add("poobee");
        assertThatThrownBy(() -> checkDuplicateName(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_숫자_입력() {
        String wrongNum = "a";
        assertThatThrownBy(() -> checkIfNum(wrongNum)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_이름_길이_입력() {
        List<String> names = new ArrayList<>();
        names.add("aaaaaa");
        assertThatThrownBy(() -> checkNameLength(names)).isInstanceOf(IllegalArgumentException.class);
    }
}
