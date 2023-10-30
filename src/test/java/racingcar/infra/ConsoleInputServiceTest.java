package racingcar.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ConsoleInputServiceTest {

    @Test
    public void Car이름_입력시_쉼표로_구분하여_String_리스트_생성() {
        System.setIn(new ByteArrayInputStream("car1,car2,car3\n".getBytes()));
        ConsoleInputService inputService = new ConsoleInputService();

        List<String> carNames = inputService.getCarNames();

        assertEquals(Arrays.asList("car1", "car2", "car3"), carNames);
    }

}
