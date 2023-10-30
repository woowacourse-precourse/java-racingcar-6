package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    @Test
    @DisplayName("RacingCars가 잘 생성되는지 확인")
    public void createRacingCars(){
        List<String> carNames = Arrays.asList("pobi","dobi");
        RacingCars racingCars = new RacingCars(carNames);
        assertThat(racingCars.getSize()).isEqualTo(2);
    }

}