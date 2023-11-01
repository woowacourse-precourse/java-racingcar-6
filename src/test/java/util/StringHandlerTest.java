package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.StringHandler;

public class StringHandlerTest {
    @Test
    void 문자열을_콤마_기준으로_리스트로_변환시킨다() {
        String input = "abc,def,ghi";

        List<String> stringList = StringHandler.separatedStringToList(input, ",");

        Assertions.assertThat(stringList.get(0)).isEqualTo("abc");
    }

    @Test
    void 리스트를_콤파_기준으로_분리된_문자열로_변환시킨다() {
        List<Car> cars = List.of(new Car("abc",0), new Car("def",0));

        String output = StringHandler.listToStringSplitBy(cars, ", ");

        Assertions.assertThat(output).isEqualTo("abc, def");
    }

    @Test
    void 문자열을_정수로_변환시킨다() {
        String input = "12";

        Assertions.assertThat(StringHandler.stringToInt(input)).isEqualTo(12);
    }

    @Test
    void 숫자가_아닌_문자열을_입력값으로_넣으면_예외를_던진다() {
        String input = "a";

        assertThrows(IllegalArgumentException.class, () -> StringHandler.stringToInt(input));
    }
}
