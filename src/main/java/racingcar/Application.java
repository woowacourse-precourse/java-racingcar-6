package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameController;
import racingcar.domain.GameData;
import racingcar.domain.View;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View view = new View();
        GameController controller = new GameController();
        GameData gameData = new GameData();


        view.printAskCarName();
        String carNames = controller.getCarNames();
        String[] carNamesArray = carNames.split(",");
        gameData.setCarList(carNamesArray.length);

        controller.splitCarNameInput(carNamesArray, gameData.getCarList());

    }
}
