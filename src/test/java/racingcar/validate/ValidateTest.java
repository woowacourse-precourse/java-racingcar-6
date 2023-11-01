package racingcar.validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateTest {
    Validate validate = Validate.getInstance();

    @Test
    public void 자동차_이름_입력_중복_경우_예외발생() throws Exception {
        //given
        List<String> input = Arrays.asList("pobi", "woni", "jun", "jun");
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validateDuplicationCarsName(input))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void 자동차_이름_입력_5초과_경우_예외발생() throws Exception {
        //given
        List<String> input = Arrays.asList("pobi", "woni", "jun", "chanyoung");
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validateLengthCarsName(input))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void 자동차_이름_입력_빈칸_포함_경우_예외발생() throws Exception {
        //given
        List<String> input = Arrays.asList("pobi", "wo ni", "jun");
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validateBlankCarsName(input))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void 라운드_입력_문자_경우_예외발생() throws Exception {
        //given
        String input = "a";
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }

    @Test
    public void 라운드_입력_1보다_작을_경우_예외발생() throws Exception {
        //given
        String input = "-1";
        //when
        Assertions.assertThatThrownBy(
                        () ->
                                validate.validateNegativeNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
        //then
    }


}
