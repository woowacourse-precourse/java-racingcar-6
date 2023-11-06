package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TotalCarTest {
    @Test
    void 리스트에_클래스를_저장() {
        TotalCar totalCar = new TotalCar();
        String name = "stardust";
        totalCar.saveNewCar(name);

        List<String> carNameList = totalCar.nameList();
        assertThat(carNameList.get(0)).isEqualTo(name);
    }

    @Test
    void 전진_지시가_있으면_자동차_거리를_한칸_늘려_저장() {
        TotalCar totalCar = new TotalCar();
        String name = "stardust";
        totalCar.saveNewCar(name);

        for (int repeat = 0; repeat < 50; repeat++) {
            totalCar.moveDistance();
        }
        List<Integer> saveDistance = totalCar.distanceList();
        assertThat(saveDistance.get(0)).isNotZero();
    }

}
