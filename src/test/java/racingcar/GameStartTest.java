package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameStartTest {

    @Test
    void 자동차_이름_입력_테스트() {
        String input = "Car1,Car2,Car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> carList = GameStart.start();

        assertThat(carList).isNotEmpty();
        assertThat(carList).hasSize(3);
        assertThat(carList).contains("Car1 : ", "Car2 : ", "Car3 : ");
    }
}
