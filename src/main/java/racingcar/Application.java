package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.util.InputValidator;
import racingcar.util.Util;
import racingcar.model.CarModel;
import racingcar.view.InitView;

public class Application {

    public static void main(String[] args) {
        InitView initView = new InitView(new InputValidator());

        String[] carNames = initView.inputCarNames();
        List<CarModel> carList = generateCarList(carNames);

        int gameCount = initView.inputTryNumber();

        GameController controller = new GameController(carList, new Util());

        for (int round = 0; round < gameCount; round++) {
            controller.race();
            controller.showCurrentResult();
        }

        controller.showWinnerCars();
    }

    private static List<CarModel> generateCarList(String[] carNames) {
        List<CarModel> carList = new ArrayList<>();

        for (String name : carNames) {
            carList.add(new CarModel(name));
        }
        return carList;
    }
}
