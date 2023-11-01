package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.CarLocationController;
import racingcar.controller.GameController;
import racingcar.controller.MaxController;
import racingcar.generator.WinArrayGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class ControllerTest {
    MaxController maxController =new MaxController();
    CarLocationController carLocationController= new CarLocationController();

    @Test
    void testfindMax() {
        int max = maxController.findMax(5,10);
        assertEquals(10,max);
    }
    @Test
    void testForwardWithRandomNumber() {
        int initialLocation = 0;
        int randomNumber = 5; // 원하는 무작위 숫자

        // Mock 객체가 5를 반환하도록 설정

        int result = CarLocationController.forward(initialLocation,randomNumber);

        int expectedLocation = initialLocation + 1; // 기본적으로 1씩 전진

        assertEquals(expectedLocation, result);
    }


    @Test
    void testGameStart() {
        WinArrayGenerator winArrayGenerator;
        CarLocationController carLocationController;
        winArrayGenerator = mock(WinArrayGenerator.class);
        carLocationController = mock(CarLocationController.class);
        GameController gameController = new GameController();

        // Test data
        List<String> participantes = new ArrayList<>();
        participantes.add("Car1");
        participantes.add("Car2");

        gameController.GameStart(participantes);

        // win 배열을 확인
        int[] win = WinArrayGenerator.win;
        // 원하는 검증을 수행
        // 예: win 배열의 크기와 값이 예상한 대로인지 확인
        assertEquals(participantes.size(), win.length);
    }

}