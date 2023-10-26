package app;

import app.repository.Valid;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidTest {


    @Test
    @DisplayName("자동차 이름에 대한 예외")
    void getCarNameException() {
        String[] validTestList = {"", " ", "aaaaaaaaaa", null, "            "};
        for (String test : validTestList) {
            assertThatThrownBy(() -> Valid.validCarName(test)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("경기 횟수에 대한 예외")
    void isNumber() {
        String[] validTestList = {"", " ", "aaaaaaaaaa", null, "            ", "0", "12", "a123", "a1", "1a"};
        for (String test : validTestList) {
            assertThatThrownBy(() -> Valid.validCount(test)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}