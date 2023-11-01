package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    Car car;

    @BeforeEach
    void init(){
        car = new Car();
    }

    @DisplayName("4 이상이면 true, 아니면 false")
    @ParameterizedTest
    @ValueSource(ints = {4,0,3,9})
    void isStepForwardTest(int randomNumber){
        assertThat(car.isStepForward(randomNumber)).isTrue();
    }

}
