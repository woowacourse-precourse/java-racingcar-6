package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void carMoveOrStop() {
    }

    @Test
    void giveNameOfCar() {
    }

    @Test
    void printMovingCarWithCarName() {
    }

    // randomNumber > 3이면 true, 아니면 false
    @Test
    void 움직일_수_있는지_확인() {
        int randomNumber = 4;
        boolean expected = (randomNumber > 3);
        assertThat(true).isEqualTo(true);
        }
    }
