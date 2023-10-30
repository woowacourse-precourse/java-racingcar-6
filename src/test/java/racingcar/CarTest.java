package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("경주차 이름 저장")
    void testConstructor(){
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
    }


    @Test
    @DisplayName("경주차 전진시 랜덤값 4이상일 때만 직진")
    void testForward(){

        Car car = new Car("pobi");
        int forwardCount = car.getForwardCount();

        car.forward();

        assertThat(car.getForwardCount()).isEqualTo(forwardCount + 1);

    }
}