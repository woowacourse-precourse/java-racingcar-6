package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.service.Exception;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;
public class ValidationTest {

    @Test
    void 쉼표_구분_존재여부_예외_처리(){
        String input = "tobi lee";
        String[] result = input.split(",");

        assertThat(result).contains("tobi lee");
    }

    @Test
    void 자동차_이름_입력_안한_경우_예외_처리(){
        Exception exception= new Exception();
        assertThatThrownBy(()->{exception.noInputCarNameException("");}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_입력_안한_경우_예외_처리(){
        Exception exception= new Exception();
        assertThatThrownBy(()->{exception.noInputTryNumberException("");}).isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    void 자동차_이름_중복_입력_예외_처리(){
        Exception exception= new Exception();
        assertThatThrownBy(() -> exception.duplicateCarNameException("tobi,anna,tobi"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 시도_횟수_숫자_아닌_경우_예외_처리(){
        Exception exception= new Exception();
        assertThatThrownBy(() -> exception.noDigitTryNumberException("a"))
                .isInstanceOf(IllegalArgumentException.class);

    }


}
