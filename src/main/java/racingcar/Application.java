package racingcar;

import racingcar.domain.GameController;
import racingcar.domain.GameData;
import racingcar.domain.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View view = new View();
        GameController controller = new GameController();
        GameData gameData = new GameData();


        view.printAskCarName();
        String carNames = controller.getCarNamesInput();
        String[] carNamesArray = carNames.split(","); // 메서드화 하기(split & []->List<Car>)
        gameData.setCarList(carNamesArray.length);

        controller.splitCarNameInput(carNamesArray, gameData.getCarList());//gameData.getCarList() 리펙토링 고려해보기

    }
}
