package racingcar.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerSelectorTest {

    WinnerSelector winnerSelector = new WinnerSelector();

    public ArrayList<Car> candidateProvider() {
        ArrayList<Car> candidateList = new ArrayList<Car>();

        Car pobiCar = new Car("pobi");
        pobiCar.MoveOneStepForward();
        pobiCar.MoveOneStepForward();

        Car woniCar = new Car("woni");
        woniCar.MoveOneStepForward();

        Car junCar = new Car("jun");
        junCar.MoveOneStepForward();
        junCar.MoveOneStepForward();

        candidateList.add(pobiCar);
        candidateList.add(woniCar);
        candidateList.add(junCar);

        return candidateList;
    }

    @Test
    @DisplayName("리스트 맵 변환 메서드 테스트")
    public void 리스트_맵_변환_테스트() {
        ArrayList<Car> candidateList = candidateProvider();
        HashMap<String, Integer> winnerMap = winnerSelector.convertListToMap(candidateList);
        assertThat(winnerMap).hasSize(3)
                .contains(entry("pobi", 2), entry("woni", 1), entry("jun", 2));
    }

    @Test
    @DisplayName("최대값을 가진 키,밸류 값만 남기는 메서드 테스트")
    public void 최대값_키_남기기_메서드_테스트() {
        ArrayList<Car> candidateList = candidateProvider();
        HashMap<String, Integer> winnerMap = winnerSelector.convertListToMap(candidateList);
        assertThat(winnerSelector.retainKeyWithMaxValue(winnerMap))
                .hasSize(2)
                .contains(entry("pobi", 2), entry("jun", 2))
                .doesNotContain(entry("woni", 1));
    }
}
