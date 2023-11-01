package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("사용자 상태 출력 테스트")
    void carStatusTest() {
        String expectKimStatus = "kim : ";

        String nameKim = "kim";
        List<String> nameList = new ArrayList<>();
        nameList.add(nameKim);

        Cars cars = Cars.of(nameList);
        List<String> carStatusList = cars.getCarStatusList();
        String actualKimStatus = carStatusList.get(0);

        assertThat(actualKimStatus).isEqualTo(expectKimStatus);
    }

    @Test
    @DisplayName("사용자 전진 상태 출력 테스트")
    void carForwardStatusTest() {
        String nameKim = "kim";
        List<String> nameList = new ArrayList<>();
        nameList.add(nameKim);

        Cars cars = Cars.of(nameList);
        for (int i = 0; i < 1000; i++) {
            cars.move();
        }

        List<String> carStatusList = cars.getCarStatusList();
        String actualKimStatus = carStatusList.get(0);

        assertThat(actualKimStatus.contains("-")).isTrue();
    }

    @Test
    @DisplayName("우승자 리스트 테스트")
    void winnerListTest() {
        String nameKim = "kim";
        String nameLee = "lee";
        String namePark = "park";

        List<String> nameList = new ArrayList<>();
        nameList.add(nameKim);
        nameList.add(nameLee);
        nameList.add(namePark);

        Cars cars = Cars.of(nameList);
        for (int i = 0; i < 100; i++) {
            cars.move();
        }

        List<String> winnerList = cars.getWinnerList();
        assertThat(winnerList.size()).isGreaterThanOrEqualTo(1);
    }

}