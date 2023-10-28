package racingcar.method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class InputCarNamesTest {

    @Test
    void 정상_입력시_리스트반환() {
        Console.close();

        String testInput = " Jun , Alex , David ";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        Assertions.assertThat(Application.inputCarNames()).containsKeys("Jun", "Alex", "David");
    }

    @Test
    void 자동차이름_공백값_포함시_예외발생() {
        String[] testInputList = {
                "Jun,, Alex",
                "Jun,  , Alex",
                ",Jun, Alex",
                "Jun, Alex,",
                ",",
                ",,",
                ",  ,",
                "   ,,",
                ",,   ",
                "   ,,   "
        };

        for (String testInput : testInputList) {
            carNameInputErrorOccurs(testInput, "자동차 이름은 공백일 수 없습니다.");
        }
    }

    @Test
    void 자동차이름_5자_이상_입력시_예외발생() {
        String testInput = "Jun, Alex, JeongPyo";
        carNameInputErrorOccurs(testInput, "자동차 이름의 길이는 5자리 이하 이어야 합니다.");
    }

    @Test
    void 자동차이름_중복시_예외발생() {
        String testInput = "Jun, Alex, Alex";
        carNameInputErrorOccurs(testInput, "자동차 이름은 중복될 수 없습니다.");
    }

    private void carNameInputErrorOccurs(String testInput, String errorMessage) {
        Console.close();
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        assertThatThrownBy(Application::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}