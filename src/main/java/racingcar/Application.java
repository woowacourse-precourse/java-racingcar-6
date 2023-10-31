package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.util.Util;
import racingcar.model.CarModel;
import racingcar.util.InputValidatior;
import racingcar.view.InitView;

public class Application {

    public static void main(String[] args) {
        InitView initView = new InitView(new InputValidatior());

        String[] carNames = initView.inputCarNames();
        List<CarModel> carList = generateCarList(carNames);

        int gameCount = initView.inputTryNumber();

        GameController controller = new GameController(carList, new Util());

        for (int round = 0; round < gameCount; round++) {
            controller.race();
            controller.showCurrentResult();
        }

        List<CarModel> winnerList = controller.calculateWinner(carList);
    }

    private static List<CarModel> generateCarList(String[] carNames) {
        List<CarModel> carList = new ArrayList<>();

        for (String name : carNames) {
            carList.add(new CarModel(name));
        }
        return carList;
    }
}
