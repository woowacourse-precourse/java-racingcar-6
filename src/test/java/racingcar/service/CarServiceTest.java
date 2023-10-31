package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    @DisplayName("입력된 이름이 하나인 경우")
    void single_car() {
        String singleName = "test";
         carService.createCars(singleName);
         assertThat(carService.getAllCars().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력된 이름이 여러 가지인 경우")
    void multiple_car() {
        String multipleName = "test1,test2,test3";
        carService.createCars(multipleName);
        assertThat(carService.getAllCars().size())
                .isEqualTo(List.of(multipleName.split(",")).size());
    }
}
