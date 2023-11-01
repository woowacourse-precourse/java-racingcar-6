package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.view.Input;

public class GameManagerTest {
    GameManager gameManager = new GameManager();

    @Test
    @DisplayName("게임 시작 전 입력 값에 따른 Car 객체 리스트 반환 테스트")
    void carSetting_test() {
        Input input = Mockito.mock(Input.class);
        gameManager.input = input;

        when(input.getCarNameList()).thenReturn(Arrays.asList("pobi", "jun", "woni"));
        List<Car> carListForTest = gameManager.carSetting();

        assertThat(carListForTest.stream().map(Car::getCarName).toList())
                .isEqualTo(Arrays.asList("pobi", "jun", "woni"));
        carListForTest.stream()
                .map(Car::getPosition)
                .forEach(position -> assertEquals(0, position));
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차를 판별 테스트")
    void checkWinner_test() {
        Car car1 = Car.from("pobi", 4);
        Car car2 = Car.from("jun", 3);
        Car car3 = Car.from("woni", 4);
        car1.move();
        car3.move();
        List<Car> carListForTest = List.of(car1, car2, car3);

        List<String> winnerListForTest = gameManager.checkWinner(carListForTest);

        assertThat(winnerListForTest).contains("pobi", "woni");
    }

}
