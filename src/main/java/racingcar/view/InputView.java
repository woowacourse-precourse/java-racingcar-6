package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.InputController;
import racingcar.model.Model;

import java.util.Map;

import static racingcar.Constant.InputMenu.INPUT_CAR_NAME;
import static racingcar.Constant.InputMenu.INPUT_COUNT;

public class InputView {
    private final InputController inputController;

    public InputView(Model model) {
        inputController = new InputController(model);
    }

    public void start() {
        String carsInput = writeInConsole(INPUT_CAR_NAME);
        Map<String, String> carList = inputController.createCarList(carsInput);
        inputController.checkInvalidCarName(carList);
        String countInput = writeInConsole(INPUT_COUNT);
        inputController.checkInvalidCount(countInput);
    }


    private static String writeInConsole(String inputCarName) {
        System.out.println(inputCarName);
        return Console.readLine();
    }
}
