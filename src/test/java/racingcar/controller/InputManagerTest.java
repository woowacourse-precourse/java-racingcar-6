package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {
    InputManager inputManager;

    @BeforeEach
    void setup(){
        inputManager = new InputManager();
    }

    @Test
    void separateNames_콤마로_구분() {
        String input = "1,2";

        List<String> result = inputManager.separateNames(input);

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void separateNames_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";

        List<String> result = inputManager.separateNames(input);

        assertThat(result).contains("1");
    }

    @Test
    void checkLimitCarName_outOfLenght() {
        String name = "outOfLenght";

        assertThatThrownBy(() -> inputManager.checkLimitCarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkRepeatCondition() {
        String readLine = "1";

        int repeat = inputManager.checkRepeatCondition(readLine);

        assertThat(repeat).isEqualTo(1);
    }

    @Test
    void checkRepeatCondition_isNotNumber() {
        String readLine = "1A";

        assertThatThrownBy(() -> inputManager.checkRepeatCondition(readLine))
                .isInstanceOf(IllegalArgumentException.class);
    }
}