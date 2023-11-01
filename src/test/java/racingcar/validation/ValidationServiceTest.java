package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Driver;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidationServiceTest {

    private ValidationService validationService = new ValidationService();

    @Test
    void input_정상입력() {
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
    void input_5글자가_넘는_이름() {
        String input = "pobi,woniaaa,jun";

        assertThatThrownBy(() -> validationService.inputToDriverList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_공백_포함() {
        String input = "pobi,,jun";

        assertThatThrownBy(() -> validationService.inputToDriverList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_빈문자열() {
        String input = "";

        assertThatThrownBy(() -> validationService.inputToDriverList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
