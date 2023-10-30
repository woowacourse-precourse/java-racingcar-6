package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void createTest_인스턴스_생성_성공() {
        String name = "test";
        RacingCar racingCar = new RacingCar(name);

        Assertions.assertThat(racingCar.getName()).isEqualTo("test");
    }

    @Test
    void createTest_인스턴스_생성_실패_5글자_이상() {
        String name = "test11";

        Assertions.assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carMoveTest_1칸_움직이기_테스트() {
        RacingCar racingCar = new RacingCar("test");
        racingCar.moveOneBlock();

        Assertions.assertThat(racingCar.getCount()).isEqualTo(1);
    }

}
