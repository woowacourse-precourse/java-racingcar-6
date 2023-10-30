package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constant.*;

class CarTest {

    private static final String name = "car";
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(name);
    }

    @Test
    @DisplayName("점수_0점일때_toString_확인")
    public void toString_whenPointIsZero_checkOutput() {
        //given
        String expected = name + IS;

        //when
        String actual = car.toString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("점수_1점일때_toString_확인")
    public void toString_whenPointIsOne_checkOutput() {
        //given
        car.forward();
        String expected = name + IS + LINE;

        //when
        String actual = car.toString();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("인자로_비어있는_string_전달시_Car_객체생성_에러_확인")
    public void constructor_whenStringIsEmpty_IllegalArgumentException() {
        //given
        String emptyString = "";

        //when & then
        Assertions.assertThatThrownBy(() -> new Car(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_INPUT_NAME);
    }

    @Test
    @DisplayName("인자로_size가_초과인_string_전달시_Car_객체생성_에러_확인")
    public void constructor_whenStringSizeIsOver_IllegalArgumentException() {
        //given
        String longString = "longNameCar";

        //when & then
        Assertions.assertThatThrownBy(() -> new Car(longString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_INPUT_NAME);
    }

}