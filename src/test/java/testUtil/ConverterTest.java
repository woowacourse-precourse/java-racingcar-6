package testUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.Test;

import racingcar.utils.Converter;

public class ConverterTest {

    @Test
    void turn_convert_test(){
        String input = "5";

        int ConvertResult = Converter.convertTurn(input);

        assertThat(ConvertResult).isEqualTo(5);
    }

    @Test
    void cars_name_convert_test(){
        String input = "pobi,cash,kakao";
        String[] answer = {"pobi", "cash", "kakao"};

        String[] ConvertResult = Converter.convertCarsName(input);

        assertThat(ConvertResult).isEqualTo(answer);
    }
}
