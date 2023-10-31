package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

        assertTrue(carListForTest.contains(new Car("pobi")));
        assertTrue(carListForTest.contains(new Car("jun")));
        assertTrue(carListForTest.contains(new Car("woni")));
    }
}
