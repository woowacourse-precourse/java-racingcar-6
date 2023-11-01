package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ErrorCheckTest {

    private ErrorCheck errorCheck;
    private static final List<String> ANSWER = Arrays.asList("car1", "carcar", "car3");


    @BeforeEach
    void setUp() {

        errorCheck = new ErrorCheck();
    }

    @Test
    void carNameCheckTest() {
        assertThatThrownBy(() -> errorCheck.carNameCheck(ANSWER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 자동차 이름을 콤마로 구분하여 입력해주세요.");
    }

    @Test
    void isNoValueTest() {
        assertThatThrownBy(() -> errorCheck.isNoValue(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백만 입력할 수 없습니다.");
        assertThatThrownBy(() -> errorCheck.isNoValue(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백만 입력할 수 없습니다.");
        assertThatThrownBy(() -> errorCheck.isNoValue("     "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백만 입력할 수 없습니다.");
        assertThatThrownBy(() -> errorCheck.isNoValue(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백만 입력할 수 없습니다.");
    }

    @Test
    void biggerThanFiveTest() {
        assertThatThrownBy(() -> errorCheck.biggerThanFive("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하의 자동차 이름을 콤마로 구분하여 입력해주세요.");
    }

    @Test
    void inputNumberCheckTest() {
        assertThatThrownBy(() -> errorCheck.inputNumberCheck("가"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 정수를 입력해 주세요");
        assertThatThrownBy(() -> errorCheck.inputNumberCheck("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 정수를 입력해 주세요");
        assertThatThrownBy(() -> errorCheck.inputNumberCheck("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이하의 수를 입력할 수 없습니다.");
        assertThatThrownBy(() -> errorCheck.inputNumberCheck("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이하의 수를 입력할 수 없습니다.");
    }
}

