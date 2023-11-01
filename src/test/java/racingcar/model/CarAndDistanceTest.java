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

    @Test
    void 자동차_이동거리_반복_테스트() {
        CarAndDistance carAndDistance = new CarAndDistance();
        String distance1 = "";
        String distance2 = "";

        for(int i = 0; i < 5; i++) {
            distance1 += "_";
            distance2 += "_";
            carAndDistance.setCarAndDistance("dokgo", distance1);
            carAndDistance.setCarAndDistance("may",distance2);
        }

        assertThat(carAndDistance.getCarAndDistance(0)).isEqualTo("dokgo : _____");
        assertThat(carAndDistance.getCarAndDistance(1)).isEqualTo("may : _____");
    }

    @Test
    void 자동차_이동거리_횟수마다_출력_테스트() {
        CarAndDistance carAndDistance = new CarAndDistance();

        String distance1 = "";

        for(int i = 0; i < 5; i++) {
            distance1 += "_";
            carAndDistance.setCarAndDistance("dokgo", distance1);
            assertThat(carAndDistance.getCarAndDistance(0)).isEqualTo("dokgo : " + distance1);
        }
    }
}
