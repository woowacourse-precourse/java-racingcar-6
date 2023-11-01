package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputControllerTest {

    @Test
    @DisplayName("이름 구분 Test")
    void splitNames() {
        String names = "ruby,cpp,java";
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("ruby", "cpp", "java"));

        assertThat(InputController.splitNames(names)).isEqualTo(nameList);
    }

    @Test
    @DisplayName("이름 유효성 성공 Test")
    void validNamesSuccess() {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("ruby", "cpp", "java"));

        assertThat(InputController.validNames(nameList)).isEqualTo(true);
    }

    @Test
    @DisplayName("이름 유효성 실패 Test (5자 이상 이름 포함)")
    void validNamesFail() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("ruby", "python", "java"));

        assertThat(InputController.validNames(names)).isEqualTo(false);
    }
}