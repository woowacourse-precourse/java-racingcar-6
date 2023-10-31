package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    @DisplayName("자동차 이름 입력 및 갯수 검증")
    void 자동차_이름_입력_갯수_검증() {

        String carName = "car1,car2,car";

        CarService carService = new CarService();

        int carCount = carService.initInputCarName(carName);

        assertEquals(carCount,3);
    }

    @Test
    @DisplayName("최종 승리자 출력")
    void 최종_승리자_출략() {
        List<String> winner = new ArrayList<>();
        List<String> cars = List.of("car1","car3");

        CarService carService = Mockito.mock(CarService.class);
        Mockito.when(carService.getWinner(Mockito.any(List.class))).thenReturn(cars);

        winner = carService.getWinner(winner);
        List<String> expectedWinner = List.of("car1", "car3");

        assertEquals(winner,expectedWinner);
    }
}
