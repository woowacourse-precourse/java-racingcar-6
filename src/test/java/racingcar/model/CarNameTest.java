package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CarName 클래스 테스트")
public class CarNameTest {
    CarName carNameTest;

    @Test
    @DisplayName("CarName 클래스 생성 테스트")
    void makeCarNameTest() {
        List<String> test = new ArrayList<>();
        test.add(0, "pobi");
        test.add(1, "woni");
        carNameTest = CarName.makeCarName(test);
        assertThat(test).isEqualTo(carNameTest.getCarName());
    }
}
