package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private Referee referee = new Referee();
    private List<Car> racingCars = new ArrayList<>();

    @BeforeEach
    void init(){

        Car car1 = new Car("car1");
        car1.plusDistance();
        racingCars.add(car1);

        Car car2 = new Car("car2");
        car2.plusDistance();
        car2.plusDistance();
        racingCars.add(car2);
    }

    @Test
    @DisplayName("모든 자동차의 이동 거리 저장")
    void 이동_거리_저장() {
        List<Integer> check = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(referee.saveAllDistances(racingCars)).isEqualTo(check);
    }

    @Test
    @DisplayName("저장된 이동 거리 중 최대 거리 찾기")
    void 최대_이동_거리(){
        List<Integer> distances = referee.saveAllDistances(racingCars);
        assertThat(referee.findMaxDistance(distances)).isEqualTo(2);
    }

}