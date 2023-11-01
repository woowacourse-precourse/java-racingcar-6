package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private final Validator validator = new Validator();


    @DisplayName("리스트 안의 요소들의 이름의 길이가 유효한 경우가 아닐 경우 예외 발생")
    @Test
    void checkEachCarNameLengthValidTest(){

        List<String> carNameList = List.of("woonbe", "java", " ");

        assertThatThrownBy(()-> validator.checkEachCarNameLengthValid(carNameList))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("String으로 입력 받은 값이 유효한 길이의 이름이 아니면 예외 발생")
    @Test
    void isValidNameLengthTest(){

        String input = "woonbe";
        String input2 = "";

        assertThatThrownBy(() -> validator.isValidNameLength(input))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.isValidNameLength(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 내부에 중복되는 이름이 있을 경우 예외 발생")
    @Test
    void checkDuplicateNameTest(){

        List<String> carNameList = List.of("java", "java","python");

        assertThatThrownBy(()-> validator.checkDuplicateName(carNameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("String으로 입력 받을 경우에도 유효한 이름이 아닐 경우 예외 발생")
    @Test
    void isValidCarNameTest(){

        List<String> carNameList = new ArrayList<>();
        String name = "woonbe, java, spring";

        assertThatThrownBy(() -> validator.isValidCarName(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("유효한 숫자가 아닐 경우 예외를 발생")
    @Test
    void isValidTrialNumberTest(){

        String input = "woonbe";
        String input2 = "";

        assertThatThrownBy(() -> validator.isValidTrialNumber(input))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.isValidTrialNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);

    }


}