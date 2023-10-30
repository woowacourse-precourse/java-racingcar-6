package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.Model.Cars;

public class CarTest {

    @Test
    void n회_전진했을경우_객체테스트() {
        Cars james = new Cars("james");
        for (int i = 0; i < 5; i++) {
            james.goOneStep();
        }
        assertThat(james.askDistance()).isEqualTo(5);
        assertThat(james.getName()).isEqualTo("james");
    }
}
