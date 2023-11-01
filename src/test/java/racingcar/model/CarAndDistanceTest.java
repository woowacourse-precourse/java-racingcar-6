package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarAndDistanceTest {

    @Test
    void 자동차_이동거리_Set_Get_테스트() {
        CarAndDistance carAndDistance = new CarAndDistance();

        carAndDistance.setCarAndDistance("dokgo","--");
        carAndDistance.setCarAndDistance("may","--");
        carAndDistance.setCarAndDistance("cat","---");
        carAndDistance.setCarAndDistance("uncle","----");
        carAndDistance.setCarAndDistance("king","-----");

        assertThat(carAndDistance.carAndDistanceResult(5)).contains("dokgo : --","may : --","cat : ---","uncle : ----","king : -----");
    }

    @Test
    void 자동차_이동거리_반복_테스트() {
        CarAndDistance carAndDistance = new CarAndDistance();
        String distance1 = "";
        String distance2 = "";

        for(int i = 0; i < 5; i++) {
            distance1 += "-";
            distance2 += "-";
            carAndDistance.setCarAndDistance("dokgo", distance1);
            carAndDistance.setCarAndDistance("may",distance2);
        }

        assertThat(carAndDistance.carAndDistanceResult(2)).contains("dokgo : -----","may : -----");
    }

    @Test
    void 자동차_이동거리_횟수마다_출력_테스트() {
        CarAndDistance carAndDistance = new CarAndDistance();

        String distance1 = "";

        for(int i = 0; i < 5; i++) {
            distance1 += "-";
            carAndDistance.setCarAndDistance("dokgo", distance1);
        }
        assertThat(carAndDistance.carAndDistanceResult(5)).contains("dokgo : " + distance1);
    }
}
