package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarAndDistanceTest {

    @Test
    void 자동차_이동거리_Set_Get_테스트() {
        CarAndDistance carAndDistance = new CarAndDistance();

        carAndDistance.setCarAndDistance("dokgo","__");
        carAndDistance.setCarAndDistance("may","_");
        carAndDistance.setCarAndDistance("cat","___");
        carAndDistance.setCarAndDistance("uncle","____");
        carAndDistance.setCarAndDistance("king","_____");

        assertThat(carAndDistance.getCarAndDistance(0)).isEqualTo("dokgo : __");
        assertThat(carAndDistance.getCarAndDistance(1)).isEqualTo("may : _");
        assertThat(carAndDistance.getCarAndDistance(2)).isEqualTo("cat : ___");
        assertThat(carAndDistance.getCarAndDistance(3)).isEqualTo("uncle : ____");
        assertThat(carAndDistance.getCarAndDistance(4)).isEqualTo("king : _____");
    }
}
