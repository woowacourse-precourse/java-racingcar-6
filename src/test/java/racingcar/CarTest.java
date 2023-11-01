package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void generate_자동차클래스() {
        Car mycar = new Car("test1", 0);
        mycar.move();
        assertThat(mycar.getName()).isEqualTo("test1");
        assertThat(mycar.genPosition()).isEqualTo(1);
    }
}
