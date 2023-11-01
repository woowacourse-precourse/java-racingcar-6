package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.model.Driver;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidationServiceTest {

    private ValidationService validationService = new ValidationService();

    @Test
    void driver_input_정상입력() {
        String input = "pobi,woni,jun";

        List<Driver> driverList = validationService.inputToDriverList(input);

        String driver1 = driverList.get(0).getName();
        String driver2 = driverList.get(1).getName();
        String driver3 = driverList.get(2).getName();

        assertThat(driver1).isEqualTo("pobi");
        assertThat(driver2).isEqualTo("woni");
        assertThat(driver3).isEqualTo("jun");
    }

    @Test
    void driver_input_5글자가_넘는_이름() {
        String input = "pobi,woniaaa,jun";

        assertThatThrownBy(() -> validationService.inputToDriverList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void driver_input_공백_포함() {
        String input = "pobi,,jun";

        assertThatThrownBy(() -> validationService.inputToDriverList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void driver_input_빈문자열() {
        String input = "";

        assertThatThrownBy(() -> validationService.inputToDriverList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void tryCount_input_정상입력() {
        String input = "3";

        int tryCount = validationService.inputToTryCount(input);

        assertThat(tryCount).isEqualTo(3);
    }

    @Test
    void tryCount_input_문자입력() {
        String input = "a";

        assertThatThrownBy(() -> validationService.inputToTryCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void tryCount_input_실수입력() {
        String input = "3.3";

        assertThatThrownBy(() -> validationService.inputToTryCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
