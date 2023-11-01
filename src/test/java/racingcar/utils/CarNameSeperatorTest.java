package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CarNameSeperator의")
public class CarNameSeperatorTest {

    private final CarNameSeperator carNameSeperator = new CarNameSeperator();

    @Test
    @DisplayName("이름을 작성 안하면 예외를 던지는가")
    void seperate_car_names_with_exception() {
        //given
        String input = ",woni,yunho";

        //when
        //then
        assertThatThrownBy(() -> carNameSeperator.seperateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 분리가 잘 되는가")
    void seperate_car_name() {
        //given
        String input = "pobi,woni,yunho";
        List<String> expectedNames = List.of("pobi", "woni", "yunho");

        //when
        List<String> actualNames = carNameSeperator.seperateCarNames(input);

        //then
        assertThat(actualNames).isEqualTo(expectedNames);
    }
}
