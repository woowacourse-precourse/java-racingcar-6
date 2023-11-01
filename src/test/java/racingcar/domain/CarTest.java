package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Car의 ")
class CarTest {

    @Test
    @DisplayName("거리가 증가하는가")
    void increase_distance() {
        //given
        int expectedDistance = 1;
        String inputName = "pobi";
        Car expectedCar = new Car(inputName);

        //when
        expectedCar.increaseDistance();

        //then
        assertThat(expectedCar.getDistance()).isEqualTo(expectedDistance);
    }

    @Test
    @DisplayName("이름을 가져오는가")
    void get_name() {
        //given
        String inputName = "yunho";
        Car expectedCar = new Car(inputName);

        //when
        String expectedName = expectedCar.getName();

        //then
        assertThat(expectedName).isEqualTo(inputName);
    }

    @Test
    @DisplayName("거리를 가져오는가")
    void get_distance() {
        //given
        int distance = 0;
        String inputName = "yunho";
        Car expectedCar = new Car(inputName);

        //when
        int expectedDistance = expectedCar.getDistance();

        //then
        assertThat(expectedDistance).isEqualTo(distance);
    }

    @Nested
    @DisplayName("객체를 생성시")
    class ValidateNameLength {

        @Test
        @DisplayName("이름이 5글자가 넘어가면 예외를 던지는가")
        void validate_name_length_over_five() {
            //given
            String input = "jungyunho";

            //when
            //then
            assertThatThrownBy(() -> new Car(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}