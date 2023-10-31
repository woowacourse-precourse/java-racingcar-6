package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    void from_정상적으로생성_테스트() {
        //given
        RacingCar car1 = RacingCar.from("woni");
        RacingCar car2 = RacingCar.from("jun");
        RacingCar car3 = RacingCar.from("min");
        List<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        //when
        RacingCars racingCars = RacingCars.from(cars);
        //then
//        assertThat(car1.getName()).isEqualTo("woni");
//        assertThat(car2.getName()).isEqualTo("jun");
        assertThat(racingCars.getRacingCars().get(0).getName()).isEqualTo("woni");
        assertThat(racingCars.getRacingCars().get(1).getName()).isEqualTo("jun");
        assertThat(racingCars.getRacingCars().get(2).getName()).isEqualTo("min");
    }
}