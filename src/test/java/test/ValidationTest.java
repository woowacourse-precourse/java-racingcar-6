package test;


import org.junit.jupiter.api.Test;
import racingcar.util.Validation;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {
//- 자동차 이름이 공백일 경우
//- 자동차 이름이 5자 초과일 경우
//- 자동차 이름이 중복일 경우
//- 자동차 이름에 공백이 포함될 경우
//- 시도 횟수 입력이 공백일 경우
//- 시도 횟수 입력시 문자를 입력할 경우
//- 쉼표(',')로 자동차 이름 입력이 끝날 경우

    private final Validation validation = new Validation();

    @Test
    public void 자동차이름_공백() {
        assertThatThrownBy(() -> validation.checkCarNamesInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름에 공백이 포함되어선 안됩니다.");
    }

    @Test
    public void 자동차이름_5자초과() {
        assertThatThrownBy(() -> validation.checkCarNamesInput("nbowow"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5글자 이하여야 합니다.");

    }

    @Test
    public void 자동차이름_중복() {
        assertThatThrownBy(() -> validation.checkCarNamesInput("nbow,nbow"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복되면 안됩니다.");
    }

    @Test
    public void 자동차이름_공백이포함() {
        assertThatThrownBy(() -> validation.checkCarNamesInput("nbow ,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름에 공백이 포함되어선 안됩니다.");
    }

    @Test
    public void 시도횟수_공백() {
        assertThatThrownBy(() -> validation.checkTrialInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 숫자가 입력되어야 합니다.");
    }

    @Test
    public void 시도횟수_문자입력() {
        assertThatThrownBy(() -> validation.checkTrialInput("nbow"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 숫자가 입력되어야 합니다.");
    }

    @Test
    public void 자동차이름_쉼표로끝() {
        assertThatThrownBy(() -> validation.checkCarNamesInput("nbow,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표로 입력이 끝나면 안됩니다.");
    }
}
