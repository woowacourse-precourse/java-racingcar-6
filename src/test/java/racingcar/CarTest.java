package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carMoveOrStop() {
    }

    @Test
    void giveNameOfCar() {
        Car car = new Car();
        car.giveNameOfCar("tear");
    }

    @Test
    void printMovingCarWithCarName() {
        Car car = new Car();
        car.giveNameOfCar("test");
        car.carMoveOrStop();
        assertThat("test : -").isEqualTo(car.printMovingCarWithCarName());
    }

    // randomNumber > 3이면 true, 아니면 false
    @Test
    void 움직일_수_있는지_확인() {
        int randomNumber = 0;
        boolean expected = (randomNumber > 3);
        assertThat(false).isEqualTo(expected);
        }

        // String의 길이가 <=5이면 true, 아니면 false
    @Test
    void isCarNameLengthFive() {
        String carName = "1231";
        boolean expected = (carName.length() <= 5);
        assertThat(false).isEqualTo(expected);
    }


}
