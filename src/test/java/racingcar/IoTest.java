package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.io.InputManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IoTest {

    InputManager inputManager = new InputManager();

    @Test
    void validateNameListSize() {
        String names = "pobi,woni,jun,jan,sj,tomo";
        List<String> nameList = inputManager.namestoList(names);

        assertThatThrownBy(() -> inputManager.validateNameListSize(nameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateName() {
        String failCaseOne = "abc,def,ghijkl";
        String failCaseTwo = "abc,def,!@#A";

        List<String> failCaseOneList = inputManager.namestoList(failCaseOne);
        List<String> failCaseTwoList = inputManager.namestoList(failCaseTwo);

        assertThatThrownBy(() -> inputManager.validateName(failCaseOneList))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputManager.validateName(failCaseTwoList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateTrialFormat() {
        String failCaseOne = "12";
        String failCaseTwo = "A";

        assertThatThrownBy(() -> inputManager.validateTrialFormat(failCaseOne))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputManager.validateTrialFormat(failCaseTwo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public void setSystemIn(String input) {
        if(input != null) System.setIn(new ByteArrayInputStream(input.getBytes()));
        else System.setIn(null);
    }
}
