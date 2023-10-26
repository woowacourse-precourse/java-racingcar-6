package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Cars.goForward;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import racingcar.Cars;

public class CarTest {

    @Test
    void n회_전진했을경우_거리측정(){
        Cars james = new Cars();
        for (int i = 0; i < 5; i++) {
            james.goForward();
        }
        assertThat(james.askDistance()).isEqualTo(5);
    }

}
