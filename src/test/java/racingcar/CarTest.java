package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    public void 이름예외처리_TEST() {
        String input = "hansols";
        assertThatThrownBy(()->new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("name is limited to 5 characters");
    }

}