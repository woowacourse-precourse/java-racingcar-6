package racingcar.View;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    static InputView inputView = new InputView();

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @Test
    void 차_이름_받기() {
        System.setIn(new ByteArrayInputStream("pobi".getBytes()));
        List<String> result = inputView.getCarsName();
        assertThat(result.size() == 1);
        assertThat(result.get(0).equals("pobi"));
    }

    @Test
    void 스테이지_개수_받기() {
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        int result = inputView.getStageNumber();
        assertThat(result == 4);
    }

}