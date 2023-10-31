package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CarDistance 클래스 테스트")
public class CarDistanceTest {
    CarDistance carDistanceTest;

    @Test
    @DisplayName("CarDistance 클래스 생성 테스트")
    void makeCarDistanceTest() {
        carDistanceTest = CarDistance.makeCarDistance();
        carDistanceTest.setStartPoint(3);
        List<Integer> test = new ArrayList<>();

        test.add(0, 0);
        test.add(1, 0);
        test.add(2, 0);

        assertThat(carDistanceTest.getCarDistance())
                .isEqualTo(test);
    }
}
