package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.CarData;

public class CarDataTest {

    @Test
    public void 차_이름_생성_테스트() {
        Car car = new Car("test", 0);
        CarData carData = car.getData();
        assertEquals("test", carData.getName());
    }

    @Test
    public void 차_이동거리_생성_테스트() {
        Car car = new Car("test", 0);
        CarData carData = car.getData();
        assertEquals(0, carData.getMoveDistance());
    }


    @ParameterizedTest
    @ValueSource(strings = {"lsqssw", "lswqwiiii", "lsasd!!erw", "xxxxxxxxxxxxxxxx"})
    void 이름이_5글자를_넘는_경우_예외처리(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }


}