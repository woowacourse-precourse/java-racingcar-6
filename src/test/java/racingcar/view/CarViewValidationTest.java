package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.manager.view.CarViewValidation;

public class CarViewValidationTest {
    private final CarViewValidation carViewValidation = new CarViewValidation();

    @Test
    void 각_차량_이름_다섯_글자_이하인지_검증(){
        List<String> input = new ArrayList<>();

        input.add("pobi");
        input.add("woni");
        input.add("jun112");

        assertThat(carViewValidation.greaterThanFiveLetter(input)).isFalse();
    }
    @Test
    void 차량_입력_중_중복된_이름_존재하는지_검증(){
        List<String> input = new ArrayList<>();

        input.add("pobi");
        input.add("woni");
        input.add("pobi");

        assertThat(carViewValidation.isDuplicated(input)).isTrue();
    }
}
