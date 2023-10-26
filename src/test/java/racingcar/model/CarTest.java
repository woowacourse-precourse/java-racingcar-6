package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void createCarWithValidName() {
        // given
        String validName = "pobi";

        // when
        Car car = new Car(validName);

        // then
        assertThat(car.getName()).isEqualTo(validName);
    }

    @Test
    void exceptionThrownWhenNameIsNull() {
        // given
        String nullName = null;

        // when & then
        assertThatThrownBy(() -> new Car(nullName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exceptionThrownWhenNameExceedsMaxLength() {
        // given
        String longName = "pobipobi";

        // when & then
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exceptionThrownWhenNameIsLessThanMinLength() {
        // given
        String shortName = "";

        // when & then
        assertThatThrownBy(() -> new Car(shortName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void carShouldMoveWhenNumberIsGreaterThanOrEqualTo4() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        int initialPosition = car.getPosition();

        car.move(pickNumberInRange);

        if(pickNumberInRange >= 4){
            assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
        } else{
            assertThat(car.getPosition()).isEqualTo(initialPosition);
        }
    }
}
