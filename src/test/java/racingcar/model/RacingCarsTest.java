package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    private RacingCars racingCars;
    private String[] names = new String[]{"one","two","three"};

    @BeforeEach
    void setUp(){
        racingCars = new RacingCars(names);
    }
    
    @Test
    void getCarNames_이름리스트를_반환() {
        assertThat(racingCars.getCarNames())
                .isEqualTo(new ArrayList<>(Arrays.asList("one","two","three")));
    }

    @Test
    void getCarLocations_위치리스트를_반환() {
        assertThat(racingCars.getCarLocations())
                .isEqualTo(new ArrayList<>(Arrays.asList(0,0,0)));
    }
}