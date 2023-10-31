package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.game.Car;
import racingcar.io.CommonMessages;
import racingcar.io.InputManager;
import racingcar.io.OutputManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IoTest {

    InputManager inputManager = new InputManager();
    OutputManager outputManager = new OutputManager();

    @Test
    void InputManagerValidateNameListSize() {
        String names = "pobi,woni,jun,jan,sj,tomo";
        List<String> nameList = inputManager.namestoList(names);

        assertThatThrownBy(() -> inputManager.validateNameListSize(nameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void InputManagerValidateName() {
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
    void InputManagerValidateTrialFormat() {
        String failCaseOne = "12";
        String failCaseTwo = "A";

        assertThatThrownBy(() -> inputManager.validateTrialFormat(failCaseOne))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputManager.validateTrialFormat(failCaseTwo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void OutputManagerPrintRoundResult() {
        List<Car> carList = new ArrayList<>();

        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        carList.add(pobiCar);
        carList.add(woniCar);

        woniCar.move();

        String roundResult = CommonMessages.roundResult(carList);
        assertThat(roundResult).contains("실행결과", "pobi :", "woni : -");
    }
}

