package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = CarService.getInstance();
    }

    @Test
    void isValidate() {
        assertThatThrownBy(() -> carService.isValidate("")) //공백 테스트
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> carService.isValidate("kangyuseok")) //이름 길이 테스트
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> carService.isValidate("(*&^*&^&*")) //숫자 인지 테스트
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parkParkingLot() {
        assertThatThrownBy(() -> carService.parkParkingLot("pobi, pobi")) //중복 처리 테스트
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateRandomNumbers() { //랜덤 숫자 테스트
        carService.parkParkingLot("car1,car2,car3");

        carService.generateRandomNumbers();

        List<Car> parkingLot = carService.getParkingLot();
        for (Car car : parkingLot) {
            assertThat(car.getRandomNumber()).isBetween(0, 9);
        }
    }
}