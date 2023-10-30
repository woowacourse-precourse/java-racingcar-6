package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private final Car car = new Car();

    @Nested
    @ParameterizedTest
    @DisplayName("난수가 4이상이면 자동차는 전진한다. 4 미만이면 정지한다.")
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void isCarGoFoward(int randomNumber){
        int distanceBeforeMove = car.getDistance();
        car.move(randomNumber);
        if(randomNumber>=4) {
            assertEquals(distanceBeforeMove+1,car.getDistance());
        } else {
            assertEquals(distanceBeforeMove,car.getDistance());
        }
    }

}