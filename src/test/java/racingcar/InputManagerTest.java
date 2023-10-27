package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputManagerTest extends NsTest {
    private static InputStream stdin;

    @AfterEach
    void InputStream_초기화() {
        Console.close();
    }

    @Test
    void inputCarList_테스트() {
        String[] testset = {"game", "over", "sorry"};

        String inputList = String.join(",", testset);

        InputStream consoleInputStream = new ByteArrayInputStream(inputList.getBytes());
        System.setIn(consoleInputStream);

        List<Car> carList = InputManager.inputCarList();

        assertThat(carList.size()).isEqualTo(3);
        for(int i = 0; i < testset.length; i++) {
            assertThat(carList.get(i).getName()).isEqualTo(testset[i]);
        }
    }

    @Test
    void inputCarList_예외_테스트() {
        String[] testset = {"game", "over", "I'm so sorry"};

        String inputList = String.join(",", testset);

        InputStream consoleInputStream = new ByteArrayInputStream(inputList.getBytes());
        System.setIn(consoleInputStream);

        assertThatThrownBy(() -> InputManager.inputCarList()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryCnt_테스트() {
        String testNum = "13";

        InputStream consoleInputStream = new ByteArrayInputStream(testNum.getBytes());
        System.setIn(consoleInputStream);

        assertThat(InputManager.inputTryCnt()).isEqualTo(Integer.parseInt(testNum));
    }

    @Test
    void inputTryCnt_음수_예외_테스트() {
        String testNum = "-1";

        InputStream consoleInputStream = new ByteArrayInputStream(testNum.getBytes());
        System.setIn(consoleInputStream);

        assertThatThrownBy(() -> InputManager.inputTryCnt()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryCnt_비정수_예외_테스트() {
        String testNum = "123af";

        InputStream consoleInputStream = new ByteArrayInputStream(testNum.getBytes());
        System.setIn(consoleInputStream);

        assertThatThrownBy(() -> InputManager.inputTryCnt()).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
