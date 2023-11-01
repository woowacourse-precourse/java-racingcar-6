package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final Car testCar = new Car("name",0);

    @Test
    @DisplayName("자동차 초기화 테스트")
    void initCarTest(){
        assertThat(testCar.name).isEqualTo("name");
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    void goForwardTest(){
        testCar.goForward();
        assertThat(testCar.forwardCount).isEqualTo(1);
    }

}
