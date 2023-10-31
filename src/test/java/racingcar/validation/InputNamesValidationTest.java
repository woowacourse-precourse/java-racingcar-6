package racingcar.validation;

import org.junit.jupiter.api.Test;
import racingcar.constant.GameConstantValue;

import static org.assertj.core.api.Assertions.*;

class InputNamesValidationTest {

    String testInput1 = ",";
    String testInput2 = "pobi,woni,jun";
    String testInput3 = "pobi,javaji";
    String testInput4 = "pobi,woni,";
    String testInput5 = "";

    @Test
    void inputNamesValidationTest() {
    }

    @Test
    void splitTest() {
        String[] names = testInput4.split(",");
        assertThat(names.length).isEqualTo(2);
    }

    @Test
    void sizeTest() {
        String[] names = testInput1.split(",");
        assertThat(names.length).isEqualTo(0);
    }

    @Test
    void isLengthTest() {
        String[] names = testInput2.split(",");
        for (String name : names) {
            assertThat(name.length()).isLessThanOrEqualTo(GameConstantValue.MAX_NAME_LENGTH);
            assertThat(name.length()).isGreaterThanOrEqualTo(GameConstantValue.MIN_NAME_LENGTH);
        }
    }

    @Test
    void isLengthFailTest() {
        assertThatThrownBy(() -> InputNamesValidation.inputNamesValidation(testInput3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNullTest() {
        assertThatThrownBy(() -> InputNamesValidation.inputNamesValidation(testInput1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputNamesValidation.inputNamesValidation(testInput5)).isInstanceOf(IllegalArgumentException.class);
    }
}