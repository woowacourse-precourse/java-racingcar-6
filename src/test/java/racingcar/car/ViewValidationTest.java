package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.manager.view.Validation;

public class ViewValidationTest {
    private final Validation validation = new Validation();

    @Test
    void 구분자_기준으로_나누기_검증(){
        String input = "pobiwonijun";

        assertThat(validation.isNotSeparator(input)).isTrue();
    }
    @Test
    void 각_차량_이름_다섯_글자_이하인지_검증(){
        List<String> input = new ArrayList<>();

        input.add("pobi");
        input.add("woni");
        input.add("jun112");

        assertThat(validation.greaterThanFiveLetter(input)).isFalse();
    }
    @Test
    void 차량_입력_중_중복된_이름_존재하는지_검증(){
        List<String> input = new ArrayList<>();

        input.add("pobi");
        input.add("woni");
        input.add("pobi");

        assertThat(validation.isDuplicated(input)).isTrue();
    }
}
