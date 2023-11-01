package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars carsDomain = new Cars();
    String[] drivers = {"iii","zzz","eee"};
    String[] tmp = {"iii","zzz","eee","www","eeee"};

    @BeforeEach
    public void setting(){

    }


    @Test
    @BeforeEach
    @DisplayName("Cars 생성 TEST")
    void createCars() {
        carsDomain.createCars(drivers);
        Car[] cars = carsDomain.getCars();

        assertThat(cars.length).isEqualTo(3);
    }

    @Test
    @DisplayName("Cars moveCars TEST")
    void moveCars() {
        carsDomain.createCars(drivers);

        assertRandomNumberInRangeTest(
            () ->{
                carsDomain.moveCars();
                for (int i = 0; i < carsDomain.getCars().length;i++) {
                    assertThat(carsDomain.getCars()[i].getMileage()).isEqualTo(1);
                }
            },
            5
        );
    }

    @Test
    @DisplayName("Cars getCars TEST")
    void getCars() {
        Cars tmpCars = new Cars();
        tmpCars.createCars(tmp);

        assertThat(tmpCars.getCars().length).isEqualTo(tmp.length);
    }
}