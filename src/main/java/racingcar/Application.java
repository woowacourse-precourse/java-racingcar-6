package racingcar;

import racingcar.Controller.GameController;
import racingcar.Model.RacingMap;
import racingcar.View.TextView;
import racingcar.View.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingMap map = new RacingMap();
        View view = new TextView();

        GameController controller = new GameController(view, map);
        controller.setCarString();
        controller.setNumOfAttemp();
        controller.executeGame();
    }
}
