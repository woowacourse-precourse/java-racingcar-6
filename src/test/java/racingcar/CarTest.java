package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("경주할 자동차 이름 입력 확인")
    public void getNameTest() {
        String carName = "car";
        Car car = Car.of(carName); // static 메소드 접근 방법
        assertEquals(carName, car.getName());
    }
    @Test
    @DisplayName("이름이 null, 공백이 아닌지 확인")
    public void carNameShouldNotBeNullOrEmptyTest() {
        assertThrows(IllegalArgumentException.class, ()->{
            Car car = new Car(null);
        });
    }
    @ParameterizedTest(name = "1자리 미만이거나 5자리를 초과하면 IllegalArgumentException 발생 (carName = {arguments})")
    @DisplayName("5자리 이하인지 확인")
    @ValueSource(strings = {"", "overFive"})
    public void carNameShouldBeUnderFiveTest(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            Car.of(name);
        });
    }
    @Test
    @DisplayName("4이상의 값이 들어왔을 때 1칸 이동하는지 확인 ")
    public void moveCarTest() {
        Car car = new Car("car");
        int beforePosition = car.getPosition();
        car.move(4);
        assertEquals(car.getPosition(), beforePosition+1);
    }
}
